package jdbc.mvc.controller;

import java.util.List;

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
	public void bookAdd(BookDTO dto) { // sql문의 ?에 필요한 매개변수
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
	
	// 4. 도서 아이디로 조회
	public void bookSelectId(int bookId) {	
		System.out.println("<<< bookSelectId() >>>");
		BookDTO dto = service.bookSelectById(bookId);
		if(dto.getBookId() == bookId) {
			view.bookSelect(dto);
		} else {
			view.bookErrorMsg("select");
		}
	}
	
	// 5. 도서 제목으로 조회
	public void bookSelectTitle(String title) {
		System.out.println("<<< bookSelectTitle() >>>");
		List<BookDTO> list = service.bookSelectByTitle(title);
		if (!list.isEmpty()) {
			view.bookListAll(list);
		} else {
			view.bookErrorMsg("select");
		}
		
	}
	
	// 6. 전체 목록 조회
	public void bookSelectAll() {
		System.out.println("<<< bookSelectAll() >>>");
		List<BookDTO> list = service.bookSelectAll();
		if(!list.isEmpty()) {
			view.bookListAll(list);
		} else {
			view.bookErrorMsg("select");
		}
	}
}
