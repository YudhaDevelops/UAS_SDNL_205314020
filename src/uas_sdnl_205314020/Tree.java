package uas_sdnl_205314020;

public class Tree {

    TreeNode root;
    TreeNode parent;
    String dataPredeccessor = "";

    public Tree() {
    }

    public Tree(TreeNode node) {
        this.root = node;
    }

    public void insert(int dataNode) {
        TreeNode newNode = new TreeNode(dataNode);
        if (root == null) {
            root = new TreeNode(dataNode);
            System.out.println("Data root = " + root.getData());
        } else {
            TreeNode ptr = root;
            while (true) {
                if (newNode.getData() <= ptr.getData()) {
                    if (ptr.getLeftNode() == null) {
                        ptr.setLeftNode(newNode);
                        newNode.setParent(ptr);
                        System.out.println("Data leftNode = " + ptr.getLeftNode().getData());
                        return;
                    } else {
                        ptr = ptr.getLeftNode();
                    }
                } else {
                    if (ptr.getRightNode() == null) {
                        ptr.setRightNode(newNode);
                        newNode.setParent(ptr);
                        System.out.println("Data rightNode = " + ptr.getRightNode().getData());
                        return;
                    } else {
                        ptr = ptr.getRightNode();
                    }
                }
            }
        }
    }

    public void preorderTraversal() {
        preOrderHelper(this.getRoot());
    }

