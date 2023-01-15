package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.*;
import output.OutputError;
import output.OutputSeeDetails;
import verifyerrors.VerifyErrors;

public class Watch implements OnPage {
    /**
     * method that watches a movie for a user
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "see details")) {
            UserInput currUser = input.getCurrUser();

            // checking if the user has purchased the movie already
            if (currUser.getPurchasedMovies().contains(input.getCurrMovie())) {
                if (!currUser.getWatchedMovies().contains(input.getCurrMovie())) {
                    currUser.getWatchedMovies().add(input.getCurrMovie());
                }

                OutputSeeDetails.createOutputSeeDetails(input, input.getCurrMovie(), output);

            } else {
                OutputError.outputError(input, true, output);
            }
        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
