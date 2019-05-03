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
		CustomerDAO cDao= null;
		CustomerDTO customer = null;
		String cName = null;
		String cPassword=null;
		String url = null;
		String message = null;
		String cUserId = null;

		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		
		
		switch(action) {
		case "customerLogin" : // 고객 로그인
			if (!request.getParameter("cUserId").equals("")) {
				cUserId = request.getParameter("cUserId");
			}
			cPassword = request.getParameter("cPassword");
			cDao = new CustomerDAO();
			int result = cDao.verifyIdPassword(cUserId, cPassword);
			String errorMessage = null;
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
		
		case "logout" :   // 로그아웃
			session.removeAttribute("sessionCustomerId");
			session.removeAttribute("sessionCustomerName");
			response.sendRedirect("../view/loginForm.jsp"); // login.jsp로 보냄
			break;
			
		case "register" : // 고객 회원가입
			ArrayList<CustomerDTO> cList = new ArrayList<CustomerDTO>();
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
			url = "/FulfillmentService/WebContent/view/index.jsp"; //"bbsServlet?action=list&page=1";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			break;
			
		default : break;	
		}
	}
}
