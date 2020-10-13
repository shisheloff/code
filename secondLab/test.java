package secondLab;

public class test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addToHead(list, 5);
        list.addToTail(list, 3);
        list.addToTail(list, 7);
        list.addToHead(list, 10);
        list.addToHead(list, 2);
        list.printList(list);
        LinkedList clone = new LinkedList(list);
        clone.printList(clone);
        list.deleteByValue(2);
        list.printList(list);
        list.deleteByValue(10);
        clone.printList(clone);
        list.deleteByValue(5); 
        list.printList(list);
        clone.printList(clone);
        list.counter(list);
        clone.counter(clone);
        clone.printList(clone);
       list.deleteLinkedList();
       list.printList(list);

    }
}
