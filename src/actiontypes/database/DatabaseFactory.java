package actiontypes.database;

public class DatabaseFactory {
    /**
     * generates object of concrete class based on given information
     * @param type the type of action
     * @return object of concrete class
     */
    public Database getDatabase(final String type) {

        if (type.compareTo("add") == 0) {
            return new Add();

        } else if (type.compareTo("delete") == 0) {
            return new Delete();
        }

        return null;
    }
}
