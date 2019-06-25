package employee.payment;

public class Payment 
{
    protected String payMethod;
    
    protected int zipCode;
    
    protected int agencyNumber;
    protected int accountNumber;

    public void setBankAccount(int agcn, int accn)
    {
	this.accountNumber = accn;
	this.agencyNumber = agcn;
    }
    public int getAccountNumber()
    {
	return (this.accountNumber);
    }
    public int getAgencyNumber()
    {
	return (this.agencyNumber);
    }
    
    public void setZipcode(int zippo)
    {
	this.zipCode = zippo;
    }
    public int getZipcode()
    {
	return (this.zipCode);
    }

    
}
