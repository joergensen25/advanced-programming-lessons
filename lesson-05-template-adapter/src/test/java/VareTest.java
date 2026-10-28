import opgave2.ElVare;
import opgave2.FoedeVare;
import opgave2.Vare;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VareTest {

    @Test
    void test_beregnMoms_ElVare() {
        // Arrange
        Vare elVare = new ElVare(100, "Lampe");

        Vare foedeVare = new FoedeVare(50, "Dyre æbler");

        // Act

        double expected = 30;
        double actual = elVare.beregnMoms();
        elVare.beregnMoms();

        double expected1 = 3;
        double actual1 = foedeVare.beregnMoms();

        // Assert
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
    }

}
