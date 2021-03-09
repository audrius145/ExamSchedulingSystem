package mediator;


import java.io.FileNotFoundException;

import model.*;
import model.Class;
import parser.ParserException;
import view.ExamListViewModel;
import view.ExamViewModel;

public class ExamModelManager implements ExamListModel
{
    private ExamList examList;
    private CourseList courseList;
    private ClassList classList;
    private fileConsole fileConsole;
    private RoomList roomList;
    private ListOfDates dates;


    public ExamModelManager() throws ParserException, FileNotFoundException
    {
        this.fileConsole = new fileConsole();
        this.examList = new ExamList();
        this.courseList = fileConsole.readCourseList();
        this.classList = fileConsole.readClassList();
        this.roomList = fileConsole.readRoomList();
        this.dates = new ListOfDates();

    }


    public fileConsole getFileConsole()
    {
        return fileConsole;
    }

    public ExamList getTeachersScheduleById(String viaId)
    {
        ExamList teacherExams = new ExamList();
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).getTeacher().getViaId().equals(viaId))
            {
                teacherExams.add(examList.getExam(i));
            }
        }
        return teacherExams;
    }

    public ExamList getClassSchedule(Class theClass)
    {
        ExamList classExams = new ExamList();
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).getTheClass().equals(theClass))
            {
                classExams.add(examList.getExam(i));
            }
        }
        return classExams;
    }

    public ExamList getCourseSchedule(Course course)
    {
        ExamList courseExams = new ExamList();
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).getCourse().equals(course))
            {
                courseExams.add(examList.getExam(i));
            }
        }
        return courseExams;
    }


    public CourseList getCourses()
    {

        return courseList;
    }

    public Teacher getTeacher(Course course)
    {
        return course.getTeacher();
    }

    public ListOfDates getDates()
    {
        return dates;
    }

    public ClassList getTheClasses()
    {
        return classList;
    }

    public RoomList getRooms()
    {
        return roomList;
    }

    public ExamList getExamList()
    {
        return examList;
    }

    public ListOfDates getDate(Exam exam)
    {
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).equals(exam))
            {
                return examList.getExam(i).getDate();
            }
        }
        return null;
    }
    public void setExamRoom(Room room, Exam exam)
    {
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).equals(exam))
            {
                examList.getExam(i).setExamRoom(room);
            }
        }
    }

    public void setDate(MyDate newDate, Exam exam)
    {
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).equals(exam))
            {
                examList.getExam(i).setExamDate(newDate);
            }
        }
    }

    public int examListSize()
    {
        return examList.size();
    }

    public Exam getExam(int index)
    {
        return examList.getExam(index);
    }

    public void PlanAnExam(Course course, Class theClass, Room room, ListOfDates dates, boolean isWritten) throws ParserException, FileNotFoundException
    {
        Exam exam = new Exam(course, theClass, room, isWritten);
        for (int i = 0; i < dates.size(); i++)
        {
            exam.setExamDate(dates.getDates().get(i));
        }
        examList.add(exam);
        fileConsole.writeExamList(examList);
        fileConsole.writeExamListManual(examList);
    }

    public void removeAnExam(Exam exam)
    {
        for (int i = 0; i < examList.size(); i++)
        {
            if (examList.getExam(i).equals(exam))
            {
                examList.remove(exam);
            }
        }
    }
}