package com;

import com.Algorithms.*;

import java.util.Stack;

public class Main {

    static Stack<String> answer = new Stack<>();

//    public static int[][] a = { {6, 1, 3},
//                                {0, 4, 8},
//                                {5, 7, 2}};


    public static int[][] a = { {5, 4, 2},
                                {1, 8, 3},
                                {7, 0, 6}};

//    public static int[][] a = { {1, 2, 3},
//                                {4, 5, 0},
//                                {7, 8, 6}};


    public static void main(String[] args) {

        int i_zero = 0, j_zero = 0;
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    i_zero = i;
                    j_zero = j;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

//        Problem p = new Problem(a, i_zero, j_zero);
        AStarProblem p = new AStarProblem(a, i_zero, j_zero, 0);
        p.calculateHn();

//        BFS algo = new BFS(p);
//        DFS algo = new DFS(p);
//        LimitedDFS algo = new LimitedDFS(p);
//        IterativeDeapeningDFS algo = new IterativeDeapeningDFS(p);
//        AStar algo = new AStar(p);
        BiDirectional biDirectional = new BiDirectional(p);
        biDirectional.search();  //BiDirectional search doesn't
                                    // need to call showResult, it will show by itself

//        UniformCost algo = new UniformCost(p);

//        Problem result = algo.search();
//        //number of nodes for other algos
//        System.out.println("Number of expanded: " + algo.close.size());
//        System.out.println("Number of total: " + algo.open.size() + algo.close.size());

        //number of nodes for Iterative Deapening:
//        System.out.println("Number of expanded: " + algo.numberOfClosed);
//        System.out.println("Number of total: " + algo.numberOfTotal);

//        if(result != null) {
//            System.out.println("Depth: " + result.depth);
//            System.out.println(result.path);
//            showResult(result); //This line is for others
//        } else {
//            System.out.println("No Answer");
//        }

    }

    public static void showResult(Problem result) {
        while(result.parent != null) {
            Problem p = result.parent;
            int delta_y_zero = result.j_zero - p.j_zero;
            int delta_x_zero = result.i_zero - p.i_zero;
            if (delta_y_zero == 0) {
                if (delta_x_zero < 0)
                    answer.push("D");
                else
                    answer.push("U");
            } else if (delta_x_zero == 0) {
                if (delta_y_zero < 0)
                    answer.push("R");
                else
                    answer.push("L");
            }
            result = result.parent;
        }
        while(!answer.empty())
            System.out.print(answer.pop());

    }
}

//DDRULDLUU
//DDRULDLUU
//DLLUURDLDRURULLDRRULL
//DLLUURDLDRURULLDRRULL

//        0,1,3,
//        6,4,8,
//        5,7,2,