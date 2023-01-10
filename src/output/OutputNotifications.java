package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Notifications;

public class OutputNotifications {
    public ObjectNode createOutputNotifications(final Notifications notification) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode notifications = mapper.createObjectNode();

        notifications.put("movieName", notification.getMovieName());
        notifications.put("message", notification.getMessage());

        return notifications;
    }
}
