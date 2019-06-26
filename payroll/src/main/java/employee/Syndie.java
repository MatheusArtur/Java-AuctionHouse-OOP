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

	public double getMonthlyTax() {
		return monthlyTax;
	}

	public void setMonthlyTax(double monthlyTax) {
		this.monthlyTax = monthlyTax;
	}

	public double getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(double serviceTax) {
		this.serviceTax += serviceTax;
	}


}
