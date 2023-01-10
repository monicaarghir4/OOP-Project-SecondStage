package verifyerrors;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.CredentialsInput;
import input.Input;
import input.UserInput;
import output.OutputError;

public class VerifyErrors {
    /**
     * static method that checks if the user is on the right page in order to execute an action
     * @param input the information from the input
     * @param page  the page we want to verify
     * @return if the page is correct
     */
    public static boolean checkPage(final Input input, final String page) {
        return input.getCurrPage().compareTo(page) == 0;
    }

    /**
     * static method that checks if the credentials of a user are right
     * @param input the information from the input
     * @param credentialsInput the credentials
     * @param output where we will write the output
     * @return if the credentials are correct
     */
    public static boolean checkCredentials(final Input input,
                                           final CredentialsInput credentialsInput,
                                           final ArrayNode output) {

        for (UserInput user : input.getUsers()) {
            if (user.getCredentials().getName().compareTo(credentialsInput.getName()) == 0
                    && user.getCredentials().getPassword().
                    compareTo(credentialsInput.getPassword()) == 0) {
                return true;
            }
        }

        // if they're wrong we show an error
        OutputError outputError = new OutputError();
        outputError.outputError(input, true, output);

        input.setCurrPage("homepage logged off");

        return false;
    }
}
