package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class Subscribe implements OnPage {
    @Override
    public void onPageAction(Input input, ActionInput actionInput, ArrayNode output) {

        if (VerifyErrors.checkPage(input, "see details")) {
            MovieInput currMovie = input.getCurrMovie();
            String subscribedGenre = null;

            for (String genre : currMovie.getGenres()) {
                if (actionInput.getSubscribedGenre().compareTo(genre) == 0) {
                    subscribedGenre = genre;

                    break;
                }
            }

            if (subscribedGenre == null) {
                OutputError outputError = new OutputError();
                outputError.outputError(input, true, output);

                return;
            }

            for (String subscribedGenres : input.getCurrUser().getSubscribedGenres()) {
                if (subscribedGenres.compareTo(subscribedGenre) == 0) {
                    OutputError outputError = new OutputError();
                    outputError.outputError(input, true, output);

                    return;
                }
            }

            input.getCurrUser().getSubscribedGenres().add(subscribedGenre);

        } else {
            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);
        }
    }
}
