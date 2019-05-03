package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/control/storageServlet")
public class adminStorageProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public adminStorageProc() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		//chargeDAO cDao = new chargeDAO(); // 지급,청구에 대한 정보 테이블을 끄집어냄.
		switch(action) {
		
			case "지급/청구" : 
				
			//cDao.	
		}
	}
}
