import java.util.ArrayList;

public class RentalAgency {
    private ArrayList<Car> listOfCars;
    private ArrayList<Customer> listOfCustomers;

    public RentalAgency() {
        listOfCars = new ArrayList<>();
        listOfCustomers = new ArrayList<>();
    }

    public void addCar(Car car) {
        listOfCars.add(car);
        System.out.println(car.getDetails() + " added to the rental system.");
    }

    public void addCustomer(Customer customer) {
        listOfCustomers.add(customer);
        System.out.println(customer.getDetails() + " added to the system.");
    }

    public void rentCar(int customerId, int carId) {
        Car car = findCarById(carId);
        Customer customer = findCustomerById(customerId);

        if (car != null && customer != null && car.isAvailable()) {
            customer.rentCar(car);
        } else {
            System.out.println("Rental operation failed.");
        }
    }

    public void returnCar(int customerId) {
        Customer customer = findCustomerById(customerId);

        if (customer != null) {
            customer.returnCar();
        }
    }

    public ArrayList<Car> getAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>();
        for (Car car : listOfCars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    private Car findCarById(int carId) {
        for (Car car : listOfCars) {
            if (car.getId() == carId) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomerById(int customerId) {
        for (Customer customer : listOfCustomers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }
}
