package actiontypes.back;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;
import output.OutputError;

import java.util.Stack;

import static actiontypes.change.Movies.initializeCurrMovies;

public class Back {
    private Stack<String> pagesStack = new Stack<>();

    public Stack<String> getPagesStack() {
        return pagesStack;
    }

    public void setPagesStack(final Stack<String> pagesStack) {
        this.pagesStack = pagesStack;
    }

    public void backAction(final Input input, final ArrayNode output) {
        if (input.getCurrPage().compareTo("homepage logged off") == 0
                || input.getCurrPage().compareTo("login") == 0
                || input.getCurrPage().compareTo("register") == 0
                || input.getCurrPage().compareTo("homepage logged in") == 0) {

            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);

            return;
        }

        if (pagesStack.empty()) {
            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);

            return;
        }

        pagesStack.pop();

        if (!pagesStack.empty()) {
            input.setCurrPage(pagesStack.peek());
        }

        if (!pagesStack.empty())  {
            if (pagesStack.peek().compareTo("movies") == 0) {
                initializeCurrMovies(input);

                OutputError outputError = new OutputError();
                outputError.outputError(input, false, output);
            }
        }
    }
}

