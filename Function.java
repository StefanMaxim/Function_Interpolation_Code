
import java.util.ArrayList;

public class Function{

private ArrayList<ArrayList<Integer>> pyramid;

private double firstX;

private int firstVal;

private ArrayList<Monomial> expression;



public Function(ArrayList<Integer> vals)
{
    firstX =(vals.size() - 1)/(double)2;
    pyramid = arrPyramid(vals);
    firstVal = findFirstVal();
    expression = new ArrayList<Monomial>();
    expression.add(new Monomial(firstVal));
}






/**
 * Method that takes an ArrayList of numbers and returns an ArrayList of number that are the distances between each of the terms
 * Exe: Takes [0, 1, 3, 6, 10, 15], and returns [1, 2, 3, 4, 5], since those are the distance betwen 0 and 1, 1 and 3, 3 and 6, etc
 * @param prevArrayList the origional ArrayList from which to find the distances
 * @return An ArrayList of the distances between each of the terms in the og AL
 */
public ArrayList<Integer> arrDeriv(ArrayList<Integer> prevArrayList)
{
    ArrayList<Integer> derived = new ArrayList<Integer>();
    for(int i = 0; i < prevArrayList.size()-1; i++)
    {
        derived.add(prevArrayList.get(i+1) - prevArrayList.get(i));
    }
    
    return derived;
}

/**
 * 
 * @param ogArrayList
 * @return
 */
public ArrayList<ArrayList<Integer>> arrPyramid(ArrayList<Integer> ogArrayList)
{
    int ogSize = ogArrayList.size();
    ArrayList<ArrayList<Integer>> incPyramid = new ArrayList<ArrayList<Integer>>();
    incPyramid.add(ogArrayList);
    for(int i = 0; i < ogSize - 1; i++)
    {
        ogArrayList = arrDeriv(ogArrayList);
        incPyramid.add(ogArrayList);

    }
   return incPyramid;
}


public int findFirstVal()
{
    return pyramid.get(pyramid.size() - 1).get(0);
}

//integrates the expression by frirst integrating every existing monomial, and then adding a new one that represents C, wh
//which will be solved for using anouther method
public void integrate()
{
    for(int i = 0; i < expression.size(); i++)
    {
        expression.get(i).integrate();
    }
    
    
   expression.add(new Monomial(findC()));//change so it dont add for c = 0

}



public double sumExpression(double x)
{
double sum = 0;
for(Monomial m : expression)
{
    sum += m.findSum(x);
}
return sum;

    

}



//Returns the value of C
//WORK IN PROGRESS
public double findC()
{
    //finds value of c for the expression at any power
    int exp = expression.get(0).getExponent();
    int row = pyramid.size() -  exp - 1;
    ArrayList<Integer> corrRow = pyramid.get(row);
    int valueC = corrRow.get(corrRow.size() - 1);
    
    //finds the value of x of the expression at any power
    double valX = firstX + 0.5 * exp;


    double sum = sumExpression(valX);
    return valueC - sum;
    
}

public void findExpression()
{
    for(int i = 0; i < pyramid.size() - 1; i++)
    {
        integrate();
    }

}

public void printExpression()
{
    String printExp = new String();
    for(Monomial bob : expression)
    {
        if(bob.getCoeff() != 0)
        {
        printExp = printExp + "+" + bob.toString();
        }
    }
    System.out.println(printExp);
}

public void printPyramid()
{
    for(int i = 0; i < pyramid.size(); i++)
    {
        for(int j = 0; j < pyramid.get(i).size(); j++)
        {
            System.out.print(pyramid.get(i).get(j) + " , ");
        }
        System.out.print("\n");
    }
}

 










}