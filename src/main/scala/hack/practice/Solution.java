package hack.practice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution
{
    private void run(String [] args)
    {
        // Initialization
        //
        // In this part of the program you can perform any kind of
        // initialization routine before processing the stream
        // of data.
        String identifier = "";
        DecimalFormat decim = new DecimalFormat("#.00");
        double quoteFinalVal = 0.00;
        String operation = "";
        int rcount = 0;
        int qcount = 0;

        String line = "";
        ArrayList<String> quote = new ArrayList<String>();

        Scanner stdinScanner = new Scanner(System.in);
        Map<String,Double> processingMap = new HashMap<String,Double>();
        ArrayList<String> keys = new ArrayList<String>();

        while(stdinScanner.hasNext())
        {
            line = stdinScanner.nextLine();
            Scanner tokenScanner =  new Scanner(line);
            tokenScanner.useDelimiter("\\|");

            while (tokenScanner.hasNext())
            {
                String token = tokenScanner.next();
                quote.add(token);

                if ( token.equalsIgnoreCase("+")){
                    operation = "+";
                    keys.add(tokenScanner.next());
                    keys.add(tokenScanner.next());
                }

                if ( token.equalsIgnoreCase("R")){
                    identifier = tokenScanner.next();
                    rcount++;
                }


                if ( token.equalsIgnoreCase("Q")){
                    processingMap.put(tokenScanner.next(), Double.parseDouble(tokenScanner.next()));
                    qcount++;
                }

                if( operation.equals("+") && processingMap.size() == keys.size()){
                    for ( String identifierKey : keys){
                        Double value = processingMap.get(identifierKey);
                        if ( value != null) {
                            quoteFinalVal += value.doubleValue();
                            Double.parseDouble(decim.format(quoteFinalVal));
                        }
                    }
                    System.out.println(identifier+": "+(Double.parseDouble(decim.format(quoteFinalVal)))+"0") ;
                }else if ( rcount >= 3 ){
                    System.out.println(identifier+": "+ "nan") ;
                    break;
                }

            }
            if ( rcount == 3){
                break;
            }


        }

        stdinScanner.close();

    }

    public static void main(String []args)
    {
        Solution solution = new Solution();
        solution.run(args);
    }
}


