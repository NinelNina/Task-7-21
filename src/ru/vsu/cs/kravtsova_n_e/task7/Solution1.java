package ru.vsu.cs.kravtsova_n_e.task7;

public class Solution1 {
    private Subsequence getPositionOfSubsequence(int[] arr){
        int positionOfFirstElement = 0;
        int equalElement = arr[0];
        int countOfElements = 0;
        //int[] countOfElements = new int[arr.length];
        int countOfNotEquals = 0;
        Subsequence subseq = null;

        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] == arr[i + 1]) && (countOfElements == 0)) {
                equalElement = arr[i];
                if (i > 0) {
                    positionOfFirstElement = i - 1;
                    countOfNotEquals++;
                    countOfElements++;
                }
                else {
                    positionOfFirstElement = i;
                }
                countOfElements++;
            }
            if (equalElement == arr[i + 1]) {
                if (countOfElements == 0) {
                    countOfElements += 2;
                }
                else{
                    countOfElements++;
                }
            }
            else if (countOfElements > 0) {
                countOfNotEquals++;
                if (countOfNotEquals > 2 && arr[i + 1] != equalElement) {
                    subseq = new Subsequence(positionOfFirstElement, countOfElements);
                    break;
                    //return subseq;
                }
                countOfElements++;
            }
        }

        return subseq;
    }

    public void tests(){
        int[] arr = new int[] {4, 5, 3, 3, 7, 3, 3, 7, 6, 4, 6, 7, 7, 7, 7, 1};
        Array test1 = new Array(arr);
        Array subseq1 = new Array(test1.getSubsequence(getPositionOfSubsequence(test1.getArray())));
        subseq1.outputArray();

        arr = new int[] {6, 7, 7, 7, 7, 1, 4, 5, 3, 3, 7};
        Array test2 = new Array(arr);
        Array subseq2 = new Array(test2.getSubsequence(getPositionOfSubsequence(test2.getArray())));
        subseq2.outputArray();

        arr = new int[] {7, 6, 7, 7, 7, 7, 1, 4, 5, 3, 3, 7};
        Array test3 = new Array(arr);
        Array subseq3 = new Array(test3.getSubsequence(getPositionOfSubsequence(test3.getArray())));
        subseq3.outputArray();
        //костыль

        arr = new int[] {1, 2, 3, 4, 5, 7, 7, 7, 7, 7, 7, 7};
        Array test4 = new Array(arr);
        Array subseq4 = new Array(test4.getSubsequence(getPositionOfSubsequence(test4.getArray())));
        subseq4.outputArray();

        arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Array test5 = new Array(arr);
        Array subseq5 = new Array(test5.getSubsequence(getPositionOfSubsequence(test5.getArray())));
        subseq5.outputArray();
    }
}
