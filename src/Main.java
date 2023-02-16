import java.util.Random;
public class Main {
    public static void main(String[] args) {
        FNCD open = new FNCD();
        int count = 1;
        while(count <= 30){
        open.Opening();
        open.Washing();
        open.Repairing();
        open.Selling();
        open.Ending();
        count++;
        }
    }
}

