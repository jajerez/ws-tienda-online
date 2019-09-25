/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.tienda.online.ws;

import cl.tienda.online.vo.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author RyC
 */
@Path("v1/producto")
public class TiendaProductosOnline {

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Productos grabaProducto(@WebParam(name = "Productos") Productos objetoProducto) {
        Productos producto = new Productos();
        producto.setDescripcion(objetoProducto.getDescripcion() != null ? objetoProducto.getDescripcion() : "Sin Descripcion");
        producto.setValor(objetoProducto.getValor() != 0 ? objetoProducto.getValor() : 0);
        producto.setVigencia(objetoProducto.isVigencia() != false ? objetoProducto.isVigencia() : false);
        return producto;
    }

    @GET
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Productos> obtieneProductos() {
        List<Productos> listaProductos = new ArrayList<>();
        for (int cantidad = 0; cantidad < 4; cantidad++) {
            Productos producto = new Productos();
            producto.setDescripcion("Sin Descripcion");
            producto.setValor(0);
            producto.setVigencia(false);
            listaProductos.add(producto);
        }
        return listaProductos;
    }

    @GET
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Productos obtieneProducto(@PathParam("id") int id) {
        Productos producto = new Productos();

        if (id == 1) {
            producto.setDescripcion("Sin Descripcion");
            producto.setValor(0);
            producto.setVigencia(false);
        }

        return producto;
    }

    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String borraProducto(@PathParam("id") int id) {
        String mensaje = "";

        if (id == 1) {
            mensaje = "Elemento Borrado";
        } else {

        }

        return mensaje;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public String actualizaProducto(@PathParam("id") int id) {
        String mensaje = "";

        if (id == 1) {
            mensaje = "Elemento Actualizado";
        } else {

        }

        return mensaje;
    }
}
