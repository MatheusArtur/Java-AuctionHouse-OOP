package employee.types;

public class Hourly extends Employee
{
    protected double weeklyHours;

    public void setHours(double value)
    {
	this.salesPercentage += value;
    }

    public double getHours()
    {
	return (this.weeklyHours);
    }
}
