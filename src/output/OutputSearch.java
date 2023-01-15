package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.ActionInput;
import input.Input;
import input.MovieInput;

public final class OutputSearch {
    private OutputSearch() {
    }

    /**
     * method that creates the output for the search action
     * @param input the information from the input
     * @param actionInput the data of the action
     * @param output where we will write the output
     */
    public static void createOutputSearch(final Input input, final ActionInput actionInput,
                                   final ArrayNode output) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputSearch = mapper.createObjectNode();

        outputSearch.set("error", null);

        ArrayNode movies = mapper.createArrayNode();
        String startsWith = actionInput.getStartsWith();

        // checking if the movies from the users list start with the string given
        for (MovieInput movieInput : input.getCurrMoviesList()) {

            if (movieInput.getName().startsWith(startsWith)) {
                movies.add(OutputMovieFormat.createOutputMovieFormat(movieInput));
            }
        }

        outputSearch.set("currentMoviesList", movies);

        ObjectNode user = OutputUserFormat.createOutputUserFormat(input.getCurrUser());

        outputSearch.set("currentUser", user);

        output.add(outputSearch);
    }
}
