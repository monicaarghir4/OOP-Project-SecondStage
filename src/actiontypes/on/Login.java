package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.*;
import output.OutputError;
import verifyerrors.VerifyErrors;

import java.util.ArrayList;

public class Login implements OnPage {
    /**
     * method that logs in a user
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

//        VerifyErrors verifyErrors =  new VerifyErrors();
        OutputError outputError = new OutputError();

        CredentialsInput credentials = actionInput.getCredentials();

        if (VerifyErrors.checkPage(input, "login")) {
            if (VerifyErrors.checkCredentials(input, credentials, output)) {

                input.setCurrPage("homepage logged in");

                // setting the current user to the one that's logging in
                for (UserInput user : input.getUsers()) {
                    if (user.getCredentials().getName().compareTo(credentials.getName()) == 0) {
                        input.setCurrUser(user);
                    }
                }

                input.setCurrMoviesList(new ArrayList<>());

                input.getBack().getPagesStack().push("homepage logged in");

                outputError.outputError(input, false, output);
            }

        } else {
            outputError.outputError(input, true, output);
        }
    }
}
