
public class Socio implements Comparable<Socio>{
	private String Nombre;
	private Integer Edad;
	private String Equipo;
	private String EstadoCivil;
	private String NivelEstudios;
	
	
	
	
	public Socio() {
		super();
	}

	public Socio(String nombre, Integer edad, String equipo, String estadoCivil, String nivelEstudios) {
		super();
		Nombre = nombre;
		Edad = edad;
		Equipo = equipo;
		EstadoCivil = estadoCivil;
		NivelEstudios = nivelEstudios;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Integer getEdad() {
		return Edad;
	}
	public void setEdad(Integer edad) {
		Edad = edad;
	}
	public String getEquipo() {
		return Equipo;
	}
	public void setEquipo(String equipo) {
		Equipo = equipo;
	}
	public String getEstadoCivil() {
		return EstadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		EstadoCivil = estadoCivil;
	}
	public String getNivelEstudios() {
		return NivelEstudios;
	}
	public void setNivelEstudios(String nivelEstudios) {
		NivelEstudios = nivelEstudios;
	}

	@Override
	public int compareTo(Socio e) {
		if(e.getEdad()>Edad) {
			return -1;
		}else if(e.getEdad()>Edad) {
			return 0;
		}else {
			return 1;
		}
	}
}
