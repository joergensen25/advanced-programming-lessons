package simplefactory;

public class CarFactory {

    public enum CarType {
        Sedan,
        Convertible,
        Pickup
    }
    public enum FuelType {
        Gasoline,
        Electricity,
        Hybrid
    }



    public Car createCar(CarType carType, int seats, int doors) {
        switch (carType) {
            case Sedan:
                return new Sedan(seats, doors);

            case Convertible:
                return new Convertible(seats, doors);

            case Pickup:
                return new Pickup(seats, doors);

            default:
                throw new IllegalArgumentException("Ukendt biltype");
        }

    }
}
