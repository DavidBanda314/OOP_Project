public class Buyer {
    private double chanceBuying;
    private String typeNeeded;

    private void setChanceBuying () {
        int randomNum = (int) (Math.random() * 3) + 1;
        switch (randomNum) {
            case 1:
                this.chanceBuying = 0.1;
                break;
            case 2:
                this.chanceBuying = 0.5;
                break;
            case 3:
                this.chanceBuying = 0.7;
                break;
        }
    }

    private void setTypeNeeded() {
        int randomNum = (int)(Math.random() * 3) + 1;
        switch (randomNum) {
            case 1:
                this.typeNeeded = "JustLooking";
                break;
            case 2:
                this.typeNeeded = "WantsOne";
                break;
            case 3:
                this.typeNeeded = "NeedsOne";
                break;
        }
    }
    public Buyer() {
            setChanceBuying();
            setTypeNeeded();
            System.out.println(this.chanceBuying);
            System.out.println(this.typeNeeded);
    }
}