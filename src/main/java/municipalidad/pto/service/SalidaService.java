package municipalidad.pto.service;

import java.util.List;

import municipalidad.pto.model.Salida;

public interface SalidaService {
	void persistSalida(Salida salida);
	Salida findSalidaById(int id);
	void updateSalida(Salida salida);
	void deleteSalida(Salida salida);
	List<Salida> listaSalidas();
	Integer ultimoIngreso();
}
