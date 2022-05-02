package uebungen.jan.übung6jan;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void printPreorder(){

        System.out.println("Ausgabe des Suchbaums in Preorder-Reihenfolge: ");
        printPreorder(root);
    }

    private void printPreorder(TreeNode node){
        System.out.println(node.value);
        if(node.getLeft() != null){
            printPreorder(node.getLeft());
        }
        if(node.getRight() != null){
            printPreorder(node.getRight());
        }

    }

    public List<Integer> getLeaves(){
        return getLeaves(root);
    }

    private List<Integer> getLeaves(TreeNode node){
        List<Integer> list = new ArrayList<>();
        if(node.getLeft() != null){
            list.addAll(getLeaves(node.getLeft()));
        }
        if(node.getRight() != null){
            list.addAll(getLeaves(node.getRight()));
        }
        if(node.getLeft() == null && node.getRight() == null){
            list.add(node.value);
        }
        return list;
    }

    public int getMaxPathSum(){
        return getMaxPathSum(root);
    }

    private int getMaxPathSum(TreeNode node){
        int sumLinks = 0;
        int sumRechts = 0;
        if(node.getLeft() != null){
            sumLinks = getMaxPathSum(node.getLeft());
            sumLinks = sumLinks + node.value;
        }
        if(node.getRight() != null){
            sumRechts = getMaxPathSum(node.getRight());
            sumRechts = sumRechts + node.value;
        }
        if(node.getLeft() == null && node.getRight() == null){
            return node.value;
        }
        if(sumLinks > sumRechts){
            return sumLinks;
        }
        return sumRechts;
    }

    public List<Integer> getElementsInLevel(int lvl){
       return getElementsInLevel(root, lvl, 0);
    }

    private List<Integer> getElementsInLevel(TreeNode node,int lvl, int currentlvl){
        List<Integer> list = new ArrayList<>();
        if(lvl == currentlvl){
            list.add(node.value);
            return list;
        }
        if(node.getLeft() != null){
            list.addAll(getElementsInLevel(node.getLeft(),lvl,currentlvl+1));
        }
        if(node.getRight() != null){
            list.addAll(getElementsInLevel(node.getRight(),lvl,currentlvl+1));
        }
        return list;
    }

    public boolean isComplete(){
        return isComplete(root);
    }

    private boolean isComplete(TreeNode node){
        if(node.getLeft() != null && node.getRight() != null){
            isComplete(node.getLeft());
            isComplete(node.getRight());
        }else{
            return false;
        }
        return true;
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
        tree.printPreorder();
        System.out.println(Arrays.toString(tree.getLeaves().toArray()));
        System.out.println(tree.getMaxPathSum());
        System.out.println("Prüfung Lvl 0" +tree.getElementsInLevel(0));
        System.out.println("Prüfung Lvl 1" +tree.getElementsInLevel(1));
        System.out.println("Prüfung Lvl 2" +tree.getElementsInLevel(2));
        System.out.println();
    }
}