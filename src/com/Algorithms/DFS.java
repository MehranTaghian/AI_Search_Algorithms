package com.Algorithms;

import java.util.Stack;

public class DFS extends BaseClass {


    public Stack<Problem> open = new Stack<>();

    public DFS(Problem p) {
        this.problem = p;
        open.add(problem);
//        Problem solved = search();
//        if (solved != null) {
//            printPuzzle(solved);
//        } else System.out.println("No Answer");
    }

    public Problem search() {
        while (!open.isEmpty()) {
            Problem p = open.pop();
            close.add(p);
//            System.out.println("i'th iteration");
//            printPuzzle(p);
//            System.out.println();
            if (p.i_zero - 1 >= 0) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero - 1, p1.j_zero);
                p1.i_zero--;
                if (notInCloseOrOpenList(p1, close)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (BaseClass.finish(p1.puzzle))
                        return p1;
                    open.push(p1);
                }
            }
            if (p.i_zero + 1 < p.puzzle.length) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero + 1, p1.j_zero);
                p1.i_zero++;
                if (notInCloseOrOpenList(p1, close)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (BaseClass.finish(p1.puzzle))
                        return p1;
                    open.push(p1);
                }

            }
            if (p.j_zero - 1 >= 0) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero - 1);
                p1.j_zero--;
                if (notInCloseOrOpenList(p1, close)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (BaseClass.finish(p1.puzzle))
                        return p1;
                    open.push(p1);
                }
            }
            if (p.j_zero + 1 < p.puzzle[0].length) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero + 1);
                p1.j_zero++;
                if (notInCloseOrOpenList(p1, close)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (BaseClass.finish(p1.puzzle))
                        return p1;
                    open.push(p1);
                }
            }
        }
        return null;

    }

}
