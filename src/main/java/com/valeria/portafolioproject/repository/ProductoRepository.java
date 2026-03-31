package com.valeria.portafolioproject.repository;

import com.valeria.portafolioproject.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
