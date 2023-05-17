package pe.upeu.edu.pe.graphQl.dto;

public record LibroRequest(

        Integer id_libro,
        String titulo,
        String descripcion,
        String pagina,
        String edicion,
        int id_autor,
        int id_editorial


) {
}
