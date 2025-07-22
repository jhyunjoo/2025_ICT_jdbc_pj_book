package jdbc.mvc.controller;

import java.util.List;

import jdbc.mvc.dto.MovieDTO;
import jdbc.mvc.service.MovieServiceImpl;
import jdbc.mvc.view.View;

public class MovieController {
	
	MovieServiceImpl service = new MovieServiceImpl();
	View view = new View();

	// 1. 추가
	public void movieInsert(MovieDTO dto) {
		System.out.println("MovieController - movieInsert()");
		int insertCnt = service.movieInsert(dto);
		if(insertCnt == 1) {
			System.out.println("영화 추가 성공" + insertCnt);
		} else {
			view.boardErrorMsg("select");
		}
	}
	
	// 2. 수정
	public void movieUpdate(int movieNo, MovieDTO dto) {
		System.out.println("MovieController - movieUpdate()");
		int updateCnt = service.movieUpdate(movieNo, dto);
		if(updateCnt == 1) {
			System.out.println("영화 수정 성공" + updateCnt);
		} else {
			view.boardErrorMsg("update");
		}
	}
	
	// 3. 삭제
	public void movieDelete(int movieNo) {
		System.out.println("MovieController - movieDelete()");
		int deleteCnt = service.movieDelete(movieNo);
		if(deleteCnt == 1) {
			System.out.println("영화 삭제 성공" + deleteCnt);
		} else {
			view.boardErrorMsg("delete");
		}
	}
	
	// 4. 영화번호 조회
	public void movieSelectByNo(int movieNo) {
		System.out.println("MovieController - movieSelectByNo()");
		MovieDTO dto = service.movieSelectByNo(movieNo);
		if(movieNo == dto.getMovieNo()) {
			view.movieSelect(dto);
		} else {
			view.boardErrorMsg("select");
		}
		
	}
	
	// 5. 영화제목 조회
	public void movieSelectByTitle(String movieTitle) {
		System.out.println("MovieController - movieSelectByTitle()");
		List<MovieDTO> list = service.movieSelectByTitle(movieTitle);
		if(!list.isEmpty()) {
			view.movieListAll(list);
		} else {
			view.boardErrorMsg("select");
		}
	}
	
	// 6. 영화등급 조회
	public void movieSelectByGenre(String genre) {
		System.out.println("MovieController - movieSelectByGenre()");
		List<MovieDTO> list = service.movieSelectByGenre(genre);
		if(!list.isEmpty()) {
			view.movieListAll(list);
		} else {
			view.boardErrorMsg("select");
		}
	}
	
	// 7. 전체목록 조회
	public void movieSelectByAll() {
		System.out.println("MovieController - movieSelectByAll()");
		List<MovieDTO> list = service.movieSelectByAll();
		if(!list.isEmpty()) {
			view.movieListAll(list);
		} else {
			view.boardErrorMsg("select");
		}
	}
	
}
