package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Entity.User;

public class test {
	
	private static SessionFactory sf;
	private static Session s;
	private static Transaction tran;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration con = new Configuration().configure();
		ServiceRegistry ser = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		sf = con.buildSessionFactory(ser);
		s = sf.openSession();
		tran = s.beginTransaction();
		
		
		User u = new User("2", "2", "1");
		User i = new User("3", "4", "4");
		s.save(u);
		s.save(i);
		
		
		tran.commit();
		s.close();
		sf.close();
		
	}

}
