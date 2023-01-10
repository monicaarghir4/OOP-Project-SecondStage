package input;

import java.util.ArrayList;

public class ContainsInput {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    public ContainsInput() {
    }

    public ContainsInput(final ArrayList<String> actors, final ArrayList<String> genre) {
        this.actors = actors;
        this.genre = genre;
    }

    /**
     * @return the array of actors
     */
    public ArrayList<String> getActors() {
        return actors;
    }

    /**
     * @param actors sets the actors
     */
    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * @return the array of genres
     */
    public ArrayList<String> getGenre() {
        return genre;
    }
}
