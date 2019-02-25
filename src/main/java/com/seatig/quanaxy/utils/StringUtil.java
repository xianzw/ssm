package com.seatig.quanaxy.utils;

/**
 * String工具
 * @Description 
 * @author xianw
 * @time 2019年2月25日下午2:13:14
 * @version v1.0
 */
public class StringUtil {

    /**
     * 判断字符串时候为空
     * @Description 
     * @param: @param str
     * @param: @return      
     * @return: boolean
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 比较两字符串是否相等，忽略大小写
     * @Description 
     * @param: @param s1
     * @param: @param s2
     * @param: @return      
     * @return: boolean
     * @param s1
     * @param s2
     * @return
     */
    public static boolean equalsIgnorecase(String s1, String s2) {
		if (s1 == null && s2 == null)
			return true;
		if (s1 != null && s2 != null) {
			if (s1.toLowerCase().equals(s2.toLowerCase()))
				return true;
		}
		return false;
	}
    

    /**
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if ((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param str
     * @return
     */
    public static String formatLike(String str) {
        if (isNotEmpty(str)) {
            return "%" + str + "%";
        } else {
            return null;
        }
    }
}
