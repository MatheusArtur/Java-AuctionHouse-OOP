package employee.syndie;

public class Syndie
{
    protected double monthlyTax;
    protected double serviceTax;

    public void setSubscription(double value)
    {
	this.monthlyTax = value;
    }
    
    public void setLeech(double value)
    {
	this.serviceTax = value;
    }

    public double getSubscription(double value)
    {
	return (this.monthlyTax);
    }
    
    public double getLeech(double value)
    {
	return (this.serviceTax);
    }
}
