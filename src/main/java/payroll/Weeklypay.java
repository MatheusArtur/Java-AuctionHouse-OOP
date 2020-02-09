package payroll;
import agenda.Agenda;
import employee.*;
import employee.types.Hourly;


public class Weeklypay
{
    public double normalRatio(Employee citizen)
    {
	double aux;
	aux = ((Hourly)citizen).getWeeklyHours();

	if(aux > 8.0)
	    {
		return 1.5;
	    }
	else
	    {
		return 1.0;
	    }
	
    }
    
    public double WeeklyIncome(Employee emp, int today, Agenda empA)
    {
	double stonks = 0.0;
	if(empA.getDay() == today)
	    {
		stonks = ((Hourly) emp).getPerhour() * ((Hourly) emp).getWeeklyHours() * normalRatio(emp);
	    }
	return stonks;
    }
}
