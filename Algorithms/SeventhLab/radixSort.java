package Algorithms.SeventhLab;

import java.util.Arrays;

public class radixSort {
    public static void LSDsort(Integer[] array) {
        radixSort.LSDsort(array, 10);
    }
    // LSD сортировка 
    public static void LSDsort(Integer[] array, int radix) {
        if (array.length == 0) {
            return;
        }

        // определяем максимальный и минимальный элементы
        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        int exponent = 1;
        while ((maxValue - minValue) / exponent >= 1) {
            radixSort.countingSortByDigit(array, radix, exponent, minValue);
            exponent *= radix;
        }
    }
    private static void countingSortByDigit(Integer[] array, int radix, int exponent, int minValue) {
        int bucketIndex;
        int[] buckets = new int[radix];
        int[] output = new int[array.length];

        for (int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            bucketIndex = (int)(((array[i] - minValue) / exponent) % radix);
            buckets[bucketIndex]++;
        }

        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            bucketIndex = (int)(((array[i] - minValue) / exponent) % radix);
            output[--buckets[bucketIndex]] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
    // нахождение максимального элемента
    public static int getMax(int[] arr, int n){ 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    }   

    // сортировка подсчетом
    public static void countSort(int[] arr, int n, int exp) { 
        int[] output = new int[n];  
        int i; 
        int[] count = new int[10]; 
        Arrays.fill(count, 0); 
   
        for (i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 

        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
   
        for (i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
  
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
    static void radixsort(int[] arr, int n) { 
        int m = getMax(arr, n); 

        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
  
    // вывод массива 
    void print(int[] arr, int n) { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 

    public static void BucketSort(int[] Database, int maxVal) {

        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < Database.length; i++) {
            bucket[Database[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                Database[outPos++] = i;
            }
        }
    }
}