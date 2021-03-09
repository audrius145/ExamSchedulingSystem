package model;

import java.util.ArrayList;

/**
 * Class representing an ArrayList of Courses.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class CourseList
{
    private ArrayList<Course> courseList;

    /**
     * Zero argument constructor.
     * The constructor is used to create a new ArrayList for the courses.
     */
    public CourseList()
    {
        this.courseList = new ArrayList<>();
    }

    /**
     * Returning the number of courses stored in the ArrayList.
     *
     * @return size of the ArrayList as an integer
     */
    public int getNumberOfCourses()
    {
        return courseList.size();
    }

    /**
     * Returning all of the courses.
     *
     * @return ArrayList of all the courses that are stored.
     */
    public ArrayList<Course> getCourses()
    {
        return courseList;
    }

    /**
     * Getting a Course that has the same name as the given parameter.
     *
     * @param name name of a course
     * @return Course object or null if no match is found.
     */
    public Course getCourseByName(String name)
    {
        for (int i = 0; i < courseList.size(); i++)
        {
            if (courseList.get(i).getCourseName().equals(name))
            {
                return courseList.get(i);
            }
        }
        return null;
    }

    /**
     * Adding an object to the ArrayList.
     *
     * @param course a Course object
     */
    public void add(Course course)
    {
        courseList.add(course);
    }

    /**
     * Returning the size of the ArrayList.
     *
     * @return size of the ArrayList as an integer
     */
    public int size()
    {
        return courseList.size();
    }

    /**
     * Returning a Course at a given index from the ArrayList.
     *
     * @param index the place of the Course object that should be returned
     * @return a Course object
     */
    public Course get(int index)
    {
        return courseList.get(index);
    }

    /**
     * Returning an ArrayList of all the courses that have not been scheduled for examination.
     *
     * @return ArrayList of unscheduled Course objects.
     */
    public ArrayList<Course> getUnscheduledCourses()
    {
        ArrayList<Course> unscheduled = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++)
        {
            if (!courseList.get(i).getIsScheduled())
            {
                unscheduled.add(courseList.get(i));
            }
        }
        return unscheduled;
    }

    /**
     * Returning the courses that have the same teacher as in the parameter.
     *
     * @param teacher a Teacher object
     * @return ArrayList of Courses with the same Teacher as given in the parameter.
     */
    public ArrayList<Course> getCoursesWithTeacher(Teacher teacher)
    {
        ArrayList<Course> coursesWithCertainTeacher = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++)
        {
            Teacher teacherC = courseList.get(i).getTeacher();
            if (teacherC.equals(teacher))
            {
                coursesWithCertainTeacher.add(courseList.get(i));
            }
        }
        return coursesWithCertainTeacher;
    }

    /**
     * Returning a String of all of the courses data using the toString() method from the Course class.
     *
     * @return String of all the stored classes data.
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < courseList.size(); i++)
        {
            s += courseList.get(i).toString();
            s += "\n";
        }
        return s;
    }
}
