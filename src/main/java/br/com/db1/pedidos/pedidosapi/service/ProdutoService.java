package br.com.db1.pedidos.pedidosapi.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;

import br.com.db1.pedidos.pedidosapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoDTO> getByCodigo() {
		return this.getByCodigo();
	}
	
/*	public List<ProdutoDTO> getByCodigo(Produto codigo) {
		return produtoRepository.findByCodigo(codigo).stream().map(produto -> this.produtoToDto(produto))
				.collect(Collectors.toList());
	}*/

	public ProdutoDTO salvar(ProdutoDTO dto) {
		Produto produto = new Produto(dto.getCodigo(), dto.getNome(), dto.getValor());
		Produto produtoSalvo = produtoRepository.save(produto);
		return this.produtoToDto(produtoSalvo);
	}

	private ProdutoDTO produtoToDto(Produto produto) {
		return new ProdutoDTO(produto.getId(), produto.getCodigo(), produto.getNome(), produto.getValor());
	}

	public ProdutoDTO alterar(Long id, ProdutoDTO body) {
		try {
			Produto produtoDatabase = produtoRepository.getOne(id);
			produtoDatabase.setCodigo(body.getCodigo());
			produtoDatabase.setNome(body.getNome());
			produtoRepository.save(produtoDatabase);
			return this.produtoToDto(produtoDatabase);
		} catch (ConstraintViolationException e) {
			throw new RuntimeException("Codigo Duplicado");
		}
	}
	
	public ProdutoDTO deletar(Long id) {
		Produto produtoDatabase = produtoRepository.getOne(id);
		produtoRepository.save(produtoDatabase);
		return null;
	}

}
