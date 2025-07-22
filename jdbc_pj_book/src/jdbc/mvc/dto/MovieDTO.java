package jdbc.mvc.dto;

public class MovieDTO {
	
	private int movieNo;			// 영화번호
	private String movieTitle;		// 영화제목
	private String movieRegDate;	// 개봉일
	private String rating;			// 등급
	private String genre;			// 장르
	private String director;		// 감독
	private String actor;			// 출연배우
	private String distributor;		// 배급사
	
	public MovieDTO() {
		super();
	}

	public MovieDTO(int movieNo, String movieTitle, String movieRegDate, String rating, String genre, String director,
			String actor, String distributor) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.movieRegDate = movieRegDate;
		this.rating = rating;
		this.genre = genre;
		this.director = director;
		this.actor = actor;
		this.distributor = distributor;
	}

	public int getMovieNo() {
		return movieNo;
	}

	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getMovieRegDate() {
		return movieRegDate;
	}

	public void setMovieRegDate(String movieRegDate) {
		this.movieRegDate = movieRegDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", movieRegDate=" + movieRegDate
				+ ", rating=" + rating + ", genre=" + genre + ", director=" + director + ", actor=" + actor
				+ ", distributor=" + distributor + "]";
	}
}
