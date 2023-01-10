package actiontypes.change;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import output.OutputError;
import output.OutputSeeDetails;
import verifyerrors.VerifyErrors;

public class SeeDetails implements ChangePage {
    /**
     * method that shows the details of a certain movie
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void changePageAction(final Input input, final ArrayNode output,
                                 final ActionInput actionInput) {

//        VerifyErrors verifyErrors =  new VerifyErrors();
        OutputError outputError = new OutputError();

        if (VerifyErrors.checkPage(input, "movies")) {
            boolean check = true;

            // looking for the movie in the list of the users movies
            for (MovieInput movieInput : input.getCurrMoviesList()) {
                if (movieInput.getName().compareTo(actionInput.getMovie()) == 0) {

                    // sending it to the method that displays the details of the movie
                    OutputSeeDetails outputSeeDetails = new OutputSeeDetails();
                    outputSeeDetails.createOutputSeeDetails(input, movieInput, output);

                    check = false;

                    input.setCurrPage("see details");
                    input.setCurrMovie(movieInput);

                    input.getBack().getPagesStack().push("see details");

                    break;
                }
            }

            // if we don't find the movie in the list we send an error
            if (check) {
                outputError.outputError(input, true, output);
            }

        } else {
            outputError.outputError(input, true, output);
        }
    }
}
