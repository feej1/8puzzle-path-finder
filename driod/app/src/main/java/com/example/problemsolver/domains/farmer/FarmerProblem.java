package com.example.problemsolver.domains.farmer;
import com.example.problemsolver.framework.problem.Problem;

/**
 *
 * @author jobo9
 */
public class FarmerProblem extends Problem{
    public FarmerProblem (){
        super();
        super.setName("Welcome to the Farmer, Wolf, Goat, and Cabbage, Problem");
        super.setIntroduction(INTRO);
        super.setMover(new FarmerMover());
        super.setInitialState(new FarmerState("West", "West","West","West"));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new  FarmerState("East", "East", "East", "East"));
    }

    private static final String INTRO =

            "A farmer and his wolf, goat, and cabbage come to the edge of a\n"
                    + "river they wish to cross. There is a boat at the river's edge\n"
                    + "that only the farmer can row. The farmer can take at most one\n"
                    + "other object besides himself on a crossing, but if the wolf is\n"
                    + "ever left with the goat, the wolf will eat the goat; similarly,\n"
                    + "if the goat is left with the cabbage, the goat will eat the\n"
                    + "cabbage. Devise a sequence of crossings of the river so that all\n"
                    + "four characters arrive safely on the other side." ;



}
