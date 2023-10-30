package com.example.tomcatdemo;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// GLAB - 309.1.2 - Creating Servlets  with the  IntelliJ Ultimate

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    protected void doPostOrig(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String username = request.getParameter("myName");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        out.print("<html><head><title> Welcome to the Web World </title></head><body>");
        out.println("<h2> username is :" + username + "</h2> \n");
        out.println("<h2> password is :" + password + "</h2> \n");
        out.println("</body></html>");
    }
        //protected void doPost(HttpServletRequest  HttpServletResponse
        //request, HttpServletResponse response) throws IOException, ServletException {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            String user = "user";
            String pass = "123";
            String username = request.getParameter("myName");
            String password = request.getParameter("password");
            if(username.equals(user) & password.equals(pass)) {
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
                rd.forward(request, response);
            }
            else {
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
                rd.forward(request, response);
            }
        }



    public void destroy() {
    }
}