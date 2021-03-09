package mediator;


import model.*;
import model.Class;
import parser.ParserException;

import java.io.FileNotFoundException;

public interface ExamListModel
{
    ExamList getTeachersScheduleById(String viaId) throws ParserException;

    ExamList getClassSchedule(Class theClass);

    ExamList getCourseSchedule(Course course);


    CourseList getCourses();
    Teacher getTeacher(Course course);
    ClassList getTheClasses();
    RoomList getRooms();
    ListOfDates getDate(Exam exam);
    int examListSize();
    Exam getExam(int index);
    fileConsole getFileConsole();
    ExamList getExamList();

    void setExamRoom(Room room,Exam exam);
    void setDate(MyDate newDate,Exam exam);
    void PlanAnExam(Course course, Class theClass, Room room, ListOfDates dates, boolean isWritten) throws ParserException, FileNotFoundException;
    void removeAnExam(Exam exam);
    ListOfDates getDates();

}
