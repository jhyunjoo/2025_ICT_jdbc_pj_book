package jdbc.mvc.view;

import java.util.Scanner;

import jdbc.mvc.controller.BoardController;
import jdbc.mvc.controller.BookController;
import jdbc.mvc.dto.BoardDTO;
import jdbc.mvc.dto.BookDTO;

public class Menu {
	
	// 입력을 위한 스캐너
	Scanner sc = new Scanner(System.in);
	// 컨트롤러
	BookController bc = new BookController();
	BoardController boardCr = new BoardController();
	
	// 1. 도서관리  2. 게시판  3. 내가 좋아하는 주제  4. 종료
	public void displayMenu() {
		
		while(true) {
			System.out.println("*------------------------------------------*");
			System.out.println("    1. 도서관리   2. 게시판    3. 고양이   4. 종료   ");
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
					me_menu();
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

	// 3. 나
	public void me_menu() {
		System.out.println("<<< me_menu >>>");
	}
}
