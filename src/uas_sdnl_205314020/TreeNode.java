package uas_sdnl_205314020;

public class TreeNode {
    private int data;
    TreeNode leftNode;
    TreeNode rightNode;
    TreeNode parent;

    
    public TreeNode(int charData){
        this.data = charData;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    
    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode(){
        return rightNode;
    }

    public void setLeftNode(TreeNode node){
        this.leftNode = node;
    }

    public void setRightNode(TreeNode node){
        this.rightNode = node;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    
}
