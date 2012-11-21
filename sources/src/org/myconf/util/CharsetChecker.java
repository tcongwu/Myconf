package org.myconf.util;

/**
 * @author libin
 *
 * ¼ì²é×Ö·ûÊôÓÚÄÇ¸ö×Ö·û¼¯
 */
public class CharsetChecker {
	
	/**
	 * Support for Chinese(GB2312) characters
	 * #define isgb2312head(c) (0xa1<=(uchar)(c) && (uchar)(c)<=0xf7)
	 * #define isgb2312tail(c) (0xa1<=(uchar)(c) && (uchar)(c)<=0xfe)
	 */
	public static boolean isGB2312( byte head,byte tail ){   
		int iHead = head & 0xff;   
		int iTail = tail & 0xff;   
		return ((iHead>=0xa1 && iHead<=0xf7 && iTail>=0xa1 && iTail<=0xfe) ? true : false);   
	}
	
	/**
	 * Support for Chinese(GBK) characters
	 * #define isgbkhead(c) (0x81<=(uchar)(c) && (uchar)(c)<=0xfe)
	 * #define isgbktail(c) ((0x40<=(uchar)(c) && (uchar)(c)<=0x7e)
	 * || (0x80<=(uchar)(c) && (uchar)(c)<=0xfe))
	 */
	public static boolean isGBK( byte head,byte tail ){   
		int iHead = head & 0xff;   
		int iTail = tail & 0xff;   
		return ((iHead>=0x81 && iHead<=0xfe && (iTail>=0x40 && iTail<=0x7e || iTail>=0x80 && iTail<=0xfe)) ? true : false);   
	}
	
	/**
	 * Support for Chinese(BIG5) characters
	 * #define isbig5head(c) (0xa1<=(uchar)(c) && (uchar)(c)<=0xf9)
	 * #define isbig5tail(c) ((0x40<=(uchar)(c) && (uchar)(c)<=0x7e)
	 * ||(0xa1<=(uchar)(c) && (uchar)(c)<=0xfe))
	 */
	public static boolean isBIG5( byte head,byte tail ){   
		int iHead = head & 0xff;   
		int iTail = tail & 0xff;   
		return ((iHead>=0xa1 && iHead<=0xf9 && (iTail>=0x40 && iTail<=0x7e || iTail>=0xa1 && iTail<=0xfe)) ? true : false);   
	}
	
	/**
	 * ÅĞ¶Ï×Ö·ûÊÇ·ñÎª¼òÌåºº×Ö
	 * @param ch
	 * @return
	 */
	public static boolean isCN(char ch){
		if((ch>19967) && (ch<40869))
			return true;
		else
			return false;
	}
	
	/**
	 * ÅĞ¶Ï×Ö·ûÊÇ·ñÎªºº×Ö
	 * @param ch
	 * @return
	 */
	public static boolean isZH(String sch){
		byte[] sChars = null; 
		sChars = sch.getBytes();
		
		if(sChars.length!=2)
			return false;
			
		return (isGB2312(sChars[0],sChars[1]) || isGBK(sChars[0],sChars[1]) || isBIG5(sChars[0],sChars[1]));
	}
} 
