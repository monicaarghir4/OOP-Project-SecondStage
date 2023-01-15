package actiontypes.change;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class LogOut implements ChangePage {
    /**
     * method that disconnects the user
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void changePageAction(final Input input, final ArrayNode output,
                                 final ActionInput actionInput) {

        if (VerifyErrors.checkPage(input, "homepage logged in")
                || VerifyErrors.checkPage(input, "see details")
                || VerifyErrors.checkPage(input, "upgrades")
                || VerifyErrors.checkPage(input, "movies")) {

            input.setCurrPage("homepage logged off");
            input.setCurrUser(null);

            while (!input.getBack().getPagesStack().empty()) {
                input.getBack().getPagesStack().pop();
            }

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
