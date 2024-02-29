package DataStructure;
import java.util.ArrayList;

public class LearnArrayList {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(arr);
        arr.remove(1);
        System.out.println(arr);
        arr.remove(Integer.valueOf(3));
        System.out.println(arr);
        arr.set(0, 9);
        System.out.println(arr);
        arr.addFirst(4);
        System.out.println(arr);
//        arr.sort();
    }
}
