package in.akash.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert(value = true)
@DynamicUpdate(value = true)
public class Student {

	@Id

	private Integer sid;

	private String sName;

	private String sAddres;

	private Integer sAge;

	public Student() {
		System.out.println("zero argument constructors are used by Hibernate Internally.");
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddres() {
		return sAddres;
	}

	public void setsAddres(String sAddres) {
		this.sAddres = sAddres;
	}

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sAddres=" + sAddres + ", sAge=" + sAge + "]";
	}
}
