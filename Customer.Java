public class Customer {
    private int id;
    private String name;
    private String email;
    private Car rentedCar;

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.rentedCar = null;
    }

    public void rentCar(Car car) {
        if (rentedCar == null && car.isAvailable()) {
            rentedCar = car;
            car.rentCar();
        } else {
            System.out.println(name + " cannot rent the car.");
        }
    }

    public void returnCar() {
        if (rentedCar != null) {
            rentedCar.returnCar();
            rentedCar = null;
        } else {
            System.out.println(name + " has no car to return.");
        }
    }

    public String getDetails() {
        return "Customer ID: " + id + ", Name: " + name + ", Email: " + email + 
               (rentedCar != null ? ", Rented Car: " + rentedCar.getDetails() : ", No car rented.");
    }
}
