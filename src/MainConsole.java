

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Address;
import com.example.Person;

public class MainConsole {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();

		Collection<Address> address=new ArrayList<Address>();
		Address addr1=new Address();
		addr1.setCity("Lucknow");
		
		address.add(addr1);
		
		Person person=new Person();
		person.setPersonId(0);
		person.setDob(new Date());
		
		person.setAddress(address);
		
		
		session.save(person);
		
		transaction.commit();
		
		
		@SuppressWarnings("unchecked")
		java.util.List<Person> persons= session.createCriteria(Person.class, "0").list();
		
		Iterator<Person> iterator=persons.iterator();
		
		while (iterator.hasNext()) {
			Person person2 = iterator.next();
			
			System.out.println(person2.getDob().getDate());
			System.out.println(person2.getAddress().iterator().next().getCity());
			
		}
		
		sessionFactory.close();
		

	}

}
