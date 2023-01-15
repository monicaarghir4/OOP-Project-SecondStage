package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Input;
import input.MovieInput;

public final class OutputError {
    private OutputError() {
    }

    /**
     * method that creates the output for the errors
     * @param input the information from the input
     * @param error the value of the error
     * @param output where we will write the output
     */
    public static void outputError(final Input input, final boolean error,
                            final ArrayNode output) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputError = mapper.createObjectNode();

        // if we have an error we display it according to the instructions
        if (error) {
            outputError.put("error", "Error");

            ArrayNode movies = mapper.createArrayNode();
            outputError.set("currentMoviesList", movies);

            outputError.set("currentUser", null);

            output.add(outputError);

            return;
        }

        outputError.set("error", null);

        // creating the array node of the movies in the users list
        ArrayNode movies = mapper.createArrayNode();

        for (MovieInput movieInput : input.getCurrMoviesList()) {
            movies.add(OutputMovieFormat.createOutputMovieFormat(movieInput));
        }

        outputError.set("currentMoviesList", movies);

        // creating the user json format
        ObjectNode user = OutputUserFormat.createOutputUserFormat(input.getCurrUser());

        outputError.set("currentUser", user);

        output.add(outputError);
    }
}
