package com.movieRating.demo.model;

public class Rating {

	private String Movieid;
	private int rating;

	public Rating() {

	}

	public Rating(String movieid, int rating) {

		Movieid = movieid;
		this.rating = rating;
	}

	public String getMovieid() {
		return Movieid;
	}

	public void setMovieid(String movieid) {
		Movieid = movieid;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [Movieid=" + Movieid + ", rating=" + rating + "]";
	}

}
