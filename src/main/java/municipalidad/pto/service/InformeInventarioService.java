package municipalidad.pto.service;

import java.util.List;

import municipalidad.pto.model.InformeInventario;

public interface InformeInventarioService {
	InformeInventario findInformeInventarioById(int id);
	List<InformeInventario> listaInformeInventario();
	void updateInformeInventario(InformeInventario informe);
	void deleteInformeInventario(InformeInventario informe);
	void guardarInformeInventario(InformeInventario informe);
	Integer ultimoInforme();
}
