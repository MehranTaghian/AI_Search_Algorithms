package com.Algorithms;

public class AStarProblem extends Problem {
    public int Hn = 0;
    public int Gn;

    public AStarProblem(int[][] puzzle, int i_zero, int j_zero, int gn) {
        super(puzzle, i_zero, j_zero);
//        calculateHn();
        Gn = gn;
    }

    public void calculateHn(){
        Hn = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                int row = puzzle[i][j] / puzzle.length;
                int col = (puzzle[i][j] - 1) % puzzle.length;
                Hn += Math.abs(i - row);
                Hn += Math.abs(j - col);
            }
        }
    }

    public int Fn(){
        return Gn + Hn;
    }


}
