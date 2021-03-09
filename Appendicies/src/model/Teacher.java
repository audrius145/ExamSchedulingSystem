package model;

/**
 * Class representing a teacher.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class Teacher
{
    private String firstName;
    private String lastName;
    private String viaId;

    /**
     * Three-argument constructor that initializes the instance variables.
     *
     * @param firstName firstname of the teacher
     * @param lastName  lastname of the teacher
     * @param viaId     the VIA ID of the teacher
     */
    public Teacher(String firstName, String lastName, String viaId)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.viaId = viaId;
    }

    /**
     * Getting the firstname of the teacher.
     *
     * @return String of the teacher's firstname
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Getting the lastname of the teacher.
     *
     * @return String of the teacher's lastname
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Getting the VIA ID of the teacher.
     *
     * @return String of the teacher's VIA ID
     */
    public String getViaId()
    {
        return viaId;
    }

    /**
     * Returning all of the teacher's information as a String.
     *
     * @return String of the teacher's information.
     */
    public String toString()
    {
        String s = "";
        s += firstName + " " + lastName + ", ";
        s += "VIA ID: ";
        s += viaId + ". ";
        return s;
    }

    /**
     * Returning whether two Teacher objects are equals.
     * It compares lastname, firstname and VIA ID.
     *
     * @param obj the object that the selected object is compared to
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Teacher)) return false;
        Teacher other = (Teacher) obj;
        return this.lastName.equals(other.lastName) && this.viaId.equals(other.viaId) && this.firstName.equals(other.firstName);
    }
}
