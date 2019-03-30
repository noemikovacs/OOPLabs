import Domain.*;
import Repository.*;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();

        Controller controller =  fxmlLoader.getController();

        IValidator<Medicament> medicamentValidator = new MedicamentValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Medicament> medicamentRepository = new InMemoryRepository<>(medicamentValidator);
        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);

        MedicamentService medicamentService = new MedicamentService(medicamentRepository);
        medicamentService.addOrUpdate("1","paracetamol","ZHT",85.2,false);
        medicamentService.addOrUpdate("2","fasconal","ZT",15.2,false);
        medicamentService.addOrUpdate("3","antibiotic","TFG",45.3, true);

        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicamentRepository);
        controller.setServices(medicamentService, clientService, transactionService);

        primaryStage.setTitle("Medicament manager");
        primaryStage.setScene(new Scene(root, 650, 500));

        primaryStage.show();

        //Console console = new Console(medicamentService, clientService, transactionService);
        //console.run();

        //NewConsole newConsole = new NewConsole(medicamentService, clientService, transactionService);
        //newConsole.run();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
