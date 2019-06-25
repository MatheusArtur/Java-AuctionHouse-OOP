package employee;
import employee.syndie.*;
import employee.payment.*;
import employee.pcard.*;
import employee.types.*;
import agenda.*;

public class Employee implements EmployeeUtils
{
    private int employeeID;
    private String employeeName;
    private String employeeAdress;
    protected Syndie infoSyndie;
    protected Payment infoPayment; 
    protected Agenda infoAgenda;

    public Employee(String name, String adress, String type, char syndie, String payment)
    {

    }

    public void manageEmployee(String name, String adress, String type, char syndie, String payment)
    {
	
    }
}
