package com.hams.ferrechinuapp.control;

import com.hams.ferrechinuapp.entidad.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;

@Controller
public class ClienteControl {
    Cliente cliente;
    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }
    @GetMapping("/listar")
    public String listarClientes(){
        String url = "jdbc:mariadb://localhost:3306/ferrechinusas?useSSL=false";
        String user = "hams";
        String password = "hualmasi";

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            Statement dec = cnn.createStatement();
            ResultSet r = dec.executeQuery("SELECT * FROM cliente;");
            while (r.next())
            {
                System.out.println("----------------------------------------------------------");
                System.out.println("Documento: " + r.getString("numero"));
                System.out.println("Nùmero: " + r.getString("Documento_tipo"));
                System.out.println("Nombres: " + r.getString("nombre"));
                System.out.println("Barrio: " + r.getString("barrio"));
                System.out.println("Dirección: " + r.getString("direccion"));
                System.out.println("Celular: " + r.getString("celular"));
                System.out.println("Correo: " + r.getString("correo"));
                System.out.println("Clave: " + r.getString("clave"));
            }
            dec.close();
            cnn.close();
            r.close();
            dec.close();
            cnn.close();
        }catch(SQLException e){
            e.printStackTrace();
            return "noHayClientes";
        }
        return "listarClientes";
    }
    @GetMapping("/registrar")
    public String registrar() {
        return "registrar";
    }
    @GetMapping("/actualizar")
    public String actualizar() { return "actualizar";}
    @GetMapping("/actualizarCliente")
    public String actualizarCliente(@RequestParam(value = "doc") String doc,
                                    @RequestParam (value = "num") String num,
                                    @RequestParam (value = "nom") String nom,
                                    @RequestParam (value = "bar") String bar,
                                    @RequestParam (value = "dir") String dir,
                                    @RequestParam (value = "num") String cel,
                                    @RequestParam (value = "cor") String cor,
                                    @RequestParam (value = "cla") String cla)
    {
        String url = "jdbc:mariadb://localhost:3306/ferrechinusas?useSSL=false";
        String user = "hams";
        String password = "hualmasi";

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            Statement dec = cnn.createStatement();
            ResultSet r = dec.executeQuery("SELECT * FROM cliente WHERE Documento_tipo ='" + doc + "' AND numero ='" + num + "';");
            if (r.next()) {
                dec.executeUpdate("UPDATE cliente SET nombre='"+nom + "', barrio='" + bar+"', direccion='"+dir+"', celular='"+cel+"',correo='"+cor+"', clave='"+cla+"' WHERE Documento_tipo='"+doc+"' AND numero = '"+num+"';");
            }
            r.close();
            dec.close();
            cnn.close();
        }catch(SQLException e){
                e.printStackTrace();
            return "clienteNoActualizado";
        }
        return "clienteActualizado";
    }
    @GetMapping("/eliminar")
    public String eliminarCliente() {
        return "eliminar";
    }
    @GetMapping("/eliminarCliente")
    public String eliminarCliente(@RequestParam(value = "doc") String doc,
                                  @RequestParam (value = "num") String num)
        {
            String url = "jdbc:mariadb://localhost:3306/ferrechinusas?useSSL=false";
            String user = "hams";
            String password = "hualmasi";
            String nom, bar, dir, cel, cor;
            try {
                Connection cnn = DriverManager.getConnection(url, user, password);
                Statement dec = cnn.createStatement();
                dec.executeUpdate ("DELETE FROM cliente WHERE Documento_tipo ='"+doc+"' AND numero ='"+num+"';");
            }catch(SQLException e){
                e.printStackTrace();
                return "clienteNoEliminado";
            }
            return "clienteEliminado";
    }
    @GetMapping("/consultar")
    public String consultarCliente() {
        return "consultar";
    }
    @GetMapping("/verCliente")
    public String verCliente(@RequestParam(value = "doc") String doc,
                             @RequestParam (value = "num") String num)
    {
        String url = "jdbc:mariadb://localhost:3306/ferrechinusas?useSSL=false";
        String user = "hams";
        String password = "hualmasi";
        String nom, bar, dir, cel, cor;
        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            Statement dec = cnn.createStatement();
            ResultSet r = dec.executeQuery ("SELECT * FROM cliente WHERE Documento_tipo ='"+doc+"' AND numero ='"+num+"';");
            if (r.next())
            {
                cliente = new Cliente(r.getString("numero"), r.getString("Documento_tipo"), r.getString("nombre"),r.getString("barrio"), r.getString("direccion"), r.getString("celular"), r.getString("correo"), r.getString("clave"));
            }
            dec.close();
            cnn.close();
            nom = cliente.getNombre();
            bar = cliente.getBarrio();
            dir = cliente.getDireccion();
            cel = cliente.getCelular();
            cor = cliente.getCorreo();
            System.out.println("Documento: " + doc);
            System.out.println("Nùmero: " + num);
            System.out.println("Nombres: " + nom);
            System.out.println("Barrio: " + bar);
            System.out.println("Dirección: " + dir);
            System.out.println("Celular: " + cel);
            System.out.println("Correo: " + cor);
        }catch(SQLException e){
            e.printStackTrace();
            return "clienteNoRegistrado";
        }
        return "verCliente";
    }
    @GetMapping("/guardarCliente")
    public String guardar(@RequestParam(value = "doc") String doc,
                           @RequestParam (value = "num") String num,
                           @RequestParam (value = "nom") String nom,
                           @RequestParam (value = "bar") String bar,
                           @RequestParam (value = "dir") String dir,
                           @RequestParam (value = "num") String cel,
                           @RequestParam (value = "cor") String cor,
                           @RequestParam (value = "cla") String cla)
    {
        String url = "jdbc:mariadb://localhost:3306/ferrechinusas?useSSL=false";
        String user = "hams";
        String password = "hualmasi";

        try {
            Connection cnn = DriverManager.getConnection(url, user, password);
            Statement dec = cnn.createStatement();
            dec.executeUpdate("INSERT INTO cliente VALUES('"+num+"','" + nom + "','" + bar+"','"+dir+"','"+cel+"','"+cor+"','"+doc+"','"+cla+"');");
            dec.close();
            cnn.close();
        }catch(SQLException e){
            e.printStackTrace();
            return "clienteNoRegistrado";
        }
        return "guardarCliente";
    }
}
