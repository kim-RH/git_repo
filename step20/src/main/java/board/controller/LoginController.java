package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.dao.MemberDAO;

@Controller
public class LoginController {

	@RequestMapping(value = "/member/login.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		ModelAndView modelAndView = new ModelAndView();
		
		if (name == null || name.equals("")) {
			modelAndView.setViewName("loginForm.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			modelAndView.setViewName("redirect:../board/boardList.do");
		}
		return modelAndView;
	}

}
