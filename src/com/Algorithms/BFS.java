package com.Algorithms;

public class BFS extends BaseClass {

    public BFS(Problem p) {
        this.problem = p;
        open.add(problem);
//        Problem solved = search();
//        if (solved != null) {
//            printPuzzle(solved);
//        } else System.out.println("No Answer");
    }

    public Problem search() {
        while (!open.isEmpty()) {
            Problem p = open.remove();
            close.add(p);
//            System.out.println("i'th iteration");
//            printPuzzle(p);
//            System.out.println();
//            System.out.println(p.path);
            if (p.i_zero - 1 >= 0) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero - 1, p1.j_zero);
                p1.i_zero--;
                p1.path = p.path + "D";//Move sliding to down
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }
            }
            if (p.i_zero + 1 < p.puzzle.length) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero + 1, p1.j_zero);
                p1.i_zero++;
                p1.path = p.path + "U";//Move sliding to up
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }

            }
            if (p.j_zero - 1 >= 0) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero - 1);
                p1.j_zero--;
                p1.path = p.path + "R";//Move sliding to right
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }
            }
            if (p.j_zero + 1 < p.puzzle[0].length) {
                Problem p1 = new Problem(createCopy(p.puzzle), p.i_zero, p.j_zero);
                swap(p1.puzzle, p1.i_zero, p1.j_zero, p1.i_zero, p1.j_zero + 1);
                p1.j_zero++;
                p1.path = p.path + "L";//Move sliding to left
                if (notInCloseOrOpenList(p1, close) && notInCloseOrOpenList(p1, open)) {
                    p1.parent = p;
                    p1.depth = p.depth + 1;
                    if (finish(p1.puzzle))
                        return p1;
                    open.add(p1);
                }
            }
        }
        return null;
    }


}
