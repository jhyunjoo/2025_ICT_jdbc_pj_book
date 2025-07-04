package jdbc.mvc.dto;

import java.sql.Date;	// 주의

public class BoardDTO {

	private int boardNo;			// 글번호(PK)
	private String boardTitle;		// 글제목
	private String boardContent;	// 글내용
	private String boardId;			// 작성자
	private String boardRegDate;		// 작성일
	
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(int boardNo, String boardTitle, String boardContent, String boardId, String boardRegDate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardId = boardId;
		this.boardRegDate = boardRegDate;
	}

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	
	public String getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(String boardRegDate) {
		this.boardRegDate = boardRegDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardId=" + boardId + ", boardRegDate=" + boardRegDate + "]";
	}
	
}
