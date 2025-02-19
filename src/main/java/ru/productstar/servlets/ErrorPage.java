package ru.productstar.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static jakarta.servlet.RequestDispatcher.*;

@WebServlet("/errorpage")
public class ErrorPage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset = utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">");
        out.println("<title>Сообщение об ошибке</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<strong>Error</strong> (" + request.getAttribute(ERROR_STATUS_CODE) + ") - " + request.getAttribute(ERROR_MESSAGE));
        out.println("</body></html>");
    }
}
