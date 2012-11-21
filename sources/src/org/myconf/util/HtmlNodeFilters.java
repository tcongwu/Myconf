package org.myconf.util;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.TableTag;
import org.htmlparser.tags.TitleTag;

/**
 * ���õ�HTML��ǩ����
 */
public class HtmlNodeFilters {

	/**
	 * ������ȡҳ���ͼ��
	 */
	public final static NodeFilter imageFilter = new NodeFilter() {
		public boolean accept(Node node) {
			return (node instanceof ImageTag);
		}		
	};
	/**
	 * ������ȡҳ��ı��
	 */
	public final static NodeFilter tableFilter = new NodeFilter() {
		public boolean accept(Node node) {
			return (node instanceof TableTag);
		}		
	};
	/**
	 * ������ȡҳ��ı���
	 */
	public final static NodeFilter titleFilter = new NodeFilter() {
		public boolean accept(Node node) {
			return (node instanceof TitleTag);
		}		
	};
}
