package com.micropradeep.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micropradeep.ratingsdataservice.model.Rating;
import com.micropradeep.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping(value="/ratingsdata",produces = { MediaType.APPLICATION_JSON_VALUE })
public class RatingsResource {

	
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") int movieId) {
		return new Rating( movieId, 4);
	}

	@RequestMapping("users/{userId}")
	public UserRating  getUserRating(@PathVariable("userId") int userId)
	{
		List<Rating> ratings =Arrays.asList(new Rating(100,4),new Rating(105,2));
		UserRating userRating=new UserRating();
		userRating.setId(userId);
		userRating.setRatings(ratings);
		
		return userRating ;
}
}
