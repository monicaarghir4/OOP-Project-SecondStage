package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.CredentialsInput;
import input.Input;
import input.UserInput;
import output.OutputError;
import output.OutputSeeDetails;
import verifyerrors.VerifyErrors;

public class Purchase implements OnPage {
    /**
     * method that purchases a movie for a user
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "see details")) {
            UserInput currUser = input.getCurrUser();
            CredentialsInput currUserCredentials = currUser.getCredentials();

            if (currUser.getPurchasedMovies().contains(input.getCurrMovie())) {
                OutputError.outputError(input, true, output);

                return;
            }

            // verifying if the user has a premium account
            if (currUserCredentials.getAccountType().compareTo("premium") == 0) {
                // checking if he has anymore free movies
                if (currUser.getNumFreePremiumMovies() > 0) {

                    // adding it in the list of the purchased movies of the user
                    currUser.setNumFreePremiumMovies(currUser.getNumFreePremiumMovies() - 1);
                    currUser.getPurchasedMovies().add(input.getCurrMovie());

                    OutputSeeDetails.createOutputSeeDetails(input, input.getCurrMovie(), output);

                // if he doesn't have anymore free movies we check if he has tokens to buy the movie
                } else if (currUser.getTokensCount() >= 2) {

                    currUser.setTokensCount(currUser.getTokensCount() - 2);
                    currUser.getPurchasedMovies().add(input.getCurrMovie());

                    OutputSeeDetails.createOutputSeeDetails(input, input.getCurrMovie(), output);

                } else {
                    OutputError.outputError(input, true, output);
                }

            // if he doesn't have a premium account
            } else {
                if (currUser.getTokensCount() >= 2) {

                    currUser.setTokensCount(currUser.getTokensCount() - 2);
                    currUser.getPurchasedMovies().add(input.getCurrMovie());

                    OutputSeeDetails.createOutputSeeDetails(input, input.getCurrMovie(), output);

                } else {
                    OutputError.outputError(input, true, output);
                }
            }
        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
