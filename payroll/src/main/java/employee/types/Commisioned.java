package employee.types;
import agenda.*;

public class Commisioned extends Salaried
{
    protected double salesRevenue;
    protected double salesPercentage;

    public Commisioned(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double income, double cut, double revenue)
    {
	super(id, name, adress, type, syndie, payment, payday, income);
	this.salesRevenue = revenue;
	this.salesPercentage = cut;
    }

    public void manageEmployee(int id, String name, String adress, String type, String syndie, String payment, Agenda payday, double income, double cut, double revenue)
    {
	super.manageEmployee(id, name, adress, type, syndie, payment);
	this.salesRevenue = revenue;
	this.salesPercentage = cut;
    }

    public double getSalesRevenue()
    {
	return salesRevenue;
    }


    public double getSalesPercentage()
    {
	return salesPercentage;
    }
}
