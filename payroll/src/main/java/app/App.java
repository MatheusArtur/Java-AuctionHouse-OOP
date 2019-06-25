package app;
import java.util.ArrayList;
import employee.*;
import agenda.*;
import java.util.Calendar;
import java.util.Scanner;

public class App
{
    private static final ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static final ArrayList<Agenda> agendaList = new ArrayList<Agenda>();

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

    }
    
    public void initAgendas()
    {

    }

    public static void main(String[] args)
    {
    	agendaList.add(new Agenda(1, "Monthly", 0, 0));
	employeeList.add(new Employee(0, "Jane Doe", "Shonan Av. 1994", "Salaried", 'y', "Mail"));
    }

}
