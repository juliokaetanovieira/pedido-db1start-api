package br.com.db1.pedidos.pedidosapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByCodigo(Produto codigo);

}
