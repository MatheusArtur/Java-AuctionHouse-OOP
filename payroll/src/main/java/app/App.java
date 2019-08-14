package app;
import java.util.ArrayList;
import employee.*;
import employee.types.Commisioned;
import employee.types.Hourly;
import employee.types.Salaried;
import agenda.*;
import java.util.Calendar;
import java.util.Scanner;
import memento.*;
import inputHandler.*;

public class App
{
    private static final ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private static final ArrayList<Agenda> agendaList = new ArrayList<Agenda>();
    public static Calendar c = Calendar.getInstance();
    public static int lastPayroll = c.get(Calendar.DAY_OF_YEAR) - 1;
    public static int id = 0;
    public static int plan= 2;
    public static Scanner input = new Scanner(System.in);
    public static final Memento status = new Memento();
    


    // fun1
    public static void newEmployee()
    {
	String name, address, type, isSyndie, payMethod;
	double income, percentage, perhour;
	
	System.out.print("Input employee name:");
	name = input.nextLine();
	
	System.out.print("Input employee adress:");
	address = input.nextLine();
	
	type = inputHandler.catchEmployeeType("Input employee type: (Hourly/Commisioned/Salaried):");
	
	isSyndie = inputHandler.catchSyndie("The employee wishes to join the Union? (y/n):");

	payMethod = inputHandler.catchPayType("The employee preferred payment method: (Mail/Bank/Hand):");
	
	
	if(type.equals("Hourly"))
	    {
		perhour = inputHandler.catchDouble("Input employee Hourly Salary:");
		employeeList.add(new Hourly(id, name, address, type, isSyndie, payMethod, agendaList.get(1), 0, perhour));
	    }
	
	else if(type.equals("Commisioned"))
	    {
		income = inputHandler.catchDouble("Input employee base Income:");
		percentage = inputHandler.catchDouble("Input employee percentage on sales revenue:");
		employeeList.add(new Commisioned(id, name, address, type, isSyndie, payMethod, null, income, percentage, 0));
	    }
	else
	    {
		income = inputHandler.catchDouble("Input employee base Income:");
		employeeList.add(new Salaried(id, name, address, type, isSyndie, payMethod, agendaList.get(0), income));
	    }

	System.out.printf("Employee %s added, with ID = %d %n", employeeList.get(id).getEmployeeName(), id);
	id++;
    }
    // fun2
    public static void rmEmployee(int idAux)
    {
	employeeList.remove(idAux);
	System.out.println("Employee PURGED");
    }

    // fun3
    public static void launchPointCard(int idAux)
    {
	double init, end, tot;
	init = inputHandler.catchDouble("Input starting hour:");
	end = inputHandler.catchDouble("Input ending hour:");
	
	tot = end - init;
	
	((Hourly)employeeList.get(idAux)).setWeeklyHours(tot);
    }
    // fun4
    public static void launchSaleRevenue(int idAux)
    {
	double pricing;
	pricing = inputHandler.catchDouble("Add sale pricing:");
	((Commisioned)employeeList.get(idAux)).setSalesRevenue(pricing);
    }
    // fun5
    public static void launchServiceCost(int idAux)
    {
	double pricing;
	System.out.println();
	pricing = inputHandler.catchDouble("Add Union service fee:");

	employeeList.get(idAux).setService(pricing);
    }
    // fun6
    public static void newEditEmployee(int idAux)
    {
	String name, address, type, isSyndie, payMethod;
	double income, percentage, perhour;
	
	System.out.printf("You are now editing Employee %s%n", employeeList.get(idAux).getEmployeeName());
	
	System.out.print("Input employee name:");
	name = input.nextLine();

	System.out.print("Input employee adress:");
	address = input.nextLine();
	
	type = inputHandler.catchEmployeeType("Input employee type: (Hourly/Commisioned/Salaried):");

	isSyndie = inputHandler.catchSyndie("The employee wishes to join or update Union information? (y/n):");

	payMethod = inputHandler.catchPayType("The employee preferred payment method: (Mail/Bank/Hand):");

	if(type.equals("Hourly"))
	    {
		perhour = inputHandler.catchDouble("Input employee Hourly Salary:");
		employeeList.remove(idAux);
		employeeList.add(idAux, new Hourly(idAux, name, address, type, isSyndie, payMethod, agendaList.get(1), 0, perhour));
	    }
	
	else if(type.equals("Commissioned"))
	    {
		income = inputHandler.catchDouble("Input employee base Income:");
		percentage = inputHandler.catchDouble("Input employee percentage on sales:");
		employeeList.remove(idAux);
		employeeList.add(idAux, new Commisioned(idAux, name, address, type, isSyndie, payMethod, agendaList.get(2), income, percentage, 0.0));

	    }
	else
	    {
		income = inputHandler.catchDouble("Input employee base Income:");
		employeeList.remove(idAux);
		employeeList.add(idAux, new Salaried(idAux, name, address, type, isSyndie, payMethod, agendaList.get(0), income));
	    }
    }

    // fun 10
    public static void newAgenda()
    {
	String ty;
	int f, s, day;
	ty = inputHandler.catchPeriodType("Input type: (Monthly/Weekly/Bimonthly):");
	
	if(ty.equals("Monthly"))
	    {
		day = inputHandler.catchInt("Input day of the Month (1-31):");
		agendaList.add(new Agenda(day, ty, 0, 0));
	    }
	else if(ty.equals("Weekly"))
	    {
		System.out.println("Monday=1 | Tuesday=2 | Wendsday=3 | Thursday=4 | Friday=5 | Saturday=6 | Sunday=7");
		day = inputHandler.catchInt("Input day of the Week::");
		agendaList.add(new Agenda(day, ty, 0, 0));
	    }
	else
	    {
		System.out.println("Monday=1 | Tuesday=2 | Wendsday=3 | Thursday=4 | Friday=5 | Saturday=6 | Sunday=7");
		day = inputHandler.catchInt("Input day of the Week::");
		f = inputHandler.catchInt("Input first Week : (1-4)");
		s = inputHandler.catchInt("Input second Week : (first Week-4)");
		agendaList.add(new Agenda(day, ty, f, s));
	    }
	plan++;
	System.out.printf("The created Agenda is the number %d; you can now assign existing employees to it%n", plan);
    }

