package jdbc.mvc.view;

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
				System.out.println("도서 조회 실패!!");
				break;
			default :
				System.out.println("ERROR!!");
		}
	}
}
