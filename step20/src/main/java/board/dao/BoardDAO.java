package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 저장
	public int boardWrite(BoardDTO dto) {
		return sqlSession.insert("mybatis.board.boardWrite", dto);
	}
	// 목록 보기
	public List<BoardDTO> boardList(int startNum, int endNum){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.board.boardList", map);
	}
	// 상세 보기
	public BoardDTO boardView(int seq){
		return sqlSession.selectOne("mybatis.board.boardView", seq);
	}
	// 조회수 증가
	public int updateHit(int seq) {
		return sqlSession.update("mybatis.board.updateHit", seq);
	}
	// 전체 목록 갯수
	public int getTotalA() {
		return sqlSession.selectOne("mybatis.board.getTotalA");
	}
	// 삭제
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.board.boardDelete", seq);
	}
}
