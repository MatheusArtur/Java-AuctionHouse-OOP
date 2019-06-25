package employee.types;
import employee.*;

class Hourly extends Employee
{
    protected double weeklyHours;


    public Hourly(int id, String name, String adress, String type, char syndie, String payment, double hours)
    {
	super(id, name, adress, type, syndie, payment);
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
