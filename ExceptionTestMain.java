package exceptiontest;


import java.math.BigInteger;
import java.security.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExceptionTestMain {

   static ContainsExclamationManager containsExclamationManager = new ContainsExclamationManager();
    public static void main(String[] args)  {

        boolean exit =true;
        while(exit){


            Scanner scanner  =  new Scanner(System.in);

            // Arithmatic Operation Exception
                try{
                    int x = 100;
                    int y = 0;  // denominator is set to zero
                    System.out.println( x/y ); // throws ArithmeticException

                }catch (ArithmeticException e){
                    System.out.println(" Arithamatic Exception fırlatırım " + e.getMessage());
                }

            // Null Pointer Operation Exception


            try{
                String data = null;
            System.out.println( data.length() );

            }catch (NullPointerException e){
            System.out.println(" NullPointer Exception fırlatırım " + e.getMessage());

        }


            // DateTime Operation Exception


            try{
                LocalDate now = LocalDate.now();
                DateTimeFormatter.RFC_1123_DATE_TIME.format(now);

            }catch (DateTimeException e){
                System.out.println("Datetime Excetion fırlatırım" + e.getMessage());
            }

            // ArrayIndexOfBound Operation Exception

            try{
                String[] data = new String[5];

                data[6] = "More Data";

            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array Index Of Bound Exception fırlatırım" + e.getMessage());
            }

            // NegativeArraySizeExeption Operation Exception
            /* Developers must set array size to a positive integer. If a minus sign slips into the array size declaration,
            this throws the NegativeArraySizeException.*/

            try{
                String[] data = new String[-5]; // throws Runtime Exception
                data[1] = "More Data";

            } catch (NegativeArraySizeException e){
                System.out.println("NegativeArraySizeException Exception fırlatırım" + e.getMessage());

            }


            // ArrayStoreException Operation Exception

            /*
            The ArrayStoreException shares similarities with the ClassCastException.
            This Java runtime exception happens when the wrong type of object is placed into an array.
             */

            try{
                        Number[] bigInt = new BigInteger[5];
                bigInt[0] = Double.valueOf(12345);
            } catch (ArrayStoreException e ){
                System.out.println("ArrayStoreException Exception fırlatırım" + e.getMessage());

            }

            // UnpposrtedOperation Operation Exception
            try{
                Integer[] data = {1,2,3,5,8,13,21};
                List<Integer> list = Arrays.asList(data);
                list.add(new Integer(0));
            }catch (UnsupportedOperationException e){
                System.out.println("UnsupportedOperation Exception fırlatırım" + e.getMessage());

            }

            //no such element exception
        try{
            Set set = new HashSet();
            set.iterator().next(); // Java runtime exception thrown

        } catch (NoSuchElementException e){
            System.out.println("NoSuchElement Exception fırlatırım" + e.getMessage());

        }

        // ConcurrentModifiacaiton exption ---------
        try{
            List servers = new ArrayList();
            servers.add("Tomcat");

            Iterator<String> iterator = servers.iterator();
            while (iterator.hasNext()) {
                String server = iterator.next();
                servers.add("Jetty");  // throws a Runtime Exception
            }
        }catch (ConcurrentModificationException e){
            System.out.println("ConcurrentModifiacaiton Exception fırlatırım" + e.getMessage());

        }

        // My exception
            System.out.println("Bir String deger girin");
             String checkExclamationValue= scanner.nextLine();

             try {
                 containsExclamationManager.checkExclamation(checkExclamationValue);

             } catch (ContainsExclamation e){
                 System.out.println("ContainExclamaiton Exception fırlatırım" + e.getMessage());

             }




            System.out.println("Çıkış Yapılsın mı Yes or No" );
            String checkExit=scanner.nextLine();
            if(checkExit.equalsIgnoreCase("yes")){
                exit=false;
                System.out.println("Çıkış Yapıldı...");
            }

        }

    }

}