    public static void assignAgenda(int idAux)
    {
	int newAgendaIndex;
	newAgendaIndex = inputHandler.catchInt("Please input the new Agenda index you wish to assign to the employee");
	employeeList.get(idAux).setInfoAgenda(agendaList.get(newAgendaIndex));
    }

    public static void runPayroll()
    {
	Agenda tmp;
	int greatday;
	String pantsu;
	for(Employee emp: employeeList)
	    {
		tmp = emp.getInfoAgenda();
		pantsu = tmp.getCicle();
		if(pantsu.equals("Monthly"))
		    {
			if(tmp.getDay() == c.get(Calendar.DAY_OF_MONTH))
			    {
				System.out.printf("%n PAID %lf %n",((Salaried)emp).getIncome());
			    }
		    }
		else if(pantsu.equals("Weekly"))
		    {
			if(tmp.getDay() == c.get(Calendar.DAY_OF_WEEK))
			    {
				if(((Hourly)emp).getWeeklyHours() > 8.0)
				    {
					System.out.printf("%n PAID %lf %n",(((Hourly)emp).getWeeklyHours() * ((Hourly)emp).getPerhour()) * 1.5);					
				    }
				else
				    {
					System.out.printf("%n PAID %lf %n",(((Hourly)emp).getWeeklyHours() * ((Hourly)emp).getPerhour()) * 1.0);					
				    }

			    }
		    }
		else
		    {
			if(tmp.getDay() == c.get(Calendar.DAY_OF_WEEK))
			    {
				greatday = c.get(Calendar.DAY_OF_MONTH);
				if(greatday >= 1 && greatday <= 7 && tmp.getFirstWeek() == 1){
				    System.out.printf("%n PAID %lf %n",((((Commisioned)emp).getIncome()/2))+(((Commisioned)emp).getSalesRevenue()*(((Commisioned)emp).getSalesPercentage() /10)));					
				}
				else if(greatday >= 8 && greatday <= 14 && tmp.getFirstWeek() == 2 || tmp.getSecondWeek() == 2){
				    System.out.printf("%n PAID %lf %n",((((Commisioned)emp).getIncome()/2))+(((Commisioned)emp).getSalesRevenue()*(((Commisioned)emp).getSalesPercentage() /10)));					
				}
				else if(greatday >= 15 && greatday <= 21 && tmp.getFirstWeek() == 3 || tmp.getSecondWeek() == 3){
				    System.out.printf("%n PAID %lf %n",((((Commisioned)emp).getIncome()/2))+(((Commisioned)emp).getSalesRevenue()*(((Commisioned)emp).getSalesPercentage() /10)));					
				}
				else if(greatday >= 22 && greatday <= 31 && tmp.getSecondWeek() == 4){
				    System.out.printf("%n PAID %lf %n",((((Commisioned)emp).getIncome()/2))+(((Commisioned)emp).getSalesRevenue()*(((Commisioned)emp).getSalesPercentage() /10)));					
				}
			    }
		    }
	    }
    }

    public static void main(String[] args)
    {
	agendaList.add(new Agenda(1, "Monthly", 0, 0));
	agendaList.add(new Agenda(5, "Weekly", 0, 0));
	agendaList.add(new Agenda(5, "Bimonthly", 2, 4));
	//employeeList.add(new Employee(0, "Jane Doe","Shonan Av. 1994", "Salaried", "y", "Mail", agendaList.get(0)));
	int operation, idAux, size;
	boolean loop = true;
	while (loop) {
	    idAux = 9999;
	    System.out.println("Wecolme to the Payroll System, please select your operation:");
	    operation = inputHandler.catchInt("0- Quit%n1- Add Employee%n2- Remove Employee%n3- Lauch PointCard%n4- Add a sale Revenue%n5- Add a Union service cost%n6- Edit an employee%n7- Create a new Payroll agenda%n8- Edit an created employee Agenda%n9- Run Payroll%n");
	    size = employeeList.size();
	    if (operation == 0) {
		return;
	    } else if (operation == 1) {
		newEmployee();
	    } else if (operation == 2) {
		idAux = inputHandler.catchEmployee("Input Employee ID: ", size);
		rmEmployee(idAux);
	    } else if (operation == 3) {
		idAux = inputHandler.catchEmployee("Input Employee ID: ", size);
		launchPointCard(idAux);
	    } else if (operation == 4) {
		idAux = inputHandler.catchEmployee("Input Employee ID: ", size);
		launchSaleRevenue(idAux);
	    } else if (operation == 5) {
		idAux = inputHandler.catchEmployee("Input Employee ID: ", size);
		launchServiceCost(idAux);
	    } else if (operation == 6) {
		idAux = inputHandler.catchEmployee("Input Employee ID: ", size);
		newEditEmployee(idAux);
	    } else if (operation == 7) {
		newAgenda();
	    } else if (operation == 8) {
		idAux = inputHandler.catchEmployee("Input Employee ID: ", size);
		assignAgenda(idAux);
	    } else if (operation == 9) {
		runPayroll();
	    } else {
		System.out.printf("Value out of Range%n");
	    }
	}
    }
}
