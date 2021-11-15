package ru.vsu.cs.kravtsova_n_e.task7;

public class Subsequence {
    private int positionOfFirstElement;
    private int countOfElements;

    Subsequence(int positionOfFirstElement, int countOfElements){
        this.positionOfFirstElement = positionOfFirstElement;
        this.countOfElements = countOfElements;
    }

    public int getPositionOfFirstElement(){
        return positionOfFirstElement;
    }

    public int getCountOfElements(){
        return countOfElements;
    }
}
