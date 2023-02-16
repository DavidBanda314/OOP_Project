import java.lang.Math;

//below is one example of cohesion. The staff class is initialized to have on clear implementation goal.
public class Staff {
    protected String name;
    protected Double salary;
    protected Double bonuses;
    protected Integer daysWorked;

    public Staff(){
        String[] firstName = {"Matt","John","Luke", "Sarah", "Christine", "Michelle", "Paige", "Ryan", "Daniel", "Emily", "Shane", "David", "Katherine", "Brittany", "Jeff", "Diane", "Jaden", "Max", "Carter", "Sarah"};
        String[] lastInitial = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        //source for Math.floor function: https://stackoverflow.com/questions/4550505/getting-a-random-value-from-a-javascript-array
        double fName = Math.floor(Math.random() * firstName.length);
        double lName = Math.floor(Math.random()* lastInitial.length);
        this.name = firstName[(int)fName] + " " + lastInitial[(int)lName];
        this.salary = 0.0;
        this.bonuses = 0.0;
        this.daysWorked = 0;
    }

    public Staff(String name, Double salary, Double Bonuses, Integer daysWorked){
        this.name = name;
        this.salary = salary;
        this.bonuses = Bonuses;
        this.daysWorked = daysWorked;
    }

    //this method is another example of cohesion. This method doesn't try to do too much, it simply does one thing: return a name
    public String getName(){
        return this.name;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public Double getSalary(){
        return this.salary;
    }

    public Double getBonuses(){
        return this.bonuses;
    }

    public void addBonuses(double extra){
        this.bonuses += extra;
    }

    public void incrDays(){
        this.daysWorked++;
    }

    public Integer getDays(){
        return this.daysWorked;
    }
}

class Mechanic extends Staff{
    private Double uniqueRate;

    public Mechanic() {
        this.uniqueRate = 300.00;
        this.name = "MC: " + this.name;
    }
    public Mechanic(String name, Double salary, Double Bonuses, Integer daysWorked){
        this.name = name;
        this.salary = salary;
        this.bonuses = Bonuses;
        this.daysWorked = daysWorked;
        this.uniqueRate = 300.00;
        this.name = "MC: " + this.name;
    }

    public void addSalary(){
        this.salary += this.uniqueRate;
    }
}

class SalesPerson extends Staff{
    private Double uniqueRate;

    public SalesPerson() {
        this.uniqueRate = 350.00;
        this.name = "SP: " + this.name;
    }
    //example of polymorphism. Can either choose the default constructer, or this one, depending on parameter input
    public SalesPerson(String name, Double salary, Double Bonuses, Integer daysWorked){
        this.name = name;
        this.salary = salary;
        this.bonuses = Bonuses;
        this.daysWorked = daysWorked;
        this.uniqueRate = 300.00;
        this.name = "SP: " + this.name;
    }

    public void addSalary(){
        this.salary += this.uniqueRate;
    }
}

class Intern extends Staff{
    //this is an example of Inheritance. Intern is inheriting all of the properties from Staff.
    private Double uniqueRate;

    public Intern() {
        this.uniqueRate = 250.00;
        this.name = "IN: " + this.name;
    }

    public Intern(String name, Double salary, Double Bonuses, Integer daysWorked){
        this.name = name;
        this.salary = salary;
        this.bonuses = Bonuses;
        this.daysWorked = daysWorked;
        this.uniqueRate = 300.00;
        this.name = "IN: " + this.name;
    }

    public void addSalary(){
        this.salary += this.uniqueRate;
    }
}