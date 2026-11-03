import org.junit.jupiter.api.Test;
import simplefactory.Car;
import simplefactory.CarFactory;
import simplefactory.Sedan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static simplefactory.CarFactory.CarType.Sedan;

public class FactoryTest {

    @Test
    public void createCarTest() {
        // Arrange
        CarFactory carFactory = new CarFactory();
        Car car = carFactory.createCar(Sedan, 5, 5);

        // Act
        assertInstanceOf(Sedan.class, car);
        // Assert

    }
}
