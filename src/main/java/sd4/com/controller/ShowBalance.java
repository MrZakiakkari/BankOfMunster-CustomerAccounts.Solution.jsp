package sd4.com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sd4.com.model.Accounts;
import sd4.com.model.AccountsDB;

/**
 *
 * @author alan.ryan
 */
@WebServlet(name = "ShowBalance", urlPatterns =
{
	"/ShowBalance"
})
public class ShowBalance extends HttpServlet
{

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String address;
		try
		{
			int accountId = Integer.parseInt(request.getParameter("id"));
			Accounts customer = AccountsDB.getAccountByID(accountId);
			if (customer == null)
			{
				address = "/UnknownCustomer.jsp";
			}
			else if (customer.getBalance() < 0)
			{
				address = "/NegativeBalance.jsp";
				request.setAttribute("badCustomer", customer);
			}
			else if (customer.getBalance() < 10000)
			{
				address = "/NormalBalance.jsp";
				request.setAttribute("regularCustomer", customer);
			}
			else
			{
				address = "/HighBalance.jsp";
				request.setAttribute("eliteCustomer", customer);
			}
		}
		catch (NumberFormatException ex)
		{
			address = "/Error.jsp";
		}
		catch (Exception ex)
		{
			address = "/Error.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo()
	{
		return "Short description";
	}// </editor-fold>

}
