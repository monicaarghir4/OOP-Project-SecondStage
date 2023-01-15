package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import input.UserInput;
import output.OutputError;
import output.OutputSeeDetails;
import verifyerrors.VerifyErrors;

public class Like implements OnPage {
    /**
     * method that likes a movie for a user
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "see details")) {
            UserInput currUser = input.getCurrUser();

            // verifying if the user has watched the movie in order to like it
            if (currUser.getWatchedMovies().contains(input.getCurrMovie())) {

                // increasing the number of likes the movie has
                input.getCurrMovie().setNumLikes(input.getCurrMovie().getNumLikes() + 1);

                // also updating the movie from the list of the users movies
                for (MovieInput movieInput : input.getCurrMoviesList()) {
                    if (movieInput.getName().compareTo(input.getCurrMovie().getName()) == 0) {
                        movieInput.setNumLikes(input.getCurrMovie().getNumLikes());

                        break;
                    }
                }

                // adding the movie to the list of the movies the users liked
                currUser.getLikedMovies().add(input.getCurrMovie());

                OutputSeeDetails.createOutputSeeDetails(input, input.getCurrMovie(), output);

            } else {
                OutputError.outputError(input, true, output);
            }

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
