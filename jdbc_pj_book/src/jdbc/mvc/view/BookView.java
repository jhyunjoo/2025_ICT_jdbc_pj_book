package jdbc.mvc.view;

import java.util.Iterator;
import java.util.List;

import jdbc.mvc.dto.BookDTO;

/*
 *  뷰 - 결과화면
 *  	 Book에 정보 출력, Book 에러메시지, Book 결과 조회
 */
public class BookView {

	// 에러메시지
	public void bookErrorMsg(String msg) {
		switch(msg) {
			case "insert" :
				System.out.println("도서 추가 실패!!");
				break;
			case "update" :
				System.out.println("도서 수정 실패!!");
				break;
			case "delete" :
				System.out.println("도서 삭제 실패!!");
				break;
			case "select" :
				System.out.println("도서 데이터가 존재하지 않습니다!!");
				break;
			default :
				System.out.println("ERROR!!");
		}
	}
	
	// 전체 도서목록
	public void bookListAll(List<BookDTO> list) {
		// 방법1. 향상된 for문 조회
		System.out.println("=== 방법1. 향상된 for문으로 조회 ===");
		for(BookDTO dto : list) {
			bookSelect(dto);
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("=== 방법2. Iterator로 조회 ===");
		// 방법2. Iterator 조회
		Iterator<BookDTO> ir = list.iterator();
		while(ir.hasNext()) {
			BookDTO dto = ir.next();
			bookSelect(dto);
			System.out.println();
		}
		
	}
	
	// 1건 데이터 조회
	public void bookSelect(BookDTO dto) {
		System.out.println("도서 ID : " + dto.getBookId());
		System.out.println("도서 제목 : " + dto.getTitle());
		System.out.println("도서 저자 : " + dto.getAuthor());
		System.out.println("출판사 : " + dto.getPublisher());
		System.out.println("가격 : " + dto.getPrice());
		System.out.println("출판일 : " + dto.getPubdate());
	}
	
}
