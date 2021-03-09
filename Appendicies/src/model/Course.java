package model;

import java.util.ArrayList;

/**
 * Class representing a course.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class Course
{
    private String courseName;
    private Teacher teacher;
    private boolean isScheduled;


    /**
     * Two-argument constructor.
     * The instance variables are initialized.
     *
     * @param courseName the course's name
     * @param teacher the course's teacher
     */
    public Course(String courseName, Teacher teacher)
    {
        this.courseName = courseName;
        this.teacher = teacher;
        this.isScheduled = false;
    }

    /**
     * Returning the courseName variable.
     *
     * @return the courseName variable.
     */
    public String getCourseName()
    {
        return courseName;
    }

    /**
     * Returning the teacher object.
     *
     * @return Teacher object that is associated with the course.
     */
    public Teacher getTeacher()
    {
        return teacher;
    }

    /**
     * Returning the isScheduled instance variable.
     *
     * @return boolean of isScheduled
     */
    public boolean getIsScheduled()
    {
        return isScheduled;
    }

    /**
     * Setting the isScheduled variable to a new value.
     *
     * @param scheduled determines whether the course is already scheduled for an exam
     */
    public void setScheduled(boolean scheduled)
    {
        isScheduled = scheduled;
    }

    /**
     * Returning whether two Course objects are equals.
     * It compares courseName and teacher variables between the two Course objects.
     *
     * @param obj the object that the selected object is compared to
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Course))
            return false;
        Course other = (Course) obj;
        return this.courseName.equals(other.courseName) && this.teacher.equals(other.teacher)&&this.isScheduled==other.isScheduled;
    }

    /**
     * Returning a String with the course's name and its assigned teacher's information.
     *
     * @return String of the course's data.
     */
    public String toString()
    {
        String s = "";
        s += courseName;
        s += ", teacher: " + teacher.toString();
        return s;
    }

    public void setIsScheduled()
    {
        this.isScheduled=true;
    }
}
