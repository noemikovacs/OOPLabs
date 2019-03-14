package Service;

import Domain.Client;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository repository;

    public ClientService(ClientRepository repository) {

        this.repository = repository;
    }
    //Client(String id, String firstName, String lastName, String CNP, String dateOfRegistration)
    public void addOrUpdate(String id, String firstName, String lastName, String CNP, String dateOfRegistration) {

        Client existing = repository.findById(id);

        if (existing != null) {
            // keep unchanged fields as they were
            if (firstName.isEmpty()) {
                firstName = existing.getFirstName();
            }
            if (lastName.isEmpty()) {
                lastName = existing.getLastName();
            }
            if (CNP.isEmpty()) {
                CNP = existing.getCNP();
            }
            if (dateOfRegistration.isEmpty()) {
                dateOfRegistration = existing.getDateOfRegistration();
            }
        }
        Client client = new Client(id, firstName, lastName, CNP, dateOfRegistration);
        repository.upsert(client);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

}
