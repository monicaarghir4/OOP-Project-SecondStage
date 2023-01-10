package actiontypes.on;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;

public interface OnPage {
    /**
     * method that implements the actions for each page
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     * @param output where we will write the output
     */
    void onPageAction(Input input, ActionInput actionInput, ArrayNode output);
}
