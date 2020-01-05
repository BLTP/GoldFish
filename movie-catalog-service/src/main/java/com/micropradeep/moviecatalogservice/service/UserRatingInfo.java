package com.micropradeep.moviecatalogservice.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micropradeep.moviecatalogservice.model.Rating;
import com.micropradeep.moviecatalogservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating getUserRating(int userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId, UserRating.class);
	}

	public UserRating getFallbackUserRating(int userId) {
	
		UserRating userRating=new UserRating();
		userRating.setId(userId);
		userRating.setRatings(Arrays.asList(new Rating(0,0),new Rating(0,0)));
		return userRating;
	}
}
