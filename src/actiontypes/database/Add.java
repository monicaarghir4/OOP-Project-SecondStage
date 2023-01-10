package actiontypes.database;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.*;
import output.OutputError;

public class Add implements Database {
    @Override
    public void databaseAction(Input input, ArrayNode output, ActionInput actionInput) {
        for (MovieInput movie : input.getMovies()) {
            if (movie.getName().compareTo(actionInput.getAddedMovie().getName()) == 0) {
                OutputError outputError = new OutputError();
                outputError.outputError(input, true, output);

                return;
            }
        }

        input.getMovies().add(actionInput.getAddedMovie());

        for (UserInput user : input.getUsers()) {
            for (String genre : actionInput.getAddedMovie().getGenres()) {
                if (user.getSubscribedGenres().contains(genre)) {
                    if (actionInput.getAddedMovie().getCountriesBanned().contains(user.getCredentials().getCountry())) {
                        OutputError outputError = new OutputError();
                        outputError.outputError(input, true, output);

                        return;
                    } else {
                        Notifications notification = new Notifications();

                        notification.setMovieName(actionInput.getAddedMovie().getName());
                        notification.setMessage("ADD");

                        user.getNotifications().add(notification);

                        break;
                    }
                }
            }
        }
    }
}
