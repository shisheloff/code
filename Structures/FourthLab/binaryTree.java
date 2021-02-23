package Structures.FourthLab;

public class binaryTree {
            Node root; // корневой узел
    private int counter; // счетчик узлов

    // так называемый узел дерева, в котором есть ссылка на левый и правый узел, ключ, по которому происходит сравнение при добавлении нового элемента и сами данные, которые будут храниться в узле
    public class Node{
        private Node leftNode;
        private Node rightNode;
        private Object data;
        private int key;
        private int N;

        public  Node(int key, Object val) {
            leftNode = rightNode = null;// потом проверить на наследование ссылок от родителя
            this.data = val;
            this.key = key;
            N = 1;
        }
        public void setLeftNode(Node node){
            this.leftNode = node;
        }
        public void setRightNode(Node node){
            this.rightNode = node;
        }
        public void setVal(Object val){
            this.data = val;
        }
        public Node getLeftNode(){
            return this.leftNode;
        }
        public Node getRighNode(){
            return this.rightNode;
        }
        public String toString() {
            String res = data + "";
            if (leftNode!=null) res = leftNode.toString() + "-" + res;
            if (rightNode!=null) res = rightNode.toString() + "-" + res;
            return res;
        }
        
    }

    public int size(){
        return size(root);
    }
    private int size(Node node){
        if (node == null) return 0;
        return node.N;
    }

    //конструктор
    public binaryTree() {
        root = null;
        this.counter = 0;
    }

    //копирующий конструктор
    public binaryTree(binaryTree clone){
        this.root = clone.root;
        this.counter = clone.counter;
    }

    // удаление всех элементов дерева
    public void clear(){
        root = null;
        counter = 0;
    }

    //добавление элемента
    public void insertElement(int key, Object value){
       root = insertElementTo(root, value, key);
    }
    private Node insertElementTo(Node curr, Object value, int key){
        if (curr == null) return new Node(key, value);
        if (key == curr.key){
            curr.data = value;
            return curr;
        } else if (key > curr.key){
            curr.rightNode = insertElementTo(curr.rightNode, value, key);
        } else if (key < curr.key){
            curr.leftNode = insertElementTo(curr.leftNode, value, key);
        }
        curr.N = size(curr.leftNode)+ size(curr.rightNode) + 1;
        return curr;
    }

    //поиск элемента по ключу
    public Object get(int key){
        return get(key, root);
    }
    private Object get(int key, Node cur){
        if (cur == null) return null;
        if (key > cur.key) 
            return get(key, cur.rightNode);
        else if (key < cur.key)
            return get(key, cur.leftNode);
        return cur.data;
    }
    public boolean contains(int key){
        Object val = get(key);
        return val!=null;

    }

    public String toString(){
        if (root!=null) return root.toString();
        return "empty";
    }
    // вывод бинарного дерева
    public void printBinaryTree(Node root, int level){
        if(root==null)
             return;
        printBinaryTree(root.rightNode, level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++)
                System.out.print("|\t");
                System.out.println("|-------"+root.data);
        }
        else
            System.out.println(root.data);
        printBinaryTree(root.leftNode, level+1);
    }   
    
    public int heightOfBinaryTree(Node node)
{
    if (node == null)
    {
        return 0;
    }
    else
    {
        return 1 +
        Math.max(heightOfBinaryTree(node.leftNode),
            heightOfBinaryTree(node.rightNode));
    }
}
}
