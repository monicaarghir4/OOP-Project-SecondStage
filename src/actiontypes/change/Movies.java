package actiontypes.change;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import output.OutputError;
import verifyerrors.VerifyErrors;

import java.util.ArrayList;

public class Movies implements ChangePage {
    /**
     * method that shows all the movies
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void changePageAction(final Input input, final ArrayNode output,
                                 final ActionInput actionInput) {

//        VerifyErrors verifyErrors =  new VerifyErrors();
        OutputError outputError = new OutputError();

        if (VerifyErrors.checkPage(input, "homepage logged in")
                || VerifyErrors.checkPage(input, "see details")
                || VerifyErrors.checkPage(input, "upgrades")
                || VerifyErrors.checkPage(input, "movies")) {

            input.setCurrPage("movies");
            initializeCurrMovies(input);

            input.getBack().getPagesStack().push("movies");

            outputError.outputError(input, false, output);

        } else {
            outputError.outputError(input, true, output);
        }
    }

    /**
     * method that initializes the list that contains the movies
     * @param input the information from the input
     */
    public static void initializeCurrMovies(final Input input) {
        // resetting the list
        input.setCurrMoviesList(new ArrayList<>());

        for (MovieInput movie : input.getMovies()) {
            boolean check = true;

            // checking if the movie is available in the country of the user
            for (String countryBanned : movie.getCountriesBanned()) {
                if (input.getCurrUser().getCredentials().getCountry()
                        .compareTo(countryBanned) == 0) {
                    check = false;
                    break;
                }
            }

            // adding it to the list of the current users
            if (check) {
                if (!input.getCurrMoviesList().contains(movie)) {
                    input.getCurrMoviesList().add(movie);
                }
            }
        }
    }
}
