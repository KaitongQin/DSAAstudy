public class AVLTree{
    static class treeNode{
        treeNode father;
        treeNode leftSon;
        treeNode rightSon;
        int value;
        int height;
        public treeNode (int value) {
            this.value = value;
            this.height = 1;
        }
        public int getRightHeight () {
            if (rightSon == null) {
                return 0;
            }
            return rightSon.height;
        }
        public int getLeftHeight () {
            if (leftSon == null) {
                return 0;
            }
            return leftSon.height;
        }
        public int getBalance (treeNode node) {
            if (node == null) {
                return 0;
            }
            return node.getLeftHeight() - node.getRightHeight();
        }
        public treeNode rightRotate (treeNode root) {
            treeNode tmp = root.leftSon;
            if (root.father == null) {
                if (tmp.rightSon == null) {
                    root.leftSon = null;
                } else {
                    tmp.rightSon.father = root;
                    root.leftSon = tmp.rightSon;
                }
                root.height = Math.max(tmp.getRightHeight(), root.getRightHeight()) + 1;
                tmp.rightSon = root;
                root.father = tmp;
                tmp.father = null;
                tmp.height = Math.max(tmp.getLeftHeight(), root.height) + 1;
            } else {
                treeNode f = root.father;
                if (tmp.rightSon == null) {
                    root.leftSon = null;
                } else {
                    tmp.rightSon.father = root;
                    root.leftSon = tmp.rightSon;
                }
                root.height = Math.max(tmp.getRightHeight(), root.getRightHeight()) + 1;
                tmp.rightSon = root;
                root.father = tmp;
                tmp.father = f;
                if (f.value > tmp.value) {
                    f.leftSon = tmp;
                } else {
                    f.rightSon = tmp;
                }
                tmp.height = Math.max(tmp.getLeftHeight(), root.height) + 1;
            }
            return tmp;
        }
        public treeNode leftRotate (treeNode root) {
            treeNode tmp = root.rightSon;
            if (root.father == null) {
                if (tmp.leftSon == null) {
                    root.rightSon = null;
                } else {
                    tmp.leftSon.father = root;
                    root.rightSon = tmp.leftSon;
                }
                root.height = Math.max(tmp.getLeftHeight(), root.getLeftHeight()) + 1;
                tmp.leftSon = root;
                root.father = tmp;
                tmp.father = null;
                tmp.height = Math.max(tmp.getRightHeight(), root.height) + 1;
            } else {
                treeNode f = root.father;
                if (tmp.leftSon == null) {
                    root.rightSon = null;
                } else {
                    tmp.leftSon.father = root;
                    root.rightSon = tmp.leftSon;
                }
                root.height = Math.max(tmp.getLeftHeight(), root.getLeftHeight()) + 1;
                tmp.leftSon = root;
                root.father = tmp;
                tmp.father = f;
                if (f.value > tmp.value) {
                    f.leftSon = tmp;
                } else {
                    f.rightSon = tmp;
                }
                tmp.height = Math.max(tmp.getRightHeight(), root.height) + 1;
            }
            return tmp;
        }
        public treeNode insert (treeNode root, treeNode newNode) {
            if (root == null) {
                return newNode;
            }
            if (newNode.value > root.value) {
                if (root.rightSon == null) {
                    root.rightSon = newNode;
                    newNode.father = root;
                } else {
                    insert(root.rightSon, newNode);
                }
            } else {
                if (root.leftSon == null) {
                    root.leftSon = newNode;
                    newNode.father = root;
                } else {
                    insert(root.leftSon, newNode);
                }
            }
            root.height = Math.max(root.getRightHeight(), root.getLeftHeight()) + 1;
            int balance = root.getBalance(root);
            if (balance == -2 && newNode.value < root.rightSon.value) {
                root.rightSon = root.rightSon.rightRotate(root.rightSon);
                return root.leftRotate(root);
            } else if (balance == 2 && newNode.value > root.leftSon.value) {
                root.leftSon = root.leftSon.leftRotate(root.leftSon);
                return root.rightRotate(root);
            } else if (balance == -2) {
                return root.leftRotate(root);
            } else if (balance == 2) {
                return root.rightRotate(root);
            }
            return root;
        }
        public treeNode delete (treeNode root, int value) {
            if (root == null) {
                return root;
            }
            if (value > root.value) {
                root.rightSon = root.delete(root.rightSon, value);
            } else if (value < root.value) {
                root.leftSon = root.delete(root.leftSon, value);
            } else {
                if (root.rightSon == null && root.leftSon == null) {
                    if (root.father.value > value) {
                        root.father.leftSon = null;
                    } else {
                        root.father.rightSon = null;
                    }
                    root = null;
                } else if (root.leftSon == null) {
                    if (root.father.value > value) {
                        root.rightSon.father = root.father;
                        root.father.leftSon = root.rightSon;
                    } else {
                        root.rightSon.father = root.father;
                        root.father.rightSon = root.rightSon;
                    }
                    root = root.rightSon;
                } else if (root.rightSon == null) {
                    if (root.father.value > value) {
                        root.leftSon.father = root.father;
                        root.father.leftSon = root.leftSon;
                    } else {
                        root.leftSon.father = root.father;
                        root.father.rightSon = root.leftSon;
                    }
                    root = root.leftSon;
                } else {
                    treeNode right = root.rightSon;
                    while (right.leftSon != null) {
                        right = right.leftSon;
                    }
                    root.value = right.value;
                    delete(right, right.value);
                }
            }
            if (root != null) {
                root.height = Math.max(root.getRightHeight(), root.getLeftHeight()) + 1;
                int balance = root.getBalance(root);
                if (balance == 2 && root.leftSon.getBalance(root.leftSon) == -1) {
                    root.leftSon = root.leftSon.leftRotate(root.leftSon);
                    return root.rightRotate(root);
                } else if (balance == -2 && root.rightSon.getBalance(root.rightSon) == 1) {
                    root.rightSon = root.rightSon.rightRotate(root.rightSon);
                    return root.leftRotate(root);
                } else if (balance == 2) {
                    return root.rightRotate(root);
                } else if (balance == -2) {
                    return root.leftRotate(root);
                }
            }
            return root;
        }
    }

    public static void main(String[] args){
        treeNode root = new treeNode(1);
        root = root.insert(root, new treeNode(2));
        root = root.insert(root, new treeNode(3));
        root = root.insert(root, new treeNode(4));
        root = root.insert(root, new treeNode(5));
        root = root.insert(root, new treeNode(6));
        root = root.insert(root, new treeNode(7));
        root = root.insert(root, new treeNode(8));
        root = root.insert(root, new treeNode(9));
        root = root.delete(root, 4);
        root = root.delete(root, 1);
        System.out.println(root.value);
    }
}
