package hib_HQL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone {

	
	private int phone_id;
	
	private  String phone_number;
	
	Phone(){}

	public Phone(String phone_number) {
		super();
		
		this.phone_number = phone_number;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getPhone_id() {
		return phone_id;
	}

	public void setPhone_id(int phone_id) {
		this.phone_id = phone_id;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Phone [phone_id=" + phone_id + ", phone_number=" + phone_number + "]";
	}


	
	
}
