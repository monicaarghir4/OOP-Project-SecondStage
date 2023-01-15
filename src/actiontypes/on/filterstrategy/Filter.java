package actiontypes.on.filterstrategy;

import actiontypes.on.OnPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.FiltersInput;
import input.Input;
import input.MovieInput;
import output.OutputError;
import output.OutputFilter;
import verifyerrors.VerifyErrors;

import java.util.ArrayList;

public class Filter implements OnPage {
    /**
     * method that filters the movies of a user
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "movies")) {

            CheckingFilters checkingFilters = new CheckingFilters();
            FiltersInput filtersInput = actionInput.getFilters();

            ArrayList<MovieInput> sortedMovies;

            // verifying what filters we have
            if (filtersInput.getContains() != null && filtersInput.getSort() != null) {
                sortedMovies = checkingFilters.filter(input, actionInput, new SortAndContains());

            } else if (filtersInput.getSort() != null) {
                sortedMovies = checkingFilters.filter(input, actionInput, new Sort());

            } else {
                sortedMovies = checkingFilters.filter(input, actionInput, new Contains());

            }

            // keeping the filtered list of movies for the next actions
            input.setCurrMoviesList(sortedMovies);

            OutputFilter.createOutputFilter(input, sortedMovies, output);

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
