package com.abc.prq.EmployeeCRUDUsingHb;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        
        
        //add
//        Employee s=new Employee();
//    	s.setId(101);
//    	s.setName("Harsh Choudhary");
//    	s.setAge(21);
//    	System.out.println(s);
//    	Configuration conf=new Configuration().addAnnotatedClass(Employee.class);
//    	conf.configure("hibernate.cfg.xml"); //class
//    	SessionFactory sf=conf.buildSessionFactory(); // interface
//	    Session session=sf.openSession(); //interface
//	    Transaction tx=session.beginTransaction();
//    	session.save(s);
//    	tx.commit();
//    	session.close();
//    	sf.close();
//	    System.out.println(session);
        while(true)
        {
        	System.out.println("***************Employee Details****************");
        	System.out.println("1. Add");
        	System.out.println("2. Update");
        	System.out.println("3. Delete");
        	System.out.println("4. Display");
        	System.out.println("5. Sort based on id");
        	System.out.println("6. Get the data with range");
        	System.out.println("7. Exit");
        	System.out.println("\n\nEnter your choice (1-7):");
        	Scanner sc=new Scanner(System.in);
        	int ch=Integer.parseInt(sc.nextLine());
        	
        	
        	if(ch==1)
        	{
        		System.out.println("add got called");
        		//Scanner sc=new Scanner(System.in);
        	    int id;
        	    String name;
        	    int age;
        	    System.out.println("Enter id :");
        	    id=Integer.parseInt(sc.nextLine());
        	    System.out.println("Enter name :");
        	    name=sc.nextLine();
        	    System.out.println("Enter age :");
        	    age=Integer.parseInt(sc.nextLine());
        	    Configuration cnf=new Configuration().addAnnotatedClass(Employee.class);
        	    cnf.configure("hibernate.cfg.xml");
        	    SessionFactory sessionFactory=cnf.buildSessionFactory();
        	    Session session=sessionFactory.openSession();
        	    Transaction transaction=session.beginTransaction();
        	    
        	    Employee employee=new Employee();
        	    employee.setId(id);
        	    employee.setName(name);
        	    employee.setAge(age);
        
        	    session.save(employee);
        	    transaction.commit();
        	    session.close();
        	    System.out.println("added successfully");
        	    
        	}else
        	if(ch==2)
        	{
        		System.out.println("update got called");
        	    int id;
        	    String name;
        	    int age;
        	    System.out.println("Enter id :");
        	    id=Integer.parseInt(sc.nextLine());
        	    System.out.println("Enter name :");
        	    name=sc.nextLine();
        	    System.out.println("Enter age :");
        	    age=Integer.parseInt(sc.nextLine());
        	    
        	    Configuration cnf=new Configuration().addAnnotatedClass(Employee.class);
        	    cnf.configure("hibernate.cfg.xml");
        	    SessionFactory sessionFactory=cnf.buildSessionFactory();
        	    Session session=sessionFactory.openSession();
        	    Transaction transaction=session.beginTransaction();
        	    Employee employee=session.get(Employee.class,id);
        	    employee.setName(name);
        	    employee.setAge(age);
        	    transaction.commit();
        	    session.close();
        	    
        	    System.out.println("updated successfully");
        		
        	}else
        	if(ch==3)
        	{
        		System.out.println("delete got called");
        		int id;
        	    System.out.println("Enter id :");
        	    id=Integer.parseInt(sc.nextLine());
        		Configuration cnf=new Configuration().addAnnotatedClass(Employee.class);
        		cnf.configure("hibernate.cfg.xml");
        		SessionFactory sessionFactory=cnf.buildSessionFactory();
        		Session session=sessionFactory.openSession();
        		Transaction transaction=session.beginTransaction();
        		Employee employee=session.get(Employee.class, id);
        		session.delete(employee);
        		transaction.commit();
        		session.close();
        		System.out.println("Delete got called successfully");
        	}else
        	if(ch==4)
        	{
        		System.out.println("display got called");
        		Configuration cnf=new Configuration().addAnnotatedClass(Employee.class);
        		cnf.configure("hibernate.cfg.xml");
        		SessionFactory sessionFactory=cnf.buildSessionFactory();
        		Session session=sessionFactory.openSession();
        		Query query=session.createQuery("from Employee");
        		List<Employee> employeeList=query.list();
        		for(Employee e:employeeList)
        		{
        			System.out.println("Id :"+e.getId()+" Name : "+e.getName()+" age :"+e.getAge());
        		}
        		session.close();
        		System.out.println("Display got called successfully");
        	}else
        	if(ch==5)
        	{
        		System.out.println("sort based on Id got called");
        		Configuration cnf=new Configuration().addAnnotatedClass(Employee.class);
        		cnf.configure("hibernate.cfg.xml");
        		SessionFactory sessionFactory=cnf.buildSessionFactory();
        		Session session=sessionFactory.openSession();
        		Query query=session.createQuery("from Employee");
        		List<Employee> employeeList=query.list();
        		Collections.sort(employeeList,Collections.reverseOrder());
        		for(Employee e:employeeList)
        		{
        			System.out.println("Id :"+e.getId()+" Name : "+e.getName()+" age :"+e.getAge());
        		}
        		session.close();
        		System.out.println("sort based on Id got called successfully");
        	}else
        	if(ch==6)
        	{
        		System.out.println("get data with range got called");
        		int startId;
        		int endId;
        		System.out.println("Enter start range (Id) :");
        		startId=Integer.parseInt(sc.nextLine());
        		System.out.println("Enter end range (Id) :");
        		endId=Integer.parseInt(sc.nextLine());
        		
        		Configuration cnf=new Configuration().addAnnotatedClass(Employee.class);
        		cnf.configure("hibernate.cfg.xml");
        		SessionFactory sessionFactory=cnf.buildSessionFactory();
        		Session session=sessionFactory.openSession();
        		Query query=session.createQuery("from Employee E where E.id between :start and :end");
        		query.setParameter("start",startId);
        		query.setParameter("end",endId);
        		
        		List<Employee> employeeList=query.list();
        		for(Employee e:employeeList)
        		{
        			System.out.println("Id :"+e.getId()+" Name : "+e.getName()+" age :"+e.getAge());
        		}
        		session.close();
        		System.out.println("get data with range got called successfully");
        	}else
        	if(ch==7)
        	{
        		System.out.println("Bye, Have a good day");
        		break;
        	}
        }
    }
}
