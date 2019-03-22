import Domain.*;
import Repository.*;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;
import UI.Console;
import UI.NewConsole;

public class Main {

    public static void main(String[] args) {

        IValidator<Medicament> medicamentValidator = new MedicamentValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Medicament> medicamentRepository = new InMemoryRepository<>(medicamentValidator);
        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);

        MedicamentService medicamentService = new MedicamentService(medicamentRepository);
        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicamentRepository);

        Console console = new Console(medicamentService, clientService, transactionService);
        console.run();

        //NewConsole newConsole = new NewConsole(medicamentService, clientService, transactionService);
        //newConsole.run();
    }
}
