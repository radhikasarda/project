package hib_HQL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	private int address_id;
	
	private String city;
	
	
	
	
	
	Address(){
		
	}
	

	public Address(String city) {
		super();
		this.city = city;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAddress_id() {
		return address_id;
	}


	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", city=" + city + "]";
	}

	
	
	
	
	
	
	
	
}
