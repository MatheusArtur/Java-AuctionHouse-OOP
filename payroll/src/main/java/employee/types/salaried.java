package employee.types;

public class Salaried extends Employee
{
    protected double bruteIncome;

    public void setIncome(double value)
    {
	this.bruteIncome = value;
    }

    public double getIncome()
    {
	return (this.bruteIncome);
    }

}
