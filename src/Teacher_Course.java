import java.util.*;
import java.time.*;

class Becoming_a_teacher{
	
	Scanner sc = new Scanner(System.in);
	
	String address;
	int number_ID;
	int br_Person;
	
	Becoming_a_teacher() {
		address = "Zoom";
		number_ID = 1;
		br_Person = 0;
	}
	
	Becoming_a_teacher(String address, int number_ID, int br_Person) {
		this.address = address;
		this.number_ID = number_ID;
		this.br_Person = br_Person;
	}
	
	String getAddress() {
		return address;
	}
	
	int getNumber_ID() {
		return number_ID;
	}
	
	int getBr_Person() {
		return br_Person;
	}
	
	void setAddress(String newAddress) {
		address = newAddress;
	}
	
	void setNumber_ID(int newNumber_ID) {
		number_ID = newNumber_ID;
	}
	
	void setBr_Person(int newBr_Person) {
		br_Person = newBr_Person;
	}
	
	void read() {
		System.out.print("Address: ");
		sc.reset();
		address = sc.next();
		
		System.out.print("ID: ");
		sc.reset();
		number_ID = sc.nextInt();
		
		System.out.print("Number of people: ");
		sc.reset();
		br_Person = sc.nextInt();
	}
	
	void addPerson(int br) {
		br_Person += br_Person + br;
	}
	
	public String toString() {
		return "The address of the upcoming event is " + address + ", the ID is " + number_ID + " and the number of the people is " + br_Person;
	}
}

class School extends Becoming_a_teacher {
	
	String nameOfSchool;
	static Date last_updated = new Date();
	int br_teachers = 0;
	
	School() {
		nameOfSchool = "SMG";
		Instant now = Instant.now();
		last_updated = Date.from(now);
		br_teachers = 0;
	}
	
	School(String name, int br_teachers) {
		this.nameOfSchool = name;
		this.br_teachers = br_teachers;
		addPerson(br_teachers);
		Instant now = Instant.now();
		last_updated = Date.from(now);
	}
	
	String getNameOfSchool() {
		return nameOfSchool;
	}
	
	Date getDate() {
		return last_updated;
	}
	
	int getBr_teachers() {
		return br_teachers;
	}
	
	void setNameOfSchool(String newName) {
		nameOfSchool = newName;
		Instant now = Instant.now();
		last_updated = Date.from(now);
	}
	
	void setBr_teachers(int newBr_teachers) {
		addPerson(newBr_teachers - br_teachers);
		br_teachers = newBr_teachers;
		Instant now = Instant.now();
		last_updated = Date.from(now);
	}
	
	void read() {
		System.out.print("School name: ");
		sc.reset();
		nameOfSchool = sc.next();
		
		System.out.print("Number of teachers: ");
		sc.reset();
		br_teachers = sc.nextInt();
		
		Instant now = Instant.now();
		last_updated = Date.from(now);
	}
	
	@Override
	void addPerson(int br_t) {
		br_teachers += br_t;
		super.addPerson(br_t);
		Instant now = Instant.now();
		last_updated = Date.from(now);
	}
	
	@Override
	public String toString() {
		return "The name of the school is " + nameOfSchool + " and it has " + br_teachers + ". It was last updated on " + last_updated;
	}
}

class Presentor extends Becoming_a_teacher {
	
	int ID;
	String Status;
	Becoming_a_teacher name;
	
	Presentor() {
		ID = 1;
		Status = "online";
		name = new Becoming_a_teacher();
		super.addPerson(1);
	}
	
	Presentor(int ID, String Status, Becoming_a_teacher name) {
		this.ID = ID;
		this.Status = Status;
		this.name = name;
		super.addPerson(1);
	}
	
	int getID() {
		return ID;
	}
	
	String getStatus() {
		return Status;
	}
	
	Becoming_a_teacher getName() {
		return name;
	}
	
	void setID(int newID) {
		ID = newID;
	}
	
	void setStatus(String newStatus) {
		Status = newStatus;
	}
	
