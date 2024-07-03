public class JPArepository {
package com.JPArepository.repositorio;

import com.JParepository.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    }

