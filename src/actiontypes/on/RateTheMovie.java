package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import input.UserInput;
import output.OutputError;
import output.OutputSeeDetails;
import verifyerrors.VerifyErrors;

import java.util.ArrayList;

public class RateTheMovie implements OnPage {
    private static final int MIN_RATE = 1;
    private static final int MAX_RATE = 5;
    /**
     * method that rates a movie for a user
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

//        VerifyErrors verifyErrors =  new VerifyErrors();
        OutputError outputError = new OutputError();

        if (VerifyErrors.checkPage(input, "see details")) {

            // verifying if the rate given is from 1 to 5
            if (actionInput.getRate() < MIN_RATE || actionInput.getRate() > MAX_RATE) {
                outputError.outputError(input, true, output);
                return;
            }

            UserInput currUser = input.getCurrUser();

            // verifying if the user has watched the movie
            if (currUser.getWatchedMovies().contains(input.getCurrMovie())) {
                if (currUser.getRatedMovies().contains(input.getCurrMovie())) {
                    input.getCurrMovie().getRatings().add(actionInput.getRate());

                    for (MovieInput movieInput : input.getCurrMoviesList()) {

                        if (movieInput.getName().compareTo(input.getCurrMovie().getName()) == 0) {

                            movieInput.getRatings().add(actionInput.getRate());
                            movieInput.setNumRatings(input.getCurrMovie().getNumRatings());
                            movieInput.setRating(calculateRating(input.getCurrMovie().getRatings()));

                            break;
                        }
                    }

                    input.getCurrMovie().setRating(calculateRating(input.getCurrMovie().getRatings()));

                    OutputSeeDetails outputSeeDetails = new OutputSeeDetails();
                    outputSeeDetails.createOutputSeeDetails(input, input.getCurrMovie(), output);

                    return;
                }

                // adding the rate to the list of ratings and increasing the number of ratings
                input.getCurrMovie().getRatings().add(actionInput.getRate());
                input.getCurrMovie().setNumRatings(input.getCurrMovie().getNumRatings() + 1);

                // also modifying the movie from the list of the current movies of a user
                for (MovieInput movieInput : input.getCurrMoviesList()) {

                    if (movieInput.getName().compareTo(input.getCurrMovie().getName()) == 0) {

                        movieInput.getRatings().add(actionInput.getRate());
                        movieInput.setNumRatings(input.getCurrMovie().getNumRatings());
                        movieInput.setRating(calculateRating(input.getCurrMovie().getRatings()));

                        break;
                    }
                }

                // calculating the rating each time we get a new one
                input.getCurrMovie().setRating(calculateRating(input.getCurrMovie().getRatings()));

                // adding the movie to the rated ones of the user
                currUser.getRatedMovies().add(input.getCurrMovie());

                OutputSeeDetails outputSeeDetails = new OutputSeeDetails();
                outputSeeDetails.createOutputSeeDetails(input, input.getCurrMovie(), output);

            } else {
                outputError.outputError(input, true, output);
            }
        } else {
            outputError.outputError(input, true, output);
        }
    }

    /**
     * method that calculates the rating
     * @param ratings the list of ratings of a movie
     * @return the rating
     */
    public double calculateRating(final ArrayList<Integer> ratings) {
        double sum = 0;

        for (Integer rating : ratings) {
            sum += rating;
        }

        return sum / ratings.size();
    }
}
