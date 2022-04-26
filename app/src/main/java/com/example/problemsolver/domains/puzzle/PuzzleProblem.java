package com.example.problemsolver.domains.puzzle;
import com.example.problemsolver.framework.problem.Benchmark;
import com.example.problemsolver.framework.problem.Problem;

public class PuzzleProblem extends Problem {

    int [][]goal = {{1,2,3}, {8,0,4},{7,6,5}} ;
    int [][]initial = {{2,8,3},{1,6,4},{7,0,5}} ;
    private String end ;

    public static final PuzzleState BENCH1 =
            new PuzzleState(new int[][]{new int[]{2, 8, 3},
                    new int[]{1, 6, 4},
                    new int[]{7, 0, 5}});
    public static final PuzzleState BENCH2 =
            new PuzzleState(new int[][]{new int[]{3, 6, 4},
                    new int[]{1, 0, 2},
                    new int[]{8, 7, 5}});
    public static final PuzzleState BENCH3 =
            new PuzzleState(new int[][]{new int[]{3, 0, 4},
                    new int[]{1, 6, 5},
                    new int[]{8, 2, 7}});
    public static final PuzzleState BENCH4 =
            new PuzzleState(new int[][]{new int[]{2, 1, 3},
                    new int[]{8, 0, 4},
                    new int[]{6, 7, 5}});

    public static final PuzzleState BENCH5 =
            new PuzzleState(new int[][]{new int[]{4, 2, 0},
                    new int[]{8, 3, 6},
                    new int[]{7, 5, 1}});
    public static final PuzzleState BENCH6 =
            new PuzzleState(new int[][]{new int[]{1, 6, 3},
                    new int[]{4, 0, 8},
                    new int[]{7, 2, 5}});
    public static final PuzzleState BENCH7 =
            new PuzzleState(new int[][]{new int[]{5, 6, 7},
                    new int[]{4, 0, 8},
                    new int[]{3, 2, 1}});
    public static final PuzzleState BENCH8 =
            new PuzzleState(new int[][]{new int[]{5, 2, 7},
                    new int[]{8, 0, 4},
                    new int[]{3, 6, 1}});

    private static final PuzzleState GOAL =
            new PuzzleState(new int[][]{new int[]{1, 2, 3},
                    new int[]{8, 0, 4},
                    new int[]{7, 6, 5}});

    public PuzzleProblem() {
        super();
        super.addBenchmark(new Benchmark("8-Puz 1", 5, BENCH1, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 2", 10, BENCH2, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 3", 13, BENCH3, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 4", 18, BENCH4, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 5", 20, BENCH5, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 6", 24, BENCH6, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 7", 30, BENCH7, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 8", 30, BENCH8, GOAL));
        super.setName("Puzzle");
        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(new PuzzleState(initial));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(goal));
    }



    private static final String INTRO =
            "This is a puzzle problem, try get the puzzle so that "
                    + "the numbers go around in a circle starting at 1 and "
                    + "going all the way to 8. Where 1 is in the top left and "
                    + "the blank is in the middle";


}