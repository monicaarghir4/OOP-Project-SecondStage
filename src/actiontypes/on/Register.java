package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import input.UserInput;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class Register implements OnPage {
    /**
     * method that registers a new user to the platform
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "register")) {
            UserInput newUser = new UserInput(actionInput.getCredentials());

            // adding the new user to the list of users and logging him in
            input.getUsers().add(newUser);
            input.setCurrUser(newUser);

            input.setCurrPage("homepage logged in");

            OutputError.outputError(input, false, output);

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
