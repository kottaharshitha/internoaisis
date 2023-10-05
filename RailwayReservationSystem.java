import java.util.*;

class Train {
    private String trainNumber;
    private String trainName;
    private int totalSeats;
    private int availableSeats;

    public Train(String trainNumber, String trainName, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookTicket(int numberOfSeats) {
        if (numberOfSeats <= availableSeats) {
            availableSeats -= numberOfSeats;
            System.out.println(numberOfSeats + " seats booked successfully in " + trainName);
        } else {
            System.out.println("Sorry, no enough seats available in " + trainName);
        }
    }

    public void cancelTicket(int numberOfSeats) {
        if (numberOfSeats <= totalSeats - availableSeats) {
            availableSeats += numberOfSeats;
            System.out.println(numberOfSeats + " seats canceled successfully in " + trainName);
        } else {
            System.out.println("Invalid number of seats to cancel.");
        }
    }
}

class ReservationSystem {
    private Map<String, Train> trains;

    public ReservationSystem() {
        this.trains = new HashMap<>();
    }

    public void addTrain(Train train) {
        trains.put(train.getTrainNumber(), train);
    }

    public void bookTicket(String trainNumber, int numberOfSeats) {
        Train train = trains.get(trainNumber);
        if (train != null) {
            train.bookTicket(numberOfSeats);
        } else {
            System.out.println("Train with number " + trainNumber + " not found.");
        }
    }

    public void cancelTicket(String trainNumber, int numberOfSeats) {
        Train train = trains.get(trainNumber);
        if (train != null) {
            train.cancelTicket(numberOfSeats);
        } else {
            System.out.println("Train with number " + trainNumber + " not found.");
        }
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        Train train1 = new Train("12345", "Express 1", 100);
        Train train2 = new Train("67890", "Express 2", 150);

        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.addTrain(train1);
        reservationSystem.addTrain(train2);

        reservationSystem.bookTicket("12345", 3);
        reservationSystem.bookTicket("67890", 2);
        reservationSystem.cancelTicket("12345", 2);
    }
}
