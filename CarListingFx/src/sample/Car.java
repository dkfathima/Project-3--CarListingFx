package sample;


import javafx.scene.image.Image;

// These are the private fields to store the car information
public class Car {
    private Image image;
    private String make;
    private String model;
    private int year;
    private String vinNum;
    private int mileage;
    private double cost;
    private boolean record;

    // These are the constructor to initialize the car object
    public Car(Image image, String make, String model, int year, String vinNum,int mileage, double cost, boolean record){
        this.image = image;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vinNum = vinNum;
        this.mileage = mileage;
        this.cost = cost;
        this.record = record;
    }

    // The getter methods is to retrieve the car's image, make, model, year, mileage, cost, record
    public Image getImage() {
        return image;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public String getVinNum(){
        return vinNum;
    }
    public int getMileage(){
        return mileage;
    }
    public double getCost(){
        return cost;
    }
    public boolean isRecord(){
        return record;
    }
    public void add(Car cars) {
    }

    //The toString() method is to represent the car objects as a string
    public String toString(){
        return year + " " + make + " " + model + " ";
    }
}
