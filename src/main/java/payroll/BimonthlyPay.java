package payroll;
import agenda.Agenda;
import employee.*;
import employee.types.Commisioned;

public class BimonthlyPay
{
    public int validWeek(int lWeek, int rWeek, int period)
    {
	if(period >= 1 && period <= 7 && lWeek == 1)
	    {
		return 1;
	    }
	else if(period >= 8 && period <= 14 && lWeek == 2 | rWeek == 2)
	    {
		return 1;		
	    }
	else if(period >= 15 && period <= 21 && lWeek == 3 | rWeek == 3)
	    {
		return 1;		
	    }
	else if(period >= 22 && period <= 31 && rWeek == 4)
	    {
		return 1;		
	    }
	else
	    {
		return 0;
	    }
    }
    
    public double bimonthlyIncome(Employee emp, int today, Agenda empA, int todayMonth)
    {
	double stonks;
	int week;
	stonks = 0.0;
	week = validWeek(empA.getFirstWeek(), empA.getSecondWeek(), todayMonth);

	
	if(empA.getDay() == today && week == 1)
	    {
		stonks = (((Commisioned)emp).getIncome()/2)+(((Commisioned)emp).getSalesRevenue()*(((Commisioned)emp).getSalesPercentage()/100));
	    }
	return stonks;
    }
}
