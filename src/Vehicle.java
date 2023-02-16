import java.util.Random;

enum Condition {
    LikeNew, Used, Broken
}

enum Cleanliness {
    sparkling, clean, dirty
}
class Vehicle {
    //all of these private variables are examples of encapsulation.
    //these are all hidden implementation details of the class,
    //and outside of the class, you can not have direct access to these members.
    private String name;
    private Double cost;
    private Double salesPrice;
    private Condition condition;
    private Cleanliness cleanliness;
    private double repairBonus;
    private double washBonus;
    private double saleBonus;
    public Vehicle(Double cost) {
        this.salesPrice = cost * 2;
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        if(randomNum == 1){
            this.condition = Condition.LikeNew;
        }
        else if(randomNum == 2){
            this.condition = Condition.Broken;
        }
        else{
            this.condition = Condition.Used;
        }
        randomNum = rand.nextInt(100) + 1;
        if(randomNum <= 5){
            this.cleanliness = Cleanliness.sparkling;
        }
        else if(randomNum <= 40){
            this.cleanliness = Cleanliness.clean;
        }
        else{
            this.cleanliness = Cleanliness.dirty;
        }
        if(condition == Condition.Broken){
            this.cost = cost * 0.5;
        }
        else if(condition == Condition.Used) {
            this.cost = cost * 0.8;
        }
        else if(condition == Condition.LikeNew){
            this.cost = cost;
        }
    }

    //this is an example of abstraction. It is simply a method
    //that is provided to achieve a task, or solve a problem.
    //however, we do not know the inner workings of what the function
    //really does. All we know is the high level, necessary information
    public double getRepairBonus(){
        return this.repairBonus;
    }

    public double getWashBonus(){
        return this.washBonus;
    }

    public double getSaleBonus(){
        return this.saleBonus;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public Condition getCondition() {
        return condition;
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    public Cleanliness getCleanliness() {
        return cleanliness;
    }
    public void setCleanliness(Cleanliness cleanliness) {
        this.cleanliness = cleanliness;
    }
}

class Car extends Vehicle {
    private static int nextId = 1;
    private int id;

    private double repairBonus = 200;
    private double washBonus = 100;
    private double saleBonus = 500;

    public Car(Double cost) {
        super(cost);
        this.id = nextId++;
        this.setName("Car" + id);
    }
    public double getWashBonus() {
        return washBonus;
    }

    public double getSaleBonus() {
        return saleBonus;
    }

    public double getRepairBonus() {
        return repairBonus;
    }
}

class PerformanceCar extends Vehicle {
    private static int nextId = 1;
    private int id;

    private double repairBonus = 400;
    private double washBonus = 200;
    private double saleBonus = 1000;

    public PerformanceCar(Double cost) {
        super(cost);
        this.id = nextId++;
        this.setName("PC" + id);
    }
    public double getWashBonus() {
        return washBonus;
    }

    public double getSaleBonus() {
        return saleBonus;
    }

    public double getRepairBonus() {
        return repairBonus;
    }
}

class Pickup extends Vehicle {
    private double repairBonus = 300;
    private double washBonus = 150;
    private double saleBonus = 750;
    private static int nextId = 1;
    private int id;

    public Pickup(Double cost) {
        super(cost);
        this.id = nextId++;
        this.setName("Pickup" + id);
    }

    public double getWashBonus() {
        return washBonus;
    }

    public double getSaleBonus() {
        return saleBonus;
    }

    public double getRepairBonus() {
        return repairBonus;
    }
}