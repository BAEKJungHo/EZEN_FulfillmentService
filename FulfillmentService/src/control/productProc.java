package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/control/productServlet")
public class productProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public productProc() {
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
		RequestDispatcher rd = null;
		
		switch(action) {
			case "view" : // 카테고리(식품, 스포츠 등등)에 따른 분류
				String Title = null;
				categoryNum = Integer.parseInt(request.getParameter("category"));
				switch (categoryNum) {
				case ProductDAO.ARDUINO:
					Title = "의류";
					break;
				case ProductDAO.SENSOR:
					Title = "식품";
					break;
				case ProductDAO.ACTUATOR:
					Title = "가전제품";
					break;
				case ProductDAO.PARTS:
					Title = "스포츠";
					break;
				case ProductDAO.OSHW:
					Title = "가구";
					break;
				}
				productList = pDao.getProducts(categoryNum);
				request.setAttribute("Title", Title);
				request.setAttribute("productList", productList);
				pageContext.forward("../view/itemView.jsp");
				break;
				
			case "조회" : 
				
		
		}
	}
}
