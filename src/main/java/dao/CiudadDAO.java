package dao;

import configuracion.JPAUtil;
import jakarta.persistence.EntityManager;
import modelos.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class CiudadDAO implements CRUD<Ciudad>{
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

    /**
     * Lista todas las ciudades de la base de datos
     * @return
     */
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

    /**
     * Busca una ciudad por su id
     * @param id
     * @return
     */
    public Ciudad buscar(int id){
        try{
            EntityManager em = JPAUtil.getEntityManager();
            return em.find(Ciudad.class, id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Elimina una ciudad por su id
     * @param id
     */
    public void eliminar(int id){
        try{
            EntityManager em = JPAUtil.getEntityManager();
            Ciudad temporal = em.find(Ciudad.class, id);
            em.remove(temporal);
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("Ciudad eliminada con exito");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al eliminar la ciudad" + e.getMessage());
        }
    }

    public void editar(Ciudad ciudad){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(ciudad);
            em.getTransaction().commit();
            System.out.println("Ciudad editada con éxito");
        }catch (Exception e){
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            em.close();
        }
    }


}
