package com.Algorithms;

import java.util.ArrayList;
import java.util.Collection;

public class AStar extends BaseClass {
    public ArrayList<AStarProblem> open = new ArrayList<>();
    public ArrayList<AStarProblem> close = new ArrayList<>();

    private AStarProblem problem;

    public AStar(AStarProblem p) {
        this.problem = p;
        open.add(p);
//        AStarProblem solved = search();
//        if (solved != null) {
//            printPuzzle(solved);
//        } else System.out.println("No Answer");
    }

    public AStarProblem search() {
        while (true) {
            AStarProblem p = findNext();
            close.add(p);
//            System.out.println("i'th iteration");
//            printPuzzle(p);
//            System.out.println();
            if (p.i_zero - 1 >= 0) {
                AStarProblem p1 = new AStarProblem(createCopy(p.puzzle), p.i_zero, p.j_zero, p.Gn + 1);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero - 1, p1.j_zero);
                p1.i_zero--;
                p1.calculateHn();
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }
            }
            if (p.i_zero + 1 < p.puzzle.length) {
                AStarProblem p1 = new AStarProblem(createCopy(p.puzzle), p.i_zero, p.j_zero, p.Gn + 1);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero + 1, p1.j_zero);
                p1.i_zero++;
                p1.calculateHn();
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }

            }
            if (p.j_zero - 1 >= 0) {
                AStarProblem p1 = new AStarProblem(createCopy(p.puzzle), p.i_zero, p.j_zero, p.Gn + 1);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero - 1);
                p1.j_zero--;
                p1.calculateHn();
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }
            }
            if (p.j_zero + 1 < p.puzzle[0].length) {
                AStarProblem p1 = new AStarProblem(createCopy(p.puzzle), p.i_zero, p.j_zero, p.Gn + 1);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero + 1);
                p1.j_zero++;
                p1.calculateHn();
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }
            }
        }
    }

    private boolean notInCloseOrOpenList(AStarProblem p1, Collection<AStarProblem> list) {
        for (AStarProblem p : list) {
            boolean flag = false;
            for (int i = 0; i < p.puzzle.length; i++) {
                for (int j = 0; j < p.puzzle[0].length; j++) {
                    if (p.puzzle[i][j] != p1.puzzle[i][j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
                else if (i == p.puzzle.length - 1) return false;
            }
        }
        return true;
    }


    private AStarProblem findNext() {
        AStarProblem p = open.get(0);
        for (AStarProblem p1 : open) {
            if (p.Fn() > p1.Fn())
                p = p1;
        }
        open.remove(p);
        return p;
    }
}
