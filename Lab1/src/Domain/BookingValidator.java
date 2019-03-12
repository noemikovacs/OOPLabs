package Domain;

public class BookingValidator {

    public void validate(Booking booking){

        if (booking.getNrOfDays() <= 0) {
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }

       if (!booking.isTaken() && booking.getRating() < 1 && booking.getRating() >6 ) {
            throw new RuntimeException("The number for rating must be between 1 and 5!");
        }

        if (booking.getNrOfPers() <= 0) {
            throw new RuntimeException("the number of persons cannot be 0 or negative!");
        }

    }
}
