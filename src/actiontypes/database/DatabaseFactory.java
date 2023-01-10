package actiontypes.database;

public class DatabaseFactory {
    public Database getDatabase(final String type) {

        if (type.compareTo("add") == 0) {
            return new Add();

        } else if (type.compareTo("delete") == 0) {
            return new Delete();
        }

        return null;
    }
}
