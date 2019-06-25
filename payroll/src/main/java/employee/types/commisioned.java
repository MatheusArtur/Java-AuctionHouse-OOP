package employee.types;

public class Commisioned extends Salaried
{
    protected double salesRevenue;
    protected double salesPercentage;

    public void setPercentage(double value)
    {
	this.salesPercentage = value;
    }

    public void setRevenue(double value)
    {
	this.salesPercentage += value;
    }

    public double getPercentage()
    {

	return(this.salesPercentage);
    }

    public double getRevenue()
    {
	return (this.salesRevenue);
    }
}
