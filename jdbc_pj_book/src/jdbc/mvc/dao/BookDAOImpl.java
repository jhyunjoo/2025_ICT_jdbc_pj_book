package jdbc.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.mvc.dto.BookDTO;

// DAO - DB 처리(DB연결, 데이터 CRUD)
public class BookDAOImpl implements BookDAO {
	
	// 싱글톤
	private static BookDAOImpl instance = new BookDAOImpl();
	
	private BookDAOImpl() {};
	
	public static BookDAOImpl getInstance() {
		if(instance == null) {
			instance = new BookDAOImpl();
		}
		return instance;
	}

	// DB 연결
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbID = "scott_05";		// 계정
	String dbPW = "tiger";			// 비밀번호
	
	Connection conn = null;				// 오라클 연결 
	PreparedStatement pstmt = null;		// SQL 문장을 담음
	ResultSet rs = null;				// SQL 실행결과(SELECT절에서만 사용)
	
	// 1. 도서 추가
	@Override
	public int bookInsert(BookDTO dto) {
		System.out.println("BookDAOImpl - bookInsert()");
		
		int insertCnt = 0;
		
		String query = "INSERT INTO mvc_book_tbl(bookId, title, author, publisher, price) " 
					 + "VALUES((SELECT NVL(MAX(bookId)+1, 1) FROM MVC_BOOK_TBL), ?, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);		// 오라클 연결
			pstmt = conn.prepareStatement(query);						// SQL문 작성
			pstmt.setString(1, dto.getTitle());		// 1은 물음표 위치, title
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getPublisher());
			pstmt.setInt(4, dto.getPrice());
			
			insertCnt = pstmt.executeUpdate();		// executeUpdate() => I, U, D의 SQL 실행 => 1 : 성공 / 0 : 실패
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return insertCnt;
	}

	// 2. 도서 수정
	@Override
	public int bookUpdate(int bookId, BookDTO dto) {
		System.out.println("BookDAOImpl - bookUpdate()");
		
		String query = "UPDATE MVC_BOOK_TBL SET title = ?, author = ?, publisher = ?, price = ? WHERE bookId = ?";
		
		int updateCnt = 0;
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setString(3, dto.getPublisher());
			pstmt.setInt(4, dto.getPrice());
			pstmt.setInt(5, bookId);
			
			updateCnt = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateCnt;
	}

	// 3. 도서 삭제
	@Override
	public int bookDelete(int bookId) {
		System.out.println("BookDAOImpl - bookDelete()");
		
		String query = "DELETE FROM MVC_BOOK_TBL WHERE bookId = ?";
		
		int deleteCnt = 0;
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			deleteCnt = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteCnt;
	}

	// 4. 도서 아이디로 조회
	@Override
	public BookDTO bookSelectById(int bookId) {
		System.out.println("BookDAOImpl - bookDelete()");
		
		String query = "SELECT * FROM MVC_BOOK_TBL WHERE bookId = ?";
		BookDTO dto = new BookDTO();
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setBookId(rs.getInt("bookId"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubdate(rs.getString("pubdate"));
			} 
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	// 5. 도서 제목으로 조회
	@Override
	public List<BookDTO> bookSelectByTitle(String title) {
		System.out.println("BookDAOImpl - SelectBookByTItles()");
		
		List<BookDTO> list = new ArrayList<BookDTO>();

		String query = "SELECT * FROM MVC_BOOK_TBL WHERE title LIKE '%' || ? || '%'";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			//String like_title = "%" + title + "%";
			//pstmt.setString(1, like_title);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				
				dto.setBookId(rs.getInt("bookId"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubdate(rs.getString("pubdate"));
				
				list.add(dto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) rs.close();
				if(conn != null) rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// 6. 전체 목록 조회
	@Override
	public List<BookDTO> bookSelectAll() {
		System.out.println("BookDAOImpl - bookSelectAll()");
		
		// 리스트 생성
		List<BookDTO> list = new ArrayList<BookDTO>();
		
		// bookid로 정렬해서 전체 정보조회
		String query = "SELECT * FROM MVC_BOOK_TBL ORDER BY bookId";
		
		try {
			// 연결
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			
			// 조회
			rs = pstmt.executeQuery();	// 실행문장

			while(rs.next()) {
				// 각각의 DTO 생성 -> set -> list에 추가
				BookDTO dto = new BookDTO();
				
				dto.setBookId(rs.getInt("bookId"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setPubdate(rs.getString("pubdate"));
				
				list.add(dto);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
