package Algorithms.SixthLab;
import java.util.Arrays;

public class effectiveSort <T extends Comparable<? super T>>{
    
    // быстрая сортировка 
    public void Quicksort(T[] array, int firstIndex, int lastIndex){
        if (firstIndex < lastIndex){
            int midIndex = part(array, firstIndex, lastIndex);
            Quicksort(array, firstIndex, midIndex);
            Quicksort(array, midIndex + 1, lastIndex);
        }
    }
    private int part(T[] array, int firstIndex, int lastIndex){
        int midIndex = (firstIndex + lastIndex) / 2;
        T midValue = array[midIndex];
        firstIndex++;
        lastIndex--;
        while(true){
            do firstIndex++; while (array[firstIndex].compareTo(midValue) < 0);
            do lastIndex--; while (array[lastIndex].compareTo(midValue) > 0);
            if (firstIndex >= lastIndex) return lastIndex;
            T cmp = array[firstIndex];
            array[firstIndex] = array[lastIndex];
            array[lastIndex] = cmp;
        }
    }

    // сортировка слиянием 
    public void Mergesort(T[] array, int firstIndex, int lastIndex){
        if (firstIndex < lastIndex){
            int midIndex = (firstIndex + lastIndex) / 2;
            Mergesort(array, firstIndex, midIndex);
            Mergesort(array, midIndex + 1, lastIndex);
            merge(array, firstIndex, midIndex, lastIndex);
        }
    }
    @SuppressWarnings("unchecked")
    private void merge(T[] array, int firstIndex, int midIndex, int lastIndex){
        T[] leftarray = (T[]) new Comparable[midIndex - firstIndex + 1];
        T[] rightarray = (T[]) new Comparable[lastIndex - midIndex];
        for (int i = 0; i < leftarray.length; ++i)
            leftarray[i] = array[firstIndex + i];
        for (int i = 0; i < rightarray.length; ++i)
            rightarray[i] = array[midIndex + 1 + i];
        int leftIndex = 0; int rightIndex = 0;
        int currentIndex = firstIndex;
        while (leftIndex < leftarray.length && rightIndex < rightarray.length){
            if(leftarray[leftIndex].compareTo(rightarray[rightIndex]) <= 0){
                array[currentIndex] = leftarray[leftIndex];
                leftIndex++;
            } else {
                array[currentIndex] = rightarray[rightIndex];
                rightIndex++;
            }
            currentIndex++;
        }
        while (leftIndex < leftarray.length) array[currentIndex++] = leftarray[leftIndex++];
        while (rightIndex < rightarray.length) array[currentIndex++] = rightarray[rightIndex++];


    }

    // пирамидальная сортировка
    public void HeapSort(T[] array){
        int size = array.length;
        for (int i = size/2 - 1; i >= 0; i--){
            heapify(array, size, i);
        }
        for (int i = size - 1; i >= 0; i--){
            T cmp = array[0];
            array[0] = array[i];
            array[i] = cmp;
            heapify(array, i, 0);
        }
    }
    // пирамидальная сортировка по индексам
    public void HeapSortByIndex(T[] array, int firstIndex, int lastIndex){
        T[] subarray = Arrays.copyOfRange(array, firstIndex, lastIndex + 1);
        HeapSort(subarray);
        for(int i = firstIndex; i <= lastIndex; i++){
            array[i] = subarray[i - firstIndex];
        }
    }
    
    private void heapify(T[] array, int size, int i){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < size && array[left].compareTo(array[max]) > 0)
            max = left;
        
        if (right < size && array[right].compareTo(array[max]) > 0)
            max = right;

        if (max != i){
            T cmp = array[i];
            array[i] = array[max];
            array[max] = cmp;
            heapify(array, size, max);
        }
    }
    // вывод массива
    public void print(T[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    // задание для защиты лабораторной
    public void task(T[] array) {
        int n = array.length;
        if (n % 2 == 0){
            for( int i = 0; i < n;i+=2){
                T cmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = cmp;
            }
        } else {
            for( int i = 0; i < n - 1;i+=2){
                T cmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = cmp;
            }
        }
    }

}
