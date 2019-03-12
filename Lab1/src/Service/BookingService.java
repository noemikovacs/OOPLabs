package Service;

import Domain.Booking;
import Domain.RoomAvarageRating;
import Repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingService {

    private BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public void checkIn(int bookingID, int roomNr,int nrOfPers, int nrOfDays) {

        Booking room = new Booking(bookingID, nrOfPers,roomNr,nrOfDays);
        List<Booking> rooms = repository.getAll();

        for(Booking r: rooms) {
            if (r.getRoomNr() == roomNr && r.isTaken()) {
                throw new RuntimeException("The room is already taken!");
            }

        }
        repository.add(room);

    }

    public void checkOut(int roomNr, String feedback, int rating){

        List<Booking> bookings = repository.getAll();
        boolean flag=false;

        for (Booking b: bookings){
            if (b.getRoomNr() == roomNr && b.isTaken()){
                flag = true;
                b.setFeedback(feedback);
                b.setRating(rating);
                b.setTaken(false);
            }
        }

       if (flag == true) {
            //do nothing
        } else {
            throw new RuntimeException("The room was not booked");
        }
    }

    public List<Booking> getAll() {
        return repository.getAll();
    }

    public List<RoomAvarageRating> getRoomsByRating() {
        List<RoomAvarageRating> results = new ArrayList<>();
        HashMap<Integer, List<Double>> roomRatings = new HashMap<>();

        for (Booking b : repository.getAll()) {
            if (!b.isTaken()) {
                int no = b.getRoomNr();
                double rating = b.getRating();

                if (!roomRatings.containsKey(no)) {
                    roomRatings.put(no, new ArrayList<>());
                }
                roomRatings.get(no).add(rating);
            }
        }

        for (int no : roomRatings.keySet()) {
            List<Double> ratings = roomRatings.get(no);
            int average = 0;
            for (double r : ratings) {
                average += r;
            }
            average /= ratings.size();
            results.add(new RoomAvarageRating(no, average));
        }

        results.sort((r1, r2) -> {
            if (r1.getAverageRating() > r2.getAverageRating())
                return -1;
            else if (r1.getAverageRating() == r2.getAverageRating())
                return 0;
            else
                return 1;
        });

        return results;
    }

}
