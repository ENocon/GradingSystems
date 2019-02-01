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
}//Student1

