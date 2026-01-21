import java.util.ArrayList;
import java.util.Collections;

public class macInteger {

    public static void main(String[] args){
        System.out.println(intMax(2,3,4));
    }

    public static int intMax(int a, int b, int c) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        Collections.sort(list);
        int result = list.get(list.size() -1);
        return( result);


    }
}
