package model;

/**
 * Class representing a date.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class MyDate

{
    private int day;
    private int month;
    private int year;

    /**
     * Three-argument constructor.
     * The instance variables are set using a method that is defined in this class.
     *
     * @param day   the day
     * @param month the month as an integer representing a month from 1-12
     * @param year  the year
     */
    public MyDate(int day, int month, int year)
    {
        set(day, month, year);
    }

    /**
     * Setting the date. If the month parameter is less than 1 it is set to 1 and if more than 12, it is set to 12.
     * If the year is smaller than 0, the opposite of the number is set.
     * If the day is smaller than 1, it is set to 1.
     * If the day is larger than the number of days in the corresponding month, the max. day of the month is set.
     * This uses the method numberOfDayInMonth() defined in this class.
     *
     * @param day   the day
     * @param month the month as an integer representing a month from 1-12
     * @param year  the year
     */
    public void set(int day, int month, int year)
    {

        if (month < 1)
        {
            month = 1;
        } else if (month > 12)
        {
            month = 12;
        }
        this.month = month;
        if (year < 0)
        {
            year = -year;
        }
        this.year = year;

        if (day < 1)
        {
            day = 1;
        } else if (day > numberOfDaysInMonth())
        {
            day = numberOfDaysInMonth();
        }
        this.day = day;
    }

    /**
     * Getting the name of the month based on the month instance variable using a switch.
     *
     * @return String of the name of the month.
     */
    public String getMonthName()
    {
        switch (month)
        {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "December";
        }
    }

    /**
     * Getting the day.
     *
     * @return integer of the day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Getting the month.
     *
     * @return integer of the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Getting the year.
     *
     * @return integer of the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returning a String of the date in a defined format.
     *
     * @return the date as a String.
     */
    public String toString()
    {
        String s = "";
        if (day < 10)
        {
            s += "0";
        }
        s += day + "/";
        if (month < 10)
        {
            s += "0";
        }
        s += month + "/";
        s += year;
        return s;
    }

    /**
     * Returning if the year is a leap year.
     *
     * @return true or false
     */
    public boolean isLeapYear()
    {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    /**
     * Returning how many days are in a month.
     *
     * @return integer of how many days are in a month
     */
    public int numberOfDaysInMonth()
    {
        switch (month)
        {
            case 2:
                if (isLeapYear())
                {
                    return 29;
                }
                return 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    /**
     * Getting the name of the day based on the day instance variable using a switch.
     *
     * @return String of the name of the day.
     */
    public String dayOfWeek()
    {
        int q, m, k, j, h;
        q = day;
        if (month <= 2)
        {
            m = 12 + month;
        } else
        {
            m = month;
        }
        k = year % 100;
        if (month == 13 || month == 14)
        {
            year = year - 1;
        }
        j = year / 100;
        h = (q + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) + (5 * j)) % 7;

        switch (h)
        {
            case 0:
                return "Saturday";
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            default:
                return "Error";
        }

    }
}
