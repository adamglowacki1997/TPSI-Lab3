package lab2;

public class Teacher extends Person
{
    public Teacher(String firstName, String lastName, String emailAddress, String courseName)
    {
        super(firstName,lastName,emailAddress);
        this.courseName = courseName;
    }
    private String courseName;
    public String getCourseName()
    {
        return courseName;
    }
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }
}
