package com.example.problemsolver.domains.puzzle;
import com.example.problemsolver.domains.puzzle.PuzzleState;
import com.example.problemsolver.domains.puzzle.PuzzleState.Location;
import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.State;

public class PuzzleMover extends Mover {

    public  String slide1 = "Slide 1";
    public String slide2 = "Slide 2";
    public String slide3 = "Slide 3";
    public String slide4 = "Slide 4";
    public String slide5 = "Slide 5";
    public String slide6 = "Slide 6";
    public  String slide7 = "Slide 7";
    public  String slide8 = "Slide 8";

    public PuzzleMover() {
        super.addMove(slide1, s -> try1(s));
        super.addMove(slide2, s -> try2(s));
        super.addMove(slide3, s -> try3(s));
        super.addMove(slide4, s -> try4(s));
        super.addMove(slide5, s -> try5(s));
        super.addMove(slide6, s -> try6(s));
        super.addMove(slide7, s -> try7(s));
        super.addMove(slide8, s -> try8(s));
    }

    private State try1 (State state) {

        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(1);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            State stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide1);
            return stateNew ;
        }

        return null;
    }

    private State try2 (State state) {
        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(2);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            PuzzleState stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide2);
            return stateNew ;
        }
        return null;
    }

    private State try3 (State state) {
        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(3);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            PuzzleState stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide3);
            return stateNew ;
        }
        return null;
    }

    private State try4 (State state) {
        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(4);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            PuzzleState stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide4);
            return stateNew ;
        }
        return null;
    }

    private State try5 (State state) {
        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(5);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            PuzzleState stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide5);
            return stateNew ;
        }
        return null;
    }

    private State try6 (State state) {
        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(6);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            PuzzleState stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide6);
            return stateNew ;
        }
        return null;
    }

    private State try7 (State state) {
        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(7);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            PuzzleState stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide7);
            return stateNew ;
        }
        return null;
    }

    private State try8 (State state) {
        int x1, x2;
        int y1,y2 ;
        Location temp;
        Location temp1 ;
        temp =((PuzzleState)state).getLocation(8);
        temp1 = ((PuzzleState)state).getLocation(0);
        x1 = temp.getRow();
        x2 = temp1.getRow() ;
        y1 = temp.getColumn() ;
        y2 = temp1.getColumn() ;
        if (  (x1==x2 && (y2-y1 == 1 || y2-y1== -1)) ||
                (y1==y2 &&(x1-x2 == 1 || x1-x2 == -1))){
            PuzzleState stateNew = new PuzzleState( (PuzzleState)state, temp, temp1);
            stateNew.setMove(slide8);
            return stateNew ;
        }
        return null;
    }

}
