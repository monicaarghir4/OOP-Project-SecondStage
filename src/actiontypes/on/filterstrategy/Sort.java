package actiontypes.on.filterstrategy;

import actiontypes.change.Movies;
import input.ActionInput;
import input.FiltersInput;
import input.Input;
import input.MovieInput;

import java.util.ArrayList;

import static actiontypes.on.filterstrategy.SortAndContains.sort;

public class Sort implements FilterStrategy {
    /**
     * method that filters the movies by sorting them
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @return the list of the sorted movies
     */
    @Override
    public ArrayList<MovieInput> filter(final Input input, final ActionInput actionInput) {

        FiltersInput filtersInput = actionInput.getFilters();

        // setting the movies
        Movies.initializeCurrMovies(input);

        ArrayList<MovieInput> sortedMovies = new ArrayList<>(input.getCurrMoviesList());

        return sort(filtersInput, sortedMovies);
    }

    /**
     * method that only compares the rating of the movies
     * @param o1 the first object
     * @param o2 the second one
     * @param rating the type of the rating
     * @return the condition for the sorting
     */
    public static int compareRating(final MovieInput o1, final MovieInput o2,
                                     final String rating) {

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
    public static int compare(final MovieInput o1, final MovieInput o2, final int duration,
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
