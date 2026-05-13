import dao.CiudadDAO;
import modelos.Ciudad;

public class Main {
    public static void main(String[] args) {
        //Ciudad ciudad = new Ciudad(null, "Managua", "Capital", 11.97, -89.09);

        CiudadDAO reg = new CiudadDAO();
        //reg.guardar(ciudad);
        for (Ciudad c : reg.listar()) {
            System.out.println(c);
        }

        //System.out.println("Registro encontrado: "+ reg.buscar( 3));

        reg.eliminar(2);

        System.out.println("Registros despues de eliminar:");
        for (Ciudad c : reg.listar()) {
            System.out.println(c);
        }
    }
}
