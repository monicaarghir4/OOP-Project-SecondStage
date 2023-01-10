package input;

import java.util.ArrayList;

public class UserInput {
    private static final int NUMBER_OF_FREE_MOVIES = 15;
    private CredentialsInput credentials;

    private int tokensCount;

    private int numFreePremiumMovies = NUMBER_OF_FREE_MOVIES;

    private ArrayList<MovieInput> purchasedMovies = new ArrayList<>();

    private ArrayList<MovieInput> watchedMovies = new ArrayList<>();

    private ArrayList<MovieInput> likedMovies = new ArrayList<>();

    private ArrayList<MovieInput> ratedMovies = new ArrayList<>();

    private ArrayList<Notifications> notifications = new ArrayList<>();

    private ArrayList<String> subscribedGenres = new ArrayList<>();

    public ArrayList<String> getSubscribedGenres() {
        return subscribedGenres;
    }

    public void setSubscribedGenres(final ArrayList<String> subscribedGenres) {
        this.subscribedGenres = subscribedGenres;
    }

    public ArrayList<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(final ArrayList<Notifications> notifications) {
        this.notifications = notifications;
    }

    public UserInput(final CredentialsInput credentials, final int tokensCount,
                     final int numFreePremiumMovies, final ArrayList<MovieInput> purchasedMovies,
                     final ArrayList<MovieInput> watchedMovies,
                     final ArrayList<MovieInput> likedMovies,
                     final ArrayList<MovieInput> ratedMovies) {
        this.credentials = credentials;
        this.tokensCount = tokensCount;
        this.numFreePremiumMovies = numFreePremiumMovies;
        this.purchasedMovies = purchasedMovies;
        this.watchedMovies = watchedMovies;
        this.likedMovies = likedMovies;
        this.ratedMovies = ratedMovies;
    }

    /**
     * @return the number of tokens a user has
     */
    public int getTokensCount() {
        return tokensCount;
    }

    /**
     * @param tokensCount changes it
     */
    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    /**
     * @return the number of free movies that a user with a premium account has
     */
    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    /**
     * @param numFreePremiumMovies changes it
     */
    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    /**
     * @return the movies that the user has purchased
     */
    public ArrayList<MovieInput> getPurchasedMovies() {
        return purchasedMovies;
    }

    /**
     * @param purchasedMovies changes it
     */
    public void setPurchasedMovies(final ArrayList<MovieInput> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    /**
     * @return the movies that the user has watched
     */
    public ArrayList<MovieInput> getWatchedMovies() {
        return watchedMovies;
    }

    /**
     * @param watchedMovies changes it
     */
    public void setWatchedMovies(final ArrayList<MovieInput> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    /**
     * @return the movies that the user has liked
     */
    public ArrayList<MovieInput> getLikedMovies() {
        return likedMovies;
    }

    /**
     * @param likedMovies changes it
     */
    public void setLikedMovies(final ArrayList<MovieInput> likedMovies) {
        this.likedMovies = likedMovies;
    }

    /**
     * @return the movies that the user has rated
     */
    public ArrayList<MovieInput> getRatedMovies() {
        return ratedMovies;
    }

    /**
     * @param ratedMovies changes it
     */
    public void setRatedMovies(final ArrayList<MovieInput> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public UserInput() {
    }

    /**
     * @param credentials initializes the credentials of the user
     */
    public UserInput(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    /**
     * @return the credentials of the user
     */
    public CredentialsInput getCredentials() {
        return credentials;
    }

    /**
     * @param credentials changes them
     */
    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }
}
