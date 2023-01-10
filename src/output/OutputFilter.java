package output;

import actiontypes.change.Movies;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.ActionInput;
import input.FiltersInput;
import input.Input;
import input.MovieInput;

import java.util.ArrayList;

public class OutputFilter {
    /**
     * method that creates the output for the filter action
     * @param input the information from the input
     * @param actionInput the data of the action
     * @param output where we will write the output
     */
    public void createOutputFilter(final Input input, final ActionInput actionInput,
                                   final ArrayNode output) {

        FiltersInput filtersInput = actionInput.getFilters();

        // creating a new list for the sorted movies
        boolean check = true;
        ArrayList<MovieInput> sortedMovies = new ArrayList<>();

        Movies.initializeCurrMovies(input);

        // verifying if we have restrictions about the content
        if (filtersInput.getContains() != null) {

            for (MovieInput movieInput : input.getCurrMoviesList()) {
                if (filtersInput.getContains().getActors() != null) {
                    ArrayList<String> actors = filtersInput.getContains().getActors();

                    // adding all the movies that have the actors from the list
                    for (String actorFilter : actors) {
                        for (String actorsMovie : movieInput.getActors()) {
                            if (actorFilter.compareTo(actorsMovie) == 0) {
                                sortedMovies.add(movieInput);
                                check = false;

                                break;
                            }
                        }
                    }
                } else {
                    if (filtersInput.getContains().getGenre() != null) {
                        ArrayList<String> genres = filtersInput.getContains().getGenre();

                        for (String genreFilter : genres) {
                            for (String genreMovie : movieInput.getGenres()) {
                                if (genreFilter.compareTo(genreMovie) == 0) {
                                    sortedMovies.add(movieInput);
                                    check = false;

                                    break;
                                }
                            }
                        }
                    }
                }
            }

            // if we added the movies that have certain actors we check the genres
            // of the movie and the restrictions for the genres
            if (sortedMovies.size() != 0) {

                if (filtersInput.getContains().getActors() != null
                        && filtersInput.getContains().getGenre() != null) {

                    for (int i = 0; i < sortedMovies.size(); i++) {
                        if (filtersInput.getContains().getGenre() != null) {
                            ArrayList<String> genres = filtersInput.getContains().getGenre();

                            // we remove the movies that don't respect the restrictions
                            for (String genreFilter : genres) {
                                for (String genreMovie : sortedMovies.get(i).getGenres()) {
                                    if (genreFilter.compareTo(genreMovie) != 0) {
                                        sortedMovies.remove(i);

                                        break;
                                    }
                                }
                            }
                            i--;
                        }
                    }
                }
            }
        }

        // if we didn't find any movies we add all the movies
        if (check) {
            sortedMovies.addAll(input.getCurrMoviesList());
        }

        // checking if we have restrictions about the sorting
        if (filtersInput.getSort() != null) {

            if (filtersInput.getSort().getRating() != null) {
                String rating = filtersInput.getSort().getRating();
                String duration = filtersInput.getSort().getDuration();

                // checking the length of the movies first
                if (duration != null) {
                    if (duration.compareTo("decreasing") == 0) {
                        sortedMovies.sort((o1, o2) ->
                                compare(o1, o2, o2.getDuration(), o1.getDuration(), rating));
                    } else {
                        sortedMovies.sort((o1, o2) ->
                                compare(o1, o2, o1.getDuration(), o2.getDuration(), rating));
                    }
                } else {
                    sortedMovies.sort((o1, o2) -> compareRating(o1, o2, rating));
                }
            }
        }

        // keeping the filtered list of movies for the next actions
        input.setCurrMoviesList(sortedMovies);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputFilter = mapper.createObjectNode();

        outputFilter.set("error", null);

        ArrayNode movies = mapper.createArrayNode();

        for (MovieInput movieInput : sortedMovies) {
            OutputMovieFormat movieFormat = new OutputMovieFormat();
            movies.add(movieFormat.createOutputMovieFormat(movieInput));
        }

        outputFilter.set("currentMoviesList", movies);

        OutputUserFormat outputUserFormat = new OutputUserFormat();
        ObjectNode user = outputUserFormat.createOutputUserFormat(input.getCurrUser());

        outputFilter.set("currentUser", user);

        output.add(outputFilter);
    }

    /**
     * method that only compares the rating of the movies
     * @param o1 the first object
     * @param o2 the second one
     * @param rating the type of the rating
     * @return the condition for the sorting
     */
    private int compareRating(final MovieInput o1, final MovieInput o2, final String rating) {
        if (rating.compareTo("decreasing") == 0) {
            return Double.compare(o2.getRating(), o1.getRating());
        } else {
            return Double.compare(o1.getRating(), o2.getRating());
        }
    }

    /**
     * method that checks the length of the movies and the rating in case of equality
     * @param o1 the first object
     * @param o2 the second one
     * @param duration the first length
     * @param duration2 the second one
     * @param rating the type of rating
     * @return the condition for the sorting
     */
    private int compare(final MovieInput o1, final MovieInput o2, final int duration,
                        final int duration2, final String rating) {

        if (duration == duration2) {
            if (rating != null) {
                if (rating.compareTo("decreasing") == 0) {
                    return Double.compare(o2.getRating(), o1.getRating());
                } else {
                    return Double.compare(o1.getRating(), o2.getRating());
                }
            } else {
                return 0;
            }
        } else {
            return duration - duration2;
        }
    }
}