    public void preOrderHelper(TreeNode localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getData() + ", ");
            preOrderHelper(localRoot.getLeftNode());
            preOrderHelper(localRoot.getRightNode());
        }
    }

    public void inOrderTraversal() {
        inorderHelper(this.getRoot());
    }

    public void inorderHelper(TreeNode localRoot) {
        if (localRoot != null) {
            inorderHelper(localRoot.getLeftNode());
            System.out.print(localRoot.getData() + ", ");
            inorderHelper(localRoot.getRightNode());
        }
    }

    public void postOrderTraversal() {
        postOrderHelper(this.getRoot());
    }

    public void postOrderHelper(TreeNode localRoot) {
        String dataReturn = "";
        if (localRoot != null) {
            postOrderHelper(localRoot.getLeftNode());
            postOrderHelper(localRoot.getRightNode());
            System.out.print(localRoot.getData() + ", ");
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public boolean isLeaf(TreeNode data) {
        boolean cek = false;
        TreeNode ptr = data;
        if (ptr.getLeftNode() == null && ptr.getRightNode() == null) {
            cek = true;
        }
        return cek;
    }

    public boolean delete(int data) {
        boolean cek = false;
        TreeNode node = Search_Node(data);
        if (node != null) {
            if (!isLeaf(node)
                    && (node.getLeftNode() != null && node.getRightNode() != null)) {
                cek = delete_2_anak(node);
            } else if (!isLeaf(node)
                    && (node.getLeftNode() != null || node.getRightNode() != null)) {
                cek = delete_1_anak(node);
            } else {
                cek = delete_0_anak(node);
            }
        }
        return cek;
    }

    public boolean delete_1_anak(TreeNode data) {
        TreeNode parent = data.getParent();
        TreeNode temp = data;

        if (temp != root) {
            if (parent.getLeftNode() == temp) {
                if (temp.getLeftNode() != null) { 
                    parent.setLeftNode(temp.getLeftNode());
                    temp.getLeftNode().setParent(parent);
                } else {
                    parent.setLeftNode(temp.getRightNode());
                    temp.getRightNode().setParent(parent);
                }
                temp.setParent(null);
            } else {
                if (temp.getLeftNode() != null) {
                    parent.setRightNode(temp.getLeftNode());
                    temp.getLeftNode().setParent(parent);
                } else {
                    parent.setRightNode(temp.getRightNode());
                    temp.getRightNode().setParent(parent);
                }
                temp.setParent(null);
            }
        } else {
            if (data.getRightNode() != null) {
                TreeNode n = GetSuccessor(temp);
                if (n != null) {
                    root.setData(n.getData());
                } else { //temp = root
                    if (isLeaf(temp.getRightNode())) {
                        root.setData(temp.getRightNode().getData());
                        root.setRightNode(null);
                    } else {
                        root.setData(temp.getRightNode().getData());
                        root.setRightNode(temp.getRightNode().getRightNode());
                        temp.getRightNode().setParent(root);
                    }
                }
            } else {
                TreeNode n = getPredeccessor(temp);
                if (n != null) {
                    root.setData(n.getData());
                } else { // temp = root
                    if (isLeaf(temp.getLeftNode())) {
                        root.setData(temp.getLeftNode().getData());
                        root.setLeftNode(null);
                    }else{
                        root.setData(temp.getLeftNode().getData());
                        root.setLeftNode(temp.getLeftNode().getLeftNode());
                        temp.getLeftNode().setParent(root);
                    }
                }
            }
        }
        return true;
    }

    public boolean delete_0_anak(TreeNode data) {
        TreeNode parent = data.getParent();
        if (parent.getLeftNode() == data) {
            parent.setLeftNode(null);
            data.setParent(null);
        } else {
            parent.setRightNode(null);
            data.setParent(null);
        }
        return true;
    }

    public TreeNode Search_Node(int data) {
        TreeNode pointer = root;
        while (pointer.getData() != data) {
            if (data <= pointer.getData()) {
                pointer = pointer.getLeftNode();
            } else {
                pointer = pointer.getRightNode();
            }
            if (pointer == null) {
                return null;
            }
        }
        return pointer;
    }

    public boolean delete_2_anak(TreeNode node) {
        boolean cek = false;
        TreeNode parent = node.getParent();
        TreeNode temp = node;
        if (node != root) {
            if (parent.getRightNode() == temp) {
                if (temp.getRightNode() != null) {
                    parent.setRightNode(temp.getRightNode());                   
                    temp.getRightNode().setParent(parent);                     
                    temp.getRightNode().setLeftNode(temp.getLeftNode());
                    temp.getLeftNode().setParent(temp.getRightNode());

                } else {
                    parent.setLeftNode(temp.getLeftNode());
                    temp.getLeftNode().setParent(parent);
                    temp.getLeftNode().setRightNode(temp.getRightNode());
                    temp.getRightNode().setParent(temp.getLeftNode());
                }
                temp.setParent(null);
                cek = true;
            } else if (parent.getLeftNode() == temp) {
                if (isLeaf(temp.getRightNode())) {
                    TreeNode GetSuccessor = GetSuccessor(temp);
                    temp.setData(GetSuccessor.getData());
                    temp.setRightNode(null);
                } else {
                    TreeNode GetSuccessor = GetSuccessor(temp);
                    temp.setData(GetSuccessor.getData());
                }
                cek = true;
            }
        } else {
            TreeNode getPredeccessor = getPredeccessor(temp);
            root.setData(getPredeccessor.getData());
            cek = true;
        }
        return cek;
    }

    public TreeNode GetSuccessor(TreeNode node) {
        TreeNode Current, Successor, SuccessorParent;
        Successor = node;
        SuccessorParent = node;
        Current = node.getRightNode();
        while (Current != null) {
            SuccessorParent = Successor;
            Successor = Current;
            Current = Current.getLeftNode();
        }

        if (Successor != node.getRightNode()) {
            SuccessorParent.setLeftNode(Successor.getRightNode());
            Successor.setRightNode(node.getRightNode());
        } else {
            Successor = null;
        }
        return Successor;
    }

    public TreeNode getPredeccessor(TreeNode node) {
        TreeNode Current, Predeccessor, PredeccessorParent;
        Predeccessor = node;
        PredeccessorParent = node;
        Current = node.getLeftNode();
        dataPredeccessor += Predeccessor.getData() + ",";
        while (Current != null) {
            PredeccessorParent = Predeccessor;
            Predeccessor = Current;
            dataPredeccessor += Predeccessor.getData() + ",";
            Current = Current.getRightNode();
        }
        if (Predeccessor != node.getLeftNode()) {
            PredeccessorParent.setRightNode(Predeccessor.getLeftNode());
            Predeccessor.setLeftNode(node.getLeftNode());
        } else {
            Predeccessor = null;
        }
        System.out.println("Data Predeccessor : " + Predeccessor.getData());
        return Predeccessor;
    }

    public String getDataPredeccessor() {
        return dataPredeccessor;
    }
}
