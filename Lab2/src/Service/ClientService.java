package Service;

import Domain.Client;
import Repository.IRepository;

import java.util.List;

public class ClientService {

    private IRepository<Client> repository;

    public ClientService(IRepository<Client> repository) {
        this.repository = repository;
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param CNP
     * @param dateOfRegistration
     * @param dayOfBirth
     */

    public void addOrUpdate(String id, String firstName, String lastName, String CNP, String dateOfRegistration, String dayOfBirth) {

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
            if (dayOfBirth.isEmpty()) {
                dayOfBirth = existing.getDateOfBirth();
            }

        }
        Client client = new Client(id, firstName, lastName, CNP, dateOfRegistration, dayOfBirth);
        repository.upsert(client);
    }

    /**
     *
     * @param id
     */

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

}
