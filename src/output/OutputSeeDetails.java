package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Input;
import input.MovieInput;

public final class OutputSeeDetails {
    private OutputSeeDetails() {
    }

    /**
     * method that creates the output for seeing the details of a movie
     * @param input the information from the input
     * @param movieInput the data of the movie
     * @param output where we will write the output
     */
    public static void createOutputSeeDetails(final Input input, final MovieInput movieInput,
                                       final ArrayNode output) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputSeeDetails = mapper.createObjectNode();

        outputSeeDetails.set("error", null);

        ArrayNode movies = mapper.createArrayNode();

        if (movieInput != null) {
            movies.add(OutputMovieFormat.createOutputMovieFormat(movieInput));


            outputSeeDetails.set("currentMoviesList", movies);

            ObjectNode user = OutputUserFormat.createOutputUserFormat(input.getCurrUser());

            outputSeeDetails.set("currentUser", user);
        }

        output.add(outputSeeDetails);
    }
}
