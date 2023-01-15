package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.MovieInput;
import input.NotificationsInput;
import input.UserInput;

public final class OutputUserFormat {
    private OutputUserFormat() {
    }

    /**
     * method that creates the output format for a user
     * @param userInput the user
     * @return a json object node
     */
    public static ObjectNode createOutputUserFormat(final UserInput userInput) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode user = mapper.createObjectNode();

        ObjectNode credentials = OutputCredentials.
                createOutputCredentialsFormat(userInput.getCredentials());

        user.set("credentials", credentials);
        user.put("tokensCount", userInput.getTokensCount());
        user.put("numFreePremiumMovies", userInput.getNumFreePremiumMovies());

        ArrayNode purchasedMovies = mapper.createArrayNode();

        if (userInput.getPurchasedMovies() == null) {
            user.set("purchasedMovies", null);

        } else {
            for (MovieInput movie : userInput.getPurchasedMovies()) {
                purchasedMovies.add(OutputMovieFormat.createOutputMovieFormat(movie));
            }
            user.set("purchasedMovies", purchasedMovies);
        }

        ArrayNode watchedMovies = mapper.createArrayNode();

        if (userInput.getWatchedMovies() == null) {
            user.set("watchedMovies", null);

        } else {
            for (MovieInput movie : userInput.getWatchedMovies()) {
                watchedMovies.add(OutputMovieFormat.createOutputMovieFormat(movie));
            }

            user.set("watchedMovies", watchedMovies);
        }

        ArrayNode likedMovies = mapper.createArrayNode();

        if (userInput.getLikedMovies() == null) {
            user.set("likedMovies", null);

        } else {
            for (MovieInput movie : userInput.getLikedMovies()) {
                likedMovies.add(OutputMovieFormat.createOutputMovieFormat(movie));
            }

            user.set("likedMovies", likedMovies);
        }

        ArrayNode ratedMovies = mapper.createArrayNode();

        if (userInput.getRatedMovies() == null) {
            user.set("ratedMovies", null);

        } else {
            for (MovieInput movie : userInput.getRatedMovies()) {
                ratedMovies.add(OutputMovieFormat.createOutputMovieFormat(movie));
            }

            user.set("ratedMovies", ratedMovies);
        }

        ArrayNode notifications = mapper.createArrayNode();

        if (userInput.getNotifications() == null) {
            user.set("notifications", null);

        } else {
            for (NotificationsInput notification : userInput.getNotifications()) {
                notifications.add(OutputNotifications.createOutputNotifications(notification));
            }

            user.set("notifications", notifications);
        }

        return user;
    }
}
