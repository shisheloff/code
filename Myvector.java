package Structures.ThirdLab;

public class Myvector {
    public Object[] arr; // сам массив
    private int len; // количество элементов массива
    private int capacity; // максимальное количество элементов в массиве

    public Myvector() {
        this(0);
    }
    
    //конструктор с заданным размером массива
    public Myvector(int size){
       if (capacity < 0) throw new IllegalArgumentException("Illegal capacity " + capacity);
        this.capacity = size * 2 + 10;
        this.len = 0;
        arr = new Object[capacity];
    }
    
    //копирующий конструктор
    public Myvector(Myvector clone){
        this.len = clone.len;
        this.capacity = clone.capacity;
        this.arr =  clone.arr;
        for(int i = 0; i < this.len; i++) arr[i] = clone.arr[i];
    }
    
    //вовзращает количество элементов
    public int len(){
        return len;
    }
    
    //возвращает размер массива
    public int capacity() {
       return capacity;
   }
    
   //пустой ли массив?
    public boolean isEmpty() {
        return len() == 0;
    }
    public Object get(int i){
        return arr[i];
    }
   
    //отчистка массива
    public void clearVector(){
        for(int i = 0; i< this.len; i++) arr[i] = null;
        len = 0;
    }
    
    //увеличение массива
    public Object growUp() {
        Object[] newarr = new Object[2 * len + 10];
        for(int i = 0; i < capacity; i++) newarr[i] = arr[i];
        return newarr;
    }
    
    //добавление в конец массива
    public void addToEnd(Object data){
        if(len + 1 == capacity) growUp();
        arr[len++] = data;
        
    }

    //вставка по индексу
    public void insertByIndex(int index, Object elt) {
        if (index < 0 || index > capacity - 1) throw new IllegalArgumentException("Illegal index " + index);
        if (len == capacity) growUp();
        for(int i = len - 1; i >= index; i--) {
            arr[i + 1]=arr[i];
        }
        arr[index] = elt;
        len++;

    }
    
    //удаление по индексу
    public void delByIndex(int index) {
        if (index < 0 || index > capacity - 1) throw new IllegalArgumentException("Illegal index " + index);
        if(arr[index]!=null) arr[index] = null; len--;
    }
    
    //удаление последнего элемента массива
    public void delLastElement() {
        int index = len - 1;
        if(arr[index] != null) arr[index] = null; len--;
    }

    //вывод
    public void print() {
        if (len == 0)  System.out.println("[]");
        else {
            for (int i = 0; i < len; i++){
                 System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    public void printByIndex(int index) {
        System.out.println(arr[index]);
    }
}

