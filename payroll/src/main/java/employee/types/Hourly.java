package employee.types;
import employee.*;
import agenda.*;

public class Hourly extends Employee
{
    protected double weeklyHours;

    public Hourly(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double hours)
    {
	super(id, name, adress, type, syndie, payment, payday);
	this.weeklyHours = hours;
    }

    public void manageEmployee(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double hours)
    {
	super.manageEmployee(id, name, adress, type, syndie, payment);
	this.weeklyHours = hours;
    }

    public void setHours(double value)
    {
	this.weeklyHours += value;
    }

    public double getHours()
    {
	return (this.weeklyHours);
    }
}
