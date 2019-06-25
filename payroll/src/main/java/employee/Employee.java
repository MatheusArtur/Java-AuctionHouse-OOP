package employee;
import employee.syndie.*;
import employee.payment.*;
import employee.pcard.*;
import employee.types.*;
import employee.types.Salaried;
import agenda;

public abstract class Employee implements EmployeeUtils
{
    private int employeeID;
    private String employeeName;
    private String employeeAdress;
    protected Syndie infoSyndie;
    protected Payment infoPayment;
    protected Agenda infoAgenda;
    
    public void addEmployee(String[] name, String[] adress, String[] type, char syndie, String[] payment)
    {
	this.infoSalaried = Salaried.addEmployee(name, adress, type, syndie, payment, 2.2);
    }

    public void addEmployee(int id, String[] name, String[] adress, String[] type, char syndie, String[] payment)
    {
	//TODO
    }
}
