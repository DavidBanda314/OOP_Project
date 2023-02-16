import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.io.*;
import java.util.*;
public class FNCD {
    public static double BUDGET = 500000.00;
    private int currentDay = 0;
    private int borrowedMoney = 0;
    private double budget = BUDGET;
    private  int dailySales = 0;
    //Replace strings with correct Types
    //below is an example of identity. While three mechanics
    //can be declared with the exact same information,
    //even if all of this is the same, each individual object
    //has its own identity: that is, each one of these three
    //mechanics will have their own space in memory.
    //So, Mechanic[0] != Mechanic[1], because they each have
    //their own identity.
    private Mechanic Mechanics[] = new Mechanic[3];
    private Intern Interns[] = new Intern[3];
    private SalesPerson SalesPeople[] = new SalesPerson[3];
    private Pickup PickUpTrucks[] = new Pickup[4];
    private PerformanceCar PerformanceCars[] = new PerformanceCar[4];
    private Car Cars[] = new Car[4];
    //replace with Staff type
    private ArrayList<Staff> departedStaff = new ArrayList<Staff>();
    private ArrayList<Vehicle> pastCars = new ArrayList<Vehicle>();

    public Mechanic[] getMechanics() {
        return Mechanics;
    }

    public int getBorrowedMoney(){
        return borrowedMoney;
    }

    public SalesPerson[] getSalesPeople() {
        return SalesPeople;
    }

    public Intern[] getInterns() {
        return Interns;
    }

    public void setMechanic(Integer index){
        this.Mechanics[index] = new Mechanic();
    }

    public void setSalesPerson(Integer index){
        this.SalesPeople[index] = new SalesPerson();
    }

    public void setIntern(Integer index){
        this.Interns[index] = new Intern();
    }

