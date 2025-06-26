package jdbc.mvc.service;

import java.util.List;

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
	public int bookUpdate(int bookId, BookDTO dto) {
		System.out.println("BookServiceImpl - bookUpdate()");
		int updateCnt = dao.bookUpdate(bookId, dto);
		return updateCnt;
	}

	// 3. 도서 삭제
	@Override
	public int bookDelete(int bookId) {
		System.out.println("BookServiceImpl - bookdelete()");
		int deleteCnt = dao.bookDelete(bookId);
		return deleteCnt;
	}

	// 4. 도서 아이디로 조회
	@Override
	public BookDTO bookSelectById(int bookId) {
		System.out.println("BookServiceImpl - bookSelectById()");
		BookDTO dto = dao.bookSelectById(bookId);
		return dto;
	}

	// 5. 도서 제목으로 조회
	@Override
	public List<BookDTO> bookSelectByTitle(String title) {
		System.out.println("BookServiceImpl - bookSelectByTitle()");
		List<BookDTO> list = dao.bookSelectByTitle(title);
		return list;
	}

	// 6. 전체 목록 조회
	@Override
	public List<BookDTO> bookSelectAll() {
		System.out.println("BookServiceImpl - bookSelectAll()");
		List<BookDTO> list = dao.bookSelectAll();
		return list;
	}

}
