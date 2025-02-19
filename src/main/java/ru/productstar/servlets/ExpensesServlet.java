package ru.productstar.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.model.FinancialEventType;
import ru.productstar.servlets.model.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpensesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();

        int freeMoney = (int)context.getAttribute("freeMoney");
        var transactions = new ArrayList<Transaction>((List)context.getAttribute("transactions")); // берём имеющийся список транзакций в контексте
        for(var k : req.getParameterMap().keySet()) {
            int value = Integer.parseInt(req.getParameter(k));
            freeMoney -= value;
            transactions.add(new Transaction(k, value, FinancialEventType.Expense));
        }

        context.setAttribute("transactions", transactions); // записываем текущий список в контекст
        context.setAttribute("freeMoney", freeMoney);
//        resp.getWriter().println("Expenses were added");
        resp.sendRedirect("/summary");
    }
}
