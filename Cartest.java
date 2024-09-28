import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(1, "Model S", "Tesla", 150.0);
    }

    @Test
    void testRentCar() {
        assertTrue(car.isAvailable());
        car.rentCar();
        assertFalse(car.isAvailable());
    }

    @Test
    void testReturnCar() {
        car.rentCar();
        assertFalse(car.isAvailable());
        car.returnCar();
        assertTrue(car.isAvailable());
    }

    @Test
    void testRentAlreadyRentedCar() {
        car.rentCar();
        car.rentCar(); // Attempt to rent again
        assertFalse(car.isAvailable());
    }

    @Test
    void testReturnUnrentedCar() {
        car.returnCar(); // Attempt to return without renting
        assertTrue(car.isAvailable());
    }

    @Test
    void testGetDetails() {
        String expected = "Car ID: 1, Model: Model S, Brand: Tesla, Rental Price per Day: 150.0, Available: true";
        assertEquals(expected, car.getDetails());
    }
}
