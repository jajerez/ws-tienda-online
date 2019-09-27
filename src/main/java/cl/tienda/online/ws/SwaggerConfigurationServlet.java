package cl.tienda.online.ws;

import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * SwaggerConfigurationServlet
 *
 * @author Juan Jerez Descripcion: Clase que realiza la configuracion del
 * swagger
 */
@WebServlet(name = "SwaggerJaxrsConfig", loadOnStartup = 1)
public class SwaggerConfigurationServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        super.init(servletConfig);
        SwaggerConfig swaggerConfig = new SwaggerConfig();
        ConfigFactory.setConfig(swaggerConfig);

        swaggerConfig.setBasePath("/ws-tienda-online/recursosweb");

        swaggerConfig.setApiVersion("2.0.0");
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new DefaultJaxrsApiReader());

    }
}
