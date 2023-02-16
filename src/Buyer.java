public class Buyer {
    private double chanceBuying;
    private String typeNeeded;

    private void setChanceBuying () {
        int randomNum = (int) (Math.random() * 3) + 1;
        switch (randomNum) {
            case 1:
                this.chanceBuying = 10;
                break;
            case 2:
                this.chanceBuying = 50;
                break;
            case 3:
                this.chanceBuying = 70;
                break;
        }
    }

    private void setTypeNeeded() {
        int randomNum = (int)(Math.random() * 3) + 1;
        switch (randomNum) {
            case 1:
                this.typeNeeded = "Performance";
                break;
            case 2:
                this.typeNeeded = "Car";
                break;
            case 3:
                this.typeNeeded = "Pickup";
                break;
        }
    }
    public Buyer() {
            setChanceBuying();
            setTypeNeeded();
    }

    public double getChanceBuying(){
        return this.chanceBuying;
    }

    public String getTypeNeeded(){
        return this.typeNeeded;
    }
}