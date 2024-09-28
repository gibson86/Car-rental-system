import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RentalAgencyTest {
    private RentalAgency agency;
    private Car car1, car2;
    private Customer customer;

    @BeforeEach
    void setUp() {
        agency = new RentalAgency();
        car1 = new Car(1, "Model S", "Tesla", 150.0);
        car2 = new Car(2, "Mustang", "Ford", 100.0);
        agency.addCar(car1);
        agency.addCar(car2);

        customer = new Customer(1, "John Doe", "john@example.com");
        agency.addCustomer(customer);
    }

    @Test
    void testRentCar() {
        agency.rentCar(1, 1); // John rents Tesla
        assertFalse(car1.isAvailable());
        assertEquals(car1, customer.getRentedCar());
    }

    @Test
    void testReturnCar() {
        agency.rentCar(1, 1); // John rents Tesla
        agency.returnCar(1); // John returns Tesla
        assertTrue(car1.isAvailable());
        assertNull(customer.getRentedCar());
    }

    @Test
    void testGetAvailableCars() {
        List<Car> availableCars = agency.getAvailableCars();
        assertEquals(2, availableCars.size());

        agency.rentCar(1, 1); // John rents Tesla
        availableCars = agency.getAvailableCars();
        assertEquals(1, availableCars.size()); // Only one car should be available now
    }
}
