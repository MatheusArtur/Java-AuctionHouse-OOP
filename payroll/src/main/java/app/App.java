package app;
import java.util.ArrayList;
import employee.*;
import sun.applet.Main;
import agenda.*;
import java.util.Calendar;
import java.util.Scanner;

public class App
{
    private ArrayList<Employee> employeeList;
    private ArrayList<Agenda> agendaList;
    private int lastPayroll;

    // fun1
    private void newEmployee()
    {
	
    }
    
    // fun2
    private void rmEmployee()
    {
	
    }

    // fun3
    private void launchPointCard()
    {
	
    }
    
    // fun4
    private void launchSaleRevenue()
    {
	
    }
    
    // fun5
    private void launchServiceCost()
    {
	
    }
    
    // fun6
    private void newEditEmployee()
    {
	
    }

    // fun 10
    private void newAgenda()
    {
	int aDay, aWeekone, aWeektwo;
	String aType;

	if(aType)
	agendaList.add(Agenda.addAgenda(1, "Monthly", 0, 0));
    }
    
    public void initAgendas()
    {
	agendaList.set(0, Agenda.addAgenda(1, "Monthly", 0, 0));
	agendaList.set(1, Agenda.addAgenda(5, "Weekly", 0, 0));
	agendaList.set(2, Agenda.addAgenda(5, "Bimonthly", 2, 4));
	this.lastPayroll = c.get(Calendar.DAY_OF_YEAR) - 1;
    }

    public static void main()
    {
	boolean loop = true;
    }

}
