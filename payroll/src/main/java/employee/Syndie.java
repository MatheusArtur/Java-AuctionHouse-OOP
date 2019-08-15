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

    public void manageSyndie(Double tax, double service)
    {
	this.monthlyTax = tax;
	this.serviceTax = service;
    }

    public double getTax()
    {
	return monthlyTax + serviceTax;
    }

    public void setServiceTax(double serviceTax)
    {
	this.serviceTax += serviceTax;
    }
}
