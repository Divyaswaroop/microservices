package mymicroservice.demo.moviecatalogservice;

public class CatalogItem {

	
	private String title;
	private String description;
	private int ratings;
	
	
	
	public CatalogItem(String title, String description, int ratings) {
		super();
		this.title = title;
		this.description = description;
		this.ratings = ratings;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
	
	
	
}
