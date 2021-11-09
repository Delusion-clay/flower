package util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @describe http请求与响应工具类
 */
public class HttpServiceUtils {
    public static HttpServletResponse setHeader(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置可跨域资源共享的域名，只能设置一个具体的域名，但*可以代表所有
        response.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,OPTIONS");//设置可跨域资源共享的请求方式
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setHeader("Access-Control-Allow-Headers" ,"Origin, X-Requested-With, Content-Type, Accept,token");
        // 设置服务器字符集为 UTF-8
        response.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也使用 UTF-8 字符集
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        return response;
    }

    public static void send(HttpServletResponse response, String str){
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
