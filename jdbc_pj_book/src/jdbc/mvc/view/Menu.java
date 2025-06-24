package jdbc.mvc.view;

import java.util.Scanner;

import jdbc.mvc.controller.BookController;
import jdbc.mvc.dto.BookDTO;

public class Menu {
	
	// 입력을 위한 스캐너
	Scanner sc = new Scanner(System.in);
	// 컨트롤러
	BookController bc = new BookController();
	
	// 1. 도서관리  2. 게시판  3. 내가 좋아하는 주제  4. 종료
	public void displayMenu() {
		
		while(true) {
			System.out.println("*------------------------------------------*");
			System.out.println("    1. 도서관리   2. 게시판    3. 나    4. 종료   ");
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
		
		System.out.println("*--------------------------------------------------------------------------*");
		System.out.println("  1. 추가  2. 수정  3. 삭제  4. 도서아이디 조회  5. 도서목록 타이틀 조회  6. 전체목록 조회  7. 종료  ");
		System.out.println("*--------------------------------------------------------------------------*");
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
				break;
			case 5 :
				break;
			case 6 :
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
	
//	public BookDTO bookUpdate() {
//		 BookDTO dto = new BookDTO();
//		
//		System.out.print("책번호 : ");
//		int id = sc.nextInt();
//		
//		sc.nextLine();
//		
//		dto = bookInput();
//		dto.setBookId(id);
//		
//		return dto;
//	}
	
	public int bookId() {
		System.out.print("책 번호 : ");
		return Integer.parseInt(sc.nextLine());		// String을 int로 변환
	}
	
	public String bookTitle() {
		System.out.print("책 제목 : ");
		return sc.nextLine();
	}

	// 2. 게시판 메뉴
	public void board_menu() {
		System.out.println("<<< board_menu >>>");
	}
	
	// 3. 나
	public void me_menu() {
		System.out.println("<<< me_menu >>>");
	}
}
