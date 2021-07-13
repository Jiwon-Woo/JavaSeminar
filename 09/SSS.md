# School, Student, Subject

### GoodSchool class

```java
package goodschool;
import java.util.ArrayList;

public class GoodSchool {
	
	static private GoodSchool goodSchool = new GoodSchool();
	static public ArrayList<Student> studentList; 
	
	private GoodSchool() {
		studentList = new ArrayList<Student>(); 
	}
	
	static public GoodSchool getGoodSchool() {
		return goodSchool;
	}
	
	static public int studentNumber() {
		return studentList.size();
	}
	
	static public void addStudent(Student student) {
		studentList.add(student);
	}
	
	static public Student removeStudent(Student student) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i) == student) {
				return studentList.remove(i);
			}
		}
		return null;
	}

}
```

<br>

### Student class

```java
package goodschool;
import java.util.ArrayList;

public class Student {
	
	public String name;
	public int studentNumber;
	public Major major;
	public ArrayList<Subject> subjectList;
	
	public Student(String name, int studentNumber, Major major){
		this.name = name;
		this.studentNumber = studentNumber;
		this.major = major;
		this.subjectList = new ArrayList<Subject>();
		initSubjectList();
	}
	
	private void initSubjectList() {
		registerSubject("수학");
		registerSubject("국어");
	}
	
	public void registerSubject(String subjectName) {
		subjectList.add(new Subject(subjectName, major.mandatorySubject == subjectName));
	}
	
	public void setSubjectGrade(String subjectName) {
		for (Subject subject : subjectList) {
			if (subject.name == subjectName) {
				subject.setGrade();
				return ;
			}
		}
	}
	
	public void setSubjectScoreGrade(String subjectName, int score) {
		for (Subject subject : subjectList) {
			if (subject.name == subjectName) {
				subject.setScoreGrade(score);
				return ;
			}
		}
	}
	
	
	public void showStudentInfo() {
		System.out.print(name + " | " + studentNumber +  " | "
				+ major.name + "(" + major.mandatorySubject + ") |");
	}
	
	public void showStudentInfo(String subjectName) {
		System.out.print(" " + name + " | " + studentNumber +  " | "
				+ major.name + "(" + major.mandatorySubject + ") |");
		for (Subject subject : subjectList) {
			subject.showSubjectInfo(subjectName);
		}
		System.out.println();
	}

}
```

<br>

### Subject

```java
package goodschool;

public class Subject {
	
	public String name;
	public boolean isMandatory;
	public int score;
	public String grade;
	
	public Subject(String name, boolean isMandatory) {
		this.name = name;
		this.isMandatory = isMandatory;
	}

	public void setGrade() {
	
		GradePolicy gradePolicy;
		
		if (isMandatory == true) {
			gradePolicy = new MandatorySubjectPolicy();			
		}
		else {
			gradePolicy = new SelectiveSubjectPolicy();
		}
		
		this.grade = gradePolicy.classifyGrade(this.score);
	}
	
	public void setScoreGrade(int score) {
		this.score = score;
		setGrade();
	}
	
	public void showSubjectInfo() {
		System.out.print("  " + score + ":" + grade);
	}
	
	public void showSubjectInfo(String subject) {
		if (subject != name)
			return;
		System.out.print("  " + score + ":" + grade);
	}

}
```