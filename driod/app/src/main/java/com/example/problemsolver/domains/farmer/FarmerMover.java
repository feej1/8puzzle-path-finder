package com.example.problemsolver.domains.farmer;
import com.example.problemsolver.framework.problem.Mover;
import com.example.problemsolver.framework.problem.State;
import java.util.Set;

/**
 *
 * @author jobo9
 */
public class FarmerMover extends Mover {


    private FarmerState bad1= new FarmerState("West", "East", "East", "West");
    private FarmerState bad2= new FarmerState("West", "West", "East", "East");
    private FarmerState bad3= new FarmerState("East", "East", "West", "West");
    private FarmerState bad4= new FarmerState("East", "West", "West", "East");
    public static final String goesAlone = "Goes Alone";
    public static final String takesWolf= "Takes Wolf";
    public static final String takesCabbage = "Takes Cabbage";
    public static final String takesGoat = "Takes Goat" ;

    FarmerState initial = new FarmerState("West",   // Farmer
            "West",   // Wolf
            "West",   // Goat
            "West");  // Cabbage


    String initialString = "   |  |   \n" +
            " F |  |   \n" +
            " W |  |   \n" +
            " G |  |   \n" +
            " C |  |   \n" +
            "   |  |   ";

    public FarmerMover() {
        super.addMove(goesAlone, s -> tryAlone(s));
        super.addMove(takesWolf, s -> tryWolf(s));
        super.addMove(takesGoat, s -> tryGoat(s));
        super.addMove(takesCabbage, s -> tryCab(s));
    }

    private State tryAlone(State state) {
        FarmerState temp;
        if (((FarmerState)state).toString().equals(initial.toString()) ||
                (((FarmerState)state).toString().equals(new FarmerState("West", "West","West","East").toString())) ||
                (((FarmerState)state).toString().equals(new FarmerState("West", "East","West","West").toString())) ||
                (((FarmerState)state).toString().equals(new FarmerState("East", "East","East","East").toString()))
        ){
            return null;
        }

        if (((FarmerState)state).Farmer == "West"){ temp = new FarmerState("East",((FarmerState)state).getWolf(), ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage() );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(goesAlone);
                return temp;
            }
        }
        else { temp =new FarmerState("West",((FarmerState)state).getWolf(), ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage() );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(goesAlone);
                return temp;
            }
        }

    }

    private State tryWolf(State state) {
        //System.out.println(((FarmerState)state).toString());
        FarmerState temp;
        if ( (((FarmerState)state).toString().equals(new FarmerState("West", "West","West","West").toString()))  ||
                (((FarmerState)state).toString().equals(new FarmerState( "West", "East", "West", "East").toString()))||
                ( !(((FarmerState)state).getFarmer()).equals(((FarmerState)state).getWolf()) )
        ){
            return null;
        }

        if (((FarmerState)state).wolf== "West") { temp= new FarmerState("East","East", ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage() );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(takesWolf);
                return temp;
            }
        }
        else{ temp= new FarmerState("West","West", ((FarmerState)state).getGoat(), ((FarmerState)state).getCabbage() );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(takesWolf);
                return temp;
            }
        }



    }

    private State tryCab(State state) {
        //System.out.println(((FarmerState)state).toString());
        FarmerState temp ;
        if ( (((FarmerState)state).toString().equals(new FarmerState("West", "West", "West", "West").toString())) ||
                ( !(((FarmerState)state).getFarmer()).equals(((FarmerState)state).getCabbage()) )
        ){
            return null ;
        }

        if (((FarmerState)state).Cabbage== "West"){ temp = new FarmerState("East",((FarmerState)state).getWolf(), ((FarmerState)state).getGoat(), "East" );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(takesCabbage);
                return temp;
            }
        }
        else {temp = new FarmerState("West",((FarmerState)state).getWolf(), ((FarmerState)state).getGoat(), "West" );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(takesCabbage);
                return temp;
            }
        }



    }

    private State tryGoat(State state) {
        FarmerState temp;
        if ((((FarmerState)state).toString().equals(new FarmerState("West", "West","East","West").toString())) ||
                ( !(((FarmerState)state).getFarmer()).equals(((FarmerState)state).getGoat())) )
            return  null ;

        if (((FarmerState)state).Goat== "West") {temp = new FarmerState("East",((FarmerState)state).getWolf(), "East", ((FarmerState)state).getCabbage() );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(takesGoat);
                return temp;
            }
        }
        else { temp =new FarmerState("West",((FarmerState)state).getWolf(), "West", ((FarmerState)state).getCabbage() );
            if (temp.equals(bad1) || temp.equals(bad2)|| temp.equals(bad3) || temp.equals(bad4))return null;
            else{
                temp.setMove(takesGoat);
                return temp;
            }
        }


    }

    private State reset(State state){
        return new FarmerState ("West", "West", "West", "West") ;
    }


}
