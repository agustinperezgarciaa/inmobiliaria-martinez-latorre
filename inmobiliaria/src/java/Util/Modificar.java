package Util;
import Entidad.Venta;
import Entidad.Garante;
import Entidad.Alquileres;
import Entidad.Administrador;
import Entidad.Cliente;
import Entidad.Propietario;
import Entidad.Imagen;
import Entidad.ClientePosible;
import Entidad.Inmueble;
import Entidad.Barrio;
import java.util.Calendar;
import java.util.Date;

//Modifica cada entidad con nuevos datos
public class Modificar {
    public void ModInm(Inmueble inm,String diponibilidad){
        inm.setDisp(diponibilidad);
    }
    public void ModAdmin (Administrador ad, String email,String nombre,String apellido,String dni,String direcc,
                          String telFijo,String telMovil,String loc,Date fechaNac,String pagWeb, String usuario,
                          String password){
        ad.setEmail(email);
        ad.setNombre(nombre);
        ad.setApellido(apellido);
        ad.setDni(dni);
        ad.setDirecc(direcc);
        ad.setTelFijo(telFijo);
        ad.setTelMovil(telMovil);
        ad.setLoc(loc);
        ad.setFechaNac(fechaNac);
        ad.setPagWeb(pagWeb);
        ad.setUsuario(usuario);
        ad.setPassword(password);
     }
     public void modContra (Administrador ad, String password){
         ad.setPassword(password);
     }
        public void ModAdminSinPass (Administrador ad, String email,String nombre,String apellido,String dni,String direcc,
                          String telFijo,String telMovil,String loc,Date fechaNac,String pagWeb, String usuario){
        ad.setEmail(email);
        ad.setNombre(nombre);
        ad.setApellido(apellido);
        ad.setDni(dni);
        ad.setDirecc(direcc);
        ad.setTelFijo(telFijo);
        ad.setTelMovil(telMovil);
        ad.setLoc(loc);
        ad.setFechaNac(fechaNac);
        ad.setPagWeb(pagWeb);
        ad.setUsuario(usuario);
     }
    
    public void ModAlquiler (Alquileres alq,Date fecha,Cliente alquila,Inmueble alquilado,
                             Administrador administra,Garante garantiza, long monto){       
        alq.setFecha(fecha);
        alq.setAlquila(alquila);
        alq.setAlquilado(alquilado);
        alq.setAdministra(administra);
        alq.setGarantiza(garantiza);
        alq.setMonto(monto);
    }
    
    public void ModCliente (Cliente cli, String email,String nombre,String apellido,String dni,String direcc,String telFijo,
                            String telMovil,String loc,Date fechaNac){
        cli.setEmail(email);
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setDni(dni);
        cli.setDirecc(direcc);
        cli.setTelFijo(telFijo);
        cli.setTelMovil(telMovil);
        cli.setLoc(loc);
        cli.setFechaNac(fechaNac);
    }
    
        public void ModClientePos (ClientePosible cliPos, String email,String nombre,String apellido,String dni,String direcc,String telFijo,
                                   String telMovil,String loc,Date fechaNac, String estado){
        cliPos.setEmail(email);
        cliPos.setNombre(nombre);
        cliPos.setApellido(apellido);
        cliPos.setDni(dni);
        cliPos.setDirecc(direcc);
        cliPos.setTelFijo(telFijo);
        cliPos.setTelMovil(telMovil);
        cliPos.setLoc(loc);
        cliPos.setFechaNac(fechaNac);
        cliPos.setEstado(estado);
    }
    
    public void ModGarante(Garante gar, String email,String nombre,String apellido,String dni,String direcc,String telFijo,
                           String telMovil,String loc,Date fechaNac,String profesion,
                           String lugarTrabajo,String nacionalidad){
        gar.setEmail(email);
        gar.setNombre(nombre);
        gar.setApellido(apellido);
        gar.setDni(dni);
        gar.setDirecc(direcc);
        gar.setTelFijo(telFijo);
        gar.setTelMovil(telMovil);
        gar.setLoc(loc);
        gar.setFechaNac(fechaNac);
        gar.setProfesion(profesion);
        gar.setLugarTrabajo(lugarTrabajo);
        gar.setNacionalidad(nacionalidad);
    }
    
    public void ModPropietario (Propietario prop, String email,String nombre,String apellido,String dni,
                                String direcc,String telFijo,String telMovil,String loc,Date fechaNac){
        prop.setEmail(email);
        prop.setNombre(nombre);
        prop.setApellido(apellido);
        prop.setDni(dni);
        prop.setDirecc(direcc);
        prop.setTelFijo(telFijo);
        prop.setTelMovil(telMovil);
        prop.setLoc(loc);
        prop.setFechaNac(fechaNac);
    }
    
    public void ModVenta (Venta ven,Date fecha,Cliente vende,Inmueble vendido,Administrador administra, long monto){       
        ven.setFecha(fecha);
        ven.setVende(vende);
        ven.setVendido(vendido);
        ven.setAdministra(administra);
        ven.setMonto(monto);
    }
    
    public void ModInmueble(Inmueble inm, String operacion,Propietario posee,String tipo,int precio,String descr,
                            Barrio tiene,String dire,String disponibilidad){
        inm.setOperacion(operacion);
        inm.setPropietario(posee);
        inm.setTipo(tipo);
        inm.setValor(precio);
        inm.setDescripcion(descr);
        inm.setBarrio(tiene);
        inm.setDireccion(dire);
        inm.setDisp(disponibilidad);
    }
    
    public void ModImagen(Imagen img, String path,Inmueble inm,String tipo){
        img.setPath(path);
        img.setInmueble(inm);
        img.setTipo(tipo);
    }
        
}