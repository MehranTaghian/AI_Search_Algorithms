package com.Algorithms;

public class Problem {
    public int[][] puzzle;
    public int i_zero;
    public int j_zero;
    public Problem parent = null;
    public int depth = 0;

    public String path = "";

    public Problem(){}

    public Problem(int[][] puzzle, int i_zero, int j_zero) {
        this.puzzle = puzzle;
        this.i_zero = i_zero;
        this.j_zero = j_zero;
    }
}
