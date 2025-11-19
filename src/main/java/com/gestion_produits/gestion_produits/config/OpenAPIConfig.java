package com.gestion_produits.gestion_produits.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Gestion de Produits",
                version = "1.0.0",
                description = "API RESTful pour la gestion des produits - CRUD complet",
                contact = @Contact(
                        name = "TAMO FOTSO MICHEL DARRYL",
                        email = "tamofotos90@@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        servers = {
                @Server(
                        description = "Serveur de développement local",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenAPIConfig {
}
