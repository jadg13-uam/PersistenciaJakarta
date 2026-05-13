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
    }
}
