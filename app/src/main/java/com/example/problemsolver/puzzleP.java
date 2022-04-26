package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.problemsolver.domains.farmer.FarmerProblem;
import com.example.problemsolver.domains.puzzle.PuzzleProblem;
import com.example.problemsolver.framework.graph.Vertex;
import com.example.problemsolver.framework.problem.Benchmark;
import com.example.problemsolver.framework.problem.State;
import com.example.problemsolver.framework.solution.AStarSolver;
import com.example.problemsolver.framework.solution.SolvingAssistant;

public class puzzleP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_p);

        PuzzleProblem problem = new PuzzleProblem();
        SolvingAssistant solvingA = new SolvingAssistant(problem); // declartations
        AStarSolver solver = new AStarSolver(problem);
        Button butts [] = {findViewById(R.id.button3),findViewById(R.id.button4), findViewById(R.id.button5),findViewById(R.id.button6)
          , findViewById(R.id.button12),  findViewById(R.id.button11),  findViewById(R.id.button10),  findViewById(R.id.button13)};

        String benchs[] ={problem.getBenchmarks().get(0).getName(), problem.getBenchmarks().get(1).getName(), problem.getBenchmarks().get(2).getName()
        ,problem.getBenchmarks().get(3).getName(), problem.getBenchmarks().get(4).getName(), problem.getBenchmarks().get(5).getName()
        ,problem.getBenchmarks().get(6).getName(),problem.getBenchmarks().get(7).getName() };
        Spinner bench =findViewById(R.id.spinner);
        ArrayAdapter<String> adapter =                                            //all for spinner of benchmarks
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        benchs);
        bench.setAdapter(adapter);

        bench.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                problem.setCurrentState(problem.getBenchmarks().get(i).getStart());
                TextView temp =(TextView)findViewById(R.id.currState);
                temp.setText(problem.getCurrentState().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });

        TextView viewEditor = (TextView) findViewById(R.id.currState);
        viewEditor.setText(problem.getInitialState().toString());         //sets intial state string
        viewEditor = (TextView) findViewById(R.id.mvcount1);
        viewEditor.setText("0");                                         //sets count string
        viewEditor = (TextView) findViewById(R.id.goalS);
        viewEditor.setText(problem.getFinalState().toString());         //sets goal string
        viewEditor = (TextView) findViewById(R.id.message);
        viewEditor.setText("");                                          // sets message
        viewEditor= (TextView) findViewById(R.id.statV1);
        viewEditor.setText("");


        for (Button but: butts) {                                      //listener for all buttons
            but.setOnClickListener(event -> {
                solvingA.tryMove((String) but.getText());
                if (!solvingA.isMoveLegal()) {                                            //if false say illegal move
                    ((TextView) findViewById(R.id.message)).setText("Illegal Move");
                } else if (solvingA.isMoveLegal()) {
                    ((TextView) findViewById(R.id.message)).setText("");                                       //if legal -> say nothing
                    ((TextView)findViewById(R.id.mvcount1)).setText(String.valueOf(solvingA.getMoveCount()));       //  update curr state and count
                    ((TextView) findViewById(R.id.currState)).setText(solvingA.getProblem().getCurrentState().toString());
                }
                if (solvingA.isProblemSolved()) {                                                      //if solved say solved
                    ((TextView) findViewById(R.id.message)).setText("Congrats, Problem Solved");
                }
            });
        }

        Button but = (Button)findViewById(R.id.resetB);                    //reset listener
        but.setOnClickListener(event -> {
            TextView viewr = (TextView) findViewById(R.id.currState);
            viewr.setText(problem.getInitialState().toString());         //sets intial state string
            viewr = (TextView) findViewById(R.id.mvcount1);
            viewr.setText("0");                                         //sets count string
            viewr = (TextView) findViewById(R.id.message);
            viewr.setText("");                                        //sets messege
            solvingA.reset();                                           //resets solving assistant
            viewr = (TextView)findViewById(R.id.statV1);
            viewr.setText("");      //resets stat
            for(Button button: butts){
                button.setEnabled(true);
            }
            findViewById(R.id.solveB).setEnabled(true);
            for(Button button: butts) {
                button.setTextColor(Color.WHITE);
            }
        });

        but = (Button)findViewById(R.id.solveB);                            //solve listener
        but.setOnClickListener(event-> {
            solver.solve();
            findViewById(R.id.solveB).setEnabled(false);
            ((TextView) findViewById(R.id.statV1)).setText(solver.getStatistics().toString());
            for(Button button: butts){
                button.setEnabled(false);
            }
        });

        but = (Button) findViewById(R.id.nextB);                             //next listener
        but.setOnClickListener(event -> {
            for(Button button: butts) {
                button.setTextColor(Color.WHITE);
            }
            Vertex nextV;
            if (solver.getSolution().hasNext()) {
                nextV = solver.getSolution().next();
                if(((State)nextV.getData()).getMove()==null) nextV = solver.getSolution().next();
                ((TextView) findViewById(R.id.currState)).setText(nextV.getData().toString());
                if (((State) nextV.getData()).getMove() != null) solvingA.cPlus();
                ((TextView) findViewById(R.id.mvcount1)).setText(String.valueOf(solvingA.getMoveCount()));
                if (((TextView) findViewById(R.id.currState)).getText().equals(((TextView) findViewById(R.id.goalS)).getText())) {
                    ((TextView) findViewById(R.id.message)).setText("Congrats, Problem Solved");
                }
                for(Button button: butts) {
                    if(((State) nextV.getData()).getMove().equals(button.getText())) button.setTextColor(Color.RED);
                }
            }
        });


    }


}