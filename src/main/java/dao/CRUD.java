package dao;

import java.util.List;

public interface CRUD<T> {

    List<T> listar();
    void guardar(T object);
    void eliminar(int id);
    T buscar(int id);
}
