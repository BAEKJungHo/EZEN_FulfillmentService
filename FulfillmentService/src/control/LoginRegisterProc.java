package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import admin.AdminDAO;
import admin.AdminDTO;
import customer.CustomerDAO;
import customer.CustomerDTO;

/**
 * Servlet implementation class LoginRegisterProc
 */
@WebServlet("/control/loginRegisterServlet")
public class LoginRegisterProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(CustomerDAO.class);   
	public LoginRegisterProc() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		AdminDAO aDao = null;
		AdminDTO admin = null;
		CustomerDAO cDao= null;
		CustomerDTO customer = null;
		String cName = null;
		String cPassword = null;
		String aName = null;
		String aPassword = null;
		String url = null;
		String message = null;
		String cUserId = null;
		String aUserId = null;
		String errorMessage = null;
		int result = 0;

		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		
		
		switch(action) {
		case "customersLogin" : // 고객 로그인
			if (!request.getParameter("cUserId").equals("")) {
				cUserId = request.getParameter("cUserId");
			}
			cPassword = request.getParameter("cPassword");
			cDao = new CustomerDAO();
			result = cDao.verifyIdPassword(cUserId, cPassword);
			switch (result) {
			case CustomerDAO.ID_PASSWORD_MATCH:
				break;
			case CustomerDAO.ID_DOES_NOT_EXIST:
				errorMessage = "ID가 없음"; break;
			case CustomerDAO.PASSWORD_IS_WRONG:
				errorMessage = "패스워드가 틀렸음"; break;
			case CustomerDAO.DATABASE_ERROR:
				errorMessage = "DB 오류";
			}
			
			if (result == CustomerDAO.ID_PASSWORD_MATCH) {
				customer = cDao.getOneCustomer(cUserId);
				session.setAttribute("sessionCustomerId", customer.getcId());
				session.setAttribute("sessionCustomerName", customer.getcName());
				System.out.println("세션 ID: " + (Integer)session.getAttribute("sessionCustomerId"));
				response.sendRedirect("../view/index.jsp");
				LOG.trace("");
			} else {
				request.setAttribute("message", errorMessage);
				request.setAttribute("url", "../view/loginForm.jsp");
				rd = request.getRequestDispatcher("../error/alertMsg.jsp");
		        rd.forward(request, response);
		        LOG.trace("");
			}
			break;
			
		case "adminsLogin" : // 고객 로그인
			if (!request.getParameter("aUserId").equals("")) {
				aUserId = request.getParameter("aUserId");
			}
			aPassword = request.getParameter("aPassword");
			aDao = new AdminDAO();
			result = aDao.verifyIdPassword(aUserId, aPassword);
			switch (result) {
			case AdminDAO.ID_PASSWORD_MATCH:
				break;
			case AdminDAO.ID_DOES_NOT_EXIST:
				errorMessage = "ID가 없음"; break;
			case AdminDAO.PASSWORD_IS_WRONG:
				errorMessage = "패스워드가 틀렸음"; break;
			case AdminDAO.DATABASE_ERROR:
				errorMessage = "DB 오류";
			}
			
			if (result == AdminDAO.ID_PASSWORD_MATCH) {
				admin = aDao.getOneAdmin(aUserId);
				session.setAttribute("sessionAdminId", admin.getaId());
				session.setAttribute("sessionAdminName", admin.getaName());
				System.out.println("세션 ID: " + (Integer)session.getAttribute("sessionAdminId"));
				response.sendRedirect("../view/index.jsp");
				LOG.trace("");
			} else {
				request.setAttribute("message", errorMessage);
				request.setAttribute("url", "../view/loginForm.jsp");
				rd = request.getRequestDispatcher("../error/alertMsg.jsp");
		        rd.forward(request, response);
		        LOG.trace("");
			}
			break;
		
		case "logout" :   // 로그아웃
			session.removeAttribute("sessionCustomerId");
			session.removeAttribute("sessionCustomerName");
			session.removeAttribute("sessionAdminId");
			session.removeAttribute("sessionAdminName");
			response.sendRedirect("../view/loginForm.jsp"); // login.jsp로 보냄
			break;
			
		case "register" : // 고객 회원가입
			cUserId = request.getParameter("cUserId");
			cName = request.getParameter("cName");
			cPassword = request.getParameter("cPassword");
			customer = new CustomerDTO(cUserId, cName, cPassword);
			System.out.println(customer.toString());
			
			cDao = new CustomerDAO();
			cDao.addCustomer(customer);
			
			customer = cDao.getOneCustomer(cUserId);
			session.setAttribute("sessionCustomerId", customer.getcId());
			session.setAttribute("sessionCustomerName", customer.getcName());
			message = "귀하의 고객번호는 " + customer.getcId() + " 입니다.";
			request.setAttribute("message", message);
			url = "../view/index.jsp";
			request.setAttribute("url", url);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			break;
			
		default : break;	
		}
	}
}
