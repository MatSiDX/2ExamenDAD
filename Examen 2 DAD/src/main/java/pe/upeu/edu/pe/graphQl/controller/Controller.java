package pe.upeu.edu.pe.graphQl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import pe.upeu.edu.pe.graphQl.dto.LibroRequest;
import pe.upeu.edu.pe.graphQl.entity.Autor;
import pe.upeu.edu.pe.graphQl.entity.Editorial;
import pe.upeu.edu.pe.graphQl.entity.Libro;
import pe.upeu.edu.pe.graphQl.repository.AutorRepository;
import pe.upeu.edu.pe.graphQl.repository.EditorialRepository;
import pe.upeu.edu.pe.graphQl.repository.LibroRepository;


import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private LibroRepository libroRepository;

    @QueryMapping
    public List<Libro> listarLibro(){
        return libroRepository.findAll();
    }

    @QueryMapping
    public Libro listarLibroPorId(@Argument int id) {
        return libroRepository.findById(id).orElse(null);
    }
    @MutationMapping
    public Libro guardarLibro(@Argument LibroRequest libroRequest){
        Autor autor = autorRepository.findById(libroRequest.id_autor()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.id_editorial()).orElse(null);
        Libro libroBBDD = new Libro();

        libroBBDD.setTitulo(libroRequest.titulo());
        libroBBDD.setDescripcion(libroRequest.descripcion());
        libroBBDD.setPagina(libroRequest.pagina());
        libroBBDD.setEdicion(libroRequest.edicion());
        libroBBDD.setAutor(autor);
        libroBBDD.setEditorial(editorial);

        return libroRepository.save(libroBBDD);
    }
    @MutationMapping
    public Libro actualizarLibro(@Argument int id, @Argument LibroRequest libroRequest){
        Autor autor = autorRepository.findById(libroRequest.id_autor()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.id_editorial()).orElse(null);
        Libro libroBBDD = new Libro();

        libroBBDD.setId_libro(id);
        libroBBDD.setTitulo(libroRequest.titulo());
        libroBBDD.setDescripcion(libroRequest.descripcion());
        libroBBDD.setPagina(libroRequest.pagina());
        libroBBDD.setEdicion(libroRequest.edicion());
        libroBBDD.setAutor(autor);
        libroBBDD.setEditorial(editorial);
        return libroRepository.save(libroBBDD);
    }
    @MutationMapping
    public void eliminarLibro(@Argument int id) {
        libroRepository.deleteById(id);
    }




    //Autor
    @QueryMapping
    public List<Autor> listarAutor() {
        return autorRepository.findAll();
    }
    @QueryMapping
    public Autor listarAutorPorId(@Argument int id_autor) {
        return autorRepository.findById(id_autor).orElse(null);
    }
    @MutationMapping
    public Autor guardarAutor(@Argument Autor autor){
        Autor autorBBDD = new Autor();

        autorBBDD.setNombre(autor.getNombre());
        autorBBDD.setApellidos(autor.getApellidos());
        autorBBDD.setPais(autor.getPais());

        return autorRepository.save(autorBBDD);
    }
    @MutationMapping
    public Autor actualizarAutor(@Argument int id_autor,@Argument Autor autor){
        Autor autorBBDD = new Autor();
        autorBBDD.setId_autor(id_autor);
        autorBBDD.setNombre(autor.getNombre());
        autorBBDD.setApellidos(autor.getApellidos());
        autorBBDD.setPais(autor.getPais());

        return autorRepository.save(autorBBDD);
    }
    @MutationMapping
    public void eliminarAutor(@Argument int id_autor){
        autorRepository.deleteById(id_autor);
    }




    //Editorial
    @QueryMapping
    public List<Editorial> listarEditorial() {
        return editorialRepository.findAll();
    }
    @QueryMapping
    public Editorial listarEditorialPorId(@Argument int id_editorial) {
        return editorialRepository.findById(id_editorial).orElse(null);
    }
    @MutationMapping
    public Editorial guardarEditorial(@Argument Editorial editorial){
        Editorial editorialBBDD = new Editorial();

        editorialBBDD.setNombre_editorial(editorial.getNombre_editorial());
        editorialBBDD.setPais_editorial(editorial.getPais_editorial());

        return editorialRepository.save(editorialBBDD);
    }
    @MutationMapping
    public Editorial actualizarEditorial(@Argument int id_editorial,@Argument Editorial editorial){
        Editorial editorialBBDD = new Editorial();

        editorialBBDD.setId_editorial(id_editorial);
        editorialBBDD.setNombre_editorial(editorial.getNombre_editorial());
        editorialBBDD.setPais_editorial(editorial.getPais_editorial());

        return editorialRepository.save(editorialBBDD);
    }
    @MutationMapping
    public void eliminarEditorial(@Argument int id_editorial){
        editorialRepository.deleteById(id_editorial);
    }

}
