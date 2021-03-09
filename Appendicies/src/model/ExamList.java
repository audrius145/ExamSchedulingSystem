package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class representing an ArrayList of Exams.
 * @author Group 2
 * @version 1-December 2019
 */
public class ExamList
{
    private ArrayList<Exam> exams;

    /**
     * Zero argument constructor.
     * The constructor is used to create a new ArrayList for the exams.
     */
    public ExamList()
    {
        this.exams = new ArrayList<>();
    }

    /**
     * Getting an Exam from the ArrayList at a certain index.
     * @param index the place of the Exam object that should be returned
     * @return Exam object at the index in the ArrayList.
     */
    public Exam getExam(int index)
    {
        return exams.get(index);
    }

    /**
     * Getting an Exam that has the given class and course.
     * @param theClass a Class object
     * @param course a Course object
     * @return an Exam object
     */
    public Exam getExam(Class theClass, Course course)
    {
        for (int i = 0; i < exams.size(); i++)
        {
            if (exams.get(i).getTheClass().equals(theClass) && exams.get(i).getCourse().equals(course))
            {
                return exams.get(i);
            }
        }
        return null;
    }

    /**
     * Removing an Exam from the ArrayList of exams.
     * @param exam an Exam object
     */
    public void remove(Exam exam)
    {
        exams.remove(exam);
    }

    /**
     * Returning the number of exams stored in the ArrayList of exams.
     * @return size of the ArrayList as an integer
     */
    public int size()
    {
        return exams.size();
    }

    /**
     * Adding an Exam to the ArrayList of exams.
     * @param exam an Exam object
     */
    public void add(Exam exam)
    {
        exams.add(exam);
    }

    /**
     * Returning the ArrayList of exams.
     * @return ArrayList of Exam objects
     */
    public ArrayList<Exam> getAll(){
        return exams;
    }


    public boolean checkConflictTeacherAndDate(Teacher teacher, MyDate date)
    {
        for (int i = 0; i < exams.size(); i++)
        {
            return (exams.get(i).getDate().getDates().get(i).equals(date) && exams.get(i).getTeacher().equals(teacher));
        }
        return false;
    }


    public boolean checkConflictClassAndDate(Class theClass, MyDate date)
    {
        for (int i = 0; i < exams.size(); i++)
        {
            return (exams.get(i).getDate().getDates().get(i).equals(date) && exams.get(i).getTheClass().equals(theClass));
        }
        return false;
    }

    public boolean checkConflictRoomAndDate(Room room, MyDate date)
    {
        for (int i = 0; i < exams.size(); i++)
        {
            return (exams.get(i).getDate().getDates().get(i).equals(date) && exams.get(i).getRoom().equals(room));
        }
        return false;
    }


}
