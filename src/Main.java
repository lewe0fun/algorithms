import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Lin2List list =new Lin2List();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            list.addFirst(rnd.nextInt(100));
        }

        list.print();
        list.sort();
        list.print();
        list.revert();
        list.print();

    }

}
