package hib_HQL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class UtilityClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

    	Configuration con=new Configuration().configure().addAnnotatedClass(Trainee.class).addAnnotatedClass(Phone.class).addAnnotatedClass(Address.class);
    	
    	SessionFactory sf=con.buildSessionFactory();
    	Session session=sf.openSession();
    	session.beginTransaction();
    	
    	int id = 0;
    	int id_address = 0;
    	Trainee trainee=new Trainee();
    	List<Phone> phoneNumbers=new ArrayList<>();
    	Address address=new Address();
    	
    	System.out.println("Enter Trainee's Name:");
    	
    	Scanner scanner=new Scanner(System.in);
    	String name=scanner.nextLine();
    	
    	Query query=session.createQuery("select trainee_id from Trainee t where t.trainee_name='"+ name+"'");
    	List list = query.list();
    	
    	if(list.isEmpty()) {
    		
    		trainee.setTrainee_name(name);
        	session.save(trainee);
        	
        	System.out.println("Enter Trainee's Num:");
        	String number=scanner.next();
        	
        	phoneNumbers.add(new Phone(number));
        	trainee.setPhone(phoneNumbers);
    	}
        	
        else
    		
    	{
    		
    		id=(int) list.get(0);
    		System.out.println(id);
	    	
	    	System.out.println("Enter Trainee's Num:");
	    	String number=scanner.next();
	    	Trainee trainee_object = (Trainee) session.get(Trainee.class,id);
        	trainee_object.getPhone().add(new Phone(number));
        	session.save(trainee_object);
        	 	
       }

        	System.out.println("Enter City:");
    		String city=scanner.next();
    		
        	
    		Query query2=session.createQuery("select address_id from Address a where a.city='"+ city+"'");
    		List list_city = query2.list();
        	
        	
        	if(list_city.isEmpty()) {
        		System.out.println("CITY####"+city);
        		address.setCity(city);
        		trainee.setTraineeAddress(address);
            	session.save(address);
            	
            	
 
            
        	}
        	else {
        		
        		
        		id_address=(int) list_city.get(0);
     
        		System.out.println("ADDRESS ID######"+id_address);
        		
        		Address address_object = (Address) session.get(Address.class,id_address);
        		
        		System.out.println("CITY####"+city);
        		trainee.setTraineeAddress(address);
         
            }
        	
        	session.getTransaction().commit();
        	
        	
    	}
    
	}
    		
    	
    
	


