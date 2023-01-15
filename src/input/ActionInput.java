package input;

public class ActionInput {
    private String type;
    private String page;
    private String feature;
    private CredentialsInput credentials;
    private String startsWith;
    private FiltersInput filters;
    private String count;
    private int rate;

    private String movie;

    private String subscribedGenre;

    /**
     * @return the genre we're subscribing to
     */
    public String getSubscribedGenre() {
        return subscribedGenre;
    }

    private MovieInput addedMovie;

    private String deletedMovie;

    /**
     * @return the movie we are going to delete
     */
    public String getDeletedMovie() {
        return deletedMovie;
    }

    /**
     * @return the movie we will add
     */
    public MovieInput getAddedMovie() {
        return addedMovie;
    }

    /**
     * @return the movie of the action
     */
    public String getMovie() {
        return movie;
    }

    /**
     * @param movie sets the movie from the action
     */
    public void setMovie(final String movie) {
        this.movie = movie;
    }

    public ActionInput() {
    }

    public ActionInput(final String type, final String page, final String feature,
                       final CredentialsInput credentials, final String startsWith,
                       final FiltersInput filters, final String count, final int rate) {
        this.type = type;
        this.page = page;
        this.feature = feature;
        this.credentials = credentials;
        this.startsWith = startsWith;
        this.filters = filters;
        this.count = count;
        this.rate = rate;
    }

    /**
     * @return the type of the action
     */
    public String getType() {
        return type;
    }

    /**
     * @param type sets the type of the action
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @return the page of the action
     */
    public String getPage() {
        return page;
    }

    /**
     * @param page sets the page of the action
     */
    public void setPage(final String page) {
        this.page = page;
    }

    /**
     * @return the feature of the action
     */
    public String getFeature() {
        return feature;
    }

    /**
     * @param feature sets the feature
     */
    public void setFeature(final String feature) {
        this.feature = feature;
    }

    /**
     * @return the credentials of the action
     */
    public CredentialsInput getCredentials() {
        return credentials;
    }

    /**
     * @param credentials sets the credentials of an action
     */
    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    /**
     * @return the string that a film starts with
     */
    public String getStartsWith() {
        return startsWith;
    }

    /**
     * @return the filters of an action
     */
    public FiltersInput getFilters() {
        return filters;
    }

    /**
     * @return the count of an action
     */
    public String getCount() {
        return count;
    }

    /**
     * @return the rate given to a movie
     */
    public int getRate() {
        return rate;
    }
}
