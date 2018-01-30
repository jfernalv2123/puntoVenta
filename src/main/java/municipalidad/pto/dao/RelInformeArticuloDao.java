package municipalidad.pto.dao;

import java.util.List;

import municipalidad.pto.model.RelInformeArticulo;

public interface RelInformeArticuloDao {
	RelInformeArticulo findRelInformeArticuloById(int id);
	List<RelInformeArticulo> listaRelIngresoArticulo();
	List<RelInformeArticulo> listaRelInformeArticuloByInforme(int id);
}
