package employee;
import agenda.*;
import inputHandler.inputHandler;

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
    
    public static boolean isNullOrEmpty(String str)
    {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
    
    public Employee(int id, String name, String adress, String type, String syndie, String payment, Agenda payday)
    {
	int employeeAccount, employeeAgency, employeeZip;
	double unionFee;
	
	this.employeeID = id;
	this.employeeName = name;
	this.employeeAdress = adress;
	this.infoAgenda = payday;
	this.Pay = payment;
	
	if (syndie.equals("y")) {
	    unionFee = inputHandler.catchDouble("Input Union Monthly fee:");
	    this.infoSyndie.manageSyndie(unionFee, 0);
	}
	else
	    {
		this.infoSyndie = null;
	    }
	
	employeeAgency = inputHandler.catchInt("Input Employee Bank account agency:");
	employeeAccount = inputHandler.catchInt("Input Employee Bank account number:");
	employeeZip = inputHandler.catchInt("Input Employee zip code:");
	this.infoPayment.managePayment(employeeAgency, employeeAccount, employeeZip, payment);
    }

    public void manageEmployee(int id, String name, String adress, String type, String syndie, String payment)
    {
	int employeeAccount, employeeAgency, employeeZip;
	double unionFee, unionService;
	
	this.employeeID = id;
	this.employeeName = name;
	this.employeeAdress = adress;
	
	if (syndie.equals("y")) {
	    unionFee = inputHandler.catchDouble("Input Union Monthly fee:");
	    unionService = inputHandler.catchDouble("Input Union Service fee:");
	    infoSyndie.manageSyndie(unionFee, unionService);
	}
	
	if(!isNullOrEmpty(payment))
	    {
		employeeAgency = inputHandler.catchInt("Input Employee Bank account agency:");
		employeeAccount = inputHandler.catchInt("Input Employee Bank account number:");
		employeeZip = inputHandler.catchInt("Input Employee zip code:");
		infoPayment.managePayment(employeeAgency, employeeAccount, employeeZip, payment);		    
	    }
    }

    public void setService(double price)
    {
	this.infoSyndie.setServiceTax(price);
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
}

