package actiontypes.on.filterstrategy;

import actiontypes.change.Movies;
import input.ActionInput;
import input.FiltersInput;
import input.Input;
import input.MovieInput;

import java.util.ArrayList;

public class Contains implements FilterStrategy {
    /**
     * method that filters the movies by that they contain
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @return the list of the sorted movies
     */
    @Override
    public ArrayList<MovieInput> filter(final Input input, final ActionInput actionInput) {

        FiltersInput filtersInput = actionInput.getFilters();

        // creating a new list for the sorted movies
        boolean check = true;
        ArrayList<MovieInput> sortedMovies = new ArrayList<>();

        Movies.initializeCurrMovies(input);

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

        // if we didn't find any movies we add all the movies
        if (check) {
            sortedMovies.addAll(input.getCurrMoviesList());
        }

        return sortedMovies;
    }
}
