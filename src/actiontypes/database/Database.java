package actiontypes.database;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;

/**
 * interface that implements all the database actions
 */
public interface Database {
    /**
     * method that will modify the database
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    void databaseAction(Input input, ArrayNode output, ActionInput actionInput);
}
