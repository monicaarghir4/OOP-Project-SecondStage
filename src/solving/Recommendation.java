package solving;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;
import input.MovieInput;
import input.Notifications;
import output.OutputRecommendation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Recommendation {
    public void recommendation(Input input, ArrayNode output) {

            Hashtable<String, Integer> genres = new Hashtable<>();

            for (MovieInput movie : input.getCurrUser().getLikedMovies()) {

                for (String genre : movie.getGenres()) {

                    if (!genres.contains(genre)) {
                        genres.put(genre, 1);
                    } else {
                        genres.put(genre, genres.get(genre) + 1);
                    }
                }
            }

            ArrayList<Map.Entry<String, Integer>> sortedGenres = sortValue(genres);

            ArrayList<MovieInput> sortedMovies = new ArrayList<>(input.getCurrMoviesList());

            sortedMovies.sort((o1, o2) -> o2.getNumLikes() - o1.getNumLikes());

            for (MovieInput movie : sortedMovies) {
                if (!input.getCurrUser().getWatchedMovies().contains(movie)) {
                    for (Map.Entry<String, Integer> genre : sortedGenres) {
                        for (String genreMovie : movie.getGenres()) {
                            if (genreMovie.compareTo(genre.getKey()) == 0) {
                                Notifications notification = new Notifications();

                                notification.setMovieName(movie.getName());
                                notification.setMessage("Recommendation");

                                input.getCurrUser().getNotifications().add(notification);

                                OutputRecommendation outputRecommendation = new OutputRecommendation();
                                outputRecommendation.createOutputRecommendation(input, output);

                                return;
                            }
                        }
                    }
                }
            }

            Notifications notification = new Notifications();

            notification.setMovieName("No recommendation");
            notification.setMessage("Recommendation");

            input.getCurrUser().getNotifications().add(notification);

        OutputRecommendation outputRecommendation = new OutputRecommendation();
        outputRecommendation.createOutputRecommendation(input, output);
    }

    public static ArrayList<Map.Entry<String, Integer>> sortValue(Hashtable<String, Integer> t) {

        ArrayList<Map.Entry<String, Integer>> l = new ArrayList<>(t.entrySet());

        l.sort((o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) == 0) {
                return o2.getKey().compareTo(o1.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        return l;
    }
}
