# Main

### GradeTest

```java
package goodschool;

public class GradeTest {

	public static void main(String args[]) {
		
		Student kang = new Student("강감찬", 211213, new KoreanLanguage());
		Student kim = new Student("김유신", 212330, new ComputerScience());
		Student shin = new Student("신사임당", 201518, new KoreanLanguage());
		Student lee = new Student("이순신", 202360, new KoreanLanguage());
		Student hong = new Student("홍길동", 201290, new ComputerScience());
		
		GoodSchool.addStudent(kang);
		GoodSchool.addStudent(kim);
		GoodSchool.addStudent(shin);
		GoodSchool.addStudent(lee);
		GoodSchool.addStudent(hong);
		
		kang.setSubjectScoreGrade("국어", 95);
		kang.setSubjectScoreGrade("수학", 56);
		kim.setSubjectScoreGrade("국어", 95);
		kim.setSubjectScoreGrade("수학", 98);
		shin.setSubjectScoreGrade("국어", 100);
		shin.setSubjectScoreGrade("수학", 88);
		lee.setSubjectScoreGrade("국어", 89);
		lee.setSubjectScoreGrade("수학", 95);
		hong.setSubjectScoreGrade("국어", 83);
		hong.setSubjectScoreGrade("수학", 56);
		
		System.out.println("==========================================");
		System.out.println("                   국 어                   ");
		System.out.println("==========================================");
		System.out.println(" 수강생 |  학 번  |   전공(필수과목)  | 점수:학점");
		for (Student student : GoodSchool.studentList) {
			System.out.println("------------------------------------------");
			student.showStudentInfo("국어");
		}
		System.out.println("------------------------------------------\n");
		
		System.out.println("==========================================");
		System.out.println("                   수 학                   ");
		System.out.println("==========================================");
		System.out.println(" 수강생 |  학 번  |   전공(필수과목)  | 점수:학점");
		for (Student student : GoodSchool.studentList) {
			System.out.println("------------------------------------------");
			student.showStudentInfo("수학");
		}
		System.out.println("------------------------------------------");
		
	}
}
```

<br>

### 출력 결과

```
==========================================
                   국 어                   
==========================================
 수강생 |  학 번  |   전공(필수과목)  | 점수:학점
------------------------------------------
 강감찬 | 211213 | 국어국문학과(국어) |  95:S
------------------------------------------
 김유신 | 212330 | 컴퓨터공학과(수학) |  95:A
------------------------------------------
 신사임당 | 201518 | 국어국문학과(국어) |  100:S
------------------------------------------
 이순신 | 202360 | 국어국문학과(국어) |  89:B
------------------------------------------
 홍길동 | 201290 | 컴퓨터공학과(수학) |  83:B
------------------------------------------

==========================================
                   수 학                   
==========================================
 수강생 |  학 번  |   전공(필수과목)  | 점수:학점
------------------------------------------
 강감찬 | 211213 | 국어국문학과(국어) |  56:D
------------------------------------------
 김유신 | 212330 | 컴퓨터공학과(수학) |  98:S
------------------------------------------
 신사임당 | 201518 | 국어국문학과(국어) |  88:B
------------------------------------------
 이순신 | 202360 | 국어국문학과(국어) |  95:A
------------------------------------------
 홍길동 | 201290 | 컴퓨터공학과(수학) |  56:F
------------------------------------------
```