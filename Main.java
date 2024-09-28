public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Adding cars
        Car car1 = new Car(1, "Model S", "Tesla", 150.0);
        Car car2 = new Car(2, "Mustang", "Ford", 100.0);
        agency.addCar(car1);
        agency.addCar(car2);

        // Adding customers
        Customer cust1 = new Customer(1, "John Doe", "john@example.com");
        Customer cust2 = new Customer(2, "Jane Smith", "jane@example.com");
        agency.addCustomer(cust1);
        agency.addCustomer(cust2);

        // Rent a car
        agency.rentCar(1, 1); // John rents Tesla
        agency.rentCar(2, 2); // Jane rents Mustang

        // Return a car
        agency.returnCar(1);  // John returns Tesla

        // List available cars
        System.out.println("Available cars:");
        for (Car car : agency.getAvailableCars()) {
            System.out.println(car.getDetails());
        }
    }
}
