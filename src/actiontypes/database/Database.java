package actiontypes.database;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;

public interface Database {
    void databaseAction(Input input, ArrayNode output, ActionInput actionInput);
}
