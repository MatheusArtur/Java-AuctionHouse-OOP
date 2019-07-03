package error;

public class Error
{
    public static boolean isNullOrEmpty(String str)
    {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
}
