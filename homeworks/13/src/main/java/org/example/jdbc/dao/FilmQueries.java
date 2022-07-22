package org.example.jdbc.dao;

public interface FilmQueries {
    String GET_FILM_BY_ID = "SELECT * FROM film WHERE film_id = ?";
    String GET_FILM_BY_title = "SELECT * FROM film WHERE lower(title) like ?";
    String GET_FILM_BY_YEAR = "SELECT * FROM film WHERE release_year = ?";

    String GET_FILM_BY_ID_NAMED = "SELECT * FROM film WHERE film_id = :filmId";

    String GET_FILM_BY_title_NAMED = "SELECT * FROM film WHERE lower(title) like :title";

    String GET_FILM_BY_YEAR_NAMED = "SELECT * FROM film WHERE release_year = :year";
    String GET_ACTOR_BY_id =  "SELECT * FROM actor WHERE actor_id = ?";

    String GET_ACTOR_BY_Actor = "SELECT * FROM actor WHERE first_name  = ?";
    String GET_MOVIE_BY_Actor = "SELECT  * from (SELECT * FROM actor a INNER JOIN film_actor fa  ON a.actor_id =fa.actor_id  ) tm JOIN film f  ON tm.film_id=f.film_id where tm.first_name= ?";
}
