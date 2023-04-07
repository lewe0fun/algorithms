public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();

        rbt.add(4);
        rbt.add(5);
        rbt.add(2);
        System.out.println(rbt.contains(5));


    }
}