    public ArrayList<Staff> getDepartedStaff() {
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

    public double getBudget() {
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
    public void Opening(){
        incrementDay();
        Random rand = new Random();
        if(budget < 0){
            budget = budget + 250000;
            borrowedMoney += 250000;
            System.out.println("The FNCD has borrowed money, as they had a negative balance!");
        }
        if(currentDay == 1){
            for(int i = 0; i < 3; i++){
                this.Mechanics[i] = new Mechanic();
                this.Interns[i] = new Intern();
                this.SalesPeople[i] = new SalesPerson();
                this.Cars[i] = new Car(rand.nextDouble(10001)+ 10000);
                this.PerformanceCars[i] = new PerformanceCar(rand.nextDouble(20001)+ 20000);
                this.PickUpTrucks[i] = new Pickup(rand.nextDouble(30001)+ 10000);
                this.budget = this.budget - (this.Cars[i].getCost() + this.PerformanceCars[i].getCost() + this.PickUpTrucks[i].getCost());
            }
            this.Cars[3] = new Car(rand.nextDouble(10001)+ 10000);
            this.PerformanceCars[3] = new PerformanceCar(rand.nextDouble(20001)+ 20000);
            this.PickUpTrucks[3] = new Pickup(rand.nextDouble(30001)+ 10000);
            this.budget = this.budget - (this.Cars[3].getCost() + this.PerformanceCars[3].getCost() + this.PickUpTrucks[3].getCost());
        }
    }

    public void Washing(){
        Random rand = new Random();
        ArrayList<Vehicle> dirtyCars = new ArrayList<Vehicle>();
        ArrayList<Vehicle> cleanCars = new ArrayList<Vehicle>();
        for(int i = 0; i < 4; i++){
            if(this.Cars[i].getCleanliness() == Cleanliness.dirty){
                dirtyCars.add(this.Cars[i]);
            }
            else if(this.Cars[i].getCleanliness() == Cleanliness.clean){
                cleanCars.add(this.Cars[i]);
            }
            if(this.PerformanceCars[i].getCleanliness() == Cleanliness.dirty){
                dirtyCars.add(this.PerformanceCars[i]);
            }
            else if(this.PerformanceCars[i].getCleanliness() == Cleanliness.clean){
                cleanCars.add(this.PerformanceCars[i]);
            }
            if(this.PickUpTrucks[i].getCleanliness() == Cleanliness.dirty){
                dirtyCars.add(this.PickUpTrucks[i]);
            }
            else if(this.PickUpTrucks[i].getCleanliness() == Cleanliness.clean){
                cleanCars.add(this.PickUpTrucks[i]);
            }
        }
    for(int i = 0; i < 3; i++){
        for(int k = 0; k < 2; k++){
            if(!dirtyCars.isEmpty()){
                Collections.shuffle(dirtyCars);
                Vehicle toClean = dirtyCars.get(0);
                int randNum = rand.nextInt(100) + 1;
                if(randNum <= 80){
                    System.out.println(Interns[i].getName() + " has made a dirty car clean!");
                    toClean.setCleanliness(Cleanliness.clean);
                    dirtyCars.remove(0);
                }
                else if(randNum <= 90){
                    System.out.println(Interns[i].getName() + " has made a dirty car sparkling!");
                    toClean.setCleanliness(Cleanliness.sparkling);
                    dirtyCars.remove(0);
                    Interns[i].addBonuses(toClean.getWashBonus());
                }
            }
            else if(!cleanCars.isEmpty()){
                Collections.shuffle(cleanCars);
                Vehicle toClean = cleanCars.get(0);
                int randNum = rand.nextInt(100) + 1;
                if(randNum <= 5){
                    System.out.println(Interns[i].getName() + " has made a clean car dirty!");
                    toClean.setCleanliness(Cleanliness.dirty);
                    cleanCars.remove(0);
                }
                else if(randNum <= 35){
                    System.out.println(Interns[i].getName() + " has made a clean car sparkling!");
                    toClean.setCleanliness(Cleanliness.sparkling);
                    cleanCars.remove(0);
                    Interns[i].addBonuses(toClean.getWashBonus());
                }
            }
        }
    }
    }

    public void Repairing(){
        Random rand = new Random();
        ArrayList<Vehicle> brokenCars = new ArrayList<Vehicle>();
        for(int i = 0; i < 4; i++){
            if(this.Cars[i].getCondition() == Condition.Broken){
                brokenCars.add(this.Cars[i]);
            }
            else if(this.Cars[i].getCondition() == Condition.Used){
                brokenCars.add(this.Cars[i]);
            }
            if(this.PerformanceCars[i].getCondition() == Condition.Broken){
                brokenCars.add(this.PerformanceCars[i]);
            }
            else if(this.PerformanceCars[i].getCondition() == Condition.Used){
                brokenCars.add(this.PerformanceCars[i]);
            }
            if(this.PickUpTrucks[i].getCondition() == Condition.Broken){
                brokenCars.add(this.PickUpTrucks[i]);
            }
            else if(this.PickUpTrucks[i].getCondition() == Condition.Used){
                brokenCars.add(this.PickUpTrucks[i]);
            }
        }

        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 2; k++){
                if(!brokenCars.isEmpty()){
                    Collections.shuffle(brokenCars);
                    Vehicle toFix = brokenCars.get(0);
                    int randNum = rand.nextInt(100) + 1;
                    if(randNum <= 80){
                        brokenCars.remove(0);
                        if(toFix.getCondition() == Condition.Broken){
                            System.out.println(Mechanics[i].getName() + " has made a broken car used!");
                            toFix.setCondition(Condition.Used);
                            toFix.setCost(toFix.getCost() * 1.5);
                            Mechanics[i].addBonuses(toFix.getRepairBonus());
                        }
                        else{
                            System.out.println(Mechanics[i].getName() + " has made a used car like new!");
                            toFix.setCondition(Condition.LikeNew);
                            toFix.setCost(toFix.getCost() * 1.25);
                            Mechanics[i].addBonuses(toFix.getRepairBonus());
                        }
                    }
                    if(toFix.getCleanliness() == Cleanliness.sparkling){
                        toFix.setCleanliness(Cleanliness.clean);
                    }
                    if(toFix.getCleanliness() == Cleanliness.clean){
                        toFix.setCleanliness(Cleanliness.dirty);
                    }
                }
            }
        }
    }

