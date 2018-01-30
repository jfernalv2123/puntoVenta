package municipalidad.pto.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import municipalidad.pto.model.Fono;
import municipalidad.pto.model.Proveedor;

public interface FonoDao {

	Fono findFonoById(int id);
	List<Fono> listaFonos();
	List<SelectItem> comboFono();
	List<Fono> listaFonosByProveedor(Integer proveedor);
	List<String> nombreFonoByName(String fono);
}
