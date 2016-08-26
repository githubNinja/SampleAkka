package hack.practice;


import java.util.ArrayList;
import java.util.List;

public class HackerRank {

    public static void main(String[] args) {

        Double doubleValue = 12.3333334444;

        System.out.println("Math Floor value" + Math.floor(doubleValue));
        System.out.println("Math Ceil value" + Math.ceil(doubleValue));

       // Scanner sc = new Scanner(System.in).useDelimiter("");

        int i1 = 0;
        int i2 = 1;
        int n = 10;
        int counter = 0;

        List list = new ArrayList<Integer>();

       /* List list = new ArrayList<Integer>();

        while( sc.hasNext()){
            String next = sc.next();
            //System.out.println("Next::"+ next);
            list.add(next);
           // System.out.println("sc.next::"+ sc.next());
        }

        int size = list.size() - 1;
        System.out.println("List Integers::"+ list.get(size));*/

        //System.out.println("List Elements::"+ list);

        while ( counter <= 10) {
            if (counter == 0) {
               // continue;
               // break;
                list.add(counter);
            }
            if (counter == 1) {
               // continue;
                list.add(counter);
            }

            else if (counter >= 2) {
                Integer value2 = (Integer) list.get(counter - 1);
                Integer value1 = (Integer) list.get(counter - 2);
                int value3 = value1 + (value2 * value2);
                list.add(value3);
            }
            counter++;
        }
        System.out.println("List Elements::"+ list);
        int size = list.size() - 1;
        System.out.println("List Integers::"+ list.get(size));


    }
}