	void setName(Becoming_a_teacher newName) {
		name=newName;
	}
	
	void read() {
		System.out.print("ID: ");
		sc.reset();
		ID = sc.nextInt();
		
		System.out.print("Status: ");
		sc.reset();
		Status = sc.next();
		
		this.read();
		
		super.addPerson(1);
	}
	
	@Override
	public String toString() {
		return "The status of the presentor is " + Status + " and his ID is " + ID + ".  The address of his upcoming event is " + address + ", the ID is " + number_ID + " and the number of the people is " + br_Person;
	}
}

class Storage extends Becoming_a_teacher {
	
	String namefile1;
	String namefile2;
	int br_Person = 0;
	
	Storage() {
		namefile1 = "File 1";
		namefile2 = "File 2";
		br_Person = 0;
	}
	
	Storage(String namefile1, String namefile2, int br_Person) {
		this.namefile1 = namefile1;
		this.namefile2 = namefile2;
		this.br_Person = br_Person;
		this.addPerson(br_Person);
	}
	
	String getNamefile1() {
		return namefile1;
	}
	
	String getNamefile2() {
		return namefile2;
	}
	
	int getBr_Person() {
		return br_Person;
	}
	
	void setNamefile1(String newNamefile1) {
		namefile1 = newNamefile1;
	}
	
	void setNamefile2(String newNamefile2) {
		namefile1 = newNamefile2;
	}
	
	void setBr_Person(int newBr_Person) {
		this.addPerson(newBr_Person - br_Person);
		br_Person = newBr_Person;
	}
	
	void read() {
		System.out.print("Namefile 1: ");
		sc.reset();
		namefile1 = sc.next();
		
		System.out.print("Namefile 2: ");
		sc.reset();
		namefile2 = sc.next();
		
		System.out.print("Number of people: ");
		sc.reset();
		br_Person = sc.nextInt();
	}
	
	@Override
	public String toString() {
		return "The namefiles of this storage are " + namefile1 + " and " + namefile2 + ". The number of people is " + br_Person;
	}
}

class Person extends School {
	
	String name;
	String title;
	static Date added = new Date();
	
	Person() {
		name = "Vanessa";
		title = "Math teacher";
		Instant now = Instant.now();
		added = Date.from(now);
		this.addPerson(1);
	}
	
	Person(String name, String title) {
		this.name = name;
		this.title = title;
		Instant now = Instant.now();
		added = Date.from(now);
		this.addPerson(1);
	}
	
	String getName() {
		return name;
	}
	
	String getTitle() {
		return title;
	}
	
	Date getAdded() {
		return added;
	}
	
	void setName(String newName) {
		name = newName;
	}
	
	void setTitle(String newTitle) {
		title = newTitle;
	}
	
	void read() {
		System.out.print("Name: ");
		sc.reset();
		name = sc.next();
		
		System.out.print("Title: ");
		sc.reset();
		title = sc.next();
		
		Instant now = Instant.now();
		added = Date.from(now);
		
		this.addPerson(1);
	}
	
	@Override
	public String toString() {
		return "This is " + name + " and he/she is a " + title + ". Last added: " + added;
	}
}

public class Teacher_Course {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the info of the event.");
		Becoming_a_teacher event = new Becoming_a_teacher();
		event.read();
		
		System.out.println("Enter the info of the school whose teachers will be invited.");
		School school = new School();
		school.read();
		
		System.out.println("How many people would you like to add?");
		sc.reset();

		int numberOfPeople = sc.nextInt();
		Person[] audience = new Person[numberOfPeople];
		for(int i=0; i<numberOfPeople; i++) {
			System.out.println("Person " + (i+1));
			sc.reset();
			audience[i] = new Person(); 
			audience[i].read();
		}
		System.out.println(event.getBr_Person());
	}

	static String Print(Object obj) {
		if(obj instanceof Becoming_a_teacher)return obj.toString();
		else return "I don't know how to do this.";
	}
}
