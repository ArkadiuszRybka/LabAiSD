package czescA;

import java.util.ArrayList;

public class BSTree {
    private TreeNode root;

    public BSTree(){
        root=null;
    }
    public TreeNode getRoot() {return root;}

    public void insert(int elem){
        TreeNode newNode = new TreeNode();
        newNode.iData=elem;

        if(root==null) root = newNode;
        else {
            TreeNode current=root;
            while(true){
                TreeNode parent= current;
                if(elem<current.iData){
                    current=current.left;
                    if(current==null){
                        parent.left=newNode;
                        newNode.parent=parent;
                        return;
                    }
                }
                else{
                    current=current.right;
                    if(current==null){
                        parent.right=newNode;
                        newNode.parent=parent;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(int elem){
        if(root==null) return false;

        TreeNode current= root;
        while(current.iData!=elem){
            if(elem<current.iData) current=current.left;
            else current=current.right;
            if(current==null) return false;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node){
        TreeNode current=node.right;
        while(current.left!=null)
        {
            current=current.left;
        }
        return current;
    }

    private void deleteWithoutChilds(TreeNode current){
        if(current==root) root = null;
        else{
            if(current.parent.left == current) current.parent.left=null;
            else current.parent.right=null;
        }
        current.parent=null;
    }

    private void deleteWithOneLeftChild(TreeNode current){
        if(current==root) root=current.left;
        else {
            if(current.parent.left==current) current.parent.left=current.left;
            else current.parent.right = current.left;
            current.left.parent=current.parent;
        }
    }

    private void deleteWithOneRightChild(TreeNode current){
        if(current==root) root = current.right;
        else{
            if(current.parent.left==current) current.parent.left=current.right;
            else current.parent.right=current.right;
            current.right.parent=current.parent;
        }
    }

    public boolean delete(int elem) // usunięcie węzła o podanej wartości elementu
    {
        if (root == null) return false;
        TreeNode current = root;
        while (current.iData != elem)
        {
            if (elem < current.iData) current = current.left;
            else current = current.right;
            if (current == null)
                return false;
        }
        // znaleziono węzeł do usunięcia


        if (current.left == null && current.right == null)
        {
            deleteWithoutChilds(current);
        }
        else
        if (current.right == null)
        {
            deleteWithOneLeftChild(current);
        }
        else
        if (current.left == null)
        {
            deleteWithOneRightChild(current);
        }
        else
        {
            //deleteWithTwoChilds(current);
        }
        return true;
    }

    public void view(TreeNode node,int level) //wizualizacja tekstowa drzewa
    {
        if (node==null) return;
        for (int i=0; i<level; i++) System.out.print("- ");
        System.out.println(node.iData);
        view(node.left,level+1);
        view(node.right,level+1);
    }

    private void copyBSTreeToArrayList(TreeNode node, ArrayList<TreeNode> nodeList)
    {
        if (node.left!=null) copyBSTreeToArrayList(node.left,nodeList);
        nodeList.add(node);
        if (node.right!=null) copyBSTreeToArrayList(node.right,nodeList);
    }
    public void print(){
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        if(root!=null){
            copyBSTreeToArrayList(root,nodeList);
        }
        System.out.println("BST: ");
        int i=0;
        while(nodeList.size()>i){
            System.out.println(nodeList.get(i)+ " ");
            i++;
        }
        System.out.println();
    }



    public static void main(String[] args) //test drzewa BST
    {
        BSTree tree = new BSTree();

        //Wstawianie elementow
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(43);
        tree.insert(30);
        tree.insert(33);
        tree.insert(87);
        tree.insert(63);
        tree.insert(97);

        tree.view(tree.getRoot(),0);

        boolean result1 = tree.find(33);
        System.out.println("Wynik wyszukania 33:"+result1);

        boolean result2 = tree.find(40);
        System.out.println("Wynik wyszukania 40:"+result2);

        System.out.println("\n\t<< del(37) >>");
        tree.delete(37);
        tree.view(tree.getRoot(),0);
        System.out.println("\n");

        System.out.println("\n\t<< del(43) >>");
        tree.delete(43);
        tree.view(tree.getRoot(),0);
        System.out.println("\n");

        System.out.println("\n\t<< del(25) >>");
        tree.delete(25);
        tree.view(tree.getRoot(),0);
        System.out.println("\n");

        //tree.print();
    }

}
