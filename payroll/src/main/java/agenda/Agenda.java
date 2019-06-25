package agenda;
import java.util.Calendar;
import java.util.Scanner;

public class Agenda
{
    private int cicle;
    private int day;

    //cicle = 0 [monthly], 2 [bi], 2 [weekly]

    public void newAgenda(int date, int period)
    {
	this.cicle = period;
	this.day = date;
    }
    
    // public void testing()
    // {
    //     Calendar c = Calendar.getInstance();
    //     System.out.println("The Curlrent Date is:" + c.getTime());
    // 	Scanner input = new Scanner(System.in);
	
    // 	this.cicle = c.get(Calendar.DAY_OF_YEAR);
    // 	this.month = c.get(Calendar.MONTH);
    // 	this.day = c.get(Calendar.DAY_OF_MONTH);
	

    // 	System.out.printf("day = %d month = %d, cicle = %d", day, month, cicle, null);
    // 	int teste = input.nextInt();
    // 	System.out.printf("day = %d month = %d, cicle = %d %d", day, month, cicle, teste, null);
    // }
}
