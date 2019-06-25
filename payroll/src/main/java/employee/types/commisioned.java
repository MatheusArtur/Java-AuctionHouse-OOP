package employee.types;

class Commisioned extends Salaried
{
    protected double salesRevenue;
    protected double salesPercentage;
    

    public Commisioned(int id, String name, String adress, String type, char syndie, String payment, double income, double cut, double revenue)
    {
	super(id, name, adress, type, syndie, payment, income);
	this.salesRevenue = revenue;
	this.salesPercentage = cut;
		
    }
	
    public void setPercentage(double value)
    {
	this.salesPercentage = value;
    }

    public void setRevenue(double value)
    {
	this.salesRevenue += value;
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
