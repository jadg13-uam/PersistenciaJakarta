package dao;

import configuracion.JPAUtil;
import jakarta.persistence.EntityManager;
import modelos.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class CiudadDAO {
    /*
    Create
    Read
    Update
    Delete
     */

    /**
     * Guarda una ciudad en la base de datos
     * @param ciudad
     */
    public void guardar(Ciudad ciudad){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.persist(ciudad);
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("Ciudad guardada con exito");
        }  catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally{
            em.close();
        }
    }


    public List<Ciudad> listar(){
        List<Ciudad> ciudades = new ArrayList<>();

        EntityManager em = JPAUtil.getEntityManager();
        try{
            ciudades = em.createQuery("SELECT c FROM Ciudad c", Ciudad.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }

        return ciudades;
    }


}
