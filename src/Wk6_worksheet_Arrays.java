public class Wk6_worksheet_Arrays {
    public static void main(String[] args){

        int[] timeInMinutes = {1,3,5,10};
        for(int time: timeInMinutes){
            System.out.print(time * 60 + ", ");
        }

        int[][] movement = {
                {100, 100, 1000},
                {70, 100, 2000},
                {100, 70, 3000},
        };

        System.out.println( movement[1][0]);

        char letter = 'A';
        int ascii = (int) letter;
        System.out.println(ascii);

        double price = 49.99;
        int discountedPrice = (int) price;
        System.out.println(discountedPrice);


    }
}
