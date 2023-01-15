package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.NotificationsInput;

public final class OutputNotifications {
    private OutputNotifications() {
    }

    /**
     * method that creates an output for a notification
     * @param notification the data
     * @return an object for the output
     */
    public static ObjectNode createOutputNotifications(final NotificationsInput notification) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode notifications = mapper.createObjectNode();

        notifications.put("movieName", notification.getMovieName());
        notifications.put("message", notification.getMessage());

        return notifications;
    }
}
