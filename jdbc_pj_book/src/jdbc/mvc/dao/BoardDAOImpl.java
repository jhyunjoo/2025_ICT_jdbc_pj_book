package jdbc.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.mvc.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO{
	
	private static BoardDAOImpl instance = new BoardDAOImpl();
	
	private BoardDAOImpl() {};
	
	public static BoardDAOImpl getInstance() {
		if(instance == null) {
			instance = new BoardDAOImpl();
		}
		return instance;
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbID = "scott_05";
	String dbPW = "tiger";

	// 1. 추가
	@Override
	public int boardAdd(BoardDTO dto) {
		System.out.println("BoardDAOImpl - boardAdd()");
		System.out.println(dto);
		
		int insertInt = 0;
		
		String query = "insert into mvc_board_tbl(boardNo, boardTitle, boardContent, boardId) " +
						"values((select NVL(MAX(boardNo) + 1, 1) from mvc_board_tbl), ? , ? , ? )";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getBoardTitle());
			pstmt.setString(2, dto.getBoardContent());
			pstmt.setString(3, dto.getBoardId());
			
			insertInt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return insertInt;
	}

	// 2. 수정
	@Override
	public int boardUpdate(int boardNo, BoardDTO dto) {
		System.out.println("BoardDAOImpl - boardUpdate()");
		
		int updateCnt = 0;
		
		String sql = "UPDATE mvc_board_tbl SET boardTitle = ? , boardContent = ? , boardId = ? WHERE boardNo = ?";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardTitle());
			pstmt.setString(2, dto.getBoardContent());
			pstmt.setString(3, dto.getBoardId());
			pstmt.setInt(4, boardNo);
			
			updateCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(conn != null) conn.close();
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return updateCnt;
	}

	// 3. 삭제
	@Override
	public int boardDelete(int boardNo) {
		System.out.println("BoardDAOImpl - boardDelete()");
		
		int deleteCnt = 0;
		
		String query = "DELETE FROM mvc_board_tbl WHERE boardNo = ?";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			deleteCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return deleteCnt;
	}

	// 4. 게시 글번호 조회
	@Override
	public BoardDTO boardSelectByNo(int boardNo) {
		System.out.println("BoardDAOImpl - boardSelectByNo()");
		
		BoardDTO dto = new BoardDTO();
		
		String query = "SELECT * FROM mvc_board_tbl WHERE boardNo = ? ";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setBoardNo(rs.getInt("boardNo"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setBoardContent(rs.getString("boardContent"));
				dto.setBoardId(rs.getString("boardId"));
				dto.setBoardRegDate(rs.getString("boardRegDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	// 5. 글 제목으로 조회
	@Override
	public List<BoardDTO> boardSelectByTitle(String title) {
		System.out.println("BoardDAOImpl - boardSelectByTitle()");
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String query = "SELECT * FROM mvc_board_tbl WHERE boardTitle like '%' || ? || '%'";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = boardDTOSet(rs);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// 6. 작성자 조회
	@Override
	public List<BoardDTO> boardSelectById(String id) {
		System.out.println("BoardDAOImpl - boardSelectById()");
		
		List<BoardDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM mvc_board_tbl WHERE boardId = ? ORDER BY boardNo";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = boardDTOSet(rs);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// 7. 전체목록 조회
	@Override
	public List<BoardDTO> boardSelectByAll() {
		System.out.println("BoardDAOImpl - boardSelectByAll()");
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		String query = "SELECT * FROM mvc_board_tbl ORDER BY boardNo";
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbID, dbPW);
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = boardDTOSet(rs);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// boardDTO에 담기
	private BoardDTO boardDTOSet(ResultSet rs) throws SQLException {
		BoardDTO dto = new BoardDTO();
		dto.setBoardNo(rs.getInt("boardNo"));
		dto.setBoardTitle(rs.getString("boardTitle"));
		dto.setBoardContent(rs.getString("boardContent"));
		dto.setBoardId(rs.getString("boardId"));
		dto.setBoardRegDate(rs.getString("boardRegDate"));
		return dto;
	}
}
