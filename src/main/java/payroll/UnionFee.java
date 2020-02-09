package payroll;
import employee.*;

public class UnionFee
{
    public double toll(Employee emp)
    {
	double fee;
	Syndie thisguy = emp.getInfoSyndie();
	fee = thisguy.getTax();
	
	return fee;
    }
}
