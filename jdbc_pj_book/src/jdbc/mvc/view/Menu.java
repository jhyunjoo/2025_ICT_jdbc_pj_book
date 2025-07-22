package jdbc.mvc.view;

import java.util.Scanner;

import jdbc.mvc.controller.BoardController;
import jdbc.mvc.controller.BookController;
import jdbc.mvc.controller.MovieController;
import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.dto.BookDTO;
import jdbc.mvc.dto.MovieDTO;

public class Menu {
	
	// 입력을 위한 스캐너
	Scanner sc = new Scanner(System.in);
	// 컨트롤러
	BookController bc = new BookController();
	BoardController boardCr = new BoardController();
	MovieController mc = new MovieController();
	
	// 1. 도서관리  2. 게시판  3. 내가 좋아하는 주제  4. 종료
	public void displayMenu() {
		
		while(true) {
			System.out.println("*------------------------------------------*");
			System.out.println("    1. 도서관리   2. 게시판    3. 영화   4. 종료   ");
			System.out.println("*------------------------------------------*");
			System.out.print("▶ 메뉴 선택 : ");
			int menuNo = sc.nextInt();
			sc.nextLine();
			
			switch(menuNo) {
				case 1 :
					book_menu();
					break;
				case 2 :
					board_menu();
					break;
				case 3 :
					movie_menu();
					break;
				case 4 : 
					System.out.println("프로그램을 종료합니다.");
					System.out.println();
					return;
				default :
					System.out.println("메뉴를 다시 선택해주세요.");
			} // switch
		} // while
	}

	// ------------------------------------------------------------------
	// 1. 도서관리 메뉴
	public void book_menu() {
		System.out.println("<<< book_menu >>>");
		
		System.out.println("*-------------------------------------------------------------------------------*");
		System.out.println("  1. 추가  2. 수정  3. 삭제  4. 도서 아이디로 조회  5. 도서 제목으로 조회  6. 전체목록 조회  7. 종료  ");
		System.out.println("*-------------------------------------------------------------------------------*");
		System.out.print("▶ 메뉴 선택 : ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
			case 1 :
				bc.bookAdd(bookInput());
				break;
			case 2 :
				bc.bookUpdate(bookId(), bookInput());
				break;
			case 3 :
				bc.bookDelete(bookId());
				break;
			case 4 :
				bc.bookSelectId(bookId());
				break;
			case 5 :
				bc.bookSelectTitle(bookTitle());
				break;
			case 6 :
				bc.bookSelectAll();
				break;
			case 7 : 
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				return;
			default :
				System.out.println("메뉴를 다시 선택해주세요.");
		} // switch
	}
	
	// 1--1. book 추가
	private BookDTO bookInput() {
		
		// 콘솔에서 입력받은 값 -> setter 로 BookDTO 멤버변수에 전달
		// BookDTO 생성
		BookDTO dto = new BookDTO();
		
		System.out.print("도서명 : ");
		dto.setTitle(sc.nextLine());
		
		System.out.print("저자 : ");
		dto.setAuthor(sc.nextLine());
		
		System.out.print("출판사 : ");
		dto.setPublisher(sc.nextLine());
		
		System.out.print("가격 : ");
		dto.setPrice(sc.nextInt());
		
		return dto;
	}
	
	private int bookId() {
		System.out.print("책 번호 : ");
		return Integer.parseInt(sc.nextLine());		// String을 int로 변환
	}
	
	private String bookTitle() {
		System.out.print("책 제목 : ");
		return sc.nextLine();
	}

