import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    
    
    
public static void main(String[] args)
{

    
    ArrayList<Integer> bob = new ArrayList<Integer>();
    for(int i = 0; i < 40; i++)
    {
        bob.add((int)Math.pow(2, i));
    }


    Function joe = new Function(bob);

    joe.printPyramid();
   joe.findExpression();
   joe.printExpression();

  double ourGuess =  joe.sumExpression(80);
  double theGuess = Math.pow(2, 80);
  double  errorPerc = ((theGuess - ourGuess)/theGuess) *  100;



    System.out.println("OUR GUESS IS:");
    System.out.println(ourGuess);
    System.out.println("THE REAL ONE IS:");
    System.out.println(theGuess);
    System.out.println("THE ERROR  PERCENT IS:");
    System.out.println(errorPerc + "%");


/**
 * Scanner ask = new Scanner(System.in);
    System.out.println("Enter a list of values, with a comma to space them out(end with a comma as well)");
    String userImp = ask.nextLine();

    ArrayList<Integer> imput =  new ArrayList<Integer>();
    for(int i = 0; i < userImp.length();)
    {
        String val = userImp.substring(i, userImp.indexOf(",", i));
        imput.add(Integer.parseInt(val));
        i = userImp.indexOf(",", i) + 1;
    }

    Function test = new Function(imput);

   test.printPyramid();
   test.findExpression();
   test.printExpression();
 */

    




}




}
