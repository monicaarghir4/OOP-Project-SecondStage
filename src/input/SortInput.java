package input;

public class SortInput {
    private String rating;
    private String duration;

    public SortInput() {
    }

    public SortInput(final String rating, final String duration) {
        this.rating = rating;
        this.duration = duration;
    }

    /**
     * @return the order of the rating in which the movies will be sorted
     */
    public String getRating() {
        return rating;
    }

    /**
     * @param rating changes it
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * @return the order of the length in which the movies will be sorted
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration changes it
     */
    public void setDuration(final String duration) {
        this.duration = duration;
    }
}
