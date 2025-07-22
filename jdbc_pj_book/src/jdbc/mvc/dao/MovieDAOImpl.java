package jdbc.mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jdbc.mvc.dto.MovieDTO;

public class MovieDAOImpl implements MovieDAO{
	
	private static MovieDAOImpl instance = new MovieDAOImpl();
	
	private MovieDAOImpl() {};
	
	public static MovieDAOImpl getInstance() {
		if(instance == null) {
			instance = new MovieDAOImpl();
		}
		return instance;
	}
	
	
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "scott_05";
	String dbPwd = "tiger";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

	@Override
	public int movieInsert(MovieDTO dto) {
		System.out.println("MovieDAOImpl - movieInsert()");
		
		String query = "INSERT INTO mvc_movie_tbl(movieNo, movieTitle, movieRegDate, rating, genre, director, actor, distributor) "
				+ "VALUES((SELECT NVL(MAX(movieNo) + 1, 1) FROM mvc_movie_tbl), ?, ?, ?, ?, ?, ?, ?)";

		int insertCnt = 0;
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getMovieTitle());
			pstmt.setDate(2, Date.valueOf(dto.getMovieRegDate()));
			pstmt.setString(3, dto.getRating());
			pstmt.setString(4, dto.getGenre());
			pstmt.setString(5, dto.getDirector());
			pstmt.setString(6, dto.getActor());
			pstmt.setString(7, dto.getDistributor());
			
			insertCnt = pstmt.executeUpdate();
			
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
		
		return insertCnt;
	}

	@Override
	public int movieUpdate(int movieNo, MovieDTO dto) {
		System.out.println("MovieDAOImpl - movieUpdate()");
		
		String query = "UPDATE mvc_movie_tbl " 
						+ "SET movieTitle = ?, movieRegDate = ?, rating = ?, genre = ?, director = ?, actor = ?, distributor = ? "
						+ "WHERE movieNo = ?";
		int updateCnt = 0;
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getMovieTitle());
			pstmt.setDate(2, Date.valueOf(dto.getMovieRegDate()));
			pstmt.setString(3, dto.getRating());
			pstmt.setString(4, dto.getGenre());
			pstmt.setString(5, dto.getDirector());
			pstmt.setString(6, dto.getActor());
			pstmt.setString(7, dto.getDistributor());
			pstmt.setInt(8, movieNo);
			
			updateCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return updateCnt;
	}

	@Override
	public int movieDelete(int movieNo) {
		System.out.println("MovieDAOImpl - movieDelete()");
		
		String query = "DELETE FROM mvc_movie_tbl WHERE movieNo = ?";
		
		int deleteCnt = 0;
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, movieNo);
			
			deleteCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteCnt;
	}

	@Override
	public MovieDTO movieSelectByNo(int movieNo) {
		System.out.println("MovieDAOImpl - movieSelectByNo()");
		
		String query = "SELECT * FROM mvc_movie_tbl WHERE movieNo = ?";
		
		MovieDTO dto = new MovieDTO();
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = movieInput(rs, dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
				if(rs != null) rs.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public List<MovieDTO> movieSelectByTitle(String movieTitle) {
		System.out.println("MovieDAOImpl - movieSelectByTitle()");
		
		String query = "SELECT * FROM mvc_movie_tbl WHERE movieTitle LIKE '%' || ? || '%'";
		
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, movieTitle);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto = movieInput(rs, dto);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
				if(rs != null) rs.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<MovieDTO> movieSelectByGenre(String genre) {
		System.out.println("MovieDAOImpl - movieSelectByGenre()");
		
		String query = "SELECT * FROM mvc_movie_tbl WHERE genre like '%' || ? || '%'";
		
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, genre);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto = movieInput(rs, dto);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
				if(rs != null) rs.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<MovieDTO> movieSelectByAll() {
		System.out.println("MovieDAOImpl - movieSelectByAll()"); 
		
		String query = "SELECT * FROM mvc_movie_tbl ORDER BY movieNo";
		
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto = movieInput(rs, dto);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) conn.close();
				if(rs != null) rs.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	private MovieDTO movieInput(ResultSet rs, MovieDTO dto) throws SQLException {
		dto.setMovieNo(rs.getInt("movieNo"));
		dto.setMovieTitle(rs.getString("movieTitle"));
		dto.setMovieRegDate(rs.getString("movieRegDate"));
		dto.setRating(rs.getString("rating"));
		dto.setGenre(rs.getString("genre"));
		dto.setDirector(rs.getString("director"));
		dto.setActor(rs.getString("actor"));
		dto.setDistributor(rs.getString("distributor"));
		
		return dto;
	}

}
