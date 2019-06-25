package employee.types;
import employee.*;

class Salaried extends Employee
{
    protected double bruteIncome;

    public Salaried(String name, String adress, String type, char syndie, String payment, double income)
    {
	super(name, adress, type, syndie, payment);
	this.bruteIncome = income;
    }

	public void setIncome(double value)
    {
	this.bruteIncome = value;
    }

    public double getIncome()
    {
	return (this.bruteIncome);
    }

}
