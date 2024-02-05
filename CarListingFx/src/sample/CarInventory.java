package sample;
import java.util.ArrayList;
import java.util.List;


public class CarInventory {

    // This is creating the Arraylist for the car inventory
    List<Car> cars = new ArrayList<>();

    // This is to add into the arraylist
    public void addCars(Car car){
        this.cars.add(car);
    }
    // This is to keep count of inventory
    public int getInventoryCount(){
        return cars.size();
    }
    // This method returns the list of cars stored in the inventory
    public List<Car> getAllCars(){
        return cars;
    }
}
