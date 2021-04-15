package com.laissantiago.cursomc.repositories;

import com.laissantiago.cursomc.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer> {

}
