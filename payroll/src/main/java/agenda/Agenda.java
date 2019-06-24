package agenda;
import java.util.Calendar;
import java.util.Scanner;

public class Agenda
{
    private static int day;
    private static int month;
    private static int cicle;
    
    public static void testing()
    {
        Calendar c = Calendar.getInstance();
        System.out.println("The Curlrent Date is:" + c.getTime());
	Scanner input = new Scanner(System.in);
	
	cicle = c.get(Calendar.DAY_OF_YEAR);
	month = c.get(Calendar.MONTH);
	day = c.get(Calendar.DAY_OF_MONTH);
	

	System.out.printf("day = %d month = %d, cicle = %d", day, month, cicle, null);
	int teste = input.nextInt();
	System.out.printf("day = %d month = %d, cicle = %d %d", day, month, cicle, teste, null);
    }
}
