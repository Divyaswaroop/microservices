package mymicroservice.demo.moviecatalogservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalogForUserId(@PathVariable("userId") String userId) {

		// Instead of restTemplate we can use Webclient - add webflux dependecy in pom
		// to use this
		// WebClient.Builder builder = WebClient.builder();
		// Assume this is the response from Rating service API

		// Talk to Movie rating microservice and get list of all the movies rated by the
		// given user
		UserRating ratings = restTemplate.getForObject("http://movie-rating-service/ratings/users/" + userId,
				UserRating.class);

		return ratings.getUserRatings().stream().map(rating -> {

			// Communicating with Movie info microservice usign RestTemplate
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);

			// Talking to Movie info microservice using WebClient
			/*
			 * Movie movie = webClientBuilder.build() .get()
			 * .uri("http://localhost:8081/movies/"+rating.getMovieId()) .retrieve()
			 * .bodyToMono(Movie.class) .block();
			 */
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
		}).collect(Collectors.toList());

	}

}
