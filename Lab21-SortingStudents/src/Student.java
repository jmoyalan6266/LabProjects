
public class Student implements Comparable<Student> {
	private String name;
	private int studentID;

	public Student(String name2, int studentID2) {
		this.name = name2;
		this.studentID = studentID2;
	}

	public int getStuID() {
		return studentID;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return studentID + ": " + name;
	}

	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		if (this.studentID == s.getStuID()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @Override public int compareTo(Student s) { if (s.getStuID() ==
	 * studentID) { return 0; } else if (this.studentID > s.getStuID()) { return
	 * 1; } else { return -1; }
	 * 
	 * }
	 */
	@Override
	public int compareTo(Student s) {
		if (name.compareTo(s.getName()) > 0) {
			return 1;
		} else if (name.compareTo(s.getName()) == 0) {
			return 0;
		} else {
			return -1;
		}
	}
}
