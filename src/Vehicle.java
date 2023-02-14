import java.util.Random;

enum Condition {
    LikeNew, Used, Broken
}

enum Cleanliness {
    sparkling, clean, dirty
}
class Vehicle {
    private String name;
    private Double cost;
    private Double salesPrice;
    private Condition condition;
    private Cleanliness cleanliness;
    public Vehicle(Double cost, Double salesPrice, Condition condition, Cleanliness cleanliness) {
        if(condition == Condition.Broken){
            this.cost = cost * 0.5;
        }
        else if(condition == Condition.Used) {
            this.cost = cost * 0.8;
        }
        else if(condition == Condition.LikeNew){
            this.cost = cost;
        }
        this.cleanliness = cleanliness;
        this.salesPrice = salesPrice;
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

    private float repairBonus = 200;
    private float washBonus = 100;
    private float saleBonus = 500;

    public Car(Double cost, Double salesPrice, Condition condition, Cleanliness cleanliness) {
        super(cost, salesPrice, condition, cleanliness);
        this.id = nextId++;
        this.setName("Car" + id);
    }
    public float getWashBonus() {
        return washBonus;
    }

    public float getSaleBonus() {
        return saleBonus;
    }

    public float getRepairBonus() {
        return repairBonus;
    }
}

class PerformanceCar extends Vehicle {
    private static int nextId = 1;
    private int id;

    private float repairBonus = 400;
    private float washBonus = 200;
    private float saleBonus = 1000;

    public PerformanceCar(Double cost, Double salesPrice, Condition condition, Cleanliness cleanliness) {
        super(cost, salesPrice, condition, cleanliness);
        this.id = nextId++;
        this.setName("PC" + id);
    }
    public float getWashBonus() {
        return washBonus;
    }

    public float getSaleBonus() {
        return saleBonus;
    }

    public float getRepairBonus() {
        return repairBonus;
    }
}

class Pickup extends Vehicle {
    private float repairBonus = 300;
    private float washBonus = 150;
    private float saleBonus = 750;
    private static int nextId = 1;
    private int id;

    public Pickup(Double cost, Double salesPrice, Condition condition, Cleanliness cleanliness) {
        super(cost, salesPrice, condition, cleanliness);
        this.id = nextId++;
        this.setName("Pickup" + id);
    }

    public float getWashBonus() {
        return washBonus;
    }

    public float getSaleBonus() {
        return saleBonus;
    }

    public float getRepairBonus() {
        return repairBonus;
    }
}