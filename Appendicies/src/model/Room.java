package model;

/**
 * Class representing a room.
 *
 * @author Group 2
 * @version 1-December 2019
 */
public class Room
{
    private String roomName;
    private int size;
    private boolean vga;
    private boolean hdmi;
    private boolean isArrangedW;

    /**
     * Five-argument constructor. Initializing the instance variables.
     *
     * @param roomName    name of the room
     * @param size        size of the room
     * @param vga         determines if the room has VGA connection
     * @param hdmi        determines if the room has HDMI connection
     * @param isArrangedW determines if the room is arranged for a written exam
     */
    public Room(String roomName, int size, boolean vga, boolean hdmi,
                boolean isArrangedW)
    {
        this.roomName = roomName;
        this.size = size;
        this.vga = vga;
        this.hdmi = hdmi;
        this.isArrangedW = isArrangedW;
    }

    /**
     * Getting the VGA variable.
     *
     * @return true or false
     */
    public boolean isVga()
    {
        return vga;
    }

    /**
     * Getting the HDMI variable.
     *
     * @return true or false
     */
    public boolean isHdmi()
    {
        return hdmi;
    }

    /**
     * Getting the isArrangedW variable.
     *
     * @return true or false
     */
    public boolean isArrangedForWritten()
    {
        return isArrangedW;
    }

    /**
     * Getting the name of the room.
     *
     * @return the name of the room String
     */
    public String getRoomName()
    {
        return roomName;
    }

    /**
     * Getting the size of the room.
     *
     * @return the size of the room
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Setting the isArrangedW variable in case of the room being rearranged.
     *
     * @param isArrangedW the new value of the isArrangedW
     */
    public void setIsArrangedForWritten(boolean isArrangedW)
    {
        this.isArrangedW = isArrangedW;
    }

    /**
     * Getting if the room is compatible for an oral examination.
     *
     * @return true or false
     */
    public boolean isCompatibleForOral()
    {
        return vga && hdmi && !isArrangedW;
    }

    /**
     * Getting if the room is compatible for a written examination.
     *
     * @return true or false
     */
    public boolean isCompatibleForWritten()
    {
        return isArrangedW;
    }

    /**
     * Returning whether two Room objects are equals.
     * It compares size, vga, hdmi, roomName and isArrangedW variables between the two Room objects.
     *
     * @param obj the object that the selected object is compared to
     * @return true or false
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Room))
        {
            return false;
        }
        Room other = (Room) obj;
        return roomName.equals(other.roomName)
                && size == other.size && vga == other.vga && hdmi == other.hdmi && isArrangedW == other.isArrangedW;
    }

    /**
     * Getting the room's information as a String.
     * @return String of the room's data
     */
    public String toString()
    {
        return "Room: " + roomName + System.lineSeparator()
                + "Size: " + size + System.lineSeparator()
                + "VGA: " + vga + System.lineSeparator() + "HDMI: " + hdmi
                + "\n" + "Is it arranged for written?: " + isArrangedW;
    }
}
