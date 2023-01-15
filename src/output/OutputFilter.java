package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Input;
import input.MovieInput;

import java.util.ArrayList;

public final class OutputFilter {
    private OutputFilter() {
    }

    /**
     * method that creates the output for the filter action
     * @param input the information from the input
     * @param sortedMovies the movies
     * @param output where we will write the output
     */
    public static void createOutputFilter(final Input input,
                                          final ArrayList<MovieInput> sortedMovies,
                                          final ArrayNode output) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputFilter = mapper.createObjectNode();

        outputFilter.set("error", null);

        ArrayNode movies = mapper.createArrayNode();

        for (MovieInput movieInput : sortedMovies) {
            movies.add(OutputMovieFormat.createOutputMovieFormat(movieInput));
        }

        outputFilter.set("currentMoviesList", movies);

        ObjectNode user = OutputUserFormat.createOutputUserFormat(input.getCurrUser());

        outputFilter.set("currentUser", user);

        output.add(outputFilter);
    }
}
