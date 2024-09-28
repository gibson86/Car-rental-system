import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;
    private Car car;

    @BeforeEach
    void setUp() {
        customer = new Customer(1, "John Doe", "john@example.com");
        car = new Car(1, "Model S", "Tesla", 150.0);
    }

    @Test
    void testRentCar() {
        assertNull(customer.getRentedCar());
        customer.rentCar(car);
        assertEquals(car, customer.getRentedCar());
    }

    @Test
    void testReturnCar() {
        customer.rentCar(car);
        customer.returnCar();
        assertNull(customer.getRentedCar());
    }

    @Test
    void testRentAlreadyRentedCar() {
        car.rentCar();
        customer.rentCar(car); // Attempt to rent already rented car
        assertNull(customer.getRentedCar());
    }

    @Test
    void testGetDetails() {
        String expected = "Customer ID: 1, Name: John Doe, Email: john@example.com, No car rented.";
        assertEquals(expected, customer.getDetails());
    }
}
