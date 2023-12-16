import java.io.*;
import java.util.StringTokenizer;

public class lab7F{
    static class treeNode{
        treeNode father;
        treeNode leftSon;
        treeNode rightSon;
        int value;
        int height;
        int info;
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
        public int getInfo(treeNode node) {
            if (node == null) {
                return 0;
            }
            if (node.leftSon == null && node.rightSon == null) {
                return 1;
            } else if (node.leftSon == null) {
                return node.rightSon.info + 1;
            } else if (node.rightSon == null) {
                return node.leftSon.info + 1;
            } else {
                return node.leftSon.info + node.rightSon.info + 1;
            }
        }
        public treeNode searchByInfo(int info, treeNode node) {
            int a = node.getInfo(node.leftSon);
            if (info == a + 1) {
                return node;
            }
            if (info <= a) {
                return searchByInfo(info, node.leftSon);
            }
            return searchByInfo(info - a - 1, node.rightSon);
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
                root.info = getInfo(root);
                tmp.rightSon = root;
                root.father = tmp;
                tmp.father = null;
                tmp.height = Math.max(tmp.getLeftHeight(), root.height) + 1;
                tmp.info = getInfo(tmp);
            } else {
                treeNode f = root.father;
                if (tmp.rightSon == null) {
                    root.leftSon = null;
                } else {
                    tmp.rightSon.father = root;
                    root.leftSon = tmp.rightSon;
                }
                root.height = Math.max(tmp.getRightHeight(), root.getRightHeight()) + 1;
                root.info = getInfo(root);
                tmp.rightSon = root;
                root.father = tmp;
                tmp.father = f;
                if (f.value > tmp.value) {
                    f.leftSon = tmp;
                } else {
                    f.rightSon = tmp;
                }
                tmp.height = Math.max(tmp.getLeftHeight(), root.height) + 1;
                tmp.info = getInfo(tmp);
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
                root.info = getInfo(root);
                tmp.leftSon = root;
                root.father = tmp;
                tmp.father = null;
                tmp.height = Math.max(tmp.getRightHeight(), root.height) + 1;
                tmp.info = getInfo(tmp);
            } else {
                treeNode f = root.father;
                if (tmp.leftSon == null) {
                    root.rightSon = null;
                } else {
                    tmp.leftSon.father = root;
                    root.rightSon = tmp.leftSon;
                }
                root.height = Math.max(tmp.getLeftHeight(), root.getLeftHeight()) + 1;
                root.info = getInfo(root);
                tmp.leftSon = root;
                root.father = tmp;
                tmp.father = f;
                if (f.value >= tmp.value) {
                    f.leftSon = tmp;
                } else {
                    f.rightSon = tmp;
                }
                tmp.height = Math.max(tmp.getRightHeight(), root.height) + 1;
                tmp.info = getInfo(tmp);
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
            newNode.info = getInfo(newNode);
            root.height = Math.max(root.getRightHeight(), root.getLeftHeight()) + 1;
            root.info = getInfo(root);
            int balance = root.getBalance(root);
            if (balance == -2 && newNode.value < root.rightSon.value) {
                root.rightSon = root.rightSon.rightRotate(root.rightSon);
                return leftRotate(root);
            } else if (balance == 2 && newNode.value > root.leftSon.value) {
                root.leftSon = leftRotate(root.leftSon);
                return rightRotate(root);
            } else if (balance == -2) {
                return leftRotate(root);
            } else if (balance == 2) {
                return rightRotate(root);
            }
            return root;
        }
        public treeNode delete (treeNode root, int value) {
            if (root == null) {
                return null;
            }
            if (value > root.value) {
                root.rightSon = delete(root.rightSon, value);
            } else if (value < root.value) {
                root.leftSon = delete(root.leftSon, value);
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
                    treeNode tmp = right;
                    while (right.leftSon != null) {
                        right = right.leftSon;
                    }
                    root.value = right.value;
                    root.rightSon = delete(tmp, right.value);
                }
            }
            if (root != null) {
                root.height = Math.max(root.getRightHeight(), root.getLeftHeight()) + 1;
                root.info = getInfo(root);
                int balance = getBalance(root);
                if (balance == 2 && root.leftSon.getBalance(root.leftSon) == -1) {
                    root.leftSon = leftRotate(root.leftSon);
                    return rightRotate(root);
                } else if (balance == -2 && root.rightSon.getBalance(root.rightSon) == 1) {
                    root.rightSon = rightRotate(root.rightSon);
                    return leftRotate(root);
                } else if (balance == 2) {
                    return rightRotate(root);
                } else if (balance == -2) {
                    return leftRotate(root);
                }
            }
            return root;
        }
    }
    public static void main(String[] args){
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int type = in.nextInt();
        int pt = in.nextInt();

    }
    private static class QReader{
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer = new StringTokenizer("");

        private String innerNextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!tokenizer.hasMoreTokens()) {
                String nextLine = innerNextLine();
                if (nextLine == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(nextLine);
            }
            return true;
        }

        public String nextLine() {
            tokenizer = new StringTokenizer("");
            return innerNextLine();
        }

        public String next() {
            hasNext();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
    private static class QWriter implements Closeable{
        private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        public void print(Object object) {
            try {
                writer.write(object.toString());
            } catch (IOException e) {
                return;
            }
        }

        public void println(Object object) {
            try {
                writer.write(object.toString());
                writer.write("\n");
            } catch (IOException e) {
                return;
            }
        }

        @Override
        public void close() {
            try {
                writer.close();
            } catch (IOException e) {
                return;
            }
        }
    }
}
