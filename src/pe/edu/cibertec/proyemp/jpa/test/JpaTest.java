package pe.edu.cibertec.proyemp.jpa.test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pe.edu.cibertec.proyemp.jpa.domain.Departamento;
import pe.edu.cibertec.proyemp.jpa.domain.Empleado;

public class JpaTest {
	
	private	EntityManager manager;
	
	public JpaTest(EntityManager manager)
	{
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory(
						"persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		//try {
		//	test.crearEmpleados();
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		
		test.crearEmpleados2();
		
		tx.commit();

		test.listarEmpleados();

		//System.out.println(".. done");
	}
	
	private void crearEmpleados() {
		//int nroDeEmpleados = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList().size();
		//if (nroDeEmpleados == 0) {
			Departamento departamento = new Departamento("Java");
			manager.persist(departamento);
			//creo guardo guardo
			Empleado emp1= new Empleado("Boby");
			Empleado emp2= new Empleado("Mikee");
			
			manager.persist(emp2);
			manager.persist(emp1);

		//}
	}
	
	private void crearEmpleados2() {
		
		//creo guardo al final
		Departamento java = new Departamento("Java");
		Empleado emp1= new Empleado("Boby");
		Empleado emp2= new Empleado("Mikee");
		
		//List<Empleado> empleados = new ArrayList<Empleado>();
		//empleados.add(emp1);
		//empleados.add(emp2);
		//Refactorizando
		
			
		java.setEmpleado(Arrays.asList(emp1, emp2));
		manager.persist(java);
	}
	
	//private void crearDepartamento() {
		//int nroDeEmpleados = manager.createQuery("Select a From Empleado a", Empleado.class).getResultList().size();
		//if (nroDeEmpleados == 0) {
		//	Departamento departamento = new Departamento(".NET");
		
		//}
	//}

	/**
	 * Este metodo hace una consulta OJO a la entidad
	 * EL JPA realiza un query "HQL/JQL" a la entidad esta reconoce q tabla es
	 * y por debajo hace la consulta con elmysql y la compara con una clase
	 * de tipo Empleado y retorna la lista  
	 */
	private void listarEmpleados() {
		//HQL
		List<Empleado> resultList = manager.createQuery(
				"Select a From Empleado a", Empleado.class).getResultList();
		//SQL
		//List<Empleado> resultList = manager.createNativeQuery(
		//		"Select * From Empleado ", Empleado.class).getResultList();
				
		System.out.println("nro de empleados:" + resultList.size());
		for (Empleado next : resultList) {
			System.out.println("siguiente empleado: " + next);
		}
	}

}
