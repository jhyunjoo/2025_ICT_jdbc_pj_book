package jdbc.mvc.dao;

import jdbc.mvc.dto.BookDTO;

public interface BookDAO {
	
	// 1. 도서 추가
	public int bookInsert(BookDTO dto);
	
	// 2. 도서 수정
	public int bookUpdate(int bookId, BookDTO dto);
	
	// 3. 도서 삭제
	public int bookDelete(int bookId);
	
	// 4. 도서 아이디 조회
	public BookDTO SelectBookById(int bookId);
	
	// 5. 도서 목록 조회
	public BookDTO SelectBookByTitle(String title);

}
