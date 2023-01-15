package actiontypes.database;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.*;
import output.OutputError;

public class Delete implements Database {
    /**
     * method that deletes a movie from our databases
     * @param input the information from the input
     * @param output where we will write the output
     * @param actionInput the data about the action we are performing
     */
    @Override
    public void databaseAction(final Input input, final ArrayNode output,
                               final ActionInput actionInput) {
        boolean check = true;

        for (MovieInput movie : input.getMovies()) {
            if (movie.getName().compareTo(actionInput.getDeletedMovie()) == 0) {
                check = false;

                // notifying the users about the deleted movie
                for (UserInput user : input.getUsers()) {
                    if (user.getPurchasedMovies().contains(movie)) {

                        NotificationsInput notification = new NotificationsInput();

                        notification.setMovieName(actionInput.getDeletedMovie());
                        notification.setMessage("DELETE");

                        user.getNotifications().add(notification);

                        // returning their money or free movie pass
                        if (user.getCredentials().getAccountType().compareTo("premium") == 0) {
                            user.setNumFreePremiumMovies(user.getNumFreePremiumMovies() + 1);
                        } else {
                            user.setTokensCount(user.getTokensCount() + 2);
                        }

                        // deleting the movie from the users data
                        user.getPurchasedMovies().remove(movie);
                        user.getWatchedMovies().remove(movie);
                        user.getLikedMovies().remove(movie);
                        user.getRatedMovies().remove(movie);
                    }
                }

                input.getMovies().remove(movie);

                break;
            }
        }

        // if we don't find the movie we display an error
        if (check) {
            OutputError.outputError(input, true, output);
        }
    }
}
