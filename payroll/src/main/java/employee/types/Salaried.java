package employee.types;
import employee.*;
import agenda.*;

public class Salaried extends Employee
{
    protected double bruteIncome;

    public Salaried(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double income)
    {
	super(id, name, adress, type, syndie, payment, payday);
	this.bruteIncome = income;
    }

    public void manageEmployee(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double income)
    {
	super.manageEmployee(id, name, adress, type, syndie, payment);
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
