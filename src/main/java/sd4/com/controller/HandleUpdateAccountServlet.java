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
 * @author M.Zaki Al Akkari <https://github.com/MrZakiakkari>
 */
@WebServlet(name = "HandleUpdateAccountServlet", urlPatterns =
{
	"/HandleAdjustAccount"
})
public class HandleUpdateAccountServlet extends HttpServlet
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
			Accounts customer = buildCustomerFromForm(request);
			AccountsDB.update(customer);
			//response.sendRedirect("/AdjustAccount?id"+customer.getAccountNumber());
			address = "/AccountDetails.jsp";
			request.setAttribute("account", customer);
		}
		catch (Exception e)
		{
			address = "/Error.jsp";
			request.setAttribute("errorMessage", "Sorry, an error occured");
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
	private Accounts buildCustomerFromForm(HttpServletRequest request) throws Exception
	{
		int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
		Accounts customer = AccountsDB.getAccountByID(accountNumber);
		//customer.setAccountNumber(Integer.parseInt(request.getParameter("newaccountNumber")));
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setSortCode(request.getParameter("sortCode"));
		customer.setBalance(Double.parseDouble(request.getParameter("balance")));
		return customer;
	}
}
