package actiontypes.change;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;

/**
 * interface that implements all the change page actions
 */
public interface ChangePage {
    /**
     * method that will change the page
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    void changePageAction(Input input, ArrayNode output, ActionInput actionInput);
}
