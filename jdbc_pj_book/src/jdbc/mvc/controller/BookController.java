package jdbc.mvc.controller;

import jdbc.mvc.dto.BookDTO;
import jdbc.mvc.service.BookServiceImpl;

/*
 *  작성일 : 2025.6.18
 *  작성자 : 지현주
 *  설명 : 컨트롤러 - 고객의 요구사항(비지니스 로직)에 대한 흐름제어를 담당한다.
 *  			Book 정보에 대한 추가, 수정, 삭제, 도서아이디 조회, 도서목록 조회, 전체목록 조회 메뉴의 흐름 제어
 *  	BookController -> BookServiceImpl -> BookDAOImpl
 */

public class BookController {

	BookServiceImpl service = new BookServiceImpl();
	
	// 1. 도서 추가
	public void bookAdd(BookDTO dto) {
		System.out.println("<<< bookInsert() >>>");
		System.out.println(dto);
		
		service.bookInsert(dto);
	}
	
	// 2. 도서 수정
	
	// 3. 도서 삭제
	
	// 4. 도서아이디 조회
	
	// 5. 도서목록 조회
	
	// 6. 전체목록 조회
	
}
