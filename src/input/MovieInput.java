package input;

import java.util.ArrayList;

public class MovieInput {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    private int numLikes;

    private double rating;

    private int numRatings;

    private final ArrayList<Integer> ratings =  new ArrayList<>();

    /**
     * @return the list of all the ratings a movie has
     */
    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    /**
     * @return the total number of likes
     */
    public int getNumLikes() {
        return numLikes;
    }

    /**
     * @param numLikes changes it
     */
    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    /**
     * @return the calculated rating of the movie
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating changes it
     */
    public void setRating(final double rating) {
        this.rating = rating;
    }

    /**
     * @return the total number of ratings given
     */
    public int getNumRatings() {
        return numRatings;
    }

    /**
     * @param numRatings changes it
     */
    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    public MovieInput() {
    }

    public MovieInput(final String name, final String year, final int duration,
                      final ArrayList<String> genres, final ArrayList<String> actors,
                      final ArrayList<String> countriesBanned) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.genres = genres;
        this.actors = actors;
        this.countriesBanned = countriesBanned;
    }

    /**
     * @return the name of the movie
     */
    public String getName() {
        return name;
    }

    /**
     * @param name changes it
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the year of the movie
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year changes it
     */
    public void setYear(final String year) {
        this.year = year;
    }

    /**
     * @return the length of the movie
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration changes it
     */
    public void setDuration(final int duration) {
        this.duration = duration;
    }

    /**
     * @return the genres of the movie
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * @param genres changes it
     */
    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * @return the actors of the movie
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * @param actors changes it
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * @return the countries in which the movie is forbidden
     */
    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    /**
     * @param countriesBanned changes it
     */
    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }
}
