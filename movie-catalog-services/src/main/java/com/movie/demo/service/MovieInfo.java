package com.movie.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.movie.demo.model.CatalogItem;
import com.movie.demo.model.Movie;
import com.movie.demo.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallBackCatalogItem")
	public CatalogItem getCatalogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieid(), Movie.class);
		return new CatalogItem(movie.getName(), "full climax", rating.getRating());

	}

	private CatalogItem getFallBackCatalogItem(Rating rating) {
		return new CatalogItem("Movie not found", "", rating.getRating());
	}

}
