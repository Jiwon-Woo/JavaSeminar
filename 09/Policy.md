# Policy

### GradePolicy Interface

```java
package goodschool;

public interface GradePolicy {
	
	public String classifyGrade(int score);

}
```

<br>

### Mandatory Subject Policy class

```java
package goodschool;

public class MandatorySubjectPolicy implements GradePolicy {

	@Override
	public String classifyGrade(int score) {
		if (100 >= score && score >=95) {
			return "S";
		}
		else if (95 > score && score >= 90) {
			return "A";
		}
		else if (90 > score && score >= 80) {
			return "B";
		}
		else if (80 > score && score >= 70) {
			return "C";
		}
		else if (70 > score && score >= 60) {
			return "D";
		}
		else if (60 > score && score >= 0) {
			return "F";
		}
		else {
			return null;			
		}
	}

}
```

<br>

### Selective Subject Policy class

```java
package goodschool;

public class SelectiveSubjectPolicy implements GradePolicy {

	@Override
	public String classifyGrade(int score) {
		if (100 >= score && score >= 90) {
			return "A";
		}
		else if (90 > score && score >= 80) {
			return "B";
		}
		else if (80 > score && score >= 70) {
			return "C";
		}
		else if (70 > score && score >= 55) {
			return "D";
		}
		else if (55 > score && score >= 0) {
			return "F";
		}
		else {
			return null;			
		}
	}

}
```