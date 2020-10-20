package com.vaibhavs.MineSweeper.model;

public class Minesfield {

    // setting default minimum values for the minefield
    private int no_of_mines = 6;
    private int Times_played = 0;
    private int Rows = 4;
    private int Col = 6;

    private static Minesfield instance;

    // default constructor
    public Minesfield(int no_of_mines, int no_of_scans, int times_played, int rows, int col) {
        this.no_of_mines = no_of_mines;
        this.Times_played = times_played;
        this.Rows = rows;
        this.Col = col;
    }

    //getters and setters
    public int getNo_of_mines() {
        return no_of_mines;
    }

    public void setNo_of_mines(int no_of_mines) {
        this.no_of_mines = no_of_mines;
    }

    public int getTimes_played() {
        return Times_played;
    }

    public void setTimes_played(int times_played) {
        Times_played = times_played;
    }

    public int getRows() {
        return Rows;
    }

    public void setRows(int rows) {
        Rows = rows;
    }

    public int getCol() {
        return Col;
    }

    public void setCol(int col) {
        Col = col;
    }

    //Singleton pattern
    private Minesfield(){

    }
    public static Minesfield getInstance(){
        if (instance == null){
            instance = new Minesfield();
        }
        return instance;
    }
}