package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class Subscribe implements OnPage {
    /**
     * method that subscribes an user to a genre
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "see details")) {
            MovieInput currMovie = input.getCurrMovie();
            String subscribedGenre = null;

            for (String genre : currMovie.getGenres()) {
                if (actionInput.getSubscribedGenre().compareTo(genre) == 0) {
                    subscribedGenre = genre;

                    break;
                }
            }

            // if we don't find the genre in the list of genres of the current movie
            if (subscribedGenre == null) {
                OutputError.outputError(input, true, output);

                return;
            }

            for (String subscribedGenres : input.getCurrUser().getSubscribedGenres()) {
                if (subscribedGenres.compareTo(subscribedGenre) == 0) {

                    OutputError.outputError(input, true, output);

                    return;
                }
            }

            input.getCurrUser().getSubscribedGenres().add(subscribedGenre);

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
