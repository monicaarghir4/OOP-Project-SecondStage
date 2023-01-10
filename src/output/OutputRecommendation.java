package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Input;

public class OutputRecommendation {
    public void createOutputRecommendation(Input input, ArrayNode output) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode outputRecommendation = mapper.createObjectNode();

        outputRecommendation.set("error", null);
        outputRecommendation.set("currentMoviesList", null);

        OutputUserFormat outputUserFormat = new OutputUserFormat();
        ObjectNode user = outputUserFormat.createOutputUserFormat(input.getCurrUser());

        outputRecommendation.set("currentUser", user);

        output.add(outputRecommendation);
    }
}
