package me.jiatao.ssm;

import org.jsoup.Jsoup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EvaluateServlet", urlPatterns = "/EvaluateServlet")
public class EvaluateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

//    https://blog.csdn.net/sinat_32867867/article/details/78019114
//    https://blog.csdn.net/yuxiaohui78/article/details/49092575
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Jsoup.connect("https://login.m.taobao.com/login.htm");
    }
}
