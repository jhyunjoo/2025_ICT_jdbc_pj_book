package jdbc.mvc.service;

import jdbc.mvc.dto.BookDTO;

public class BookServiceImpl implements BookService{

	// 1. 도서추가
	@Override
	public int bookInsert(BookDTO dto) {
		System.out.println("BookServiceImpl - bookInsert()");
		return 0;
	}

	// 2. 도서 수정
	@Override
	public int bookUpdate(BookDTO dto) {
		System.out.println("BookServiceImpl - bookUpdate()");
		return 0;
	}

	// 3. 도서 삭제
	@Override
	public int bookDelete(int bookId) {
		System.out.println("BookServiceImpl - bookdelete()");
		return 0;
	}

}
