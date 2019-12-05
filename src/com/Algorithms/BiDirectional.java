package com.Algorithms;

import com.Main;

import java.util.*;

public class BiDirectional extends BaseClass {


    private Queue<Problem> open1 = new LinkedList<>();
    private Queue<Problem> open2 = new LinkedList<>();


    private ArrayList<Problem> close1 = new ArrayList<>();
    private ArrayList<Problem> close2 = new ArrayList<>();

    public BiDirectional(Problem p) {
        this.problem = p;
        open1.add(problem);
        int a[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}};
        Problem solved = new Problem(a, 2, 2);
        open2.add(solved);
        Problem meetNode = search();
        if (meetNode != null) {
            showResult(meetNode);
        } else System.out.println("No Answer");
    }

    public Problem search() {
        Problem meetPoint;
        meetPoint = checkMeetPoint();
        if (meetPoint != null) return meetPoint;

        while (true) {
            searchSubProblem(open1, close1);
            meetPoint = checkMeetPoint();
            if (meetPoint != null) return meetPoint;
            searchSubProblem(open2, close2);
            meetPoint = checkMeetPoint();
            if (meetPoint != null) return meetPoint;
        }
    }

    private Problem checkMeetPoint() {
        for (Problem p1 : open1) {
            if (!notInCloseOrOpenList(p1, open2)) {
                return p1;
            }
        }
        return null;
    }

    private void showResult(Problem meetPoint) {
        //print the half of the way by showResult function written in com.Main class
        Problem result1 = getResultFromMeetPoint(meetPoint, open1);
        Main.showResult(result1);

        //And now we have to print the other half
        //open2 contains the part of problem which starts from solved-puzzle
        Problem result2 = getResultFromMeetPoint(meetPoint, open2);
        showResultReverse(result2);

        System.out.println();

        System.out.println("Number of expanded: " + close1.size() + close2.size());
        System.out.println("Number of total: " + open1.size() + open2.size() + close1.size() + close2.size());

        System.out.println("Depth: " + (result1.depth + result2.depth));

    }


    /**
     * @param mp: MeetPoint
     * @return
     */
    private Problem getResultFromMeetPoint(Problem mp, Collection<Problem> list) {
        for (Problem p: list) {
            boolean flag = false;
            for (int i = 0; i < p.puzzle.length; i++) {
                for (int j = 0; j < p.puzzle[0].length; j++) {
                    if(p.puzzle[i][j] != mp.puzzle[i][j]){
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }
            if(!flag) return p;
        }
        return null;
    }

    public static void showResultReverse(Problem result) {
        Problem p = result.parent;
        if(p != null) {
            int delta_y_zero = p.j_zero- result.j_zero;
            int delta_x_zero = p.i_zero - result.i_zero;
            if (delta_y_zero == 0) {
                if (delta_x_zero < 0)
                    System.out.print("D");
                else
                    System.out.print("U");
            } else if (delta_x_zero == 0) {
                if (delta_y_zero < 0)
                    System.out.print("R");
                else
                    System.out.print("L");
            }
            showResultReverse(p);
        }
    }

}
