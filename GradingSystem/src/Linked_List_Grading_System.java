//Programmer: Elizabeth Nocon
//Description:
//This program will ask the user to input student names and grades. 
//The program will use this information to create a linked list. 
//The program will then print the student names and grades in order
//of highest grade to lowest. The program will also create a text document. 

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Comparable;

public class Linked_List_Grading_System 
{
	public static void main (String [] args) throws Exception
	{
		//Create scanner to read user input. 
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter the name of your class.");
		String className = userInput.next();
		
		//Ask for class size. 
		System.out.println("Please enter the size of your class:");
		int classSize = userInput.nextInt();
		
		//Create Linked List for class. 
		classLinkedList classGrades = new classLinkedList();
		
		//Create variables for student name and grade. 
		String firstName = null, lastName = null;
		int grade;
		
		//Create while loop to repeatedly ask for user input. 
		for(int i = 0; i < classSize; i++)
		{	
			System.out.println("Please enter student's first and last name.");
			firstName = userInput.next();
			lastName = userInput.next();
			String name = firstName +" "+ lastName;
			
			System.out.println("Please enter "+ name +"'s grade.");
			grade = userInput.nextInt();
			
			//Only accept grades that are 0 or greater. 
			if (grade < 0)
			{
				System.out.println("Please enter a valid grade for the student that is greater than 0.");
				System.out.println("Please enter student " + name + " grade again.\n");
				grade = userInput.nextInt();
			}
			
			//Create student, then add to linked list. 
			Student1 newStudent = new Student1(name, grade);
			classGrades.buildLinkedList(newStudent);
		}//while loop
		
		//Close scanner.
		userInput.close();
		
		//Print student grades in order.
		System.out.println("Student Grade Results in Order from Highest to Lowest");
		System.out.println(className);
		classGrades.PrintLinkedList();
		
		
	} //Main
} //Linked_List_Grading_System

//Create a class for student. 
class Student1 implements Comparable<Student1>
{
	//Private data fields for student. 
	private String name;
	private int grade;
	
	//Create constructor for student. 
	Student1(String name, int grade)
	{
		//Set passed in values as values of private data fields. 
		this.name = name;
		this.grade = grade;
	}//Constructor
	
	//Getter for student grade. 
	public int getGrade()
	{
		return grade;
	}//getGrade()
	
	//Create compareTo method to compare student grades. 
	@Override 
	public int compareTo(Student1 other)
	{
		//If student grades are equal, then return 0. 
		if(this.getGrade() == other.getGrade())
		{
			return 0;
		}
		//If this grade is greater than other, then the current node
		//needs to go in front. 
		if(this.getGrade() > other.getGrade())
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}//compareTo
	
	public String Print()
	{
		String gradeResults = String.format("%d\t%s\n", grade, name);
		return gradeResults;
	}
}//Student1

//Class to create Linked List. 
class classLinkedList
{
	//Private Data Field. 
	private Node head;
	
	classLinkedList()
	{
		head = null;
	}
	
	//Build Linked List in order of student grades
	//Built from highest grade to lowest grade
	public void buildLinkedList(Student1 newStudent)
	{
		//Create variables to help keep track of nodes. 
		Node newNode = new Node(newStudent);
		Node current = head;
		Node previous = null;
		
		//Create boolean value for if node has been placed or not
		boolean placed = false;
		
		//While the node's proper place has not been found, continue to loop
		while(current != null && !placed)
		{
			//Search for the node's proper place
			//If a -1 is returned, then the node needs to go between 
			//two existing nodes. So, you need to return true to exit the loop. 
			//To go to if previous != null. 
			if(current.data.compareTo(newNode.data) == -1)
			{
				placed = true;
			}
			//if location has not been found, then continue to traverse the linked list
			else
			{
				previous = current;
				current = current.nextNode;
			}
		} //While Loop
		
		//If the head does not have a value, then insert the node as the head. 
		if(head == null)
		{
			head = newNode;
		}
		
		//If previous is not null, then the newNode needs to be placed between
		//existing Nodes. 
		if (previous != null)
		{
			previous.nextNode = newNode;
			newNode.nextNode = current;
		}
	} //buildLinkedList
	
	//Print Linked List. 
	public void PrintLinkedList() throws IOException
	{
		System.out.println("-------------------------------------");
		System.out.println("Grade\tStudent Name");
		System.out.println("-------------------------------------");
		
		//Create text file. 
		//Print grades to external text document.
		File fileGrades = new File("classResults1.txt");
		fileGrades.createNewFile();
		PrintWriter output = new PrintWriter("classResults1.txt");
		
		Node this_Node = head;
		
		//While you are not at the end of the linked list, continue to print each student. 
		while( this_Node != null)
		{
			System.out.print(this_Node.data.Print());
			output.print(this_Node.data.Print());
			this_Node = this_Node.nextNode;
		}
		output.close();
	}//Print Linked List Method
	
	//Create node class. 
	private static class Node
	{
		//Private data fields. 
		Student1 data;
		Node nextNode;
		
		//Constructor for Node. 
		Node(Student1 passedInStudent)
		{
			this.data = passedInStudent;
			this.nextNode = null;
		}
	}//Node Class
} //classLinkedList
