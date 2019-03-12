import Domain.BookingValidator;
import Repository.BookingRepository;
import Service.BookingService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        BookingValidator validator = new BookingValidator();
        BookingRepository repository = new BookingRepository(validator);
        BookingService service =  new BookingService(repository);

        Console console = new Console(service);
        console.run();
    }
}
