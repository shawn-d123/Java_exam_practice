import java.util.ArrayList;

public class CodeRunner_WK8 {
    public static void main(String[] args){
        System.out.println(PMT(50000,6,10));
        System.out.println(CalculateAngle(1,1,3));
    }

    public static double PMT(double p, double r, double n){

        double r1 = (r/100.0)/12.0;
        double n1 = (n * 12.0);

        double calc = ((p*r1)*Math.pow((1 + r1),n1)) / (Math.pow((1 + r1), n1) -1);
        return calc;
    }

    public static double CalculateAngle(double a, double b, double c){

        // validate sides
        if((a + b) > c && (a + c) > b && (b + c) > a){
            // valid sides, now find angle
            double cosinA = (((b*b) + (c*c) - (a*a)))/(2*b*c);
            double rad = Math.acos(cosinA);
            double degree = Math.toDegrees(rad);
            return degree;
        }
        // invalid
        else{
            return -1.0;
        }
    }

    public static ArrayList<Integer> PointInCircle(int[][] points){

        int h = 3;
        int k = 3;
        int r = 5;

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < points.length; i++){
            // assign x and y
            int x = points[i][0];
            int y = points[i][1];

            // start calculation
            double calc = Math.pow((x-h),2) + Math.pow((y-k),2);
            int calc1 = (int)calc;

            // check if in, on or out of circle
            if(calc1 < (r*r)){
                result.add(1);
            }else if(calc1 ==  (r*r)){
                result.add(2);
            }else if(calc1 > (r*r)){
                result.add(3);
            }
        }
        return result;
    }


}
