package agenda;
import java.util.Calendar;
import java.util.Scanner;

public class Agenda
{
    private int day;
    private String cicle;
    private Pair<Integer, Integer> bimensalWeeks;
    
    public Agenda addAgenda(int date, String period, int firstWeek, int secondWeek)
    {
	this.cicle = period;
	this.day = date;
	this.bimensalWeeks = new Pair<>(firstWeek, secondWeek);
    }
}