    public void Selling(){
        Random rand = new Random();
        int randnum = rand.nextInt(5) + 1;
        if(this.currentDay/2 == 5 || this.currentDay/2 == 6 || this.currentDay/2 == 11 || this.currentDay/2 ==12 || this.currentDay/2 == 17 || this.currentDay/2 == 18 || this.currentDay/2 == 23 || this.currentDay/2 == 24 || this.currentDay/2 == 29 || this.currentDay/2 == 30){
            int randNum = rand.nextInt(7) + 2;
        }
        ArrayList<PerformanceCar> perfCars = new ArrayList<PerformanceCar>();
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<Pickup> pickupCars = new ArrayList<Pickup>();
        for(int i = 0; i < 3; i++){
            if(!(PerformanceCars[i].getCondition() == Condition.Broken)){
                perfCars.add(PerformanceCars[i]);
            }
            if(!(Cars[i].getCondition() == Condition.Broken)){
                cars.add(Cars[i]);
            }
            if(!(PickUpTrucks[i].getCondition() == Condition.Broken)){
                pickupCars.add(PickUpTrucks[i]);
            }
        }
        ArrayList<Buyer> buyers = new ArrayList<Buyer>();
        for(int i = 0; i < randnum; i++){
            buyers.add(new Buyer());
        }
        while(!buyers.isEmpty()){
            Boolean sold = false;
            int chanceBuying = rand.nextInt(100) + 1;
            if(chanceBuying < buyers.get(0).getChanceBuying()){
                String typeLooking = buyers.get(0).getTypeNeeded();
                if(typeLooking == "Performance"){
                    if(!perfCars.isEmpty()){
                        double max = 0;
                        int index = 0;
                        for(int i =0; i < perfCars.size(); i++){
                            if(perfCars.get(i).getCost() > max){
                                max = perfCars.get(i).getCost();
                                index = i;
                            }
                        }
                        if(perfCars.get(index).getCleanliness() == Cleanliness.sparkling){
                            perfCars.get(index).setCost(perfCars.get(index).getCost() * 1.1);
                        }
                        if(perfCars.get(index).getCondition() == Condition.LikeNew){
                            perfCars.get(index).setCost(perfCars.get(index).getCost() * 1.1);
                        }
                        randnum = rand.nextInt(3);
                        System.out.println(SalesPeople[randnum].getName() + " has sold a performance car!");
                        this.budget = this.budget + perfCars.get(index).getSalesPrice();
                        SalesPeople[randnum].addBonuses(perfCars.get(index).getSaleBonus());
                        this.dailySales += perfCars.get(index).getSalesPrice();
                        this.pastCars.add(perfCars.get(index));
                        int carNum = 0;
                        for(int i = 0; i < 3; i++){
                            if(perfCars.get(index).getName() == PerformanceCars[i].getName()){
                                carNum = i;
                            }
                        }
                        PerformanceCars[carNum] = new PerformanceCar(rand.nextDouble(20001)+ 20000);
                        this.budget = this.budget - PerformanceCars[carNum].getCost();
                        perfCars.remove(index);
                        sold = true;
                    }
                }
                
                if(typeLooking == "Car"){
                    if(!cars.isEmpty()){
                        double max = 0;
                        int index = 0;
                        for(int i =0; i < cars.size(); i++){
                            if(cars.get(i).getCost() > max){
                                max = cars.get(i).getCost();
                                index = i;
                            }
                        }
                        if(cars.get(index).getCleanliness() == Cleanliness.sparkling){
                            cars.get(index).setCost(cars.get(index).getCost() * 1.1);
                        }
                        if(cars.get(index).getCondition() == Condition.LikeNew){
                            cars.get(index).setCost(cars.get(index).getCost() * 1.1);
                        }
                        randnum = rand.nextInt(3);
                        System.out.println(SalesPeople[randnum].getName() + " has sold a car!");
                        this.budget = this.budget + cars.get(index).getSalesPrice();
                        SalesPeople[randnum].addBonuses(cars.get(index).getSaleBonus());
                        this.dailySales += cars.get(index).getSalesPrice();
                        this.pastCars.add(cars.get(index));
                        int carNum = 0;
                        for(int i = 0; i < 3; i++){
                            if(cars.get(index).getName() == Cars[i].getName()){
                                carNum = i;
                            }
                        }
                        Cars[carNum] = new Car(rand.nextDouble(10001)+ 10000);
                        this.budget = this.budget - Cars[carNum].getCost();
                        cars.remove(index);
                        sold = true;
                    }
                }

                if(typeLooking == "Pickup"){
                    if(!pickupCars.isEmpty()){
                        double max = 0;
                        int index = 0;
                        for(int i =0; i < pickupCars.size(); i++){
                            if(pickupCars.get(i).getCost() > max){
                                max = pickupCars.get(i).getCost();
                                index = i;
                            }
                        }
                        if(pickupCars.get(index).getCleanliness() == Cleanliness.sparkling){
                            pickupCars.get(index).setCost(pickupCars.get(index).getCost() * 1.1);
                        }
                        if(pickupCars.get(index).getCondition() == Condition.LikeNew){
                            pickupCars.get(index).setCost(pickupCars.get(index).getCost() * 1.1);
                        }
                        randnum = rand.nextInt(3);
                        System.out.println(SalesPeople[randnum].getName() + " has sold a pickup truck!");
                        this.budget = this.budget + pickupCars.get(index).getSalesPrice();
                        SalesPeople[randnum].addBonuses(pickupCars.get(index).getSaleBonus());
                        this.dailySales += pickupCars.get(index).getSalesPrice();
                        this.pastCars.add(pickupCars.get(index));
                        int carNum = 0;
                        for(int i = 0; i < 3; i++){
                            if(pickupCars.get(index).getName() == PickUpTrucks[i].getName()){
                                carNum = i;
                            }
                        }
                        PickUpTrucks[carNum] = new Pickup(rand.nextDouble(30001)+ 10000);
                        this.budget = this.budget - PickUpTrucks[carNum].getCost();
                        pickupCars.remove(index);
                        sold = true;
                    }
                }
                if(sold == false){
                    ArrayList<Vehicle> leftOvers = new ArrayList<Vehicle>();
                    for(int i = 0; i < cars.size(); i++){
                        leftOvers.add(cars.get(i));
                    } 
                    for(int i = 0; i < pickupCars.size(); i++){
                        leftOvers.add(pickupCars.get(i));
                    }
                    for(int i = 0; i < perfCars.size(); i++){
                        leftOvers.add(perfCars.get(i));
                    }
                    double max = 0;
                    int index = 0;
                    for(int i = 0; i < leftOvers.size(); i++){
                        if(leftOvers.get(i).getCost() > max){
                            max = leftOvers.get(i).getCost();
                            index = i;
                        }
                    }
                    int randNum = rand.nextInt(3);
                    System.out.println(SalesPeople[randNum] + " has sold a vehicle: " + leftOvers.get(index).getName()); 
                    SalesPeople[randNum].addBonuses(leftOvers.get(index).getSaleBonus());
                    this.budget = this.budget + (leftOvers.get(index).getSalesPrice() * .8);
                    this.dailySales += (leftOvers.get(index).getSalesPrice() * .8);
                    this.pastCars.add(leftOvers.get(index));
                    for(int i = 0; i < 3; i++){
                        if(PerformanceCars[i].getName() == leftOvers.get(index).getName()){
                            PerformanceCars[i] = new PerformanceCar(rand.nextDouble(20001)+ 20000);
                            this.budget = this.budget - PerformanceCars[i].getCost();
                        }
                        if(Cars[i].getName() == leftOvers.get(index).getName()){
                            Cars[i] = new Car(rand.nextDouble(10001)+ 10000);
                            this.budget = this.budget - Cars[i].getCost();
                        }
                        if(PickUpTrucks[i].getName() == leftOvers.get(index).getName()){
                            PickUpTrucks[i] = new Pickup(rand.nextDouble(30001)+ 10000);
                            this.budget = this.budget - PickUpTrucks[i].getCost();
                        }
                    }
                }
            }
            buyers.remove(0);
        }
    }

