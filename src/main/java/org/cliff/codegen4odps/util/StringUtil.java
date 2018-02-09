package org.cliff.codegen4odps.util;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * String Utility Class This is used to encode passwords programmatically
 * 
 * <p>
 * <a h ref="StringUtil.java.html"> <i>View Source </i> </a>
 * </p>
 * 
 * @author raible
 */
public class StringUtil {

	/**
	 * get the left string by the findStr from oraStr
	 * 
	 * @param oraStr
	 * @param findStr
	 * @return
	 */
	public static String getLeftOfFindString(String oraStr, String findStr) {
		if (StringUtils.isBlank(oraStr) || StringUtils.isBlank(findStr))
			return null;
		int position = oraStr.indexOf(findStr);
		if (position <= 0)
			return oraStr;
		return oraStr.substring(0, position);
	}

	/**
	 * get the right string by the findStr from oraStr
	 * 
	 * @param oraStr
	 * @param findStr
	 * @return
	 */
	public static String getRightOfFindString(String oraStr, String findStr) {
		if (StringUtils.isBlank(oraStr) || StringUtils.isBlank(findStr))
			return null;

		int position = oraStr.lastIndexOf(findStr);
		if (position <= 0)
			return oraStr;

		return oraStr.substring(position + 1);
	}

	/**
	 * 将camel大小写形式的字符串转换为大写加下划线的字符串 sample: helloWorld --> HELLO_WORLD
	 * 
	 * @param camelStyleString
	 * @return
	 */
	public static String convertCamelStyleToUpperCase(String camelStyleString) {
		if (StringUtils.isBlank(camelStyleString)) {
			return null;
		}
		if (camelStyleString.length() == 1) {
			return camelStyleString.toUpperCase();
		}
		String upperCaseString = "";
		upperCaseString += camelStyleString.charAt(0);
		for (int i = 1; i < camelStyleString.length(); i++) {
			if ((camelStyleString.charAt(i) >= 'A')
					&& (camelStyleString.charAt(i) <= 'Z')) {
				// 如果为大写字母,说明为单词开头,则加下划线分割
				upperCaseString += "_";
			}
			upperCaseString += camelStyleString.charAt(i);
		}
		upperCaseString = upperCaseString.toUpperCase();
		return upperCaseString;
	}

	/**
	 * 将大写加下划线的字符串转换为camel大小写形式的字符串 sample: HELLO_WORLD --> helloWorld
	 * 
	 * @param upperCaseString
	 * @return
	 */
	public static String convertUpperCaseToCamelStyle(String upperCaseString) {
		
		return parseMethodType(upperCaseString);
	}

	/**
	 * 将大写加下划线的字符串转换为pascal大小写形式的字符串 sample: HELLO_WORLD --> HelloWorld
	 * 
	 * @param upperCaseString
	 * @return
	 */
	public static String convertUpperCaseToPascalStyle(String upperCaseString) {
		return parseClassType(upperCaseString);
	}
	
	
	
	public static String transformCode(String str) {
		try {
			transformCodeTest(str);
			return new String(str.getBytes("GBK"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	private static void transformCodeTest(String str)
			throws UnsupportedEncodingException {
		String[] code = { "GBK", "UTF-8", "ISO8859-1", "gb2312" };
		for (int i = 0; i < code.length; i++) {
			System.out.println(code[i] + " : "
					+ new String(str.getBytes(code[i])));
			for (int j = 0; j < code.length; j++) {
				if (i != j)
					System.out.println(code[j] + " -> " + code[i] + " : "
							+ new String(str.getBytes(code[j]), code[i]));
			}
		}
	}

	public static String parseLowercase(String str, String space) {
		ArrayList strs = StringUtil.splitString(str);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.size(); i++) {
			str = (String) strs.get(i);
			sb.append(str.toLowerCase());
			if (i < strs.size() - 1)
				sb.append(space);
		}
		return sb.toString();
	}

	public static String parseUppercase(String str, String space) {
		ArrayList strs = StringUtil.splitString(str);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.size(); i++) {
			str = (String) strs.get(i);
			sb.append(str.toUpperCase());
			if (i < strs.size() - 1)
				sb.append(space);
		}
		return sb.toString();
	}

	public static String parseMethodType(String str) {
		ArrayList strs = StringUtil.splitString(str);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.size(); i++) {
			str = (String) strs.get(i);
			if (i > 0)
				sb.append(str.substring(0, 1).toUpperCase());
			else
				sb.append(str.substring(0, 1).toLowerCase());
			sb.append(str.substring(1, str.length()).toLowerCase());
		}
		return sb.toString();
	}

	public static String parseClassType(String str) {
		ArrayList strs = StringUtil.splitString(str);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.size(); i++) {
			str = (String) strs.get(i);
			sb.append(str.substring(0, 1).toUpperCase());
			sb.append(str.substring(1, str.length()).toLowerCase());
		}
		return sb.toString();
	}

	public static String wipeUnderline(String str) {
		while (str.indexOf("_", 0) == 0) {
			;
		}
		return str;
	}

	/**
	 * 将字符串拆分为单词列表
	 * 
	 * @param str
	 * @return
	 */
	private static ArrayList splitString(String str) {
		ArrayList strArray = new ArrayList();
		strArray.add(str);
		strArray = StringUtil.splitStrWithStr(strArray, "_");
		strArray = StringUtil.splitStrWithStr(strArray, " ");
		return strArray;
	}

	/**
	 * 将字符串组中每个字符串以split拆分，然后再组成字符串组
	 * 
	 * @param in
	 * @param split
	 * @return
	 */
	private static ArrayList splitStrWithStr(ArrayList in, String split) {
		ArrayList out = new ArrayList();
		for (int i = 0; i < in.size(); i++) {
			String tempStr = (String) in.get(i);
			String[] strs = tempStr.split(split);
			for (int j = 0; j < strs.length; j++) {
				out.add(strs[j]);
			}
		}
		return out;
	}

	/**
	 * 用字府c给字符串str补足位数
	 * 
	 * @param str
	 * @param c
	 * @param digitNum
	 * @return
	 */
	public static String getFullChar(String str, char c, int digitNum) {
		if (str != null) {
			for (int i = str.length(); i < digitNum; i++) {
				str = c + str;
			}
		}
		return str;
	}

	/**
	 * 得到字符串中第一个不是c字符的后面的字符串
	 * 
	 * @param str
	 * @param c
	 * @return
	 */
	public static long getNumberFromString(String str, char c) {
		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				if (c != str.charAt(i)) {
					return Long.parseLong(str.substring(i, str.length()));
				}
			}
		}
		return 0;
	}

	public static String getCamelCase(String input,String sperater){
        String[] inputwords = input.trim().split(sperater);
        String result = "";
        for(String w:inputwords){
            if(w!=null && w.length()>0){
               result += w.substring(0, 1).toUpperCase() + w.substring(1);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
	    String input = "wd_weekhot_deal_ada";
	    String result = getCamelCase(input,"_");
	    System.out.println(result);
		System.out.println(getFullChar("1", '#', 2));
	}
}