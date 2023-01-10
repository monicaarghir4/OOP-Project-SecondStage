import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;
import solving.SolveActions;

import java.io.File;

public class Main {
    /**
     * the starting point of the project
     * @param args the arguments which are the files for the input and output
     */
    public static void main(final String[] args) {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert a JSON string to an input.Input object
            Input input = mapper.readValue(new File(args[0]), Input.class);

            // setting the page to the logged off one for the start
            input.setCurrPage("homepage logged off");

            // creating the array node for the output
            ArrayNode output = mapper.createArrayNode();

            // solving the actions
            SolveActions solveActions = SolveActions.getInstance();
            solveActions.solveActions(input, output);

            // converting to json
            ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(args[1]), output);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
