package actiontypes.change;

public class ChangePageFactory {
    /**
     * generates object of concrete class based on given information
     * @param page the page where we want to be
     * @return an object of concrete class
     */
    public ChangePage getChangePage(final String page) {

        if (page.compareTo("login") == 0) {
            return new Login();

        } else if (page.compareTo("register") == 0) {
            return new Register();

        } else if (page.compareTo("logout") == 0) {
            return new LogOut();

        } else if (page.compareTo("movies") == 0) {
            return new Movies();

        } else if (page.compareTo("see details") == 0) {
            return new SeeDetails();

        } else if (page.compareTo("upgrades") == 0) {
            return new Upgrades();
        }

        return null;
    }
}
