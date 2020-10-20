package conexion;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class conexion {
    java.sql.Connection con;
    public conexion(){
    
   }
    
    public java.sql.Connection getConexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliaria","eocampo","eocampo");
        return con;
    }
    public void close() throws SQLException{
        if(con!= null){
            con.close();
        }
    }
   
    public LinkedList listar(String s) throws SQLException{
        try{
            LinkedList list= new LinkedList();
            PreparedStatement ps=con.prepareStatement("select * from inmueble where descr like '%"+s+"%'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(("Nombre:" +rs.getString(2)+"</br>Apellido: "+rs.getString(3)+"</br></br>"));
            }
            return list;
        }catch (Exception e){
                e.printStackTrace();
            }
            return null;
    }
    
    
} 