package hack.practice;

import java.util.*;

public class SquareRoot {


    public static void main(String[] args) {
        // calculateSquareRoot(12);

        //int[] array = {11,2,3,2,10,12};

        //arrayOfIntegers();
        findNearestNumber();
        //getArrayOfIntegers();
        //double mySquareRoot = findMySquareRoot(-10.0);
        //System.out.println("square Root of a Number::" + mySquareRoot);

      /*  System.out.println("Squre Root of a number::"+ Math.sqrt(12));
        findSquareRoot(-3);

        //0.03571428571428559
        double num1 = 2.0;
        double rsult = ( 0.03571428571428559 + (12.0/0.03571428571428559))/2;
        System.out.println("Result value::"+ rsult);

        double f1 = 3.4642857142857144;
        double f2 = 3.5;

        System.out.println("diff::"+ (f2 - f1) );

        findMySquareRoot(-3);
*/

        //long l = System.currentTimeMillis();
        //System.out.println("Time1::" + (System.currentTimeMillis() - l));
        //System.out.println("Element Exists::"+ checkIfnumberExistsInArray1(array,6,10));

        /*long l1 = System.currentTimeMillis();
        System.out.println("Element Exists::"+ checkIfnumberExistsInArray2(array,6,10));
        System.out.println("Time2::" + (System.currentTimeMillis() - l1));*/

    }
/*1 = 2 * 3 * 4
  2 = 1 * 3 * 4
  3 = 1 * 2 * 4
  4 = 1 * 2 * 3

*/



    private static void calculateSquareRoot(int number) {
        System.out.println("Squre Root of a number::" + Math.sqrt(number));

        double x = 64 % 20;
        System.out.println("3 /2 is :::" + x);


    }

    private static int returnSquareRoot(int number) {
        int number1 = 0;
        Integer i = squareRoot1(number);
        System.out.println("Integr SeqRoot::" + i);
        if (i != null) return i;
        else
            return number;
       /* if ( number > 0  && ( (number)/(number/2) == number)){
          number1 = number;
        }
        return number1;*/
    }

    private static Integer squareRoot1(int number) {
        for (int i = 1; i < number; i++) {
            if ((i * i) == number) return i;
            else continue;
        }
        return null;
    }

    private static double squareRoot2(int number) {
        double ceil = Math.ceil(number / 2);
        double x = 2 ^ Double.valueOf(ceil).intValue();
        System.out.println("xxx:" + x);
        /*double y = 0;*/
        for (int i = 0; i < number; i++) {
            double y = Math.floor((x + Math.floor(number / x)) / 2);
            if (y >= x)
                return x;
            else
                x = y;
        }
        return x;
    }

    private static boolean checkIfnumberExistsInArray1(int array[], int array_len, int num) {
        //List<Integer> arrayElements = Arrays.asList(new Integer[array.length]);
        //Best Solution using an Array.
        String[] a = new String[array.length];
        String s = Arrays.toString(array);
        String numberToFind = String.valueOf(12);
        boolean contains = s.contains(numberToFind);
        System.out.println("Contains::" + contains);

        Set<String> arrayElements = new HashSet<String>(Arrays.asList(a));
        for (String element : arrayElements) {
            System.out.println("Element::" + element);
        }
        return arrayElements.contains(num);
    }

    private static boolean checkIfnumberExistsInArray2(int array[], int array_len, int num) {
        List<Integer> arrayElements = Arrays.asList(new Integer[array.length]);
        Set<Integer> setArray = new HashSet<Integer>(arrayElements);
        return setArray.contains(num);
    }

    private static List<Integer> getArrayOfIntegers() {
        Integer[] integerArray = {1, 2, 3, 4};
        Integer[] finalArray = new Integer[integerArray.length];

        for (int i = 0; i < integerArray.length; i++) {
            int number = i;
            int tempResult = 1;
            for (int arrayCounter = 0; arrayCounter < integerArray.length; arrayCounter++) {
                if (number != arrayCounter) {
                    tempResult = tempResult * integerArray[arrayCounter];
                }
            }
            finalArray[i] = tempResult;
        }
        return Arrays.asList(finalArray);

    }

    private static void findNearestNumber(){

        Random random = new Random();
        Integer[] randomArray = new Integer[100];
        Integer[] resultArray = new Integer[2];

        for(int i = 0;i<100;i++){
            randomArray[i] = i+1;
        }
        System.out.println("Random Numbers::" + Arrays.asList(randomArray));


        int start = 0;
        int end = 99;
        int requiredSum = 100;

        while( start != end ){
            System.out.println("Start ::"+ start + "and end ::"+ end);
            if ( (randomArray[start] + randomArray[end]) == requiredSum ){
                resultArray[0] = randomArray[start];
                resultArray[1] = randomArray[end];
                break;
            }else if ( requiredSum > randomArray[start] + randomArray[end]){
                start++;
            }else{
                end --;
            }
        }

        System.out.println("RequiredNumbers are ::" + resultArray[0] + "and:::" + resultArray[1]);


    }

    public static double findMySquareRoot(double number) {
        double squareRoot = number / 2;
        double g1;

        if (number == 0) {
            return number;
        } else if (number < 0) {
            number = -number;
        }

        do {
            g1 = squareRoot;
            squareRoot = (g1 + (number / g1)) / 2;
        }
        while ((g1 - squareRoot) != 0);
        return squareRoot;
    }


    /*This method finds out the square root without using
    any built-in functions and displays it */
    public static void findSquareRoot(double number)
    {

        boolean isPositiveNumber = true;
        double g1;

        //if the number given is a 0
        if(number==0)
        {
            System.out.println("Square root of "+number+" = "+0);
        }

        //If the number given is a -ve number
        else if(number<0)
        {
            number=-number;
            isPositiveNumber = false;
        }

        //Proceeding to find out square root of the number
        double squareRoot = number/2;
        do
        {
            g1=squareRoot;
            squareRoot = (g1 + (number/g1))/2;
        }
        while((g1-squareRoot)!=0);

        //Displays square root in the case of a positive number
        if(isPositiveNumber)
        {
            System.out.println("Square roots of "+number+" are ");
            System.out.println("+"+squareRoot);
            System.out.println("-"+squareRoot);
        }
        //Displays square root in the case of a -ve number
        else
        {
            System.out.println("Square roots of -"+number+" are ");
            System.out.println("+"+squareRoot+" i");
            System.out.println("-"+squareRoot+" i");
        }

    }
}


