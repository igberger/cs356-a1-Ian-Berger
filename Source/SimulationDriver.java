//Ian Berger
//CS356
//Assignment 1
import java.util.Random;
public class SimulationDriver
{
   public static void main(String[] args)
   {
      Random r = new Random();
      int numberOfStudents = 30;//Class size of 30
      Student[] students = new Student[numberOfStudents];
      
      for(int i=0; i<numberOfStudents; i++)//Randomly assign student ID's
         students[i] = new Student(((Integer)r.nextInt(1000000)).toString());
      
      //Multiple answer questions
      Question qm1 = new Question(true, new String[]{"A", "B", "C", "D"});
      Question qm2 = new Question(true, new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I"});
      
      //Single answer questions
      Question qs1 = new Question(false, new String[]{"True", "False"});
      Question qs2 = new Question(false, new String[]{"A", "B", "C"});
      
      //Initialize iClicker with the first question qm1
      IClickerService iClicker = new IClickerService(qm1);
      
      //Output test results
      System.out.println("Each student sumbmits a random answer 4 times.\n");
      studentsEachAnswerNTimes(4, students, qm1, iClicker);
      studentsEachAnswerNTimes(4, students, qm2, iClicker);
      studentsEachAnswerNTimes(4, students, qs1, iClicker);
      studentsEachAnswerNTimes(4, students, qs2, iClicker);
      
      System.out.println("\nStudents randomly submit a total 40 random answers.\n");
      studentsAnswerNTimesTotal(40, students, qm1, iClicker);
      studentsAnswerNTimesTotal(40, students, qm2, iClicker);
      studentsAnswerNTimesTotal(40, students, qs1, iClicker);
      studentsAnswerNTimesTotal(40, students, qs2, iClicker);
   }
   
   private static void studentsEachAnswerNTimes(int n, Student[] students, Question q, IClickerService iClicker)
   { 
      iClicker.setQuestion(q);
      
      for(int i=0; i<n; i++)
         for(int j=0; j<students.length; j++)
            iClicker.submit(students[j].getID(), students[j].getAnswer(q));
      
      iClicker.printStats();
   }
   private static void studentsAnswerNTimesTotal(int n, Student[] students, Question q, IClickerService iClicker)
   { 
      Random r = new Random();
      iClicker.setQuestion(q);
      
      for(int i=0; i<n; i++)//randomly pick students to submit answers
      {
         int index = r.nextInt(students.length);
         iClicker.submit(students[index].getID(), students[index].getAnswer(q));
      }
      
      iClicker.printStats();
   }
}