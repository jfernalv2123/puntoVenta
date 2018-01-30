package municipalidad.pto.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import municipalidad.pto.dao.DireccionProveedorDao;
import municipalidad.pto.dao.FonoDao;
import municipalidad.pto.dao.GenericDao;
import municipalidad.pto.dao.IngresoDao;
import municipalidad.pto.dao.MailDao;
import municipalidad.pto.dao.ProveedorDao;
import municipalidad.pto.model.DireccionProveedor;
import municipalidad.pto.model.Fono;
import municipalidad.pto.model.Mail;
import municipalidad.pto.model.Proveedor;
import municipalidad.pto.objetos.ProveedoresTabla;
import municipalidad.pto.service.ProveedorService;

@Service("proveedorService")
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	GenericDao genericDao;
	@Autowired
	ProveedorDao proveedorDao;
	@Autowired
	MailDao mailDao;
	@Autowired
	FonoDao fonoDao;
	@Autowired
	IngresoDao ingresoDao;
	@Autowired
	DireccionProveedorDao direccionProveedorDao;
	
	@Transactional
	public void persistProveedor(Proveedor proveedor) {
		genericDao.Guardar(proveedor);
		
	}
	@Transactional
	public Proveedor findProveedorById(int id) {
	
		return proveedorDao.findProveedorById(id);
	}
	@Transactional
	public void updateProveedor(Proveedor proveedor) {
		genericDao.update(proveedor);
		
	}
	@Transactional
	public void deleteProveedor(Proveedor proveedor) {
		genericDao.delete(proveedor);
		
	}
	@Transactional
	public List<Proveedor> listaProveedor() {
		return proveedorDao.listaProveedor();
	}
	@Transactional
	public List<SelectItem> comboProveedor(){
		return proveedorDao.comboProveedor();
	}
	@Transactional
	public Proveedor proveedorBynombre(String proveedor){
		return proveedorDao.proveedorBynombre(proveedor);
	}
	@Transactional
	public List<ProveedoresTabla> listaProveedores(){
		List<Proveedor> listaPro=proveedorDao.listaProveedor();
		List<ProveedoresTabla> listaAux=new ArrayList<ProveedoresTabla>();
		for(Proveedor p:listaPro){
			ProveedoresTabla provTabla=new ProveedoresTabla();
			provTabla.setIdProveedor(p.getIdProveedor());
			provTabla.setProveedor(p.getProveedor());
			provTabla.setCategoria(p.getCategoria());
			provTabla.setRazonSocial(p.getRazonSocial());

			String mailAux="";
			String fonoAux="";
			String direccionAux="";
			List<DireccionProveedor> direccionProveedor = new ArrayList<DireccionProveedor>();
			List<Mail> mailList = new ArrayList<Mail>();
			List<Fono> fonoList = new ArrayList<Fono>();
			for(Fono fo:fonoDao.listaFonosByProveedor(p.getIdProveedor())){
				fonoList.add(fo);
				fonoAux+=fo.getFono();
				fonoAux+="  ";
			}
			for(Mail m:mailDao.listaMailByProveedor(p.getIdProveedor())){
				mailList.add(m);
				mailAux+=m.getMail();
				mailAux+="  ";
			}
			
			for(DireccionProveedor d:direccionProveedorDao.listaDireccionProveedorByProveedor(p.getIdProveedor())){	
				direccionProveedor.add(d);
				direccionAux+=d.getDireccion()+","+d.getCiudad()+","+d.getRegion()+"  ";
				
			}
			provTabla.setFonoList(fonoList);
			provTabla.setMailList(mailList);
			provTabla.setDireccionProveedor(direccionProveedor);
			provTabla.setMail(mailAux);
			provTabla.setFono(fonoAux);
			provTabla.setDireccion(direccionAux);
			provTabla.setCantidadArticulos(12);
//			provTabla.setCantidadArticulos(ingresoDao.ingresosByProveedor(p.getIdProveedor()));
			listaAux.add(provTabla);
		}
		
		return listaAux;
	}
	@Transactional
	public List<String> nombreProveedorByName(String proveedor){
		return proveedorDao.nombreProveedorByName(proveedor);
	}
	@Transactional
	public List<Proveedor> buscadorTablaProveedores(Integer id, String proveedor, boolean credito, String articulo,
			Integer categoria, String fono, String mail, String direccion, String ciudad, String region){
		return proveedorDao.buscadorTablaProveedores(id, proveedor, credito, articulo, categoria, fono, mail, direccion, ciudad, region);
	}
}
