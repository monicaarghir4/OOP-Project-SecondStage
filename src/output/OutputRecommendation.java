package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Input;

public final class OutputRecommendation {
    private OutputRecommendation() {
    }

    /**
     * method that creates the output for the recommendation
     * @param input the information from the input
     * @param output where we will write the output
     */
    public static void createOutputRecommendation(final Input input, final ArrayNode output) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputRecommendation = mapper.createObjectNode();

        outputRecommendation.set("error", null);
        outputRecommendation.set("currentMoviesList", null);

        ObjectNode user = OutputUserFormat.createOutputUserFormat(input.getCurrUser());

        outputRecommendation.set("currentUser", user);

        output.add(outputRecommendation);
    }
}
