package com.hrio.rpc.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这个代码大家应该很熟悉吧，这个是sevlet的基本知识。
 * 任何请求被进来都会被这个sevlet处理
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //把所有请求都交给HttpServerHandler处理
        new HttpServerHandler().handler(req, res);
    }
}
