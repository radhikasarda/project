package hib_HQL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Trainee {
	
	private int trainee_id;
	
	private String trainee_name;
	
	private List<Phone> phone=new ArrayList<>();
	
	private Address traineeAddress;
	
	Trainee(){}
	
	
	

	public Trainee(String trainee_name, List<Phone> phone, Address traineeAddress) {
		super();
		this.trainee_name = trainee_name;
		this.phone = phone;
		this.traineeAddress = traineeAddress;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTrainee_id() {
		return trainee_id;
	}

	public void setTrainee_id(int trainee_id) {
		this.trainee_id = trainee_id;
	}

	public String getTrainee_name() {
		return trainee_name;
	}

	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}
	@OneToMany(cascade = CascadeType.ALL)
	
	@JoinTable(name = "TRAINEE_PHONE", joinColumns = { @JoinColumn(name = "TRAINEE_ID") }, inverseJoinColumns = { @JoinColumn(name = "PHONE_ID") })
	public List<Phone> getPhone() {
		return phone;
	}

	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}



	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinTable(name = "TRAINEE_ADDRESS", joinColumns = { @JoinColumn(name = "ADDRESS_ID") }, inverseJoinColumns = { @JoinColumn(name = "TRAINEE_ID") })
	@JoinColumn(name="address_id")
	public Address getTraineeAddress() {
		return traineeAddress;
	}




	public void setTraineeAddress(Address traineeAddress) {
		this.traineeAddress = traineeAddress;
	}




	@Override
	public String toString() {
		return "Trainee [trainee_id=" + trainee_id + ", trainee_name=" + trainee_name + ", phone=" + phone
				+ ", traineeAddress=" + traineeAddress + "]";
	}
	
	
	

}
