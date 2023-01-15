package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.CredentialsInput;

public final class OutputCredentials {
    private OutputCredentials() {
    }

    /**
     * method that creates a json format for the credentials
     * @param credentialsInput the credentials
     * @return a json object node with the credentials
     */
    public static ObjectNode createOutputCredentialsFormat(final CredentialsInput
                                                                   credentialsInput) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode credentials = mapper.createObjectNode();

        credentials.put("name", credentialsInput.getName());
        credentials.put("password", credentialsInput.getPassword());
        credentials.put("accountType", credentialsInput.getAccountType());
        credentials.put("country", credentialsInput.getCountry());
        credentials.put("balance", credentialsInput.getBalance());

        return credentials;
    }
}
