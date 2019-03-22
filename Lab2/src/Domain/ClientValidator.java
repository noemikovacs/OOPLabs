package Domain;

public class ClientValidator {

    //cnp validare

    /**
     * Validates a client
     * @param client
     * @throws RuntimeException if there are validation errors.
     */

    public void validate(Client client) {
        if (!(client.getCNP().length() == 13)) {
            throw new RuntimeException("The CNP is invalid, it must be 13 character!");
        }

    }
}
