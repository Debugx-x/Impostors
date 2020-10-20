package com.vaibhavs.MineSweeper.model;

public class Minesfield {

    private int no_of_mines;
    private int no_of_scans;
    private int Times_played;
    private int Rows;
    private int Col;

    private static Minesfield instance;

    // default constructor
    public Minesfield(int no_of_mines, int no_of_scans, int times_played, int rows, int col) {
        this.no_of_mines = no_of_mines;
        this.no_of_scans = no_of_scans;
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

    public int getNo_of_scans() {
        return no_of_scans;
    }

    public void setNo_of_scans(int no_of_scans) {
        this.no_of_scans = no_of_scans;
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