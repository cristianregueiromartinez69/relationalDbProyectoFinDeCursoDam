package com.finproyectodam.relationaldb.canciones.controller;

import com.finproyectodam.relationaldb.canciones.service.CancionesService;
import com.finproyectodam.relationaldb.model.entitys.Cancion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController de canciones
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/relationaldb/spotify/canciones")
public class CancionesRestController {

    //servicio de las canciones
    private final CancionesService cancionesService;

    /**
     * Constructor de la clase
     * @param cancionesService el servicio de las canciones
     */
    public CancionesRestController(CancionesService cancionesService) {
        this.cancionesService = cancionesService;
    }

    /**
     * Metodo para obtener un listado de las canciones de spotify
     * @return la lista de canciones o null
     */
    @GetMapping("/info")
    public ResponseEntity<List<Cancion>> getAllSongsrestController() {
        try{
            List<Cancion> cancionList = cancionesService.getAllSongsService();
            if(cancionList != null) {
                return ResponseEntity.ok(cancionList);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Metodo GET para obtener cancion por el id
     * @param id el id de la cancion
     * @return el objeto cancion o null
     */
    @GetMapping("/info/id/{id}")
    public ResponseEntity<Cancion> getSongsByIdRestController(@PathVariable Integer id) {
        try{
            Cancion cancion = cancionesService.getCancionByIdService(id);
            if(cancion != null) {
                return ResponseEntity.ok(cancion);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Metodo Get para obtener una cancion o canciones por titulo
     * @param titulo el titulo de la cancion
     * @return la cancion o lista de canciones por titulo
     */
    @GetMapping("/info/titulo/{titulo}")
    public ResponseEntity<List<Cancion>> getSongsByTituloRestController(@PathVariable String titulo) {
        try{
            List<Cancion> cancionList = cancionesService.getCancionesByTituloService(titulo);
            if(cancionList != null) {
                return ResponseEntity.ok(cancionList);
            }
            else{
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }




}