	// 2. 게시판 메뉴
	public void board_menu() {
		System.out.println("<<< board_menu >>>");
		
		System.out.println("*------------------------------------------------------------------------------------------*");
		System.out.println("  1. 추가  2. 수정  3. 삭제  4. 게시 글번호 조회  5. 글 제목으로 조회 6. 작성자 조회  7. 전체목록 조회  8. 종료  ");
		System.out.println("*------------------------------------------------------------------------------------------*");
		System.out.print("▶ 메뉴 선택 : ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
			case 1:
				boardCr.boardAdd(boardInput()); 
				break;
			case 2:
				boardCr.boardUpdate(boardNo() ,boardInput());
				break;
			case 3:
				boardCr.boardDelete(boardNo());
				break;
			case 4:	
				boardCr.boardSelectByNo(boardNo());
				break;
			case 5:
				boardCr.boardSelectByTitle(boardTitle());
				break;
			case 6:
				boardCr.boardSelectById(boardId());
				break;
			case 7:
				boardCr.boardSelectByAll();
				break;
			case 8:
				System.out.println("프로그램을 종료합니다");
				System.out.println();
				return;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");
		} // switch
	}
	
	private BoardDTO boardInput() {
		
		BoardDTO dto = new BoardDTO();
		
		System.out.print("글 제목 : ");
		dto.setBoardTitle(sc.nextLine()); 
		System.out.print("글 내용 : ");
		dto.setBoardContent(sc.nextLine()); 
		System.out.print("작성자 : ");
		dto.setBoardId(sc.nextLine()); 
		
		return dto;
	}
	
	private int boardNo() {
		System.out.print("글 번호 : ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		return boardNo;
	}
	
	private String boardTitle() {
		System.out.print("글 제목 : ");
		String boardTitle = sc.nextLine();
		return boardTitle;
	}
	
	private String boardId() {
		System.out.print("작성자 : ");
		String boardId = sc.nextLine();
		return boardId;
	}

	// 3. 영화
	public void movie_menu() {
		System.out.println("<<< movie_menu >>>");
		
		System.out.println("*------------------------------------------------------------------------------------------*");
		System.out.println("1.추가   2.수정   3. 삭제   4.영화번호 조회   5.영화제목 조회   6. 영화장르 조회   7. 전체목록 조회   8. 종료");
		System.out.println("*------------------------------------------------------------------------------------------*");
		System.out.print("▶ 메뉴 선택 : ");
		int menuNo = sc.nextInt();
		sc.nextLine();
		
		switch(menuNo) {
			case 1 :
				mc.movieInsert(movieInput());
				break;
			case 2 :
				mc.movieUpdate(movieNo(), movieInput());
				break;
			case 3 :
				mc.movieDelete(movieNo());
				break;
			case 4 :
				mc.movieSelectByNo(movieNo());
				break;
			case 5 :
				mc.movieSelectByTitle(movieTitle());
				break;
			case 6 :
				mc.movieSelectByGenre(movieGenre());
				break;
			case 7 :
				mc.movieSelectByAll();
				break;
			case 8 :
				System.out.println("프로그램을 종료합니다.");
				System.out.println();
				return;
			default :
				System.out.println("메뉴를 선택해주세요.");
		}
	}
	
	private MovieDTO movieInput() {
		
		MovieDTO dto = new MovieDTO();
		
		System.out.print("영화 제목 : ");
		dto.setMovieTitle(sc.nextLine()); 
		
		System.out.print("개봉일 : ");
		dto.setMovieRegDate(sc.nextLine()); 
		
		System.out.print("등급 : ");
		dto.setRating(sc.nextLine()); 
		
		System.out.print("장르 : ");
		dto.setGenre(sc.nextLine()); 
		
		System.out.print("감독 : ");
		dto.setDirector(sc.nextLine()); 
		
		System.out.print("출연배우 : ");
		dto.setActor(sc.nextLine()); 
		
		System.out.print("배급사 : ");
		dto.setDistributor(sc.nextLine()); 
		
		return dto;
	}
	
	private int movieNo() {
		System.out.print("영화번호 : ");
		int movieNo = sc.nextInt();
		sc.nextLine();
		
		return movieNo;
	}
	
	private String movieTitle() {
		System.out.print("영화제목 : ");
		return sc.nextLine();
	}
	
	private String movieGenre() {
		System.out.print("장르 : ");
		return sc.nextLine();
	}
}
