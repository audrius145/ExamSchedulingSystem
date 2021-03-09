package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Class;
import model.Course;
import model.Exam;
import model.Room;


public class ExamViewModel
{
    private StringProperty courseProperty;
    private StringProperty classProperty;
    private StringProperty roomProperty;
    private StringProperty dateProperty;
    private StringProperty examinerProperty;
    private Course course;
    private Class theClass;
    private Room room;
    private boolean isWritten;



    public ExamViewModel(Exam exam)
    {
        courseProperty = new SimpleStringProperty(exam.getCourse().getCourseName());
        classProperty = new SimpleStringProperty(exam.getTheClass().getClassName());
        roomProperty = new SimpleStringProperty(exam.getRoom().getRoomName());
        dateProperty=new SimpleStringProperty(exam.getDate().allDates());
        examinerProperty = new SimpleStringProperty(exam.getTeacher().toString());
        course=exam.getCourse();
        room=exam.getRoom();
        theClass=exam.getTheClass();
        isWritten=exam.isWritten();
    }

    public void setCourseProperty(String courseProperty)
    {
        this.courseProperty.set(courseProperty);
    }

    public void setClassProperty(String classProperty)
    {
        this.classProperty.set(classProperty);
    }

    public void setRoomProperty(String roomProperty)
    {
        this.roomProperty.set(roomProperty);
    }

    public void setDateProperty(String dateProperty)
    {
        this.dateProperty.set(dateProperty);
    }

    public void setExaminerProperty(String examinerProperty)
    {
        this.examinerProperty.set(examinerProperty);
    }




    public Course getCourse()
    {
        return course;
    }

    public Class getTheClass()
    {
        return theClass;
    }

    public Room getRoom()
    {
        return room;
    }

    public boolean isWritten()
    {
        return isWritten;
    }


    public StringProperty getCourseProperty()
    {
        return courseProperty;
    }


    public StringProperty getclassProperty()
    {
        return classProperty;
    }


    public StringProperty getroomProperty()
    {
        return roomProperty;
    }


    public StringProperty getdateProperty()
    {
        return dateProperty;
    }


    public StringProperty getexaminerProperty()
    {
        return examinerProperty;
    }
}

