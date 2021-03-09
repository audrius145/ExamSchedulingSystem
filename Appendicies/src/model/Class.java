package model;

/**
 * A class representing a Class of students
 *
 * @author Group 2
 * @version 1 - December 2019
 */
public class Class
{
    private String className;
    private String classRoom;
    private int studentCount;

    /**
     * Three-argument constructor.
     * The instance variables are initialized.
     *
     * @param className name of the class
     * @param classRoom name of the class' room
     * @param studentCount number of students in the class
     */
    public Class(String className, String classRoom, int studentCount)
    {
        this.className = className;
        this.classRoom = classRoom;
        this.studentCount = studentCount;
    }

    /**
     * Returning the className variable.
     *
     * @return the className variable
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * Returning the classRoom variable.
     *
     * @return the classRoom variable
     */
    public String getClassRoom()
    {
        return classRoom;
    }

    /**
     * Returning the studentCount variable.
     *
     * @return the studentCount variable
     */
    public int getStudentCount()
    {
        return studentCount;
    }

    /**
     * Returning whether two Class objects are equals.
     * It compares className, classRoom and studentCount.
     *
     * @param obj the object that the selected object is compared to
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Class))
            return false;
        Class other = (Class) obj;
        return this.className.equals(other.className) && this.studentCount == other.studentCount && this.classRoom.equals(other.classRoom);
    }

    /**
     * Returning a String with the class' name and designated class room.
     *
     * @return String of the class' data except studentCount.
     */
    public String toString()
    {
        String s = "Name: ";
        s += className + ", classroom: " + classRoom + ".";
        return s;
    }
}
