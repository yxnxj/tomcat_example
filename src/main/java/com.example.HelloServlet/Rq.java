package com.example.HelloServlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
    HttpServletRequest req;
    HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void encoding() {
        // 들어오는 파라미터를 UTF-8로 해석
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // 서블릿이 HTML 파일을 만들 때 UTF-8 로 쓰기
        resp.setCharacterEncoding("UTF-8");
        // HTML이 UTF-8 형식이라는 것을 브라우저에게 알린다.
        resp.setContentType("text/html; charset=utf-8");
    }
    public int getIntParam(String key, int defaultValue) {
        String param = req.getParameter(key);
        if(param == null)
            return defaultValue;

        try{
            return Integer.parseInt(param);
        }catch(NumberFormatException e){
            return defaultValue;
        }
    }

    public void appendBody(String formatted)  {
        try {
            resp.getWriter().append(formatted);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
