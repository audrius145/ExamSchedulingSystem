package model;

import java.util.ArrayList;

/**
 * Class representing an ArrayList of teachers.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class TeacherList
{
    private ArrayList<Teacher> teachers;

    /**
     * Zero argument constructor.
     * The constructor is used to create a new ArrayList for the teachers.
     */
    public TeacherList()
    {
        this.teachers = new ArrayList<>();
    }

    /**
     * Getting a Teacher object from the ArrayList that has a specific VIA ID.
     *
     * @param viaId the VIA ID of a teacher
     * @return Teacher object with the specified ID
     */
    public Teacher getTeacher(String viaId)
    {
        for (int i = 0; i < teachers.size(); i++)
        {
            if (teachers.get(i).getViaId().equals(viaId))
            {
                return teachers.get(i);
            }
        }
        return null;
    }

    /**
     * Adding a Teacher to the ArrayList of teachers.
     *
     * @param teacher Teacher object
     */
    public void add(Teacher teacher)
    {
        teachers.add(teacher);
    }

    /**
     * Returning how many teachers are in the ArrayList.
     *
     * @return size of the ArrayList as an integer
     */
    public int getNumberOfTeachers()
    {
        return teachers.size();
    }

    /**
     * Getting all of the teachers' information as a String.
     *
     * @return String with all of the teachers information
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < teachers.size(); i++)
        {
            s += teachers.get(i).toString();
            s += "\n";
        }
        return s;
    }
}
