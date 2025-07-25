package jdbc.mvc.view;

import java.util.Iterator;
import java.util.List;

import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.dto.BookDTO;
import jdbc.mvc.dto.MovieDTO;

/*
 *  뷰 - 결과화면
 *  	 Book에 정보 출력, Book 에러메시지, Book 결과 조회
 */
public class View {

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
	
	public void boardErrorMsg(String msg) {
		switch(msg) {
			case "insert" :
				System.out.println("글 추가 실패!!");
				break;
			case "update":
				System.out.println("글 수정 실패!!");
				break;
			case "delete":
				System.out.println("글 삭제 실패!!");
				break;
			case "select":
				System.out.println("글 데이터가 존재하지 않습니다!!");
				break;
			default :
				System.out.println("ERROR!!");
		}
	}
	
	public void movieErroMsg(String msg) {
		switch(msg) {
			case "insert" :
				System.out.println("영화 추가 실패!!");
				break;
			case "update" :
				System.out.println("영화 수정 실패!!");
				break;
			case "delete" :
				System.out.println("영화 삭제 실패!!");
				break;
			case "select" :
				System.out.println("영화 데이터가 존재하지 않습니다.!!");
				break;
			default : 
				System.out.println("ERROR!!");
		}
	}
	
	// 전체 목록
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
	
	public void boardListAll(List<BoardDTO> list) {
		// 방법1. 향상된 for문 조회
		System.out.println("=== 방법1. 향상된 for문으로 조회 ===");
		for(BoardDTO dto : list) {
			boardSelect(dto);
		}
		System.out.println(); 
		
		// 방법2. Iterator 조회
		System.out.println("=== 방법2. Iterator로 조회 ===");
		Iterator<BoardDTO> ir = list.iterator();
		while(ir.hasNext()) {
			BoardDTO dto = ir.next();
			boardSelect(dto);
		}
	}
	
	public void movieListAll(List<MovieDTO> list) {
		System.out.println("=== 방법1. 향상된 for문으로 조회 ===");
		for(MovieDTO dto : list) {
			movieSelect(dto);
			System.out.println();
		}
		System.out.println();
		System.out.println("=== 방법2. Iterator로 조회 ===");
		Iterator<MovieDTO> ir = list.iterator();
		while(ir.hasNext()) {
			MovieDTO dto = ir.next();
			movieSelect(dto);
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
	
	public void boardSelect(BoardDTO dto) {
		System.out.println("글 번호 : " + dto.getBoardNo());
		System.out.println("글 제목 : " + dto.getBoardTitle());
		System.out.println("글 내용 : " + dto.getBoardContent());
		System.out.println("작성자 : " + dto.getBoardId());
		System.out.println("작성일 : " + dto.getBoardRegDate());
	} 
	
	public void movieSelect(MovieDTO dto) {
		System.out.println("영화 번호 : " + dto.getMovieNo());
		System.out.println("영화 제목 : " + dto.getMovieTitle());
		System.out.println("개봉일 : " + dto.getMovieRegDate());
		System.out.println("등급 : " + dto.getRating());
		System.out.println("장르 : " + dto.getGenre());
		System.out.println("감독 : " + dto.getDirector());
		System.out.println("출연배우 : " + dto.getActor());
		System.out.println("배급사 : " + dto.getDistributor());
	}
}
