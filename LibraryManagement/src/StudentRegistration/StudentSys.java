package StudentRegistration;
import java.util.*;
class student{
	String name;
	int rollNo;
	int age;
	double cgpa;
    int NoOfArrears;
    student(String name,int rollNO,int age,double cgpa,int NoOfArrears){
    	this.name=name;
    	this.rollNo=rollNO;
    	this.age=age;
    	this.cgpa=cgpa;
    	this.NoOfArrears=NoOfArrears;
    }
}
public class StudentSys {
	public static void main(String args[]) {
	int MAX_STUDENTS=100;
  student[] studentDB=new student[MAX_STUDENTS];
  int studentCount=0;
  Scanner sc=new Scanner(System.in);
  boolean booleanExit=false;
  while(!booleanExit) {
	   System.out.println("\nStudent Registration System");
       System.out.println("1. Add Student");
       System.out.println("2. Modify a student's DB");
       System.out.println("3. Delete a student from DB");
       System.out.println("4. Search Student by Name");
       System.out.println("5. Search Student by Roll No");
       System.out.println("6. Exit");
       System.out.println("Enter your choice: ");
       System.out.println("----------------------------------");

      int action=sc.nextInt();
      switch(action) {
      case 1:{
    	  if(studentCount<MAX_STUDENTS) {
    		  System.out.print("Enter student name: ");
              sc.nextLine(); 
              String name = sc.nextLine();
              System.out.print("Enter student age: ");
              int age = sc.nextInt();
              System.out.print("Enter student roll number: ");
              int rollNo = sc.nextInt();
              System.out.print("Enter student CGPA: ");
              double cgpa = sc.nextDouble();
              System.out.println("Enter the Number Of Arrears :");
              int arrearCount=sc.nextInt();
              student studentEntry=new student(name,rollNo,age,cgpa,arrearCount);
              studentDB[studentCount]=studentEntry;
              
              System.out.println("DATA SUCCESSFULY INSERTED!!");
              
    	  }
    	  else {
    		  System.out.println("MAX LIMIT OF STUDENTS REACHED !");
    	  }
    	  break;
      }
      case 2:{
    	  System.out.println("Enter the rollNo of the student you want to modify:");
    	  int rollNo=sc.nextInt();
    	  boolean StudentFound=false;
    	  for(int i=0;i<studentDB.length;i++) {
    		  if(studentDB[i]!=null && studentDB[i].rollNo==rollNo) {
    			  StudentFound=true;
    			  System.out.println("1. Change the Name");
    			  System.out.println("2. Change the Age");
    			  System.out.println("3. Change the CGPA");
    			  System.out.println("4. Change the ArrearCount");
    			  System.out.println("Select the option you want to perform");
                  System.out.println("----------------------------------");

                  int actionChooser=sc.nextInt();
                  switch(actionChooser) {
                  case 1:{
                	  System.out.println("Enter the name you want to change to :");
                	  String name=sc.nextLine();
                	  studentDB[i].name=name;
                	 break;
                  }
                  case 2:{
                	  System.out.println("Enter the age you want to change to :");
                	  int age=sc.nextInt();
                	  studentDB[i].age=age;
                	 break;
                  }
                  case 3:{
                	  System.out.println("Enter the CGPA you want to change to :");
                	  double CGPA=sc.nextDouble();
                	  studentDB[i].cgpa=CGPA;
                	 break;
    		  }
                  case 4:{
                	  System.out.println("Enter the ArrearCount you want to change to :");
                	  int arrear=sc.nextInt();
                	  studentDB[i].NoOfArrears=arrear;
                	 break;
    	  }
      }
    }
    	  }
    	  if(!StudentFound) {
    		  System.out.println("Student Not Found!");
              System.out.println("----------------------------------");

    	  }
    	  break;
      }
      case 3:{
    	  System.out.println("Enter The RollNo of the Student you need to Remove :");
    	  int rollNo=sc.nextInt();
  	    boolean studentFound = false;
  	  for (int i = 0; i < studentDB.length; i++) {
	        if (studentDB[i] != null && studentDB[i].rollNo==rollNo) {
	            studentFound = true;
	            studentDB[i]=null;
	        }
	        if(!studentFound) {
	        	System.out.println("Student Not Found!");
                System.out.println("----------------------------------");

	        }
  	  }
  	  break;
      }
      case 4: {
    	    System.out.print("Enter the Name of Student you want to search: ");
    	    sc.nextLine(); // Consume newline
    	    String studentName = sc.nextLine();
    	    boolean studentFound = false;
    	    for (int i = 0; i < studentDB.length; i++) {
    	        if (studentDB[i] != null && studentDB[i].name.equals(studentName)) {
    	            studentFound = true;
    	            System.out.println("The Name of Student is: " + studentDB[i].name);
    	            System.out.println("The rollNo of Student is: " + studentDB[i].rollNo);
    	            System.out.println("The Age of Student is: " + studentDB[i].age);
    	            System.out.println("The CGPA of Student is: " + studentDB[i].cgpa);
    	            System.out.println("The Arrear Count of Student is: " + studentDB[i].NoOfArrears);
                    System.out.println("----------------------------------");

    	        }
    	    }
    	    if (!studentFound) {
    	        System.out.println("Student Not Found!");
    	    }
    	    break;
    	}
      case 5:{
    	  System.out.println("Enter the rollNo of Student you want to search :");
    	  int studentRollNo=sc.nextInt();
    	  boolean studentFound=false;
    	  for(int i=0;i<studentDB.length;i++) {
    		  student studentTester=studentDB[i];
    		  if(studentTester.rollNo==studentRollNo){
    			  studentFound=true;
    			  System.out.println("The Name of Student is : "+studentTester.name);
    			  System.out.println("The rollNo of Student is : "+studentTester.rollNo);
    			  System.out.println("The Age of Student is : "+studentTester.age);
    			  System.out.println("The CGPA of Student is : "+studentTester.cgpa);
    			  System.out.println("The Arrear Count of Student is : "+studentTester.NoOfArrears);
                  System.out.println("----------------------------------");
    		  }
    	  }
    	  if(!studentFound) {
    		  System.out.println("Student Not Found !");
    	  }
    	  break;
      }
      case 6:{
    	  booleanExit=true;
      }
      }
  } 
}
}
