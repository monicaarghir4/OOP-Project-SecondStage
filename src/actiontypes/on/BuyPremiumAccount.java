package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.CredentialsInput;
import input.Input;
import input.UserInput;
import output.OutputError;
import verifyerrors.VerifyErrors;

public class BuyPremiumAccount implements OnPage {
    private static final int PAY_TOKENS = 10;
    /**
     * method that makes the account of a user premium
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    @Override
    public void onPageAction(final Input input, final ActionInput actionInput,
                             final ArrayNode output) {

        if (VerifyErrors.checkPage(input, "upgrades")) {

            // paying for the premium account
            UserInput currUser = input.getCurrUser();
            currUser.setTokensCount(currUser.getTokensCount() - PAY_TOKENS);

            // changing the type of the account
            CredentialsInput currUserCredentials = currUser.getCredentials();
            currUserCredentials.setAccountType("premium");

        } else {
            OutputError.outputError(input, true, output);
        }
    }
}
