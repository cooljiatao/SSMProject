package me.jiatao.ssm;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "EvaluateServlet", urlPatterns = "/EvaluateServlet")
public class EvaluateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    //    https://blog.csdn.net/sinat_32867867/article/details/78019114
//    https://blog.csdn.net/yuxiaohui78/article/details/49092575
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsoup.connect("https://login.m.taobao.com/login.htm");
    }


    public static final String returnCookies() {
        try {
            Connection conn = Jsoup.connect("https://login.m.taobao.com/login.htm");
            conn.method(Connection.Method.GET);
            conn.followRedirects(false);
            Connection.Response response = conn.execute();
            Map<String, String> getCookies = response.cookies();
            String Cookie = getCookies.toString();
            Cookie = Cookie.substring(Cookie.indexOf("{") + 1, Cookie.lastIndexOf("}"));
            Cookie = Cookie.replaceAll(",", ";");
            return Cookie;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String goHttp() {

        try {
            Connection conn = Jsoup.connect("https://xueqiu.com/v4/stock/quote.json?code=SH600000");
            conn.header("Host","xueqiu.com");
            conn.header("Connection","keep-alive");
            conn.header("Cache-Control","max-age=0");
            conn.header("Upgrade-Insecure-Requests","1");
            conn.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
            conn.header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//          conn.header("Accept-Encoding","gzip, deflate, sdch, br");
            conn.header("Accept-Language","zh-CN,zh;q=0.8");
            conn.header("Cookie",returnCookies());
            conn.method(Connection.Method.GET);
            conn.followRedirects(false);
            conn.ignoreContentType(true);
            Connection.Response response = conn.execute();
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