    public void Ending(){
        Random rand = new Random();
        this.incrementDay();
        for(int i = 0; i < 3; i++){
            SalesPeople[i].addSalary();
            SalesPeople[i].incrDays();
            Interns[i].addSalary();
            Interns[i].incrDays();
            Mechanics[i].addSalary();
            Mechanics[i].incrDays();
        }
        //daily pay
        this.budget = this.budget - 2700;
        for(int i = 0; i < 3; i++){
            int randNum = rand.nextInt(10) + 1;
            if(randNum == 1){
                System.out.println(Interns[i].getName() + " has quit!");
                this.departedStaff.add(Interns[i]);
                Interns[i] = new Intern();
            }
        }
        for(int i = 0; i < 3; i++){
            int randNum = rand.nextInt(10) + 1;
            if(randNum == 1){
                System.out.println(Mechanics[i].getName() + " has quit!");
                this.departedStaff.add(Mechanics[i]);
                randNum = rand.nextInt(3);
                Mechanics[i] = new Mechanic(Interns[randNum].getName(), Interns[randNum].getSalary(), Interns[randNum].getBonuses(), Interns[randNum].getDays());
                Interns[randNum] = new Intern();
            }
        }

        for(int i = 0; i < 3; i++){
            int randNum = rand.nextInt(10) + 1;
            if(randNum == 1){
                System.out.println(SalesPeople[i].getName() + " has quit!");
                this.departedStaff.add(SalesPeople[i]);
                randNum = rand.nextInt(3);
                SalesPeople[i] = new SalesPerson(Interns[randNum].getName(), Interns[randNum].getSalary(), Interns[randNum].getBonuses(), Interns[randNum].getDays());
                Interns[randNum] = new Intern();
            }
        }

        System.out.println("\n\nDaily Report:\nInterns:\n");
        for(int i = 0; i < 3; i++){
            System.out.println("Name: " + Interns[i].getName() + "   Days Worked: " + Interns[i].getDays() + "   Normal Pay: " + Interns[i].getSalary() + "   Bonus Pay: " + Interns[i].getBonuses() + "   Working: Employed");
        }
        System.out.println("\nMechanics: \n");
        for(int i = 0; i < 3; i++){
            System.out.println("Name: " + Mechanics[i].getName() + "   Days Worked: " + Mechanics[i].getDays() + "   Normal Pay: " + Mechanics[i].getSalary() + "   Bonus Pay: " + Mechanics[i].getBonuses() + "   Working: Employed");
        }
        System.out.println("\nSales People: \n");
        for(int i = 0; i < 3; i++){
            System.out.println("Name: " + SalesPeople[i].getName() + "   Days Worked: " + SalesPeople[i].getDays() + "   Normal Pay: " + SalesPeople[i].getSalary() + "   Bonus Pay: " + SalesPeople[i].getBonuses() + "   Working: Employed");
        }
        System.out.println("\nPast Workers: \n");
        for(int i = 0; i < departedStaff.size(); i++){
            System.out.println("Name: " + departedStaff.get(i).getName() + "   Days Worked: " + departedStaff.get(i).getDays() + "   Normal Pay: " + departedStaff.get(i).getSalary() + "   Bonus Pay: " + departedStaff.get(i).getBonuses() + "   Working: Quit");
        }
        System.out.println("\n\nInventory:\nCars: \n");
        for(int i = 0; i < 3; i++){
            System.out.println("Name: " + Cars[i].getName() + "   Cost: " + Cars[i].getCost() + "   Sales Price: " + Cars[i].getSalesPrice() + "   Condition: " + Cars[i].getCondition() + "   Cleanliness: " + Cars[i].getCleanliness() + "   Sold: In Stock");
        }
        System.out.println("\nPerformance Cars: \n");
        for(int i = 0; i < 3; i++){
            System.out.println("Name: " + PerformanceCars[i].getName() + "   Cost: " + PerformanceCars[i].getCost() + "   Sales Price: " + PerformanceCars[i].getSalesPrice() + "   Condition: " + PerformanceCars[i].getCondition() + "   Cleanliness: " + PerformanceCars[i].getCleanliness() + "   Sold: In Stock");
        }
        System.out.println("\nPickup Trucks: \n");
        for(int i = 0; i < 3; i++){
            System.out.println("Name: " + PickUpTrucks[i].getName() + "   Cost: " + PickUpTrucks[i].getCost() + "   Sales Price: " + PickUpTrucks[i].getSalesPrice() + "   Condition: " + PickUpTrucks[i].getCondition() + "   Cleanliness: " + PickUpTrucks[i].getCleanliness() + "   Sold: In Stock");
        }
        System.out.println("\nPast Cars: \n");
        for(int i = 0; i < pastCars.size(); i++){
            System.out.println("Name: " + pastCars.get(i).getName() + "   Cost: " + pastCars.get(i).getCost() + "   Sales Price: " + pastCars.get(i).getSalesPrice() + "   Condition: " + pastCars.get(i).getCondition() + "   Cleanliness: " + pastCars.get(i).getCleanliness() + "   Sold: Sold");
        }
        System.out.println("\n\nFinances:\n");
        System.out.println("Operating Budget: " + this.budget + "\nDaily Sales: " + this.dailySales + " \nDay Number: " + this.currentDay/2);
        if(this.borrowedMoney != 0){
            System.out.println("Borrowed money: " + this.borrowedMoney);
        }
        dailySales = 0;
    }
}
