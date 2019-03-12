package Domain;

public class Booking {

    private int bookingID;
    private int nrOfPers;
    private int roomNr;
    private int nrOfDays;
    private String feedback;
    private int rating;
    private boolean isTaken = false;

    public Booking(int bookingID, int nrOfPers, int roomNr, int nrOfDays) {
        this.bookingID = bookingID;
        this.nrOfPers = nrOfPers;
        this.roomNr = roomNr;
        this.nrOfDays = nrOfDays;
    }

    public Booking(int bookingID, int nrOfPers, int roomNr, int nrOfDays, String feedback, int rating, boolean isTaken) {
        this.bookingID = bookingID;
        this.nrOfPers = nrOfPers;
        this.roomNr = roomNr;
        this.nrOfDays = nrOfDays;
        this.feedback = feedback;
        this.rating = rating;
        this.isTaken = isTaken;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", nrOfPers=" + nrOfPers +
                ", roomNr=" + roomNr +
                ", nrOfDays=" + nrOfDays +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                ", isTaken=" + isTaken +
                '}';
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getNrOfPers() {
        return nrOfPers;
    }

    public void setNrOfPers(int nrOfPers) {
        this.nrOfPers = nrOfPers;
    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public int getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(int nrOfDays) {
        this.nrOfDays = nrOfDays;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
