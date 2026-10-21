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
                return new Sedan();

            case Convertible:
                return new Convertible();

            case Pickup:
                return new Pickup();

            default:
                throw new IllegalArgumentException("Ukendt biltype");
        }

    }
}
