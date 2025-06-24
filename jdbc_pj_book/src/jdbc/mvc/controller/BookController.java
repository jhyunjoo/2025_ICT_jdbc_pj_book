package jdbc.mvc.controller;

import jdbc.mvc.dto.BookDTO;
import jdbc.mvc.service.BookServiceImpl;
import jdbc.mvc.view.BookView;

/*
 *  작성일 : 2025.6.18
 *  작성자 : 지현주
 *  설명 : 컨트롤러 - 고객의 요구사항(비지니스 로직)에 대한 흐름제어를 담당한다.
 *  			Book 정보에 대한 추가, 수정, 삭제, 도서아이디 조회, 도서목록 조회, 전체목록 조회 메뉴의 흐름 제어
 *  	BookController -> BookServiceImpl -> BookDAOImpl
 */

public class BookController {

	BookServiceImpl service = new BookServiceImpl();
	BookView view = new BookView();
	
	// 1. 도서 추가
	public void bookAdd(BookDTO dto) {
		System.out.println("<<< bookInsert() >>>");
		System.out.println(dto);
		
		int insertCnt = service.bookInsert(dto);
		if(insertCnt == 1) {
			System.out.println("책 추가 성공" + insertCnt);
		} else {
			view.bookErrorMsg("insert");
		}
	}
	
	// 2. 도서 수정
	public void bookUpdate(int bookId, BookDTO dto) {
		System.out.println("<<< bookUpdate() >>>");
		System.out.println(bookId + " : " +dto);
		
		int updateCnt = service.bookUpdate(bookId, dto);
		if(updateCnt == 1) {
			System.out.println("책 수정 성공" + updateCnt );
		} else {
			view.bookErrorMsg("delete");
		}
	}
	
	// 3. 도서 삭제
	public void bookDelete(int bookId) {
		System.out.println("<<< bookDelete() >>>");
		int deleteCnt = service.bookDelete(bookId);
		if(deleteCnt == 1) {
			System.out.println("책 삭제 성공" + deleteCnt);
		} else {
			view.bookErrorMsg("delete");
		}
	}
	
	// 4. 도서아이디 조회
	public void bookSelectId(int bookId) {
		System.out.println("<<< bookSelectId() >>>");
	}
	
	// 5. 도서목록 조회
	public void bookSelectTitle(String title) {
		System.out.println("<<< bookSelectTitle() >>>");
	}
	
	// 6. 전체목록 조회
	public void bookSelectAll() {
		System.out.println("<<< bookSelectAll() >>>");
	}
}
