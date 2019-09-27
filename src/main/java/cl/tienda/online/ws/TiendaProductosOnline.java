package cl.tienda.online.ws;

import cl.tienda.online.vo.Productos;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebParam;
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
 * @author Juan Jerez Descripcion: Servicio para administrar los productos de la
 * tienda online
 */
@Stateless
@Path("v1/producto")
@Api(value = "v1/producto", description = "Servicio para administrar los productos de la tienda online")
public class TiendaProductosOnline {

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Guarda los productos de la tienda online", response = Productos.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK")
        ,@ApiResponse(code = 400, message = "El formato de peticion no es el correcto")
        ,@ApiResponse(code = 404, message = "No se encontro el dato")
        ,@ApiResponse(code = 500, message = "Ocurrió un error en el servidor"),})
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
    @ApiOperation(value = "Obtiene todos los productos de la tienda online", response = Productos.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK")
        ,@ApiResponse(code = 400, message = "El formato de peticion no es el correcto")
        ,@ApiResponse(code = 404, message = "No se encontro el dato")
        ,@ApiResponse(code = 500, message = "Ocurrió un error en el servidor"),})
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
    @ApiOperation(value = "Obtiene un producto por id", response = Productos.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK")
        ,@ApiResponse(code = 400, message = "El formato de peticion no es el correcto")
        ,@ApiResponse(code = 404, message = "No se encontro el dato")
        ,@ApiResponse(code = 500, message = "Ocurrió un error en el servidor"),})
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
    @ApiOperation(value = "Borra un producto por id", response = Productos.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK")
        ,@ApiResponse(code = 400, message = "El formato de peticion no es el correcto")
        ,@ApiResponse(code = 404, message = "No se encontro el dato")
        ,@ApiResponse(code = 500, message = "Ocurrió un error en el servidor"),})
    public Productos borraProducto(@PathParam("id") int id) {
        Productos producto = new Productos();

        if (id == 1) {
            producto.setDescripcion("Sin Descripcion");
            producto.setValor(0);
            producto.setVigencia(false);
        }
        return producto;
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiOperation(value = "Actualiza un producto por id", response = Productos.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK")
        ,@ApiResponse(code = 400, message = "El formato de peticion no es el correcto")
        ,@ApiResponse(code = 404, message = "No se encontro el dato")
        ,@ApiResponse(code = 500, message = "Ocurrió un error en el servidor"),})
    public Productos actualizaProducto(@PathParam("id") int id) {
        Productos producto = new Productos();

        if (id == 1) {
            producto.setDescripcion("Sin Descripcion");
            producto.setValor(0);
            producto.setVigencia(false);
        }
        return producto;
    }
}
