package secondLab;

public class LinkedList {
     Node head;
     Node tail;
     int counter;
    
     LinkedList(LinkedList clone){
        counter = clone.getCounter();
        tail = clone.getTail();
        head = clone.getHead();
    }
    LinkedList(){

    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    public int getCounter(){
        return counter;
    }
    static class Node {
        int value;
        Node next;

        Node(int d) {
            this.value = d;
            next = null;
        }
    }

    public LinkedList addToHead(LinkedList list, int value) {
        Node elt = new Node(value);
        if (list.head == null) {
            list.head = elt;
            list.tail = elt;
        }else{
            elt.next = list.head;
            list.head = elt;
        }
        list.counter++;
        return list;
    }

    public LinkedList addToTail(LinkedList list, int value) {
        Node elt = new Node(value);
        if(list.tail == null){
            list.head = elt;
            list.tail = elt;
        } else {
            tail.next = elt; 
            list.tail = elt;
        }
        list.counter++;
        return list;
    }
      
    public void printList(LinkedList list) { 
       Node elt = list.head;
       if (list.head == null) {
           System.out.println("List is empty");
       }
       while (elt != null) {
           System.out.print(elt.value + " ");
           elt = elt.next;
       }
       System.out.println();
    } 

    public void counter(LinkedList list){
        System.out.println(list.counter);
    }

    void deleteByValue(int value){
        // Store head node
        Node temp = head, prev = null;
 
        // If head node itself holds the value to be deleted
        if (temp != null && temp.value == value)
        {
            head = temp.next; // Changed head
            counter--;
            return;
        }
 
        // Search for the value to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.value != value)
        {
            prev = temp;
            temp = temp.next;
            counter--;
        }    
        
        // If value was not present in linked list
        if (temp == null) return;
 
        // Unlink the node from linked list
        prev.next = temp.next;
    
}

    public void deleteLinkedList() {
        head = null;
        counter = 0;
    }
}