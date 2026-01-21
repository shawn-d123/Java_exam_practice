import java.util.ArrayList; // importing the ArrayList class
import java.util.Collections; // importing the Collections class to sort

public class ArrayLists_learning {
    public static void main(String[] args) {

        // initializing an array list cars
        ArrayList<String> cars = new ArrayList<>();

        // we can add elements by using .add()
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        System.out.println(cars);

        // so currently we have the arrayList: ["Volvo", "BMW", "Ford"]

        // now we can insert an element at an index in the list
        cars.add(0,"Ferrari"); // here we use .add(index,element)
        System.out.println(cars);

        cars.add(3,"Mazda"); // here we insert mazda at index 3
        System.out.println(cars + "  :add Mazda at index 3");

        // to insert a value at the start and end we can use the following
        cars.addFirst("Lamborghini"); // add first
        System.out.println(cars + "  :add Lamborghini at the start");

        cars.addLast("Pagani"); // add last
        System.out.println(cars + "  :add pagani at the end");

        // Now We can Remove elements from the ArrayList
        cars.remove(3); // remove element at index 3
        System.out.println(cars + " :remove car at index 3");

        // We can set an elements value to something to overRide it
        cars.set(0, "Jeep");
        System.out.println(cars + " : set Ferrari at index 0 to Jeep");

        // we can get the size/length of the list
        System.out.println("The size of cars is: " + cars.size());

        // we can also retrive/access an element at an index
        System.out.println("element at index 2 is: " + cars.get(2));

        System.out.println();

        //looping through an ArrayList:
        for (int i = 0; i < cars.size(); i++){
            System.out.println(cars.get(i));
        }

        System.out.println();

        // we can also use a For-Each loop
        for (String car : cars){
            System.out.println(car);
        }

        // sort the cars list
        Collections.sort(cars);
        System.out.println("Cars sorted in order: " + cars);

        // reverse the order
        Collections.reverse(cars);
        System.out.println("Cars in Reversed order: " + cars);
        // we can also Sort an ArrayList, but we have to import Collections class

        // -- we create a new ArrayList -- //

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(3);
        numbers.add(2);
        numbers.add(5);
        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println("Number sorted in order: " + numbers);

        // we can remove all elements in the list
        cars.clear();
        System.out.println(cars + " : all elements removed");


    }


}
