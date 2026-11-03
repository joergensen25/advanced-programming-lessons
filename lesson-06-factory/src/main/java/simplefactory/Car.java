package simplefactory;

public class Car {
    private int seats;
    private int doors;


    public Car(int seats, int doors) {
        this.seats = seats;
        this.doors = doors;
    }


    public int getSeats() {
        return seats;
    }

    public int getDoors() {
        return doors;
    }
}
