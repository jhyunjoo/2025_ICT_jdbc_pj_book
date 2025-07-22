package jdbc.mvc.dao;

import java.util.List;

import jdbc.mvc.dto.MovieDTO;

public interface MovieDAO {
	
	// 1. 추가
	public int movieInsert(MovieDTO dto);
	
	// 2. 수정
	public int movieUpdate(int movieNo, MovieDTO dto);
	
	// 3. 삭제
	public int movieDelete(int movieNo);
	
	// 4. 영화번호 조회
	public MovieDTO movieSelectByNo(int movieNo);
	
	// 5. 영화제목 조회
	public List<MovieDTO> movieSelectByTitle(String movieTitle);
	
	// 6. 영화등급 조회
	public List<MovieDTO> movieSelectByGenre(String genre);
	
	// 7. 전체목록 조회
	public List<MovieDTO> movieSelectByAll();

}
