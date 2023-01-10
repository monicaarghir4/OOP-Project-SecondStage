package actiontypes.change;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class Login implements ChangePage {
    /**
     * method that moves the user to the login one
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void changePageAction(final Input input, final ArrayNode output,
                                 final ActionInput actionInput) {

//        VerifyErrors verifyErrors =  new VerifyErrors();

        // if the user isn't on the right page the page won't change
        if (VerifyErrors.checkPage(input, "homepage logged off")) {
            input.setCurrPage("login");

        } else {
            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);
        }
    }
}
