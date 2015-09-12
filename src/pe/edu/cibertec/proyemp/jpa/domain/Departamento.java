package pe.edu.cibertec.proyemp.jpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
		
	// Puedo usar Integer pero en base de datos habria q entender q tipo de dato es en java y en tabla
	// para evitar un conflicto de tipo de datos. Long vendria ser begin.Integer
	// lo mejor en usar Wrapper Long
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy="departamento",
			cascade = CascadeType.PERSIST)
	private List<Empleado> empleado = 
			new ArrayList<Empleado>();;
			
	public Departamento()
	{}
	
	public Departamento(String nombre)
	{
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Empleado> getEmpleado() {
		return empleado;
	}

	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}
	
}
