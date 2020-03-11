package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 웹 브라우저용
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// DB
		// 1페이지당 목록 5개
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		//BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = boardService.boardList(startNum, endNum);
		// 페이징 숫자 3개씩
		int totalA = boardService.getTotalA(); // 총 글수
		int totalP = (totalA + 4) / 5; // 총 페이지수
		int startPage = (pg - 1) / 3 * 3 + 1; // 시작 페이지
		int endPage = startPage + 2; // 마지막 페이지
		if (endPage > totalP) endPage = totalP;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		
		modelAndView.setViewName("../board/boardList.jsp");
		return modelAndView;
	}
	
	// JSON
	@RequestMapping(value = "/board/boardListJson.do")
	public ModelAndView boardListJson(HttpServletRequest request) {
		// 1. 데이터
		int pg = 1;
		if (request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// 2. DB
		// 1페이지당 목록 5개
		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<BoardDTO> list = boardService.boardList(startNum, endNum);
		
		// JSON으로 결과값 반환
		String rt = null;
		int total = list.size();
		
		if(total > 0) {
			rt = "LIST OK";

		} else {
			rt = "FAIL";
		}
		// JSON 객체 생성
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		JSONArray item = new JSONArray();
		if(total > 0) {
			for(int i=0; i<total; i++) {
				BoardDTO boardDTO = list.get(i);
				JSONObject temp = new JSONObject();
				temp.put("seq", boardDTO.getSeq());
				temp.put("id", boardDTO.getId());
				temp.put("name", boardDTO.getName());
				temp.put("subject", boardDTO.getSubject());
				temp.put("content", boardDTO.getContent());
				temp.put("hit", boardDTO.getHit());
				temp.put("logtime", boardDTO.getLogtime());
				// JSONArray에 저장
				item.put(i,temp);
			}
		}
		// json 객체에 저장
		json.put("item", item);
		
		// 검색 결과를 서블릿으로 리턴
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("../board/boardListJson.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		//BoardDAO dao = new BoardDAO();
		boardService.updateHit(seq);
		BoardDTO dto = boardService.boardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) {
		// 데이터
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// System.out.println("id : " + id);
		//BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		int su = boardService.boardWrite(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su", su);
		
		modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView boardWriteForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		//BoardDAO dao = new BoardDAO();
		int count = boardService.boardDelete(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("count", count);
		modelAndView.setViewName("boardDelete.jsp");
		
		return modelAndView;
	}
	
}
