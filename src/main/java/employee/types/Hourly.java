package employee.types;
import employee.*;
import agenda.*;

public class Hourly extends Employee
{
    protected double weeklyHours;
    protected double perhour;

    public Hourly(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double hours, double tax)
    {
	super(id, name, adress, type, syndie, payment, payday);
	this.weeklyHours = hours;
	this.perhour = tax;
    }

    public void manageEmployee(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double hours)
    {
	super.manageEmployee(id, name, adress, type, syndie, payment);
	this.weeklyHours = hours;
    }
    
    public void setWeeklyHours(double weeklyHours)
    {
	this.weeklyHours = weeklyHours;
    }

    public double getWeeklyHours()
    {
	return weeklyHours;
    }

    public double getPerhour()
    {
	return perhour;
    }
}
