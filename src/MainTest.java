import java.util.Random;

public class MainTest {


    public static void main(String[] args) {

        Tree[] tree = new Tree[20];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new TreeImpl<Integer>();

            tree[i].add(getRandomNumber());
            do {
                tree[i].add(getRandomNumber());
            } while ((tree[i].getHeight(tree[i].getRoot()) < 4));
        }

        for (Tree tr : tree) {
            tr.display();
            System.out.println("Дерево является сбалансированным: " + isBalanced(tr));
        }

        System.out.println(howManyBalanced(tree) + "% деревьев являются сбалансированными");
    }

    private static int getRandomNumber() {
        Random random = new Random();
        int n = random.nextInt(-26, 26);
        return n;
    }

    private static boolean isBalanced (Tree tree) {
        if (tree.getRoot().getRightChild() == null || tree.getRoot().getLeftChild() == null) {
            return false;
        } else if (tree.getRoot().getRightChild().getRightChild() == null &&
                tree.getRoot().getRightChild().getLeftChild() == null ||
                tree.getRoot().getLeftChild().getRightChild() == null &&
                tree.getRoot().getLeftChild().getLeftChild() == null) {
            return false;
        }
        return true;
    }

    private static double howManyBalanced(Tree[] trees) {

        int score = 100 / trees.length;
        int percent = 0;

        for (Tree tr : trees) {
            if (isBalanced(tr)) {
                percent += score;
            }
        }

        return percent;
    }
}
