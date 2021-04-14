package com.example.problemsolver.framework.solution;
import com.example.problemsolver.framework.graph.Vertex;
import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Your name and section here
 */
public abstract class StateSpaceSolver extends Solver {

    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue
     * (DEQUE) like the GraphSolver.
     * @param problem the problem being solved
     */
    public StateSpaceSolver(Problem problem) {
        super(problem);
        super.setQueue(new LinkedList<>());
    }

    /**
     * This method implements the expand operation required by the
     * state space search algorithm.
     * @param u the vertex being expanded
     * @return the children of u in the state space search tree
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        List <String> names ;
        List <Vertex> expansion = new ArrayList<>();
        names = getProblem().getMover().getMoveNames();
        for (String moveName : names){
            if(getProblem().getMover().doMove(moveName, (State)u.getData())!=null)
                expansion.add(new Vertex(getProblem().getMover().doMove(moveName, (State)u.getData())));
        }
        return expansion;
    }
}