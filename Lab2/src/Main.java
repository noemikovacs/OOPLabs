import Domain.ClientValidator;
import Domain.MedicamentValidator;
import Domain.TransactionValidator;
import Repository.ClientRepository;
import Repository.MedicamentRepository;
import Repository.TransactionRepository;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;
import UI.Console;
import UI.NewConsole;

public class Main {

    public static void main(String[] args) {

        MedicamentValidator medicamentValidator = new MedicamentValidator();
        ClientValidator clientValidator = new ClientValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        MedicamentRepository medicamentRepository = new MedicamentRepository(medicamentValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);

        MedicamentService medicamentService = new MedicamentService(medicamentRepository);
        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicamentRepository);

        //Console console = new Console(medicamentService, clientService, transactionService);
        //console.run();

        NewConsole newConsole = new NewConsole(medicamentService, clientService, transactionService);
        newConsole.run();
    }
}
