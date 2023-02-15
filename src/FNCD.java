import java.util.ArrayList;

public class FNCD {
    public static int BUDGET = 500000;
    private int currentDay = 0;
    private int budget = BUDGET;
    private  int dailySales = 0;
    //Replace strings with correct Types
    private String Mechanics[] = new String[3];
    private String Interns[] = new String[3];
    private String SalesPeople[] = new String[3];
    private Pickup PickUpTrucks[] = new Pickup[4];
    private PerformanceCar PerformanceCars[] = new PerformanceCar[4];
    private Car Cars[] = new Car[4];
    //replace with Staff type
    private ArrayList<String> departedStaff = new ArrayList<String>();
    private ArrayList<Vehicle> pastCars = new ArrayList<Vehicle>();

    public String[] getMechanics() {
        return Mechanics;
    }

    public String[] getSalesPeople() {
        return SalesPeople;
    }

    public String[] getInterns() {
        return Interns;
    }

    public ArrayList<String> getDepartedStaff() {
        return departedStaff;
    }

    public ArrayList<Vehicle> getPastCars() {
        return pastCars;
    }

    public PerformanceCar[] getPerformanceCars() {
        return PerformanceCars;
    }

    public Pickup[] getPickUpTrucks() {
        return PickUpTrucks;
    }

    public Car[] getCars() {
        return Cars;
    }

    public int getCurrentDay() {
        return currentDay;
    }
    public void incrementDay() {
        this.currentDay += 1;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int newBudget){
        this.budget = newBudget;
    }

    public int getDailySales() {
        return dailySales;
    }

    public void setDailySales(int dailySales) {
        this.dailySales = dailySales;
    }
    // TODO Finish Implementation
}
