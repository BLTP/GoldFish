package com.micropradeep.moviecatalogservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.micropradeep.moviecatalogservice.model.CatalogItem;
import com.micropradeep.moviecatalogservice.model.Movie;
import com.micropradeep.moviecatalogservice.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Http.Header;

@Service
public class MovieInfo {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem(Rating x) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + x.getId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), x.getRating());
	}

	public CatalogItem getFallbackCatalogItem(Rating x) {
		return new CatalogItem("Movie name not found", "", x.getRating());
		
	}
}
