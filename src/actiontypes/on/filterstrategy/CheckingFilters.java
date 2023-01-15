package actiontypes.on.filterstrategy;

import input.ActionInput;
import input.Input;
import input.MovieInput;

import java.util.ArrayList;

public class CheckingFilters {
    /**
     * method that calls the filter function
     * @param input the information from the input
     * @param actionInput the data of the action
     * @param filterStrategy the interface used
     */
    public ArrayList<MovieInput> filter(final Input input, final ActionInput actionInput,
                                        final FilterStrategy filterStrategy) {

        return filterStrategy.filter(input, actionInput);
    }
}
