package com.Algorithms;

public class UniformCost extends BaseClass {

    public UniformCost(Problem p) {
        this.problem = p;
        open.add(problem);
//        Problem solved = search();
//        if (solved != null) {
//            printPuzzle(solved);
//        } else System.out.println("No Answer");
    }

    public Problem search() {
        while (!open.isEmpty()) {
            Problem p = open.peek();
            if(finish(p.puzzle)) return p;
            searchSubProblem(open, close);
        }
        return null;
    }

}
