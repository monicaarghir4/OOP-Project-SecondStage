package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.MovieInput;

public class OutputMovieFormat {
    /**
     * method that creates a json format for the output
     * @param moviesInput the movie
     * @return a json object node
     */
    public ObjectNode createOutputMovieFormat(final MovieInput moviesInput) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode movie = mapper.createObjectNode();

        movie.put("name", moviesInput.getName());
        movie.put("year", moviesInput.getYear());
        movie.put("duration", moviesInput.getDuration());

        ArrayNode genres = mapper.createArrayNode();

        if (moviesInput.getGenres() != null) {
            for (String genre : moviesInput.getGenres()) {
                genres.add(genre);
            }
        }

        movie.set("genres", genres);

        ArrayNode actors = mapper.createArrayNode();

        if (moviesInput.getActors() != null) {
            for (String actor : moviesInput.getActors()) {
                actors.add(actor);
            }
        }

        movie.set("actors", actors);

        ArrayNode countriesBanned = mapper.createArrayNode();

        if (moviesInput.getCountriesBanned() != null) {
            for (String countryBanned : moviesInput.getCountriesBanned()) {
                countriesBanned.add(countryBanned);
            }
        }

        movie.set("countriesBanned", countriesBanned);

        movie.put("numLikes", moviesInput.getNumLikes());
        movie.put("rating", moviesInput.getRating());
        movie.put("numRatings", moviesInput.getNumRatings());

        return movie;
    }
}
