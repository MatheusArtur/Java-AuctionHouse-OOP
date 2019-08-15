package payroll;
import java.util.ArrayList;
import java.util.Calendar;
import agenda.*;
import employee.*;
import payroll.MonthlyPay;

public class Payroll
{
    public static Calendar c = Calendar.getInstance();

    public void displayPay(Employee citizen, double value)
    {
	System.out.printf("%n %s Received %s in payment%n", citizen.getEmployeeName(), value);
    }
    
    public void runnerPayroll(ArrayList<Employee> employees)
    {
	double payValue;
	Agenda currentAgenda;
	String comparison;
	
	for (Employee current: employees)
	    {
		currentAgenda = current.getInfoAgenda();
		comparison = currentAgenda.getCicle();

		if(comparison.equals("Monthly"))
		    {
			payValue = new MonthlyPay().monthlyIncome(current, c.get(Calendar.DAY_OF_MONTH),
								  currentAgenda);
		    }
		else if(comparison.equals("Weekly"))
		    {
			payValue = new BimonthlyPay().bimonthlyIncome(current, c.get(Calendar.DAY_OF_WEEK), currentAgenda, c.get(Calendar.DAY_OF_MONTH));
		    }
		else
		    {
			payValue = new Weeklypay().WeeklyIncome(current, c.get(Calendar.DAY_OF_WEEK),currentAgenda);
		    }
		payValue -= new UnionFee().toll(current);
		displayPay(current, payValue);
	    }
    }
}
