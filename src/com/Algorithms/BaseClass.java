package com.Algorithms;

import java.util.*;

public class BaseClass {
    protected Problem problem;
    public Queue<Problem> open = new LinkedList<>();
    public ArrayList<Problem> close = new ArrayList<>();


    public static boolean finish(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == a.length - 1 && j == a.length - 1) {
                    if (a[i][j] != 0) return false;
                } else if (a[i][j] != i * 3 + j + 1) return false;

            }
        }
        return true;
    }

    protected void printPuzzle(Problem p) {
        for (int i = 0; i < p.puzzle.length; i++) {
            for (int j = 0; j < p.puzzle[0].length; j++) {
                System.out.print(p.puzzle[i][j]);
                System.out.print(',');
            }
            System.out.println();
        }
    }

    protected void searchSubProblem(Queue<Problem> open, ArrayList<Problem> close) {
        Problem p = open.remove();
        close.add(p);
        if (p.i_zero - 1 >= 0) {
            Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
            swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero - 1, p1.j_zero);
            p1.i_zero--;
            if (notInCloseOrOpenList(p1, close)) {
                p1.parent = p;
                p1.depth = p.depth + 1;
                open.add(p1);
            }
        }
        if (p.i_zero + 1 < p.puzzle.length) {
            Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
            swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero + 1, p1.j_zero);
            p1.i_zero++;
            if (notInCloseOrOpenList(p1, close)) {
                p1.parent = p;
                p1.depth = p.depth + 1;
                open.add(p1);
            }

        }
        if (p.j_zero - 1 >= 0) {
            Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
            swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero - 1);
            p1.j_zero--;
            if (notInCloseOrOpenList(p1, close)) {
                p1.parent = p;
                p1.depth = p.depth + 1;
                open.add(p1);
            }
        }
        if (p.j_zero + 1 < p.puzzle[0].length) {
            Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
            swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero + 1);
            p1.j_zero++;
            if (notInCloseOrOpenList(p1, close)) {
                p1.parent = p;
                p1.depth = p.depth + 1;
                open.add(p1);
            }
        }
    }

    protected boolean notInCloseOrOpenList(Problem p1, Collection<Problem> list) {
        for (Problem p: list) {
            boolean flag = false;
            for (int i = 0; i < p.puzzle.length; i++) {
                for (int j = 0; j < p.puzzle[0].length; j++) {
                    if(p.puzzle[i][j] != p1.puzzle[i][j]){
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
                else if(i == p.puzzle.length - 1) return false;
            }
        }
        return true;
    }

    protected void swap(int[][] p, int i0, int j0, int i1, int j1){
        int temp = p[i0][j0];
        p[i0][j0] = p[i1][j1];
        p[i1][j1] = temp;
    }

    protected int[][] createCopy(int[][] puzzle){
        int[][] a = new int[puzzle.length][puzzle[0].length];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                a[i][j] = puzzle[i][j];
            }
        }
        return a;
    }
}
