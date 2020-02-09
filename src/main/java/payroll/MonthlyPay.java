package payroll;
import agenda.Agenda;
import employee.*;
import employee.types.Salaried;

public class MonthlyPay
{
    public double monthlyIncome(Employee emp, int today, Agenda empA)
    {
	double stonks = 0.0;
	if(empA.getDay() == today)
	    {
		stonks = ((Salaried)emp).getIncome();
	    }
	return stonks;
    }
}
