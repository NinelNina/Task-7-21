package ru.vsu.cs.kravtsova_n_e.task7;

import java.util.ArrayList;
import java.util.Scanner;

public class Array {
    private int[] arr;
    private int n;

    Array(int n){
        this.n = n;
        this.arr = new int[n];
    }

    Array(int[] sourceArray){
        this.arr = sourceArray;
        if (sourceArray == null){
            this.n = 0;
        }
        else{
            this.n = sourceArray.length;
        }
    }

    public void inputArray(Scanner input){
        for (int i = 0; i < n; i++){
            System.out.println("Введите [" + i + "] элемент массива:");
            arr[i] = input.nextInt();
        }
    }

    public void outputArray(){
        if (arr != null) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }
        else{
            System.out.println("Последовательность не существует.");
        }
    }

    public int[] getArray(){
        return arr;
    }

    public void setArray(int[] sourceArray){
        arr = new int[sourceArray.length];
        arr = sourceArray;
    }

    public int[] getSubsequence(Subsequence subsequence){

        if (subsequence != null) {
            int[] subArray = new int[subsequence.getCountOfElements()];
            int m = subsequence.getCountOfElements() + subsequence.getPositionOfFirstElement();

            for (int i = subsequence.getPositionOfFirstElement(), j = 0; i < m && j < subsequence.getCountOfElements(); i++, j++) {
                subArray[j] = arr[i];
            }
            return subArray;
        }
        else {
            return null;
        }
    }
}
