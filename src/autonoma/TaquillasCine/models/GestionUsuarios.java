package autonoma.TaquillasCine.models;

import autonoma.TaquillasCine.models.Usuario;

public interface GestionUsuarios {
    void registrarUsuario(Usuario usuario);
    void eliminarUsuario(String identificacion);
    void actualizarUsuario(Usuario usuario);
    Usuario buscarUsuario(String id);
}