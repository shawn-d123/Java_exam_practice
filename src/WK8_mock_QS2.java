public class WK8_mock_QS2 {
    public static void main(String[] args){
        System.out.println(PMT(50000, 6 , 10));
    }
    public static double PMT (double p, double r, double n){
        double monthRate = (6.0 / 100.0) / 12.0;
        double nmonth = 12.0 * n;
        double result = (p * monthRate * Math.pow(1 + monthRate, nmonth)) / (Math.pow(1 + monthRate , nmonth) - 1);
        return(result);
    }
}
