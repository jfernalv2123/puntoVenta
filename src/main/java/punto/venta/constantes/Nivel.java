package punto.venta.constantes;

import java.io.Serializable;

public class Nivel implements Serializable {

	private Integer nivel;
	private String cargo;

	public Nivel(Integer nivel,String cargo){
		this.nivel=nivel;
		this.cargo=cargo;
	}
	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
