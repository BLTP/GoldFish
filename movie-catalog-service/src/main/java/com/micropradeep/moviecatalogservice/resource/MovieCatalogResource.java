package com.micropradeep.moviecatalogservice.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micropradeep.moviecatalogservice.model.CatalogItem;
import com.micropradeep.moviecatalogservice.model.Movie;
import com.micropradeep.moviecatalogservice.model.Rating;
import com.micropradeep.moviecatalogservice.model.UserRating;
import com.micropradeep.moviecatalogservice.service.MovieInfo;
import com.micropradeep.moviecatalogservice.service.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private MovieInfo movieInfo;
	@Autowired
	private UserRatingInfo userRatingInfo;
	@Autowired
	private RestTemplate restTemplate;
//	@Autowired
//	private WebClient.Builder builder;

	@RequestMapping("/{userId}")
	
	public List<CatalogItem> getCatalog(@PathVariable("userId") int userId) {

		// List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new
		// Rating("56789", 3));
		UserRating ratings = userRatingInfo.getUserRating(userId);
		return ratings.getRatings().stream().map(x -> {

			return movieInfo.getCatalogItem(x);

		}).collect(Collectors.toList());
	}

	

	

	

//	Movie movie =builder.build()
//	.get()
//	.uri("http://localhost:8082/movies/" + x.getMovieId())
//	.retrieve()
//	.bodyToMono(Movie.class)
//	.block();

}
