package mediator;

import model.*;
import parser.ParserException;

import java.io.FileNotFoundException;

public interface fileManager
{
    CourseList readCourseList() throws ParserException;

    ClassList readClassList() throws ParserException;


    ExamList readExamList() throws FileNotFoundException, ParserException;

    RoomList readRoomList() throws ParserException;

    void writeExamList(ExamList examList) throws ParserException, FileNotFoundException;
    void writeExamListManual(ExamList examList) throws FileNotFoundException;

}
