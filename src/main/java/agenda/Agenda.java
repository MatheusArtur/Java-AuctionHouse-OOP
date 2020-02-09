package agenda;
import java.util.Calendar;
import java.util.Scanner;

public class Agenda
{
    private int day;
    private String cicle;
    private int firstWeek;
    private int secondWeek;

    public Agenda (int date, String period, int fWeek, int sWeek)
    {
	this.cicle = period;
	this.day = date;
    }

    public void addAgenda(int date, String period, int fWeek, int sWeek)
    {
	this.cicle = period;
	this.day = date;
	this.firstWeek = fWeek;
	this.secondWeek = sWeek;
    }

    public int getDay() {
	return day;
    }
    public String getCicle() {
	return cicle;
    }
    public int getFirstWeek() {
	return firstWeek;
    }
    public int getSecondWeek() {
	return secondWeek;
    }
}
