package actiontypes.change;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class Register implements ChangePage {
    /**
     * method that sends the user to the register page
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void changePageAction(final Input input, final ArrayNode output,
                                 final ActionInput actionInput) {

        if (VerifyErrors.checkPage(input, "homepage logged off")) {
            input.setCurrPage("register");

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
