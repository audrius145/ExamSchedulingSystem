package mediator;

import model.*;
import model.Class;
import parser.ParserException;
import parser.XmlJsonParser;

import java.io.*;
import java.util.Scanner;

public class fileConsole implements fileManager
{


    public fileConsole()
    {
    }

    public CourseList readCourseList() throws ParserException
    {

        XmlJsonParser parser = new XmlJsonParser();
        CourseList courseList = parser.fromXml("C:\\Users\\jambo\\IdeaProjects\\SEPGROUP2Take2\\src\\mediator\\courses.xml", CourseList.class);
        return courseList;
    }

    public ClassList readClassList() throws ParserException
    {
        XmlJsonParser parser = new XmlJsonParser();
        ClassList classList = parser.fromXml("C:\\Users\\jambo\\IdeaProjects\\SEPGROUP2Take2\\src\\mediator\\classes.xml", ClassList.class);
        return classList;
    }


    public ExamList readExamList() throws ParserException
    {
        XmlJsonParser parser = new XmlJsonParser();
        ExamList examList = parser.fromXml("C:\\Users\\jambo\\IdeaProjects\\SEPGROUP2Take2\\src\\mediator\\exams.xml", ExamList.class);
        return examList;
    }

    public RoomList readRoomList() throws ParserException
    {
        XmlJsonParser parser = new XmlJsonParser();
        RoomList roomList = parser.fromXml("C:\\Users\\jambo\\IdeaProjects\\SEPGROUP2Take2\\src\\mediator\\rooms.xml", RoomList.class);
        return roomList;
    }

    public void writeExamList(ExamList examList) throws ParserException
    {
        XmlJsonParser parser = new XmlJsonParser();
        File file = parser.toXml(examList, "C:\\Users\\jambo\\IdeaProjects\\SEPGROUP2Take2\\src\\mediator\\exams.xml");
        System.out.println(file.getAbsolutePath());
    }

    public void writeExamListManual(ExamList examList) throws FileNotFoundException
    {
        File file = new File("C:\\Users\\jambo\\IdeaProjects\\SEPGROUP2Take2\\src\\mediator\\examManual.xml");
        PrintWriter out = new PrintWriter(file);
        String xml = "";
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
        xml += "\n<ExamList>";
        for (int i = 0; i < examList.size(); i++)
        {
            xml += "\n<Exam>";
            xml += "\n <Course>" + examList.getExam(i).getCourse().getCourseName() + "</Course>";
            xml += "\n <Class>" + examList.getExam(i).getTheClass().getClassName() + "</Class>";
            xml += "\n <Date>" + examList.getExam(i).getDate().allDates() + "</Date>";
            xml += "\n <Room>" + examList.getExam(i).getRoom().getRoomName() + "</Room>";
            xml += "\n <Examiner>" + examList.getExam(i).getTeacher().toString() + "</Examiner>";
            xml += "\n</Exam>";
        }
        xml += "\n</ExamList>";
        out.println(xml);
        out.close();
    }

}
