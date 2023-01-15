package input;

public class NotificationsInput {
    private String movieName;
    private String message;

    /**
     * @return the movie name
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName modifies the movie name
     */
    public void setMovieName(final String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return the message of the notification
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message changes the message
     */
    public void setMessage(final String message) {
        this.message = message;
    }
}
