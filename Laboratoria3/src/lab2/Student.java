package lab2;

import java.util.ArrayList;
import java.util.List;


public class Student extends Person
{
    public Student(String firstName, String lastName, String emailAddress, String groupId)
    {
        super(firstName,lastName,emailAddress);
        this.groupId = groupId;
    }
    private String groupId;
    public String getGroupId()
    {
        return groupId;
    }
    public void setGroupId(String groupId)
    {
        this.groupId = groupId;
    }
    private List<Double> grades = new ArrayList<>();
    public List<Double> getGrades()
    {
        return grades;
    }
    public void addGrade(double grade)
    {
        grades.add(grade);
    }
    public double getGradesAverage()
    {
        double average = 0;
        for(int i=0;i<grades.size();i++) 
        {
            average+=grades.get(i);
        }
        average=average/grades.size();
        return average;
    }
}
