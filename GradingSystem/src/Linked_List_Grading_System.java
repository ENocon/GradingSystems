//Programmer: Elizabeth Nocon
//Description:
//This program will ask the user to input student names and grades. 
//The program will use this information to create a linked list. 
//The program will then print the student names and grades in order
//of highest grade to lowest. The program will also create a text document. 

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.lang.Comparable;

public class Linked_List_Grading_System 
{
	public static void main (String [] args) throws Exception
	{
		
	} //Main
} //Linked_List_Grading_System

//Create a class for student. 
class Student1 implements Comparable<Student1>
{
	//Private data fields for student. 
	private String firstName;
	private String lastName;
	private int grade;
	
	//Create constructor for student. 
	Student1(String firstName, String lastName, int grade)
	{
		//Set passed in values as values of private data fields. 
		this.firstName = firstName;
		this.lastName = lastName;
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
		if(this.getGrade() > other.getGrade())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}//compareTo
	
	public String Print()
	{
		String gradeResults = String.format("%d\t%-12s\t%-12s\n", grade, firstName,lastName);
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
			//If returned value is -1, then the newNode needs to be placed before
			//the current Node
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
		if(previous == null)
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
	public void PrintLinkedList()
	{
		System.out.println("-------------------------------------");
		System.out.println("Student Grade Results in Order from Highest to Lowest");
		System.out.println("Grade\tStudentName");
		
		Node this_Node = head;
		
		//While you are not at the end of the linked list, continue to print each student. 
		while( this_Node != null)
		{
			System.out.print(this_Node.data.Print());
			this_Node = this_Node.nextNode;
		}
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
