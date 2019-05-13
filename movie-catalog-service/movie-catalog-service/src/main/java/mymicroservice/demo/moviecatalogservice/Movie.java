package mymicroservice.demo.moviecatalogservice;

public class Movie {

	private String name;
	private String movieId;
	private String description;

	
	public Movie() {
		
	}
	
	
	

	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Movie(String name, String movieId,String description) {
		super();
		this.name = name;
		this.movieId = movieId;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

}
