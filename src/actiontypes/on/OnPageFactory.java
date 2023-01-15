package actiontypes.on;

import actiontypes.on.filterstrategy.Filter;

public class OnPageFactory {
    /**
     * generates object of concrete class based on given information
     * @param feature the feature we want to implement
     * @return an object of concrete class
     */
    public OnPage getOnPage(final String feature) {
        if (feature.compareTo("login") == 0) {
            return new Login();

        } else if (feature.compareTo("register") == 0) {
            return new Register();

        } else if (feature.compareTo("search") == 0) {
            return new Search();

        } else if (feature.compareTo("filter") == 0) {
            return new Filter();

        } else if (feature.compareTo("buy tokens") == 0) {
            return new BuyTokens();

        } else if (feature.compareTo("buy premium account") == 0) {
            return new BuyPremiumAccount();

        } else if (feature.compareTo("purchase") == 0) {
            return new Purchase();

        } else if (feature.compareTo("watch") == 0) {
            return new Watch();

        } else if (feature.compareTo("like") == 0) {
            return new Like();

        } else if (feature.compareTo("rate") == 0) {
            return new RateTheMovie();

        } else if (feature.compareTo("subscribe") == 0) {
            return new Subscribe();
        }

        return null;
    }

}
