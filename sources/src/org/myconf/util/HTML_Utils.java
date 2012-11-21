package org.myconf.util;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import org.myconf.Globals;

/**
 * ���ڸ�ʽ��HTML�Ĺ�����
 * @author liudong
 */
public class HTML_Utils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String html = "<FONT CLASS=\"FrameItemFont\"><A HREF=\"org/htmlparser/lexer/package-frame.html\" target=\"packageFrame\">org.htmlparser.lexer</A></FONT><BR><FONT CLASS=\"FrameItemFont\"><A HREF=\"org/htmlparser/lexerapplications/tabby/package-frame.html\" target=\"packageFrame\">org.htmlparser.lexerapplications.tabby</A></FONT><BR><FONT CLASS=\"FrameItemFont\"><A HREF=\"org/htmlparser/lexerapplications/thumbelina/package-frame.html\" target=\"packageFrame\">org.htmlparser.lexerapplications.thumbelina</A></FONT><BR><FONT CLASS=\"FrameItemFont\"><A HREF=\"org/htmlparser/nodes/package-frame.html\" target=\"packageFrame\">org.htmlparser.nodes</A></FONT>";
		int pre_length = 150;
		String preview = preview(html, pre_length);
		System.out.println(html);
		System.out.println(html.substring(0, pre_length));
		System.out.println(preview);
	}

	private final static NodeFilter nfilter = new NodeFilter(){
		public boolean accept(Node arg0) {
			return true;
		}};
		
	/**
	 * ����Ԥ������
	 * @param html
	 * @param max_count
	 * @return
	 */
	public static String preview(String html, int max_count){
		if(html.length()<= max_count * 1.1)
			return html;
		Parser parser = new Parser();
		StringBuffer prvContent = new StringBuffer();
		try {
			parser.setEncoding(Globals.ENC_8859_1);
			parser.setInputHTML(html);
			NodeList nodes = parser.extractAllNodesThatMatch(nfilter);
			Node node = null;
			for(int i=0;i<nodes.size();i++){
				if(prvContent.length() >= max_count){
					if(node instanceof TagNode){
						TagNode tmp_node = (TagNode)node;
						boolean isEnd = tmp_node.isEndTag();
						if(!isEnd){
							prvContent.setLength(prvContent.length()-tmp_node.getText().length()-2);
						}
					}
					//��������δ�رյı�ǩ
					Node parent = node;
					//System.out.println("current node is . "+parent.getText());
					do{
						parent = parent.getParent();	
						//System.out.println("parent = "+parent);					
						if(parent==null) break;
						if(!(parent instanceof TagNode)) continue;
						//System.out.println("Parent node is no ended. "+parent.getText());
						prvContent.append(((TagNode)parent).getEndTag().toHtml());
					}while(true);
					break;
				}
				node = nodes.elementAt(i);
				if(node instanceof TagNode){
					TagNode tag = (TagNode)node;
					prvContent.append('<');
					prvContent.append(tag.getText());
					prvContent.append('>');
					//System.out.println("TAG: " + '<'+tag.getText()+'>');
				}
				else if(node instanceof TextNode){
					int space = max_count - prvContent.length();
					if(space > 10){
						TextNode text = (TextNode)node;
						if(text.getText().length() < 10)
							prvContent.append(text.getText());
						else
							prvContent.append(StringUtils.abbreviate(text.getText(), max_count - prvContent.length()));
						//System.out.println("TEXT: " + text.getText());
					}
				}
			}
			return prvContent.toString();
		} catch (ParserException e) {
			e.printStackTrace();
		}finally{
			parser = null;
		}
		return html;
	}
	
}
