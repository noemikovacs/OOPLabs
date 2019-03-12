package Repository;

import Domain.Booking;
import Domain.BookingValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepository {

    private Map<Integer, Booking> storage = new HashMap<>();
    private BookingValidator validator;

    public BookingRepository(BookingValidator validator) {

        this.validator = validator;
    }

    public void add(Booking booking) {
        if (storage.containsKey(booking.getBookingID())) {
            throw new RuntimeException("The room with that id is already exist!");
        }
        validator.validate(booking);
        booking.setTaken(true);
        storage.put(booking.getBookingID(),booking);
    }

    public void update(Booking booking) {
        if (storage.containsKey(booking.getRoomNr())) {
            throw new RuntimeException("There is no room with the given id to update!");
        }

        validator.validate(booking);
        storage.put(booking.getRoomNr(), booking);
    }

    public List<Booking> getAll() {
        return new ArrayList<>(storage.values());
    }

}
