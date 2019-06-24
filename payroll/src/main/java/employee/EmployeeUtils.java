package employee;

public interface EmployeeUtils
{
    /* Name, Adress, Type, is Syndie, Payment type */
    void addEmployee(String[], String[], String[], char , String[]);

    /* Id, Name, Adress, Type, is Syndie, Payment type */
    /* Edit all function. Leave field blank to not make edits*/
    void editEmployee(int, String[], String[], String[], char, String[]);
}
