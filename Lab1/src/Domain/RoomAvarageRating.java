package Domain;

import java.util.ArrayList;

public class RoomAvarageRating {

    private float avRating;
    private int roomNumber;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getAverageRating() {
        return avRating;
    }

    public void setAverageRating(int averageRate) {
        this.avRating = averageRate;
    }

    public RoomAvarageRating(int roomNumber, float averageRate) {
        this.roomNumber = roomNumber;
        this.avRating = averageRate;
    }

}
