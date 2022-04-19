package ub.justin.ub5;

import uebung.justin.ub3.Node;

/** Ein binaerer Suchbaum mit ganzen Zahlen als Datensatz:
 * Vorlage fuer die A1 von algo-pr05.
 * Als Operationen stehen `contains' und `insert' zur Verfuegung
 */
public class BinarySearchTree {

    /**
     * Die Knotenklasse als statische innere Klasse.
     */
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
            this.right = node;
        }
    }

    /**
     * Baumwurzel
     */
    protected TreeNode root;

    /**
     * Herausfinden, ob ein gewisser Datensatz schon im binaeren Suchbaum enthalten ist.
     *
     * @param data zu suchender Datensatz
     * @return true: Datensatz ist vorhanden; false: Datensatz ist nicht vorhanden.
     */
    public boolean contains(int data) {
        TreeNode temp = root;
        while (temp != null) {
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
     * @param data einzufuegender Datensatz
     * @return true: Datensatz wurde eingefuegt; false: Datensatz war schon vorhanden.
     */
    public boolean insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return true;
        }

        TreeNode temp = root;
        while (temp.getValue() != data) {
            if (temp.getValue() > data) {
                if (temp.getLeft() == null) {
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

    public int getElementCount(){
        return this.getElementCount(root);
    }

    private int getElementCount(TreeNode node) {
       if (node == null) {
           return 0;
       }
       return this.getElementCount(node.left)+this.getElementCount(node.right)+1;
    }
    public int getSum(){
        return this.getSum(root);
    }

    private int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getSum(node.left)+getSum(node.right)+node.value;
    }

    private boolean isLeaf(TreeNode node){

        return node.left == null && node.right == null;
    }

    // function to return maximum of two numbers
    public static int getMax(int a, int b){
        return Math.max(a, b);
    }

    public int getHeight(){
        return this.getHeight(root);
    }

    //function to get the height of a tree or node
    private int getHeight(TreeNode a){
        if(a==null || this.isLeaf(a)) {
            return 0;
        }
        //height of a node will be 1+ greater among height of right subtree and height of left subtree
        return(getMax(this.getHeight(a.getLeft()), this.getHeight(a.getRight())) + 1);
    }

    public String toString(){
        return this.toString(root);
    }

    private String toString(TreeNode node) {

        if (node == null) {
            return "";
        }
        return this.toString(node.left)+","+node.value+this.toString(node.right);
    }

    public int getLeafCount(){
        return this.getLeafCount(root);
    }

    private int getLeafCount(TreeNode node) {

        if (node == null) {
            return 0;
        }
        return getLeafCount(node.getLeft())+getLeafCount(node.getRight())+(isLeaf(node) ? 1 : 0);
    }

    private boolean hasOnlyOneChild(TreeNode node){

        return (node.left == null && node.right != null) || (node.left != null && node.right == null);
    }

    public boolean hasNodesWithOneChild() {
        return this.hasNodeWithOneChild(root);
    }

    private boolean hasNodeWithOneChild(TreeNode node) {

        if (node == null) {
            return false;
        }
        if (hasOnlyOneChild(node)) {
            return true;
        }
        return hasNodeWithOneChild(node.getLeft()) || hasNodeWithOneChild(node.getRight());
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

        System.out.println(tree.getElementCount());
        System.out.println(tree.getSum());
        System.out.println(tree);
        System.out.println(tree.getHeight());
        System.out.println(tree.getLeafCount());
        System.out.println(tree.hasNodesWithOneChild());
    }
}

