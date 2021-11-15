package ru.vsu.cs.kravtsova_n_e.task7;

public class Solution {
    private Subsequence getPositionOfSubsequence(int[] arr){
        int indexOfFirstElement = 0;
        int indexOfPreviousFirstElement = 0;
        int equalElement = arr[0];
        int countOfSubseqElements = 0;
        int countOfPreviousSubseqElements = 0;
        int countOfNotEquals = 0;
        Subsequence subseq = null;
        boolean stillEqual = false;

        for (int j = 0; j < arr.length; j++) {
            for (int i = indexOfPreviousFirstElement; i < arr.length - 1; i++) {
                if ((arr[i] == arr[i + 1]) && (countOfSubseqElements == 0)) {
                    equalElement = arr[i];
                    if (i > 0) {
                        indexOfFirstElement = i - 1;
                        countOfNotEquals++;
                        countOfSubseqElements++;
                    }
                    else {
                        indexOfFirstElement = i;
                    }
                    countOfSubseqElements++;
                }
                if (equalElement == arr[i + 1]) {
                    stillEqual = true;
                    if (countOfSubseqElements == 0) {
                        countOfSubseqElements += 2;
                    }
                    else {
                        countOfSubseqElements++;
                    }
                }
                else if (countOfSubseqElements > 0) {
                //else {
                    countOfNotEquals++;
                    stillEqual = false;
                    if (countOfNotEquals > 2 && arr[i + 1] != equalElement && countOfSubseqElements >= 4) {
                    //if (countOfNotEquals > 2 && countOfSubseqElements >= 4) {
                        //subseq = new Subsequence(indexOfPreviousFirstElement, countOfPreviousSubseqElements);
                        break;
                        //return subseq;
                    }
                    countOfSubseqElements++;
                }
            }

            if (stillEqual){
                if(arr[indexOfPreviousFirstElement - 1] != equalElement && arr[indexOfPreviousFirstElement - 2] != equalElement){
                    indexOfFirstElement = indexOfPreviousFirstElement - 2;
                }
            }

            if (countOfSubseqElements > countOfPreviousSubseqElements) {
                countOfPreviousSubseqElements = countOfSubseqElements;
                indexOfPreviousFirstElement = indexOfFirstElement;
            }

            indexOfFirstElement = 0;
            countOfSubseqElements = 0;
            countOfNotEquals = 0;
            equalElement = arr[0];
            stillEqual = false;
        }
        subseq = new Subsequence(indexOfPreviousFirstElement, countOfPreviousSubseqElements);

        return subseq;
    }

    public void tests(){
        int[] arr = new int[] {4, 5, 3, 3, 7, 3, 3, 7, 6, 4, 6, 7, 7, 7, 7, 1};
        Array test1 = new Array(arr);
        test1.outputArray();
        Array subseq1 = new Array(test1.getSubsequence(getPositionOfSubsequence(test1.getArray())));
        subseq1.outputArray();
        System.out.println();

        arr = new int[] {6, 7, 7, 7, 7, 1, 4, 5, 3, 3, 7};
        Array test2 = new Array(arr);
        test2.outputArray();
        Array subseq2 = new Array(test2.getSubsequence(getPositionOfSubsequence(test2.getArray())));
        subseq2.outputArray();
        System.out.println();

        arr = new int[] {7, 6, 7, 7, 7, 7, 1, 4, 5, 3, 3, 7};
        Array test3 = new Array(arr);
        test3.outputArray();
        Array subseq3 = new Array(test3.getSubsequence(getPositionOfSubsequence(test3.getArray())));
        subseq3.outputArray();
        //костыль
        System.out.println();

        arr = new int[] {1, 2, 3, 3, 5, 7, 7, 7, 7, 7, 7, 7};
        Array test4 = new Array(arr);
        test4.outputArray();
        Array subseq4 = new Array(test4.getSubsequence(getPositionOfSubsequence(test4.getArray())));
        subseq4.outputArray();
        System.out.println();

        arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Array test5 = new Array(arr);
        test5.outputArray();
        Array subseq5 = new Array(test5.getSubsequence(getPositionOfSubsequence(test5.getArray())));
        subseq5.outputArray();
        System.out.println();
    }
}
