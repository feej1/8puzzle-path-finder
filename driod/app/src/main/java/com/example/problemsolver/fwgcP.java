package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.problemsolver.domains.farmer.FarmerProblem;
import com.example.problemsolver.framework.graph.Vertex;
import com.example.problemsolver.framework.problem.Problem;
import com.example.problemsolver.framework.problem.State;
import com.example.problemsolver.framework.solution.AStarSolver;
import com.example.problemsolver.framework.solution.Solution;
import com.example.problemsolver.framework.solution.SolvingAssistant;

import org.w3c.dom.Text;

public class fwgcP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc_p);
        FarmerProblem problem = new FarmerProblem();
        SolvingAssistant solvingA = new SolvingAssistant(problem); // declartations
        AStarSolver solver = new AStarSolver(problem);
        Button butts [] = {findViewById(R.id.button3),findViewById(R.id.button4), findViewById(R.id.button5),findViewById(R.id.button6)};



        TextView viewEditor = (TextView) findViewById(R.id.currState);
        viewEditor.setText(problem.getInitialState().toString());         //sets intial state string
        viewEditor = (TextView) findViewById(R.id.count);
        viewEditor.setText("0");                                         //sets count string
        viewEditor = (TextView) findViewById(R.id.goalS);
        viewEditor.setText(problem.getFinalState().toString());         //sets goal string
        viewEditor = (TextView) findViewById(R.id.messege);
        viewEditor.setText("");                                          // sets message
        viewEditor= (TextView) findViewById(R.id.statV);
        viewEditor.setText("");                                         //sets blank stats


        for (int i = 0; i<4; i++) {
            Button but = butts[i];
            but.setOnClickListener(event -> {
                solvingA.tryMove((String) but.getText());
                if (!solvingA.isMoveLegal()) {                                            //if false say illegal move
                    ((TextView) findViewById(R.id.messege)).setText("Illegal Move");
                } else if (solvingA.isMoveLegal()) {
                    ((TextView) findViewById(R.id.messege)).setText("");                                       //if legal -> say nothing
                    ((TextView)findViewById(R.id.count)).setText(String.valueOf(solvingA.getMoveCount()));       //  update curr state and count
                    ((TextView) findViewById(R.id.currState)).setText(solvingA.getProblem().getCurrentState().toString());
                }
                if (solvingA.isProblemSolved()) {                                                      //if solved say solved
                    ((TextView) findViewById(R.id.messege)).setText("Congrats, Problem Solved");
                }
            });
        }
        Button but = (Button)findViewById(R.id.resetB);
        but.setOnClickListener(event -> {
            TextView viewr = (TextView) findViewById(R.id.currState);
            viewr.setText(problem.getInitialState().toString());         //sets intial state string
            viewr = (TextView) findViewById(R.id.count);
            viewr.setText("0");                                         //sets count string
            viewr = (TextView) findViewById(R.id.messege);
            viewr.setText("");                                        //sets messege
            solvingA.reset();                                           //resets solving assistant
            viewr = (TextView)findViewById(R.id.statV);
            viewr.setText("");      //resets stat
            for(int i=0; i<4;i++){
                Button button = butts[i];
                button.setEnabled(true);
            }
            findViewById(R.id.solveB).setEnabled(true);
            for(Button button: butts) {
                button.setTextColor(Color.WHITE);
            }
        });

        but = (Button)findViewById(R.id.solveB);
        but.setOnClickListener(event-> {
            solver.solve();
            findViewById(R.id.solveB).setEnabled(false);
            ((TextView) findViewById(R.id.statV)).setText(solver.getStatistics().toString());
            for(int i=0; i<4;i++){
                Button button = butts[i];
                button.setEnabled(false);
            }
        });

        but = (Button) findViewById(R.id.nextB);
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
                    ((TextView) findViewById(R.id.count)).setText(String.valueOf(solvingA.getMoveCount()));
                    if (((TextView) findViewById(R.id.currState)).getText().equals(((TextView) findViewById(R.id.goalS)).getText())) {
                        ((TextView) findViewById(R.id.messege)).setText("Congrats, Problem Solved");
                    }
                    for(Button button: butts) {
                        if(((State) nextV.getData()).getMove().equals(button.getText())) button.setTextColor(Color.RED);
                    }


            }
        });

    }

}

