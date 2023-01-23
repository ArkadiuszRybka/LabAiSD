package czescA;

public class TreeNode {
    public int iData;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        iData=0;
        parent=null;
        left=null;
        right=null;
    }
    public String toString(){return "{"+iData+"}";}
}
