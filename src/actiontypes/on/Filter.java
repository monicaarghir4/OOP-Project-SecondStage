package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import output.OutputError;
import output.OutputFilter;
import verifyerrors.VerifyErrors;

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

//        VerifyErrors verifyErrors =  new VerifyErrors();

        if (VerifyErrors.checkPage(input, "movies")) {
            OutputFilter outputFilter = new OutputFilter();
            outputFilter.createOutputFilter(input, actionInput, output);

        } else {
            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);
        }
    }
}
