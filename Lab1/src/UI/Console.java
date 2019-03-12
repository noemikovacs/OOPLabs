package UI;

import Domain.Booking;
import Domain.RoomAvarageRating;
import Service.BookingService;

import java.util.Scanner;

public class Console {

    private BookingService service;
    private Scanner scanner;

    public Console(BookingService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Check in");
        System.out.println("2. Check out");
        System.out.println("3. Raport room by rating");
        System.out.println("a. Afisare toate camerele");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleCheckIn();
            } else if (option.equals("2")) {
                handleCheckOut();
            } else if (option.equals("3")) {
                handleReport();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

    private void handleReport() {
        for (RoomAvarageRating roomAvarageRating : service.getRoomsByRating())
            System.out.println(String.format("%d %f", roomAvarageRating.getRoomNumber(), roomAvarageRating.getAverageRating()));
    }

    private void handleShowAll() {
        for (Booking b : service.getAll())
            System.out.println(b);
    }

    private void handleCheckIn() {

            System.out.println("Dati id cazare:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numar persoane:");
            int nrPers = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul camerei:");
            int roomNr = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de zile:");
            int daysNr = Integer.parseInt(scanner.nextLine());
        try {
            service.checkIn(id,roomNr,nrPers,daysNr);
            System.out.println("Check in successfully!");
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }

    private void handleCheckOut() {
        try {
            System.out.println("Dati numarul camerei:");
            int roomNr = Integer.parseInt(scanner.nextLine());
            System.out.println("Feeback:");
            String feedback = scanner.nextLine();
            System.out.println("Rating");
            int rating = Integer.parseInt(scanner.nextLine());

            service.checkOut(roomNr, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
}
