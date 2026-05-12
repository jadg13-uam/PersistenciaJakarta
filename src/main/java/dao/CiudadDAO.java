package dao;

import configuracion.JPAUtil;
import jakarta.persistence.EntityManager;
import modelos.Ciudad;

public class CiudadDAO {
    /*
    Create
    Read
    Update
    Delete
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



}
