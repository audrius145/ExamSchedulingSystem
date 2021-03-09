package model;

/**
 * Class representing an Exam.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class Exam
{
    private Room examRoom;
    private Course course;
    private Class theClass;
    private Teacher teacher;
    private ListOfDates dates;
    private boolean isWritten;
    private int hour;
    private int minute;

    /**
     * Four-argument constructor.Initializes variables and sets the hour and minute of an Exam to 8:30 by default.
     * The teacher for the exam is set by getting the course's assigned teacher.
     * A new ArrayList of dates is also created to be able to make exams that last several days.
     *
     * @param course    a Course object
     * @param theClass  a Class object
     * @param examRoom  a Room object
     * @param isWritten determines if the exam is written
     */
    public Exam(Course course, Class theClass, Room examRoom, boolean isWritten)
    {
        this.examRoom = examRoom;
        this.course = course;
        this.theClass = theClass;
        this.teacher = course.getTeacher();
        this.dates = new ListOfDates();
        this.isWritten = isWritten;
        this.hour = 8;
        this.minute = 30;
    }


    /**
     * Returning the Room object associated with the Exam.
     *
     * @return a Room object
     */
    public Room getRoom()
    {
        return examRoom;
    }

    /**
     * Setting the Room of the exam to a different one.
     *
     * @param room Room object
     */
    public void setExamRoom(Room room)
    {
        this.examRoom = room;
    }

    /**
     * Returning the minute variable of the exam.
     *
     * @return integer of the minute of which the exam starts
     */
    public int getMinute()
    {
        return minute;
    }

    /**
     * Returning the hour variable of the exam.
     *
     * @return integer of the hour of which the exam starts
     */
    public int getHour()
    {
        return hour;
    }

    /**
     * Setting the minute variable.
     *
     * @param minute the minute of which the exam starts
     */
    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    /**
     * Setting the hour variable.
     *
     * @param hour the hour of which the exam starts
     */
    public void setHour(int hour)
    {
        this.hour = hour;
    }

    /**
     * Assigning a date to the exam and adding it to the ListOfDates.
     *
     * @param date the day,month,year of the exam
     */
    public void setExamDate(MyDate date)
    {
        dates.add(date);
    }

    /**
     * Returning the Course object associated with the Exam.
     *
     * @return a Course object
     */
    public Course getCourse()
    {
        return course;
    }

    /**
     * Returning the isWritten variable associated with the Exam.
     *
     * @return a boolean determining if the exam is written
     */
    public boolean isWritten()
    {
        return isWritten;
    }

    /**
     * Returning the Class object associated with the Exam.
     *
     * @return a Class object
     */
    public Class getTheClass()
    {
        return theClass;
    }

    /**
     * Returning the Teacher object associated with the Exam that is gotten from the Course.
     *
     * @return a Teacher object
     */
    public Teacher getTeacher()
    {
        return teacher;
    }

    /**
     * Returning the ListOfDates object associated with the Exam.
     *
     * @return a ListOfDates object
     */
    public ListOfDates getDate()
    {
        return dates;
    }

    /**
     * Removing a date from the ListOfDates to be able to edit the exam.
     *
     * @param date a MyDate object
     */
    public void removeDate(MyDate date)
    {
        for (int i = 0; i < dates.size(); i++)
        {
            if (dates.getDates().get(i).equals(date))
            {
                dates.remove(date);
                return;
            }
        }
    }

    /**
     * Returning whether two Exam objects are equals.
     * It compares examRoom, course, teacher, dates and theClass.
     *
     * @param obj the object that the selected object is compared to
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Exam)) return false;
        Exam other = (Exam) obj;
        return this.examRoom.equals(other.examRoom) && this.course.equals(other.course)  && this.theClass.equals(other.theClass) ;
    }

    /**
     * Returning a String with the exam's course, class and room.
     *
     * @return String of some of the exam's data.
     */
    public String toString()
    {

        return "Course: " + getCourse() + System.lineSeparator() + "Class: "
                + getTheClass() + System.lineSeparator() + "Room: " + examRoom
                .getRoomName();

    }

    /**
     * Returning a String with the Exam's dates using the toString method in the MyDate class.
     *
     * @return String of the Exam's dates.
     */
    public String dateString()
    {
        String s = "";
        for (int i = 0; i < dates.size(); i++)
        {
            s += dates.getDates().get(i).toString() + "\n";
        }
        return s;
    }

}
