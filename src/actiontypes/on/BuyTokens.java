package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.CredentialsInput;
import input.Input;
import input.UserInput;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class BuyTokens implements OnPage {
    /**
     * method that buys tokens for a user
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

//        VerifyErrors verifyErrors =  new VerifyErrors();

        if (VerifyErrors.checkPage(input, "upgrades")) {

            // adding the tokens
            UserInput currUser = input.getCurrUser();
            currUser.setTokensCount(currUser.getTokensCount() + Integer.parseInt(actionInput.getCount()));

            // reducing the balance
            CredentialsInput currUserCredentials = currUser.getCredentials();
            int newBalance = Integer.parseInt(currUserCredentials.getBalance())
                    - Integer.parseInt(actionInput.getCount());

            currUserCredentials.setBalance(Integer.toString(newBalance));

        } else {
            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);
        }
    }
}
