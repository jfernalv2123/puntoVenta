package municipalidad.pto.service;

import java.util.List;

import javax.faces.model.SelectItem;

import municipalidad.pto.model.Fono;
import municipalidad.pto.model.Proveedor;

public interface FonoService {

	void persistFono(Fono fono);
	Fono findFonoById(int id);
	void updateFono(Fono fono);
	void deleteFono(Fono fono);
	List<Fono> listaFonos();
	List<SelectItem> comboFono();
	List<Fono> listaFonosByProveedor(Integer proveedor);
	List<String> nombreFonoByName(String fono);
}
