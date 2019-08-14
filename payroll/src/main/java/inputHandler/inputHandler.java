package inputHandler;
import app.*;

public class inputHandler
{

    public static int catchInt(String required)
    {
	while(true)
	    {
		try
		    {
			System.out.printf(required);
			return Integer.parseInt(App.input.nextLine());
		    } catch(NumberFormatException e)
		    {
			System.out.println("ERROR: Add a numeric Value");
		    }
	    }
    }
    
    public static double catchDouble(String required)
    {
	while(true)
	    {
		try
		    {
			System.out.print(required);
			return Double.parseDouble(App.input.nextLine());
		    }
		catch(NumberFormatException e)
		    {
			System.out.println("ERROR: Add a numeric Value");
		    }
	    }
    }

    public static String catchEmployeeType(String str)
    {
	String var;
	while(true)
	    {
		System.out.print(str);
		var = App.input.nextLine();
		if((var.equals("Hourly") | var.equals("Commisioned") | var.equals("Salaried")) == false)
		    {
			System.out.println("Invalid employee type");
		    }
		else
		    {
			return var;
		    }
	    }
    }

    public static String catchSyndie(String str)
    {
	String var;
	while(true)
	    {
		System.out.print(str);
		var = App.input.nextLine();
		if((var.equals("y") | var.equals("n")) == false)
		    {
			System.out.println("Invalid option");
		    }
		else
		    {
			return var;
		    }
	    }
    }

    public static String catchPayType(String str)
    {
	String var;
	while(true)
	    {
		System.out.print(str);
		var = App.input.nextLine();
		if((var.equals("Mail") | var.equals("Bank") | var.equals("Hand")) == false)
		    {
			System.out.println("Invalid option");
		    }
		else
		    {
			return var;
		    }
	    }
    }

    public static String catchPeriodType(String str)
    {
	String var;
	while(true)
	    {
		System.out.print(str);
		var = App.input.nextLine();
		if((var.equals("Monthly") | var.equals("Bimonthly") | var.equals("Weekly")) == false)
		    {
			System.out.println("Invalid option");
		    }
		else
		    {
			return var;
		    }
	    }
    }

    public static int catchEmployee(String required, int size)
    {
	int pas;
	while(true)
	    {
		try
		    {
			System.out.printf(required);
			pas = Integer.parseInt(App.input.nextLine());
			if(pas > size-1)
			    {
				System.out.println("ERROR: Employee does not exists");
			    }
			else
			    {
				return pas;
			    }
		    } catch(NumberFormatException e)
		    {
			System.out.println("ERROR: Add a numeric Value");
		    }
	    }
    }
}
