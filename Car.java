public class Car {
    private int id;
    private String model;
    private String brand;
    private double rentalPricePerDay;
    private boolean isRented;

    public Car(int id, String model, String brand, double rentalPricePerDay) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isRented = false;
    }

    public void rentCar() {
        if (!isRented) {
            isRented = true;
            System.out.println(model + " has been rented.");
        } else {
            System.out.println(model + " is already rented.");
        }
    }

    public void returnCar() {
        if (isRented) {
            isRented = false;
            System.out.println(model + " has been returned.");
        } else {
            System.out.println(model + " was not rented.");
        }
    }

    public boolean isAvailable() {
        return !isRented;
    }

    public String getDetails() {
        return "Car ID: " + id + ", Model: " + model + ", Brand: " + brand + 
               ", Rental Price per Day: " + rentalPricePerDay + ", Available: " + isAvailable();
    }
}
