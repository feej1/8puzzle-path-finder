package com.example.problemsolver.domains.farmer;
import com.example.problemsolver.framework.problem.State;
import java.util.Objects;

/**
 *
 * @author jobo9
 */
public class FarmerState extends State {

    public String wolf;
    public String Farmer;
    public String Cabbage ;
    public String Goat;



    public void setWolf(String x){
        wolf = x;
    }
    public void setGoat(String x){
        Goat = x;
    }

    public void setFarmer(String x){
        Farmer = x;
    }
    public void setCabbage(String x){
        Cabbage = x;
    }

    public String getFarmer(){
        return Farmer;
    }
    public String getWolf(){
        return wolf;
    }
    public String getGoat(){
        return Goat;
    }
    public String getCabbage(){
        return Cabbage;
    }


    public FarmerState(String farmer, String Wolf, String goat, String cabbage) {
        this.Farmer= farmer;
        this.wolf= Wolf ;
        this.Cabbage= cabbage;
        this.Goat= goat;
    }

    @Override
    public boolean equals(Object other) {
        if (other== null) return false ;
        FarmerState otherDummy = (FarmerState) other;
        return (this.wolf.equals(((FarmerState)other).wolf ) &&
                this.Farmer.equals(((FarmerState)other).Farmer ) &&
                this.Goat.equals(((FarmerState)other).Goat ) &&
                this.Cabbage.equals(((FarmerState)other).Cabbage ));

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.wolf);
        hash = 11 * hash + Objects.hashCode(this.Farmer);
        hash = 11 * hash + Objects.hashCode(this.Cabbage);
        hash = 11 * hash + Objects.hashCode(this.Goat);
        return hash;
    }




    @Override
    public String toString() {

        String temp =   "   |  |   \n" ;
        if (Farmer == "West")  temp= temp +    " F |  |   \n" ;
        else temp = temp +   "   |  | F \n" ;

        if (wolf == "West") temp = temp +   " W |  |   \n";
        else temp = temp +   "   |  | W \n";

        if (Goat == "West") temp = temp +   " G |  |   \n" ;
        else temp = temp +   "   |  | G \n";

        if (Cabbage =="West")temp = temp +   " C |  |   \n";
        else temp = temp +   "   |  | C \n";

        temp = temp +    "   |  |   " ;


        return temp;
    }


}
