package employee;
import agenda.*;
import inputHandler.inputHandler;

public class Employee implements EmployeeUtils
{
    private int employeeID;
    private String employeeName;
    private String employeeAdress;
    public Syndie infoSyndie = new Syndie(0, 0);
    protected Payment infoPayment = new Payment(9999, 9999, 9999, "Dummy");
    protected Agenda infoAgenda;
    
    public Employee(int id, String name, String adress, String type, String syndie, String payment, Agenda payday)
    {
	setBasicInfo(id, name, adress);
	setSyndieInfo(syndie);
	setPaymentInfo(payment);
	this.infoAgenda = payday;
    }

    public void manageEmployee(int id, String name, String adress, String type, String syndie, String payment)
    {
	setBasicInfo(id, name, adress);
	setSyndieInfo(syndie);
	setPaymentInfo(payment);
    }
    
    public void setInfoAgenda(Agenda infoAgenda) {
	this.infoAgenda = infoAgenda;
    }

    public void setBasicInfo(int id, String name, String adress)
    {
	this.employeeID = id;
	this.employeeName = name;
	this.employeeAdress = adress;	
    }

    public void setSyndieInfo(String syndie)
    {
	double unionFee;
	if (syndie.equals("y"))
	    {
		unionFee = inputHandler.catchDouble("Input Union Monthly fee:");
		this.infoSyndie.manageSyndie(unionFee, 0.0);
	    }
	else
	    {
		this.infoSyndie.manageSyndie(0.0, 0.0);
	    }

    }
    
    public void setPaymentInfo(String payment)
    {
	int employeeAccount, employeeAgency, employeeZip;
	employeeAccount = -1;
	employeeAgency = -1;
	employeeZip = -1;

	if(payment.equals("Mail"))
	    {
		employeeZip = inputHandler.catchInt("Input Employee zip code:");	
	    }
	else if(payment.equals("Bank"))
	    {
		employeeAgency = inputHandler.catchInt("Input Employee Bank account agency:");
		employeeAccount = inputHandler.catchInt("Input Employee Bank account number:");		    
	    }
	this.infoPayment.managePayment(employeeAgency, employeeAccount, employeeZip, payment);
    }

    public String getEmployeeName()
    {
	return employeeName;
    }
    
    public Agenda getInfoAgenda()
    {
	return infoAgenda;
    }
}

