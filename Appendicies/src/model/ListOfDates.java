package model;

import java.util.ArrayList;

/**
 * Class representing an ArrayList of MyDate objects.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class ListOfDates
{
    private ArrayList<MyDate> dates;

    /**
     * Zero argument constructor.
     * The constructor is used to create a new ArrayList of MyDates.
     */
    public ListOfDates()
    {
        this.dates = new ArrayList<>();
    }

    /**
     * Returning all of the dates as a String in order to display them in other classes.
     *
     * @return String of all the dates in the ArrayList.
     */
    public String allDates()
    {
        String s = "";
        for (int i = 0; i < dates.size(); i++)
        {
            s += dates.get(i).toString();
            s += "\n";
        }
        return s;
    }

    /**
     * Adding a MyDate object to the ArrayList of dates.
     *
     * @param date a MyDate object
     */
    public void add(MyDate date)
    {
        dates.add(date);
    }

    /**
     * Removing a MyDate object from the ArrayList of dates.
     *
     * @param date a MyDate object that should be removed.
     */
    public void remove(MyDate date)
    {
        dates.remove(date);
    }

    /**
     * Returning all of the dates stored in the ArrayList.
     *
     * @return ArrayList of all the dates stored.
     */
    public ArrayList<MyDate> getDates()
    {
        return dates;
    }

    /**
     * Getting the number of dates stored as an integer.
     *
     * @return Number of dates as an integer.
     */
    public int size()
    {
        return dates.size();
    }

    /**
     * Returning a String of the dates stored in the ArrayList.
     *
     * @return String of the dates stored.
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < dates.size(); i++)
        {
            s += dates.get(i).toString();
            s += "\n";
        }
        return s;
    }
}
