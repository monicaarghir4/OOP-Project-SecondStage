package actiontypes.change;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class Upgrades implements ChangePage {
    /**
     * method that moves the user in the upgrades page
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void changePageAction(final Input input, final ArrayNode output,
                                 final ActionInput actionInput) {

//        VerifyErrors verifyErrors =  new VerifyErrors();

        if (VerifyErrors.checkPage(input, "see details")
                || VerifyErrors.checkPage(input, "homepage logged in")) {
            input.setCurrPage("upgrades");

            input.getBack().getPagesStack().push("upgrades");

        } else {
            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);
        }
    }
}
