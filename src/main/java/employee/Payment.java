package employee;

public class Payment
{
    protected String payMethod;
    protected int zipCode;
    protected int agencyNumber;
    protected int accountNumber;

    Payment(int agency, int account, int zip, String method)
    {
	this.agencyNumber = agency;
	this.accountNumber = account;
	this.zipCode = zip;
	this.payMethod = method;
    }

    public void managePayment(int agency, int account, int zip, String method)
    {
	this.agencyNumber = agency;
	this.accountNumber = account;
	this.zipCode = zip;
	this.payMethod = method;
    }

    public String getPayMethod()
    {
	return payMethod;
    }

    public int getZipCode()
    {
	return zipCode;
    }

    public int getAgencyNumber()
    {
	return agencyNumber;
    }

    public int getAccountNumber()
    {
	return accountNumber;
    }
}
