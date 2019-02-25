package com.seatig.quanaxy.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * Response工具
 * @Description 
 * @author xianw
 * @time 2019年2月25日下午2:12:43
 * @version v1.0
 */
public class ResponseUtil {

    public static void write(HttpServletResponse response, Object o) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
