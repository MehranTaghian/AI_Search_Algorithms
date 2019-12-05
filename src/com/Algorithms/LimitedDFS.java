package com.Algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class LimitedDFS extends BaseClass {

    public Stack<Problem> open = new Stack<>();

    public LimitedDFS(Problem p) {
        this.problem = p;
    }

    public Problem search(int depth) {
        if (BaseClass.finish(problem.puzzle))
            return problem;
        open.add(problem);
        close = new ArrayList<>();

        while (!open.isEmpty()) {
            Problem p = open.pop();
            close.add(p);
//            System.out.println(p.depth);
//            printPuzzle(p);
//            System.out.println("i'th iteration");
//            printPuzzle(p);
//            System.out.println();
            if (p.depth < depth) {
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
        }
        return null;

    }
}
