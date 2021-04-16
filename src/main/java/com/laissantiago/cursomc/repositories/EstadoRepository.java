package com.laissantiago.cursomc.repositories;

import com.laissantiago.cursomc.domain.Categoria;
import com.laissantiago.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer> {

}
