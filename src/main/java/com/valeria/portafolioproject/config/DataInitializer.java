package com.valeria.portafolioproject.config;

import com.valeria.portafolioproject.model.Producto;
import com.valeria.portafolioproject.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initProductos(ProductoRepository productoRepository) {
        return args -> {
            if (productoRepository.count() == 0) {
                productoRepository.save(new Producto("Ramo de Rosas Rojas", "Rosas",
                        "Ramo elegante con 12 rosas rojas frescas.", 24990.0, 10, "/images/rosas.svg"));

                productoRepository.save(new Producto("Bouquet Primaveral", "Bouquet",
                        "Mezcla colorida de flores para regalar en cualquier ocasión.", 18990.0, 8, "/images/primavera.svg"));

                productoRepository.save(new Producto("Tulipanes Pastel", "Tulipanes",
                        "Arreglo delicado en tonos suaves.", 21990.0, 7, "/images/tulipanes.svg"));

                productoRepository.save(new Producto("Girasoles Premium", "Girasoles",
                        "Arreglo vibrante con girasoles seleccionados.", 19990.0, 6, "/images/girasoles.svg"));
            }
        };
    }
}
