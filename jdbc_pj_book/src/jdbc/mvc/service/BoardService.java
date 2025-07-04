package jdbc.mvc.service;

import java.util.List;

import jdbc.mvc.dto.BoardDTO;

public interface BoardService {
	
	// 1. 추가
	public int boardAdd(BoardDTO dto);

	// 2. 수정
	public int boardUpdate(int boardNo, BoardDTO dto);
	
	// 3. 삭제
	public int boardDelete(int boardNo);
	
	// 4. 게시 글번호 조회
	public BoardDTO boardSelectByNo(int boardNo);
	
	// 5. 글 제목으로 조회
	public List<BoardDTO> boardSelectByTitle(String title);
	
	// 6. 작성자 조회
	public List<BoardDTO> boardSelectById(String id);
	
	// 7. 전체목록 조회
	public List<BoardDTO> boardSelectByAll();
	
}
