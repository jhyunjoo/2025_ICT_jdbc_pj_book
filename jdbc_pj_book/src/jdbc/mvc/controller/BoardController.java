package jdbc.mvc.controller;

import java.util.List;

import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.service.BoardServiceImpl;
import jdbc.mvc.view.View;

public class BoardController {
	
	BoardServiceImpl service = new BoardServiceImpl();
	View view = new View();
	
	// 1. 추가
	public void boardAdd(BoardDTO dto) {
		System.out.println("BoardController - boardAdd()");
		int insertInt = service.boardAdd(dto);
		if(insertInt == 1) {
			System.out.println("글 추가 성공 " + insertInt);
		} else {
			view.boardErrorMsg("insert");
		}
	}
	
	// 2. 수정
	public void boardUpdate(int boardNo, BoardDTO dto) {
		System.out.println("BoardController - boardUpdate()");
		int updateCnt = service.boardUpdate(boardNo, dto);
		if(updateCnt == 1) {
			System.out.println("글 수정 성공 " + updateCnt);
		} else {
			view.boardErrorMsg("update");
		}
	}
	
	// 3. 삭제
	public void boardDelete(int boardNo) {
		System.out.println("BoardController - boardDelete()");
		int deleteCnt = service.boardDelete(boardNo);
		if(deleteCnt == 1) {
			System.out.println("글 삭제 성공 " + deleteCnt);
		} else {
			view.boardErrorMsg("delete");
		}
	}
	
	// 4. 게시 글번호 조회
	public void boardSelectByNo(int boardNo) {
		System.out.println("BoardController - boardSelectByNo()");
		BoardDTO dto = service.boardSelectByNo(boardNo);
		if(dto.getBoardNo() == boardNo) {
			view.boardSelect(dto);
		} else {
			view.boardErrorMsg("select");
		}
	}
	
	// 5. 글 제목으로 조회
	public void boardSelectByTitle(String title) {
		System.out.println("BoardController - boardSelectByTitle()");
		List<BoardDTO> list = service.boardSelectByTitle(title);
		if(!list.isEmpty()) { 
			view.boardListAll(list); 
		} else {
			view.boardErrorMsg("select"); 
		}
	}
	
	// 6. 작성자 조회
	public void boardSelectById(String boardId) {
		System.out.println("BoardController - boardSelectById()");
		List<BoardDTO> list = service.boardSelectById(boardId);
		if(!list.isEmpty()) {
			view.boardListAll(list);
		} else {
			view.boardErrorMsg("select");
		}
	}
	
	// 7. 전체목록 조회
	public void boardSelectByAll() {
		System.out.println("BoardController - boardSelectByAll()");
		List<BoardDTO> list = service.boardSelectByAll();
		if(!list.isEmpty()) {
			view.boardListAll(list);
		} else {
			view.boardErrorMsg("select");
		}
	}

}
