package jdbc.mvc.dao;

import jdbc.mvc.dto.BookDTO;

public interface BookDAO {
	
	// 1. 도서 추가
	public int bookInsert(BookDTO dto);
	
	// 2. 도서 수정
	public int bookUpdate(BookDTO dto);
	
	// 3. 도서 삭제
	public int bookDelete(int bookId);

}
