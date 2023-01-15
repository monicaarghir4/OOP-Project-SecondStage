package actiontypes.back;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;
import output.OutputError;

import java.util.Stack;

import static actiontypes.change.Movies.initializeCurrMovies;

/*
Class that contains the stack in which we keep the pages that the user navigates through
 */
public class Back {
    private final Stack<String> pagesStack = new Stack<>();

    /**
     * @return the stack with the pages
     */
    public Stack<String> getPagesStack() {
        return pagesStack;
    }

    /**
     * function that returns the user on the page that he was on before the actual one
     * @param input the information from the input
     * @param output where we will write the output
     */
    public void backAction(final Input input, final ArrayNode output) {

        // checking if we can go to the previous page
        if (input.getCurrPage().compareTo("homepage logged off") == 0
                || input.getCurrPage().compareTo("login") == 0
                || input.getCurrPage().compareTo("register") == 0
                || input.getCurrPage().compareTo("homepage logged in") == 0) {

            OutputError.outputError(input, true, output);

            return;
        }

        // checking if there is anymore pages we have been on
        if (pagesStack.empty()) {
            OutputError.outputError(input, true, output);

            return;
        }

        // deleting the page we were on
        pagesStack.pop();

        // setting the current page
        if (!pagesStack.empty()) {
            input.setCurrPage(pagesStack.peek());
        }

        // if the previous page was "movies" we reinitialize the list of current movies
        if (!pagesStack.empty())  {
            if (pagesStack.peek().compareTo("movies") == 0) {
                initializeCurrMovies(input);

                OutputError.outputError(input, false, output);
            }
        }
    }
}

