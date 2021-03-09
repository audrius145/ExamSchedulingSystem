package model;

import java.util.ArrayList;

/**
 * Class representing an ArrayList of rooms.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class RoomList
{
    private ArrayList<Room> rooms;

    /**
     * Zero argument constructor creating an ArrayList of rooms.
     * The constructor is used to create a new ArrayList for the rooms.
     */
    public RoomList()
    {
        this.rooms = new ArrayList<>();
    }

    /**
     * Returning the ArrayList of rooms.
     *
     * @return ArrayList of rooms.
     */
    public ArrayList<Room> getAllRooms()
    {
        return rooms;
    }

    /**
     * Getting a Room object from the ArrayList that's name matches the name given as a parameter.
     *
     * @param roomName name of the room
     * @return Room object that has the same name as in the parameter.
     */
    public Room getRoomByName(String roomName)
    {
        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).getRoomName().equals(roomName))
            {
                return rooms.get(i);
            }
        }
        return null;
    }

    /**
     * Getting an ArrayList containing the rooms that have a specific size.
     * A for-loop is used to loop through the elements of the ArrayList.
     * With an if statement inside the for-loop the rooms that are the given size are added to an ArrayList that is created at the beginning of the method.
     *
     * @param size size of a room
     * @return ArrayList of the rooms with the specified size
     */
    public ArrayList<Room> getRoomsBySize(int size)
    {
        ArrayList<Room> roomList = new ArrayList<>();
        for (Room room : rooms)
        {
            if (room.getSize() >= size)
            {
                roomList.add(room);
            }
        }
        return roomList;
    }

    /**
     * Getting the rooms in an ArrayList that are compatible for oral examination.
     * A new ArrayList is created and than the rooms that are for oral exams added to this ArrayList.
     *
     * @return ArrayList of the room compatible for oral examination.
     */
    public ArrayList<Room> getRoomsForOral()
    {
        ArrayList<Room> roomsForOral = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).isCompatibleForOral())
            {
                roomsForOral.add(rooms.get(i));
            }
        }
        return roomsForOral;
    }

    /**
     * Getting the rooms in an ArrayList that are compatible for written examination.
     * A new ArrayList is created and than the rooms that are for written exams added to this ArrayList.
     *
     * @return ArrayList of the room compatible for written examination.
     */
    public ArrayList<Room> getRoomsForWritten()
    {
        ArrayList<Room> roomsForWritten = new ArrayList<>();
        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).isCompatibleForWritten())
            {
                roomsForWritten.add(rooms.get(i));
            }
        }
        return roomsForWritten;
    }

    /**
     * Adding a room to the ArrayList of all the rooms.
     *
     * @param room Room object
     */
    public void add(Room room)
    {
        rooms.add(room);
    }

    /**
     * Getting a room at a specific index of the ArrayList.
     *
     * @param index the place of the Room object that should be returned
     * @return Room object at the index
     */
    public Room getRoom(int index)
    {
        return rooms.get(index);
    }

    /**
     * Getting the number of rooms in the ArrayList.
     *
     * @return size of the ArrayList as an integer
     */
    public int size()
    {
        return rooms.size();
    }

    /**
     * Removing a Room object from the ArrayList of all the rooms.
     *
     * @param room Room object
     */
    public void remove(Room room)
    {
        rooms.remove(room);
    }

    /**
     * Returning a String of all the rooms data.
     *
     * @return String with all the rooms data.
     */
    public String toString()
    {
        String s = "The rooms with their data that are currently in the system: ";
        for (int i = 0; i < rooms.size(); i++)
        {
            s += "\n" + i + 1;
            s += ". " + rooms.get(i).toString();
        }
        return s;
    }


}
