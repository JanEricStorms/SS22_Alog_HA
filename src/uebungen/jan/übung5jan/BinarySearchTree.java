package uebungen.jan.übung5jan;

import java.util.Date;

/** Ein binaerer Suchbaum mit ganzen Zahlen als Datensatz:
 * Vorlage fuer die A1 von algo-pr05.
 * Als Operationen stehen `contains' und `insert' zur Verfuegung
 */
public class BinarySearchTree {

    /** Die Knotenklasse als statische innere Klasse. */
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public String toString() {
            return this.value + " ";
        }

        public int getValue() {
            return this.value;
        }

        public TreeNode getLeft() {
            return this.left;
        }

        public TreeNode getRight() {
            return this.right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(TreeNode node) {
            this.left = node;
        }

        public void setRight(TreeNode node) {
            this.right= node;
        }
    }

    /** Baumwurzel */
    protected TreeNode root;

    /**
     * Herausfinden, ob ein gewisser Datensatz schon im binaeren Suchbaum enthalten ist.
     *
     * @param   data  zu suchender Datensatz
     * @return        true: Datensatz ist vorhanden; false: Datensatz ist nicht vorhanden.
     */
    public boolean contains(int data) {
        TreeNode temp = root;
        while(temp != null) {
            if (temp.getValue() == data) {
                return true;
            }
            if (temp.getValue() > data) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return false;
    }

    /**
     * Einen neuen Datensatz in den binaeren Suchbaum einfuegen.
     *
     * @param   data  einzufuegender Datensatz
     * @return        true: Datensatz wurde eingefuegt; false: Datensatz war schon vorhanden.
     */
    public boolean insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return true;
        }

        TreeNode temp = root;
        while(temp.getValue() != data) {
            if (temp.getValue() > data) {
                if(temp.getLeft() == null) {
                    temp.setLeft(new TreeNode(data));
                    return true;
                }
                temp = temp.getLeft();
            } else {
                if (temp.getRight() == null) {
                    temp.setRight(new TreeNode(data));
                    return true;
                }
                temp = temp.getRight();
            }
        }
        return false;
    }

    public String toString(){
        return toStringHelper(this.root);
    }

    private String toStringHelper(TreeNode node){
        StringBuilder sb = new StringBuilder();
        if(node.left != null) {
            System.out.println("Go Left");
            sb.append(toStringHelper(node.left) + ";");
        }
        if(node.right != null) {
            System.out.println("Go Right");
            sb.append(toStringHelper(node.right) + ";");
        }
        System.out.println("Returns :" + node.toString());
        sb.append(node);
        return sb.toString();
    }

    public DuDummerHurensohnMissingReturnStatments getSum(){
        return calcSum(this.root);
    }

    private DuDummerHurensohnMissingReturnStatments calcSum(TreeNode node){
        return new DuDummerHurensohnMissingReturnStatments();
    }

    private class DuDummerHurensohnMissingReturnStatments{

    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 50);
            System.out.println(x);
            tree.insert(x);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(i + ": " + tree.contains(i));
        }
        System.out.println("Platzhalter");
        System.out.println(tree);
        System.out.println(tree.getSum());
    }
}
