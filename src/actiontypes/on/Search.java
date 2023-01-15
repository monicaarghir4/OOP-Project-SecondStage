package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import output.OutputError;
import output.OutputSearch;
import verifyerrors.VerifyErrors;

public class Search implements OnPage {
    /**
     * method that searches for specific movies
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "movies")) {
            OutputSearch.createOutputSearch(input, actionInput, output);

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
