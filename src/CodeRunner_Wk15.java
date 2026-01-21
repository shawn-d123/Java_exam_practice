import java.util.ArrayList;

public class CodeRunner_Wk15 {
    public static void main(String[] args) {

    }

    public static double JoulesToWattHours(double j){

        double joules = 0;
        if(j <= 0){
            return -1;
        }
        else if (j > 1000000){
            return -2;
        }
        else{
            joules = (j/3600.0);
        }
        return joules;
    }

    public static int Quadrant(String x, String y){
        if(x == null || y == null || x.isEmpty() || y.isEmpty() || x.contains(" ") || y.contains(" ")){
            return -1;
        }
        int x1;
        int y1;
        try{
             x1 = Integer.parseInt(x);
             y1 = Integer.parseInt(y);

        }catch(Exception e){
            return -2;
        }
        if(x1 == 0 || y1 == 0){
            return -3;
        }

        if(x1 >0 && y1 >0){
            return 1;
        }else if(x1 < 0 && y1 > 0){
            return 2;
        }else if(x1 < 0 && y1 < 0){
            return 3;
        }else{
            return 4;
        }
    }

    public static ArrayList<Double> CToF(ArrayList<String> c){

        ArrayList<Double> result = new ArrayList<>();

        for (int i = 0; i < c.size(); i++){
            // check if value is null or empty
            if(c.get(i) == null || c.get(i).isEmpty()){
                return null;
            }
            double f;
            double addValue;
            try{
                f = Double.parseDouble(c.get(i));
                addValue = (f * (9.0/5.0) +32.0);
                result.add(addValue);
            }catch(Exception e){
                return(new ArrayList<Double>());
            }
        }
        return result;
    }
}
















