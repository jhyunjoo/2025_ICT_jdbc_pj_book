package jdbc.mvc.service;

import java.util.List;

import jdbc.mvc.dto.BookDTO;

public interface BookService {

	// 1. 도서 추가
	public int bookInsert(BookDTO dto);
	
	// 2. 도서 수정
	public int bookUpdate(int bookId, BookDTO dto);
	
	// 3. 도서 삭제
	public int bookDelete(int bookId);
	
	// 4. 도서 아이디로 조회
	public BookDTO bookSelectById(int bookId);
	
	// 5. 도서 제목으로 조회
	public List<BookDTO> bookSelectByTitle(String title);
	
	// 6. 전체목록 조회
	public List<BookDTO> bookSelectAll();
	
}
