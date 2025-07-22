package jdbc.mvc.service;

import java.util.List;

import jdbc.mvc.dao.MovieDAOImpl;
import jdbc.mvc.dto.MovieDTO;

public class MovieServiceImpl implements MovieService{

	MovieDAOImpl dao = MovieDAOImpl.getInstance();
	
	@Override
	public int movieInsert(MovieDTO dto) {
		System.out.println("MovieServiceImpl - movieInsert()");
		int insertCnt = dao.movieInsert(dto);
		return insertCnt;
	}

	@Override
	public int movieUpdate(int movieNo, MovieDTO dto) {
		System.out.println("MoveiServiceImpl - movieUpdate()");
		int updateCnt = dao.movieUpdate(movieNo, dto);
		return updateCnt;
	}

	@Override
	public int movieDelete(int movieNo) {
		System.out.println("MoveiServiceImpl - movieDelete()");
		int deleteCnt = dao.movieDelete(movieNo);
		return deleteCnt;
	}

	@Override
	public MovieDTO movieSelectByNo(int movieNo) {
		System.out.println("MoveiServiceImpl - movieSelectByNo()");
		MovieDTO dto = dao.movieSelectByNo(movieNo);
		return dto;
	}

	@Override
	public List<MovieDTO> movieSelectByTitle(String movieTitle) {
		System.out.println("MoveiServiceImpl - movieSelectByTitle()");
		List<MovieDTO> list = dao.movieSelectByTitle(movieTitle);
		return list;
	}

	@Override
	public List<MovieDTO> movieSelectByGenre(String genre) {
		System.out.println("MoveiServiceImpl - movieSelectbyGenre()");
		List<MovieDTO> list = dao.movieSelectByGenre(genre);
		return list;
	}

	@Override
	public List<MovieDTO> movieSelectByAll() {
		System.out.println("MoveiServiceImpl - movieSelectByAll()");
		List<MovieDTO> list = dao.movieSelectByAll();
		return list;
	}

}
