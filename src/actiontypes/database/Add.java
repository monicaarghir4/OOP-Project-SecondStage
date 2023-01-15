package actiontypes.database;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.*;
import output.OutputError;

public class Add implements Database {
    /**
     * method that adds a new movie in the database of the platform
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void databaseAction(final Input input, final ArrayNode output,
                               final ActionInput actionInput) {

        // checking if the movie is already in the database
        for (MovieInput movie : input.getMovies()) {
            if (movie.getName().compareTo(actionInput.getAddedMovie().getName()) == 0) {
                OutputError.outputError(input, true, output);

                return;
            }
        }

        input.getMovies().add(actionInput.getAddedMovie());

        // notifying the users that are subscribed to the movies genres about the new movie
        for (UserInput user : input.getUsers()) {
            for (String genre : actionInput.getAddedMovie().getGenres()) {

                if (user.getSubscribedGenres().contains(genre)) {

                    NotificationsInput notification = new NotificationsInput();

                    notification.setMovieName(actionInput.getAddedMovie().getName());
                    notification.setMessage("ADD");

                    user.getNotifications().add(notification);

                    break;
                }
            }
        }
    }
}
