package lab2;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements EmailRecipient 
{
    private String emailAddress;
    private List<Teacher> teachers = new ArrayList<>();
    public List<Teacher> getTeachers()
    {
        return teachers;
    }
    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }
    @Override
    public String getEmailAddress() 
    {
        return emailAddress;
    }

}
