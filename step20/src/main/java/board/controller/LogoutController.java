package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "board/logout.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("memId");
		session.removeAttribute("memName");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardList.do");
		return modelAndView;
	}
}
