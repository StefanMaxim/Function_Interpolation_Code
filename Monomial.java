public class Monomial {
    
private double coeff;
private int exponent;

public Monomial(double c)
{
    exponent = 0;
    coeff = c;
}

public double getCoeff() {
    return coeff;
}

public int getExponent() {
    return exponent;
}

public void setCoeff(double coeff) {
    this.coeff = coeff;
}

public void setExponent(int exponent) {
    this.exponent = exponent;
}


public void integrate()
{
    exponent++;
    coeff = coeff * (1/(double)exponent);
}

public double findSum(double x)
{
    return coeff * Math.pow(x, exponent);
    
    
}

public String toString()
{
    return coeff + "x^(" + exponent + ")";
}




}
