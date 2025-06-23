package jdbc.mvc.service;

import jdbc.mvc.dao.BookDAOImpl;
import jdbc.mvc.dto.BookDTO;

public class BookServiceImpl implements BookService{

	BookDAOImpl dao = new BookDAOImpl();
	
	// 1. 도서추가
	@Override
	public int bookInsert(BookDTO dto) {
		System.out.println("BookServiceImpl - bookInsert()");
		int insertCnt = dao.bookInsert(dto);
		return insertCnt;
	}

	// 2. 도서 수정
	@Override
	public int bookUpdate(BookDTO dto) {
		System.out.println("BookServiceImpl - bookUpdate()");
		int updateCnt = dao.bookUpdate(dto);
		return updateCnt;
	}

	// 3. 도서 삭제
	@Override
	public int bookDelete(int bookId) {
		System.out.println("BookServiceImpl - bookdelete()");
		int deleteCnt = dao.bookDelete(bookId);
		return deleteCnt;
	}

}
