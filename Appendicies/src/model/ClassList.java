package model;

import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Class representing an ArrayList of Classes.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class ClassList
{

    private ArrayList<Class> classes;

    /**
     * Zero argument constructor.
     * The constructor is used to create a new ArrayList for the classes.
     */
    public ClassList()
    {
        this.classes = new ArrayList<>();
    }

    /**
     * Returning a class at a given index from the ArrayList.
     * @param index index of the element that should be returned from the ArrayList
     * @return a Class object
     */
    public Class getClass(int index)
    {
        return classes.get(index);
    }

    /**
     * Returning the number of classes stored in the ArrayList.
     *
     * @return size of the ArrayList as an integer
     */
    public int size()
    {
        return classes.size();
    }

    /**
     * Returning a class that has the classRoom that is specified as a parameter.
     * The method loops through all the Class object inside the ArrayList and compares the classRoom variable to the given room's name.
     * If there is a match, it is returned.
     *
     * @param roomName the classroom's name
     * @return Class object in case of a match, otherwise null.
     */
    public Class getClassWithRoom(String roomName)
    {
        for (int i = 0; i < classes.size(); i++)
        {
            if (classes.get(i).getClassRoom().equals(roomName))
            {
                return classes.get(i);
            }
        }
        return null;
    }

    /**
     * Returning all of the classes.
     *
     * @return ArrayList of all the classes that are stored.
     */
    public ArrayList<Class> getAllClasses()
    {
        return classes;
    }

    /**
     * Returning a Class object if its name matches the given parameter.
     * The method loops through all of the classes.
     *
     * @param className the given class' name
     * @return Class object that has the same name as the parameter. If not found null.
     */
    public Class getClass(String className)
    {
        for (int i = 0; i < classes.size(); i++)
        {
            if (classes.get(i).getClassName().equals(className))
            {
                return classes.get(i);
            }
        }
        return null;
    }

    /**
     * Adding a Class to the ArrayList.
     *
     * @param theClass a Class object
     */
    public void add(Class theClass)
    {
        classes.add(theClass);
    }

    /**
     * Returning a String of all of the classes data using the toString() method from the Class class.
     *
     * @return String of all the stored classes data except for the studentCount.
     */
    public String toString()
    {
        String s = "";
        for (int i = 0; i < classes.size(); i++)
        {
            s += classes.get(i).toString();
            s += "\n";
        }
        return s;
    }
}
