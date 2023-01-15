package actiontypes.on.filterstrategy;

import input.ActionInput;
import input.Input;
import input.MovieInput;

import java.util.ArrayList;

public interface FilterStrategy {
    /**
     * method that will filter the movies
     * @param input the information from the input
     * @param actionInput the data about the action we are performing
     */
    ArrayList<MovieInput> filter(Input input, ActionInput actionInput);
}
