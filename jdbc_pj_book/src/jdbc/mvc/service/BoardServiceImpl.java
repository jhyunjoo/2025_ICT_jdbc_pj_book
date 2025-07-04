package jdbc.mvc.service;

import java.util.List;

import jdbc.mvc.dao.BoardDAOImpl;
import jdbc.mvc.dto.BoardDTO;

public class BoardServiceImpl implements BoardService{
	
	BoardDAOImpl dao = BoardDAOImpl.getInstance();

	// 1. 추가
	@Override
	public int boardAdd(BoardDTO dto) {
		System.out.println("BoardServiceImpl - boardAdd()");
		int insertInt = dao.boardAdd(dto);
		return insertInt;
	}

	// 2. 수정
	@Override
	public int boardUpdate(int boardNo, BoardDTO dto) {
		System.out.println("BoardServiceImpl - boardUpdate()");
		int updateCnt = dao.boardUpdate(boardNo, dto);
		return updateCnt;
	}

	// 3. 삭제
	@Override
	public int boardDelete(int boardNo) {
		System.out.println("BoardServiceImpl - boardDelete()");
		int deleteCnt = dao.boardDelete(boardNo);
		return deleteCnt;
	}

	// 4. 게시 글번호 조회
	@Override
	public BoardDTO boardSelectByNo(int boardNo) {
		System.out.println("BoardServiceImpl - boardSelectByNo()");
		BoardDTO dto = dao.boardSelectByNo(boardNo);
		return dto;
	}

	// 5. 글 제목으로 조회
	@Override
	public List<BoardDTO> boardSelectByTitle(String title) {
		System.out.println("BoardServiceImpl - boardSelectByTitle()");
		List<BoardDTO> list = dao.boardSelectByTitle(title);
		return list;
	}

	// 6. 작성자 조회
	@Override
	public List<BoardDTO> boardSelectById(String id) {
		System.out.println("BoardServiceImpl - boardSelectById()");
		List<BoardDTO> list = dao.boardSelectById(id);
		return list; 
	}

	// 7. 전체목록 조회
	@Override
	public List<BoardDTO> boardSelectByAll() {
		System.out.println("BoardServiceImpl - boardSelectByAll()");
		List<BoardDTO> list = dao.boardSelectByAll();
		return list;
	}
	
}
