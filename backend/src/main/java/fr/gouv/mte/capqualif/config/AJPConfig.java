//package fr.gouv.mte.capqualif.config;
//
//import org.apache.catalina.connector.Connector;
//import org.apache.coyote.ajp.AbstractAjpProtocol;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.server.WebServerFactoryCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//@Configuration
//public class AJPConfig {
//
//    //    @Value("${ajp_port}")
//    int AJP_PORT = 8009;
//
////    @Value("${ajp_secret}")
////    String AJP_SECRET;
//
//    @Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainer() {
//        return server -> {
//            if (server instanceof TomcatServletWebServerFactory) {
//                ((TomcatServletWebServerFactory) server).addAdditionalTomcatConnectors(redirectConnector());
//            }
//        };
//    }
//
//    private Connector redirectConnector() {
//        Connector connector = new Connector("AJP/1.3");
//        connector.setScheme("http");
//        connector.setPort(AJP_PORT);
//        connector.setSecure(false);
//        connector.setAllowTrace(false);
//        AbstractAjpProtocol protocol = (AbstractAjpProtocol) connector.getProtocolHandler();
//        protocol.setSecretRequired(false);
////        protocol.setSecret(AJP_SECRET);
//
//        try
//        {
//            protocol.setAddress( InetAddress.getByName( "0.0.0.0" ) );
//        }
//        catch( UnknownHostException e )
//        {
//            e.printStackTrace();
//        }
//
//        return connector;
//    }
//
//}
