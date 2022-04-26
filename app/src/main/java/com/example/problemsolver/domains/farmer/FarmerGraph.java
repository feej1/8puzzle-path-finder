package com.example.problemsolver.domains.farmer;
import com.example.problemsolver.framework.graph.Graph;
import com.example.problemsolver.framework.graph.Vertex;
/**
 *
 * @author job
 */
public class FarmerGraph extends Graph {

    Vertex v1 = new Vertex(new FarmerState("West", "West", "West", "West"));
    Vertex v2 = new Vertex(new FarmerState("East", "West", "East", "West"));
    Vertex v3 = new Vertex(new FarmerState("West", "West", "East", "West"));
    Vertex v4 = new Vertex(new FarmerState("East", "East", "East", "West"));
    Vertex v5 = new Vertex(new FarmerState("West", "East", "West", "West"));
    Vertex v6 = new Vertex(new FarmerState("East", "East", "West", "East"));
    Vertex v7 = new Vertex(new FarmerState("West", "East", "West", "East"));
    Vertex v8 = new Vertex(new FarmerState("East", "East", "East", "East"));
    Vertex v9 = new Vertex(new FarmerState("East", "West", "East", "East"));
    Vertex v10 = new Vertex(new FarmerState("West", "West", "West", "East"));



    public FarmerGraph() {
        add(v1,v2);
        add(v2,v3);
        add(v3,v4);
        add(v3,v9);
        add(v4,v5);
        add(v9,v10);
        add(v10,v6);
        add(v5,v6);
        add(v6,v7);
        add(v7,v8);
    }

    private void add(Vertex x, Vertex y) {
        addEdge(x, y);
        addEdge(y, x);
    }

}