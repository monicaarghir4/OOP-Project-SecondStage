package input;

import actiontypes.back.Back;

import java.util.ArrayList;

public class Input {
    private ArrayList<UserInput> users;

    private ArrayList<MovieInput> movies;

    private ArrayList<ActionInput> actions;

    private String currPage;

    private ArrayList<MovieInput> currMoviesList = new ArrayList<>();

    private UserInput currUser;

    private MovieInput currMovie;

    private final Back back = new Back();

    /**
     * @return returns a back object
     */
    public Back getBack() {
        return back;
    }

    /**
     * @return the current movie of an action
     */
    public MovieInput getCurrMovie() {
        return currMovie;
    }

    /**
     * @param currMovie changes the current movie of an action
     */
    public void setCurrMovie(final MovieInput currMovie) {
        this.currMovie = currMovie;
    }

    public Input(final ArrayList<UserInput> users, final ArrayList<MovieInput> movies,
                 final ArrayList<ActionInput> actions, final String currPage,
                 final ArrayList<MovieInput> currMoviesList, final UserInput currUser,
                 final MovieInput currMovie) {
        this.users = users;
        this.movies = movies;
        this.actions = actions;
        this.currPage = currPage;
        this.currMoviesList = currMoviesList;
        this.currUser = currUser;
        this.currMovie = currMovie;
    }

    /**
     * @return the list of all the movies of a user
     */
    public ArrayList<MovieInput> getCurrMoviesList() {
        return currMoviesList;
    }

    /**
     * @param currMoviesList changes it
     */
    public void setCurrMoviesList(final ArrayList<MovieInput> currMoviesList) {
        this.currMoviesList = currMoviesList;
    }

    /**
     * @return the current user that's logged
     */
    public UserInput getCurrUser() {
        return currUser;
    }

    /**
     * @param currUser changes it
     */
    public void setCurrUser(final UserInput currUser) {
        this.currUser = currUser;
    }

    /**
     * @return the page a user is currently on
     */
    public String getCurrPage() {
        return currPage;
    }

    /**
     * @param currPage changes it
     */
    public void setCurrPage(final String currPage) {
        this.currPage = currPage;
    }

    public Input() {
    }

    public Input(final ArrayList<UserInput> users, final ArrayList<MovieInput> movies,
                 final ArrayList<ActionInput> actions) {
        this.users = users;
        this.movies = movies;
        this.actions = actions;
    }

    /**
     * @return all the users from the input
     */
    public ArrayList<UserInput> getUsers() {
        return users;
    }

    /**
     * @param users changes the list
     */
    public void setUsers(final ArrayList<UserInput> users) {
        this.users = users;
    }

    /**
     * @return all the movies from the input
     */
    public ArrayList<MovieInput> getMovies() {
        return movies;
    }

    /**
     * @param movies changes the list
     */
    public void setMovies(final ArrayList<MovieInput> movies) {
        this.movies = movies;
    }

    /**
     * @return the actions from the input
     */
    public ArrayList<ActionInput> getActions() {
        return actions;
    }

    /**
     * @param actions changes it
     */
    public void setActions(final ArrayList<ActionInput> actions) {
        this.actions = actions;
    }
}
