package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private  BoardDAO dao;
	
	@Override
	public int boardWrite(BoardDTO dto) {
		return dao.boardWrite(dto);
	}

	@Override
	public int boardModify(BoardDTO dto) {
		return 0;
	}

	@Override
	public int boardDelete(int seq) {
		return dao.boardDelete(seq);
	}

	@Override
	public BoardDTO boardView(int seq) {
		return dao.boardView(seq);
	}

	@Override
	public List<BoardDTO> boardList(int startNum, int endNum) {
		return dao.boardList(startNum, endNum);
	}

	@Override
	public int updateHit(int seq) {
		return dao.updateHit(seq);
	}

	@Override
	public int getTotalA() {
		return dao.getTotalA();
	}

}
