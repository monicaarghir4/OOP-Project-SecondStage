package input;

public class CredentialsInput {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public CredentialsInput() {
    }

    public CredentialsInput(final String name, final String password, final String accountType,
                            final String country, final String balance) {
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
    }

    /**
     * @return the name of a user
     */
    public String getName() {
        return name;
    }

    /**
     * @param name sets the name of a user
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the password of a user
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password sets it
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the type of the users account
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType changes it
     */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return the country of the user
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country changes it
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @return the balance of the user
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance changes it
     */
    public void setBalance(final String balance) {
        this.balance = balance;
    }
}
