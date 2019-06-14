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

		Configuration con = new Configuration().configure().addAnnotatedClass(Trainee.class)
				.addAnnotatedClass(Phone.class).addAnnotatedClass(Address.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		int id = 0;
		int id_address = 0;
		Trainee trainee ;
		List<Phone> phoneNumbers = new ArrayList<>();
		Address address = new Address();

		System.out.println("Enter Trainee's Name:");

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		List list = session.createQuery("select trainee_id from Trainee t where t.trainee_name='" + name + "'").getResultList();
		/* List list = query.list(); */

		if (list.isEmpty()) {

			trainee=new Trainee();
			trainee.setTrainee_name(name);
			session.save(trainee);

			System.out.println("Enter Trainee's Num:");
			String number = scanner.next();

			phoneNumbers.add(new Phone(number));
			trainee.setPhone(phoneNumbers);
		}

		else

		{

			id = (int) list.get(0);
			//System.out.println(id);

			System.out.println("Enter Trainee's Num:");
			String number = scanner.next();
			trainee=(Trainee) session.get(Trainee.class, id);
			trainee.getPhone().add(new Phone(number));
			session.save(trainee);

		}

		System.out.println("Enter City:");
		String city = scanner.next();

		List list_city= session.createQuery("select address_id from Address a where a.city='" + city + "'").getResultList();
		/*List list_city = query2.list();*/

		if (list_city.isEmpty()) {
			
			address.setCity(city);
			trainee.setTraineeAddress(address);
			session.save(trainee);

		} else {

			id_address = (int) list_city.get(0);

			Address address_object = (Address) session.get(Address.class, id_address);

			trainee.setTraineeAddress(address);

		}

		session.getTransaction().commit();

	}

}
