import org.junit.jupiter.api.Test;
import simplefactory.CarFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static simplefactory.CarFactory.CarType.Sedan;

public class FactoryTest {

    @Test
    public void createCarTest() {
        // Arrange
        CarFactory carFactory = new CarFactory();
        carFactory.createCar(Sedan, 6, 5);

        // Act

        // Assert

    }
}
