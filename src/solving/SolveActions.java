package solving;

import actiontypes.change.ChangePage;
import actiontypes.change.ChangePageFactory;
import actiontypes.change.Movies;
import actiontypes.database.Database;
import actiontypes.database.DatabaseFactory;
import com.fasterxml.jackson.databind.node.ArrayNode;
import input.ActionInput;
import input.Input;
import actiontypes.on.OnPage;
import actiontypes.on.OnPageFactory;
import input.MovieInput;

import java.util.*;

public final class SolveActions {
    private static final SolveActions INSTANCE = new SolveActions();

    private SolveActions() {
    }

    public static SolveActions getInstance() {
        return INSTANCE;
    }

    /**
     * method that creates instances of the factory classes and executes the methods
     * @param input the information from the input
     * @param output where we will write the output
     */
    public void solveActions(final Input input, final ArrayNode output) {

        // going through the actions from the input
        for (ActionInput actionInput : input.getActions()) {

            // checking which type of action we're executing
            if (actionInput.getType().compareTo("change page") == 0) {

                ChangePageFactory changePageFactory = new ChangePageFactory();
                ChangePage changePage = changePageFactory.getChangePage(actionInput.getPage());

                changePage.changePageAction(input, output, actionInput);
            } else if (actionInput.getType().compareTo("on page") == 0) {

                OnPageFactory onPageFactory = new OnPageFactory();
                OnPage onPage = onPageFactory.getOnPage(actionInput.getFeature());

                onPage.onPageAction(input, actionInput, output);
            } else if (actionInput.getType().compareTo("back") == 0){

                input.getBack().backAction(input, output);
            } else {

                DatabaseFactory databaseFactory = new DatabaseFactory();
                Database database = databaseFactory.getDatabase(actionInput.getFeature());

                database.databaseAction(input, output, actionInput);

            }
        }

//        if (input.getCurrUser().getCredentials().getAccountType().compareTo("premium") == 0) {
////            Hashtable<String, Integer> genres = new Hashtable<>();
//            ArrayList<String> genreTop = new ArrayList<>(genres.keySet());
//            ArrayList<Integer> genreOrder = new ArrayList<>(genres.values());
//
//            for (MovieInput movie : input.getCurrUser().getLikedMovies()) {
//
//                for (String genre : movie.getGenres()) {
//
//                    if (!genreTop.contains(genre)) {
////                        genres.put(genre, 1);
//                        genreTop.add(genre);
//                    } else {
////                        genres.put(genre, genres.get(genre) + 1);
//                        genreOrder
//                    }
//                }
//            }

//            Integer max = 0;
//
//            for (Integer numberOfLikes : genres.values()) {
//
//            }

//            ArrayList<String> genreTop = new ArrayList<>(genres.keySet());
//            ArrayList<Integer> genreOrder = new ArrayList<>(genres.values());

//            Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
//                @Override
//                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//                    return Integer.  o1;
//                }
//            }
//
//            Collections.sort(genreTop);

//        }
    }
}
