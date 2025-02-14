package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;

import java.io.IOException;

/**
 * Servlet implementation class BoardProcessServlet
 */
@WebServlet("/board/delete")
public class BoardDeleteProcessServlet extends HttpServlet {
	BoardDao dao = new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// num
		int num = Integer.parseInt(request.getParameter("num"));
		// passwd
		String passwd = request.getParameter("passwd");
		// pageNum
		String pageNum = request.getParameter("pageNum");
		// 비번이 맞는지 boolean으로 얻기
		boolean chkPass = dao.checkPass(num, passwd);
		// true면 삭제 후 목록으로 이동(페이지 번호 전달)
		// false면 fail.jsp로 포워드
		if (chkPass) {
			dao.delete(num);
			response.sendRedirect("./list?pageNum="+pageNum);
		} else {
			RequestDispatcher rd=request.getRequestDispatcher("./fail.jsp");
			request.setAttribute("pageNum", pageNum);
			rd.forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
