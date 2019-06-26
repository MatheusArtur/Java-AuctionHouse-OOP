package employee;

public class Syndie
{
    protected double monthlyTax;
    protected double serviceTax;

    Syndie(int tax, int service)
    {
	this.monthlyTax = tax;
	this.serviceTax = service;
    }

    public void manageSyndie(int tax, int service)
    {
	this.monthlyTax = tax;
	this.serviceTax = service;
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
