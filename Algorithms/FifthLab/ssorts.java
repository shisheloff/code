package Algorithms.FifthLab;

import Structures.ThirdLab.Myvector;

public class ssorts{

//простейшие сортировки: пузырьковая(bubbleSort), вставками(insertionSort) и выбором(selectionSort)
public static class simpleSorts <T extends Comparable<? super T>>{  
     // пузырьковая сортировка массива заданной длины любого типа данных
    public void fullBubbleSort(T[] array){
        int counter = array.length;
        while(counter > 0){
             int modindex = 0;
             for (int currIndex = 1; currIndex < counter; currIndex++){
                 if (array[currIndex - 1].compareTo(array[currIndex]) > 0){
                     T cmp = array[currIndex - 1];
                     array[currIndex - 1] = array[currIndex];
                     array[currIndex] = cmp;
                     modindex = currIndex;
                    }
             }
             counter = modindex;
        }
    }
        
    // пузырьковая сортировка любой подпоследовательности
    public void BubbleSortByIndexes(T[] array, int firstIndex, int lastIndex){
        for ( int i = firstIndex; i < array.length; i++) {
            for (int j = lastIndex + 1; j > i; j--){
                if( array[j-1].compareTo(array[j]) > 0){
                    T cmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = cmp;
                }
            }
        }
    }

    // сортировка всавткой массива заданной длины любого типа данных
    public void fullInsertionSort(T[] array){
        for (int i = 1; i < array.length; i++){
            int currIndex = i;
            while(currIndex > 0 && array[currIndex - 1].compareTo(array[currIndex]) > 0){
                T cmp = array[currIndex];
                array[currIndex] = array[currIndex - 1];
                array[currIndex - 1] = cmp;
                currIndex--;
            }
        }
    }

    //сортировка вставкой в заданном диапозоне
    public void insertionSortByIndexes(T[] array, int firstIndex, int lastIndex){
        for (; firstIndex < lastIndex + 1; firstIndex++){
            int currIndex = firstIndex;
            while(currIndex > 0 && array[currIndex - 1].compareTo(array[currIndex]) > 0){
                T cmp = array[currIndex];
                array[currIndex] = array[currIndex - 1];
                array[currIndex - 1] = cmp;
                currIndex--;
            }
        }
    }

    // сортировка выбором массива заданной длинны любого типа данных
    public void fullSelectionSort(T[] array){
        for (int currIndex = 0; currIndex < array.length - 1; currIndex++){
            int minIndex = currIndex;
            for (int i = currIndex + 1; i < array.length; i++){
                if(array[i].compareTo(array[minIndex]) < 0){
                    minIndex = i;
                }
            if(minIndex != currIndex){
                T cmp = array[currIndex];
                array[currIndex] = array[minIndex];
                array[minIndex] = cmp;
            }
            }
        }
    }

    // сортировка выбором в заданном диапозоне
    public void SelectionSortByIndexes(T[] array, int firstIndex, int lastIndex){
        for(int currIndex = firstIndex; currIndex < lastIndex + 1; currIndex++){
            int minIndex = currIndex;
            for (int i = currIndex + 1; i <= lastIndex + 1; i++) {
                if (array[i].compareTo(array[minIndex]) < 0)
                    minIndex = i;
            }
            if(minIndex != currIndex){
                T cmp = array[currIndex];
                array[currIndex] = array[minIndex];
                array[minIndex] = cmp;
            }
        }
    }

    public void print(T[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    @SuppressWarnings("unchecked")
    //choice дает выбор сортировки: 1 - по возрастанию, 2 - по убыванию
    public void selectionSortForDynamicMassive(Myvector mv, int choice){
        switch (choice) {
            case 1:
            for (int currIndex = 0; currIndex < mv.len() - 1; currIndex++){
                int minIndex = currIndex;
                Object min = mv.arr[minIndex];
                for (int i = minIndex + 1; i < mv.len(); i++){
                    if(((Comparable<? super T>) mv.arr[i]).compareTo((T) min) < 0) {
                        minIndex = i;
                        min = mv.arr[i];
                    }
                }
                if(minIndex != currIndex){
                    Object cmp = mv.arr[minIndex];
                    mv.arr[minIndex] = mv.arr[currIndex];
                    mv.arr[currIndex] = cmp;
                }
                
            }
            return;
        
            case 2:
            for (int currIndex = 0; currIndex < mv.len() - 1; currIndex++){
                int minIndex = currIndex;
                Object min = mv.arr[minIndex];
                for (int i = minIndex + 1; i < mv.len(); i++){
                    if(((Comparable<? super T>) mv.arr[i]).compareTo((T) min) > 0) {
                        minIndex = i;
                        min = mv.arr[i];
                    }
                }
                if(minIndex != currIndex){
                    Object cmp = mv.arr[minIndex];
                    mv.arr[minIndex] = mv.arr[currIndex];
                    mv.arr[currIndex] = cmp;
                }
                
            }
                
            return;
        }
    }

}
}