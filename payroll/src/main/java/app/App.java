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
    public static int plan= 2;
    public static Scanner input = new Scanner(System.in);
    
    public static boolean isNullOrEmpty(String str)
    {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

    // fun1
    public static void newEmployee()
    {
	String name, address, type, isSyndie, payMethod;
	double income, percentage, perhour;
	name = input.nextLine();
	System.out.println("Input employee name:");
	name = input.nextLine();
	
	System.out.println("Input employee adress:");
	address = input.nextLine();
	
	System.out.println("Input employee type: (Hourly/Commisioned/Salaried):");
	type = input.nextLine();
	
	System.out.println("The employee wishes to join the Union? (y/n)");
	isSyndie = input.nextLine();

	System.out.println("The employee preferred payment method: (Mail/Bank/Hand)");
	payMethod = input.nextLine();
	
	
	if(type.equals("Hourly"))
	    {
		System.out.println("Input employee Hourly Salary:");
		perhour = input.nextDouble();
		employeeList.add(new Hourly(id, name, address, type, isSyndie, payMethod, agendaList.get(1), 0, perhour));
	    }
	
	else if(type.equals("Commisioned"))
	    {
		System.out.println("Input employee base Income:");
		income = input.nextDouble();
		System.out.println("Input employee percentage on sales revenue:");
		percentage = input.nextDouble();
		employeeList.add(new Commisioned(id, name, address, type, isSyndie, payMethod, null, income, percentage, 0));
	    }
	else
	    {
		System.out.println("Input employee base Income:");
		income = input.nextDouble();
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
	System.out.println("Input starting hour:");
	init = input.nextDouble();
	System.out.println("Input ending hour:");
	end = input.nextDouble();
	
	tot = end - init;
	
	((Hourly)employeeList.get(idAux)).setHours(tot);;
    }
    // fun4
    public static void launchSaleRevenue(int idAux)
    {
	System.out.println("Add sale pricing:");
	double pricing;
	pricing = input.nextDouble();
	((Commisioned)employeeList.get(idAux)).setSalesRevenue(pricing);

	
    }
    // fun5
    public static void launchServiceCost(int idAux)
    {
	double pricing;
	System.out.println("Add Union service fee:");
	pricing = input.nextDouble();

	employeeList.get(idAux).setService(pricing);
    }
    // fun6
    public static void newEditEmployee(int idAux)
    {
	String name, address, type, isSyndie, payMethod;
	double income, percentage, perhour;
	
	System.out.printf("You are noew editing Employee %s%n", employeeList.get(idAux).getEmployeeName());
	System.out.println("WARNING:");
	System.out.println("Make sure to leave the field blank if you don't want to change it");
	
	name = input.nextLine();
	System.out.println("Input employee name:");
	name = input.nextLine();
	
	if(isNullOrEmpty(name))
	    {
		name = employeeList.get(idAux).getEmployeeName();		
	    }

	System.out.println("Input employee adress:");
	address = input.nextLine();
	
	if(isNullOrEmpty(address))
	    {
		address = employeeList.get(idAux).getEmployeeAdress();
	    }
	
	System.out.println("Input employee type: (Hourly/Commisioned/Salaried):");
	type = input.nextLine();


	System.out.println("The employee wishes to join or update Union information? (y/n)");
	isSyndie = input.nextLine();

	System.out.println("The employee preferred payment method: (Mail/Bank/Hand)");
	payMethod = input.nextLine();

	if(type.equals("Hourly"))
	    {
		System.out.println("Input employee Hourly Salary:");
		perhour = input.nextDouble();
		employeeList.remove(idAux);
		employeeList.set(idAux, new Hourly(idAux, name, address, type, isSyndie, payMethod, agendaList.get(1), 0.0, perhour));
	    }
	
	else if(type.equals("Commissioned"))
	    {
		System.out.println("Input employee base Income:");
		income = input.nextDouble();

		System.out.println("Input employee percentage on sales:");
		percentage = input.nextDouble();
		
		employeeList.remove(idAux);
		employeeList.set(idAux, new Commisioned(idAux, name, address, type, isSyndie, payMethod, agendaList.get(2), income, percentage, 0.0));

	    }
	else if(type.equals("Salaried"))
	    {
		System.out.println("Input employee base Income:");
		income = input.nextDouble();
		employeeList.remove(idAux);
		employeeList.set(idAux, new Salaried(idAux, name, address, type, isSyndie, payMethod, agendaList.get(0), income));
	    }
	else if(isNullOrEmpty(type))
	    {
		((Employee)employeeList.get(idAux)).manageEmployee(idAux, name, address, type, isSyndie, payMethod);
	    }
	else
	    {
		System.out.printf("Invalid Employee Type, ABORTED %n");
		return ;
	    }
    }

    // fun 10
    public static void newAgenda()
    {
	String ty;
	int f, s, day;
	ty = input.nextLine();
	System.out.println("Input type: (Monthly/Weekly/Bimonthly):");
	ty = input.nextLine();
	
	if(ty.equals("Monthly"))
	    {
		System.out.println("Input day of the Month (1-31):");
		day = input.nextInt();
		agendaList.add(new Agenda(day, ty, 0, 0));
	    }
	else if(ty.equals("Weekly"))
	    {
		System.out.println("Monday=1 | Tuesday=2 | Wendsday=3 | Thursday=4 | Friday=5 | Saturday=6 | Sunday=7");
		System.out.println("Input day of the Week::");
		day = input.nextInt();
		agendaList.add(new Agenda(day, ty, 0, 0));
	    }
	else
	    {
		System.out.println("Monday=1 | Tuesday=2 | Wendsday=3 | Thursday=4 | Friday=5 | Saturday=6 | Sunday=7");
		System.out.println("Input day of the Week::");
		day = input.nextInt();
		System.out.println("Input first Week : (1-4)");
		f = input.nextInt();
		System.out.println("Input second Week : (first Week-4)");
		s = input.nextInt();
		agendaList.add(new Agenda(day, ty, f, s));
	    }
	plan++;
	System.out.printf("The created Agenda is the number %d; you can now assign existing employees to it%n", plan);
    }

    public static void assignAgenda(int idAux)
    {
	int newAgendaIndex;
	System.out.println("Please input the new Agenda index you wish to assign to the employee");
	newAgendaIndex = input.nextInt();
	employeeList.get(idAux).setInfoAgenda(agendaList.get(newAgendaIndex));
    }

    public static void runPayroll()
    {
	Agenda tmp;
	inr greatday;
	for(Employee emp: employeeList)
	    {
		tmp = emp.getInfoAgenda();
		emp.getClass();
		if(tmp.getCicle().equals("Monthly"))
		    {
			if(tmp.getDay() == c.get(Calendar.DAY_OF_MONTH))
				{
				    System.out.printf("%n PAID %lf %n",((Salaried)emp).getIncome());
				}
		    }
		else if(tmp.getCicle().equals("Weekly"))
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
	int operation, idAux;
	boolean loop = true;

	while(loop)
	    {
		idAux = 9999;
		System.out.println("Wecolme to the Payroll System, please select your operation:");
		System.out.printf("0- Quit%n1- Add Employee%n2- Remove Employee%n3- Lauch PointCard%n4- Add a sale Revenue%n5- Add a Union service cost%n6- Edit an employee%n7- Create a new Payroll agenda%n8- Edit an created employee Agenda%n9- Run Payroll%n");
		operation = input.nextInt();

		
		if (operation == 0) {
		    return ;
		}
		if (operation == 1) {
		    newEmployee();
		}
		else if (operation == 2) {
		    System.out.println("Input Employee ID:");
		    idAux = input.nextInt();
		    rmEmployee(idAux);
		}
		else if (operation == 3) {
		    System.out.println("Input Employee ID:");
		    idAux = input.nextInt();
		    launchPointCard(idAux);
		}
		else if (operation == 4) {
		    System.out.println("Input Employee ID:");
		    idAux = input.nextInt();
		    launchSaleRevenue(idAux);
		}
		else if (operation == 5) {
		    System.out.println("Input Employee ID:");
		    idAux = input.nextInt();
		    launchServiceCost(idAux);
		}
		else if (operation == 6) {
		    System.out.println("Input Employee ID:");
		    idAux = input.nextInt();
		    newEditEmployee(idAux);
		}
		else if (operation == 7) {
		    newAgenda();
		}
		else if (operation == 8) {
		    System.out.println("Input Employee ID:");
		    idAux = input.nextInt();
		    assignAgenda(idAux);
		}
		else if (operation == 9) {
		    runPayroll();
		}
		else{
		    System.out.printf("Invalid%n");
		}
	    }
    }
	
}
