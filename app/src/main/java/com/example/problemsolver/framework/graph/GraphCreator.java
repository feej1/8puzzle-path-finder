package com.example.problemsolver.framework.graph;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import java.util.List;
import java.util.Stack;

/**
 * Joseph Fee
 */
public class GraphCreator {


    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        stack1 = new Stack() ;
        start = new Vertex(problem.getInitialState());
        stack1.push(start);
        names = problem.getMover().getMoveNames();
        while (!stack1.empty()) {

            u = stack1.pop() ;
            for (String move : names ){
                next = problem.getMover().doMove(move,(State)u.getData() );
                if (next != null){
                    v = new Vertex(next);
                    if (graph.getVerticies().containsKey(v))  {
                        v= graph.getVerticies().get(v);
                    }
                    else stack1.push(v);
                    graph.addEdge(u, v);
                }
            }
        }
        return graph;
    }

    private Graph graph = null;
    private Stack<Vertex> stack1 ;
    private Vertex start ;
    private State next ;
    private List<String> names ;
    private Vertex u ;
    private Vertex v ;
}