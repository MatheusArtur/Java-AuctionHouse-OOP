package app;
import java.util.ArrayList;
import employee.*;
import employee.types.Commisioned;
import employee.types.Hourly;
import employee.types.Salaried;
import agenda.*;
import java.util.Calendar;
import java.util.Scanner;

public class App
{
    private static final ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static final ArrayList<Agenda> agendaList = new ArrayList<Agenda>();
    public static Calendar c = Calendar.getInstance();
    public static int lastPayroll = c.get(Calendar.DAY_OF_YEAR) - 1;
    public static int id = 0;
    public static Scanner input = new Scanner(System.in);

    // fun1
    public static void newEmployee()
    {
	String name, address, type, isSyndie, payMethod;
	double income, percentage;
	System.out.println("Input employee name:");
	name = input.nextLine();
	
	System.out.println("Input employee adress:");
	address = input.nextLine();
	
	System.out.println("Input employee type: (hourly/commisioned/salaried):");
	type = input.nextLine();
	
	System.out.println("The employee wishes to join the Union? (y/n)");
	isSyndie = input.nextLine();

	System.out.println("The employee preferred payment method: (Mail/Bank/Hand)");
	payMethod = input.nextLine();
	
	
	if(type == "hourly")
	    {
		employeeList.add(new Hourly(id, name, address, type, isSyndie, payMethod, agendaList.get(1), 0));
	    }
	
	System.out.println("Input employee base Income:");
	income = input.nextDouble();
	
	if(type == "commisioned")
	    {
		System.out.println("Input employee percentage on sales revenue:");
		percentage = input.nextDouble();
		employeeList.add(new Commisioned(id, name, address, type, isSyndie, payMethod, null, income, percentage, 0));
	    }
	else
	    {
		employeeList.add(new Salaried(id, name, address, type, isSyndie, payMethod, agendaList.get(0), income));
	    }

	System.out.printf("Employee %s added, with ID = %d %n", employeeList.get(id).getEmployeeName(), id);
	id++;
    }
    // fun2
    public static void rmEmployee(int idAux)
    {
	employeeList.get(idAux).manageEmployee(9999, null, null, null, null, null);
	System.out.println("Employee PURGED");
    }

    // fun3
    public void launchPointCard(int idAux)
    {
	double init, end, tot;
	System.out.println("Input starting hour");
	init = input.nextDouble();
	System.out.println("Input ending hour");
	end = input.nextDouble();
	
	tot = end - init;
	
	((Hourly)employeeList.get(idAux)).setHours(tot);;
    }
    // fun4
    public void launchSaleRevenue()
    {
	
    }
    // fun5
    public void launchServiceCost()
    {
	
    }
    // fun6
    public static void newEditEmployee(int idAux)
    {
	String name, address, type, isSyndie, payMethod;
	double income, percentage;
	
	System.out.println("Input employee name:");
	name = input.nextLine();
	if( name == null)
	    {
		name = employeeList.get(idAux).getEmployeeName();
	    }

	
	System.out.println("Input employee adress:");
	address = input.nextLine();
	if(address == null)
	    {
		address = employeeList.get(idAux).getEmployeeAdress();
	    }
	System.out.println("Input employee type: (hourly/commisioned/salaried):");
	type = input.nextLine();

	System.out.println("The employee wishes to join the Union? (y/n)");
	isSyndie = input.nextLine();


	System.out.println("The employee preferred payment method: (Mail/Bank/Hand)");
	payMethod = input.nextLine();

	if(type != null)
	    {
		
		
		if(type == "hourly")
		    {
			((Hourly)employeeList.get(idAux)).manageEmployee(idAux, name, address, type, isSyndie, payMethod, agendaList.get(1), 0.0);
		    }
	
		System.out.println("Input employee base Income:");
		income = input.nextDouble();

		if(income == 0)
		    {
			income = ((Salaried)employeeList.get(idAux)).getIncome();
			
		    }
		
		if(type == "commisioned")
		    {
			System.out.println("Input employee base Income:");
			percentage = input.nextDouble();

			if(percentage == 0)
			    {
				percentage = ((Commisioned)employeeList.get(idAux)).getSalesPercentage();

			    }
			((Commisioned)employeeList.get(idAux)).manageEmployee(idAux, name, address, type, isSyndie, payMethod, agendaList.get(2), income, percentage, 0.0);
		    }
		else
		    {
			((Salaried)employeeList.get(idAux)).manageEmployee(idAux, name, address, type, isSyndie, payMethod, agendaList.get(0), income);
		    }
	    }	
    }

    // fun 10
    public void newAgenda()
    {
    }
    public void initAgendas()
    {

    }

    public static void main(String[] args)
    {
	agendaList.add(new Agenda(1, "Monthly", 0, 0));
	agendaList.add(new Agenda(5, "Weekly", 0, 0));
	agendaList.add(new Agenda(5, "Bimonthly", 2, 4));
	//employeeList.add(new Employee(0, "Jane Doe","Shonan Av. 1994", "Salaried", "y", "Mail", agendaList.get(0)));

	
	int operation, idAux;
	System.out.println("Operation");
	operation = input.nextInt();
	
 	if (operation == 1) {
	    newEmployee();
 	}
	if (operation == 2) {
	    System.out.println("Input Employee ID");
	    rmEmployee(idAux);
 	}
    }
	
}
