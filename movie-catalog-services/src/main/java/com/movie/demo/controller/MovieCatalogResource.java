package com.movie.demo.controller;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.demo.model.CatalogItem;
import com.movie.demo.model.Movie;
import com.movie.demo.model.Rating;
import com.movie.demo.model.UserRating;
import com.movie.demo.service.MovieInfo;
import com.movie.demo.service.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder builder;

	@Autowired
	private MovieInfo movieInfo;

	@Autowired
	private UserRatingInfo userRatingInfo;

	@GetMapping("/{userId}")
	// @HystrixCommand(fallbackMethod = "getFallBackCatalog")
	// in the case of any failure getFallBackCatalog this method will be execute.
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

//		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId,
//				UserRating.class);

		// this time instead of passing localhost:port no we are passing the name of the
		// service
		// because we have enabled @@LoadBalanced. it will ask eureka for that name.
		UserRating ratings = userRatingInfo.getUserRating(userId);

		return ratings.getUserRating().stream().map(rating ->

		// making call using RestTemplate
		// Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" +
		// rating.getMovieid(), Movie.class);

		movieInfo.getCatalogItem(rating)

		// making call using web client(this is latest way).
		// we are making get call that's why giving get() method, we can also give
		// post().
//			Movie movie = builder.build().get().uri("http://localhost:8082/movies/" + rating.getMovieid()).retrieve()
//					.bodyToMono(Movie.class).block();

		).collect(Collectors.toList());

		// get all rated movie ids

		// for each movie id call the movie info service and get details.

		// put them all together

//		return Collections.singletonList(new CatalogItem("Dhamam", "full climax", 9)
//
//		);

	}

//
//	public List<CatalogItem> getFallBackCatalog(@PathVariable("userId") String userId) {
//
//		return Arrays.asList(new CatalogItem("No Movie", "", 0));
//	}
}
