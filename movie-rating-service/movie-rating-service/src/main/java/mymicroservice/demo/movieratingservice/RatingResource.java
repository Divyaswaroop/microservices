package mymicroservice.demo.movieratingservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratings")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId,4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getRatingList(@PathVariable("userId") String userId) {


		List<Rating> ratings = Arrays.asList(
				new Rating("SpiderMan", 4), 
				new Rating("Avengers", 5)
				);
		
		UserRating userRating = new UserRating();
		userRating.setUserRatings(ratings);
		
		return userRating;
				
	}
}
