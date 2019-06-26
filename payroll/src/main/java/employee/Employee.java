package employee;
import agenda.*;
import employee.*;
import java.util.Scanner;

public class Employee implements EmployeeUtils
{
    private int employeeID;
    private String employeeName;
    private String employeeAdress;
    protected Syndie infoSyndie = new Syndie(0, 0);
    protected Payment infoPayment = new Payment(9999, 9999, 9999, "Dummy");
    protected Agenda infoAgenda;
    protected String Synd;
    protected String Pay;
    
    
    Scanner input = new Scanner(System.in);
    
    public Employee(int id, String name, String adress, String type, String syndie, String payment, Agenda payday)
    {
	int unionFee, unionService, employeeAccount, employeeAgency, employeeZip;
	    
	this.employeeID = id;
	this.employeeName = name;
	this.employeeAdress = adress;
	this.infoAgenda = payday;
	this.Pay = payment;
	
	if (syndie == "y") {
	    System.out.println("Input Union Monthly fee:");
	    unionFee = input.nextInt();
	    System.out.println("Input Union Service fee:");
	    unionService = input.nextInt();
	    this.infoSyndie.manageSyndie(unionFee, unionService);
	}
	else
	    {
		this.infoSyndie = null;
	    }
	
	System.out.println("Input Employee Bank account agency:");
	employeeAgency = input.nextInt();
	System.out.println("Input Employee Bank account number:");
	employeeAccount = input.nextInt();
	System.out.println("Input Employee zip code:");
	employeeZip = input.nextInt();
	this.infoPayment.managePayment(employeeAgency, employeeAccount, employeeZip, payment);
    }

    public void manageEmployee(int id, String name, String adress, String type, String syndie, String payment)
    {
	int unionFee, unionService, employeeAccount, employeeAgency, employeeZip;
	    
	this.employeeID = id;
	this.employeeName = name;
	this.employeeAdress = adress;
	
	if (syndie == "y") {
	    System.out.println("Input Union Monthly fee:");
	    unionFee = input.nextInt();
	    System.out.println("Input Union Service fee:");
	    unionService = input.nextInt();
	    infoSyndie.manageSyndie(unionFee, unionService);
	}
	
	if(payment != null)
		{
		    System.out.println("Input Employee Bank account agency:");
		    employeeAgency = input.nextInt();
		    System.out.println("Input Employee Bank account number:");
		    employeeAccount = input.nextInt();
		    System.out.println("Input Employee zip code:");
		    employeeZip = input.nextInt();
		    infoPayment.managePayment(employeeAgency, employeeAccount, employeeZip, payment);		    
		}
    }

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAdress() {
		return employeeAdress;
	}

	public void setEmployeeAdress(String employeeAdress) {
		this.employeeAdress = employeeAdress;
	}

	public Syndie getInfoSyndie() {
		return infoSyndie;
	}

	public void setInfoSyndie(Syndie infoSyndie) {
		this.infoSyndie = infoSyndie;
	}

	public Payment getInfoPayment() {
		return infoPayment;
	}

	public void setInfoPayment(Payment infoPayment) {
		this.infoPayment = infoPayment;
	}

	public Agenda getInfoAgenda() {
		return infoAgenda;
	}

	public void setInfoAgenda(Agenda infoAgenda) {
		this.infoAgenda = infoAgenda;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
}

