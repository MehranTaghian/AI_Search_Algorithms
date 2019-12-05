package com.Algorithms;

public class IterativeDeapeningDFS extends BaseClass {

    public int numberOfClosed = 0;
    public int numberOfTotal = 0;

    public IterativeDeapeningDFS(Problem p) {
        this.problem = p;
        open.add(problem);
    }

    public Problem search(int limit){
        int depth = 1;
        LimitedDFS d = new LimitedDFS(problem);
        Problem result = d.search(depth);
        numberOfClosed += d.close.size();
        numberOfTotal += d.open.size() + d.close.size();
        while(result == null){
            depth++;
            if(depth == limit)
                return null;
            result = d.search(depth);
            numberOfClosed += d.close.size();
            numberOfTotal += d.open.size() + d.close.size();
        }

        return result;

    }
}
