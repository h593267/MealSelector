package dev.arnemunthekaas.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.arnemunthekaas.DB.MealDAO;
import dev.arnemunthekaas.mealview.MealView;
import dev.arnemunthekaas.selector.MealSelector;

@WebServlet(name = "SelectorServlet", urlPatterns = "/selector")
public class SelectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private MealDAO mealDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MealView mealview = (MealView) request.getAttribute("currentmeal");
		request.setAttribute("meal", mealview);
		if(mealview == null)
			request.setAttribute("meal", MealSelector.roulette(mealDAO, request));
		request.getRequestDispatcher("WEB-INF/selector.jsp")
 		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("meal", MealSelector.roulette(mealDAO, request));
		request.getRequestDispatcher("WEB-INF/selector.jsp")
 		.forward(request, response);
	}

}
