package actiontypes.database;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.*;
import output.OutputError;

public class Delete implements Database {
    @Override
    public void databaseAction(Input input, ArrayNode output, ActionInput actionInput) {
        boolean check = true;
        for (MovieInput movie : input.getMovies()) {
            if (movie.getName().compareTo(actionInput.getDeletedMovie()) == 0) {
                check = false;

                for (UserInput user : input.getUsers()) {
                    if (user.getPurchasedMovies().contains(movie)) {
                        Notifications notification = new Notifications();

                        notification.setMovieName(actionInput.getDeletedMovie());
                        notification.setMessage("DELETE");

                        user.getNotifications().add(notification);

                        if (user.getCredentials().getAccountType().compareTo("premium") == 0) {
                            user.setNumFreePremiumMovies(user.getNumFreePremiumMovies() + 1);
                        } else {
                            user.setTokensCount(user.getTokensCount() + 2);
                        }

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

        if (check) {
            OutputError outputError = new OutputError();
            outputError.outputError(input, true, output);
        }
    }
}
