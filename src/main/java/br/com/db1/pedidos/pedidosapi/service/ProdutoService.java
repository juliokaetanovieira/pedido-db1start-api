package br.com.db1.pedidos.pedidosapi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.ClienteStatus;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.domain.entity.ProdutoStatus;
import br.com.db1.pedidos.pedidosapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
/*    public List<ProdutoDTO> getAllActive() {
    	return this.getByStatus(ProdutoStatus.ATIVO);
    }
    
	public List<Produto> getByCodigo(Produto codigo) {
		return produtoRepository.findByCodigo(codigo).stream().map(
				cliente -> this.produtoToDto(produto))
				.collect(Collectors.toList());
	}
	
    public List<Produto> getByCodigo(Produto codigo){
    	return produtoRepository.findByCodigo(codigo);
    }

   public ProdutoDTO salvar(ProdutoDTO dto) {
	   Produto produto = new Produto(dto.getCodigo(), dto.getNome(), dto.getValor());
	   Produto produtoSalvo = produtoRepository.save(produto);
	   return this.produtoToDto(produtoSalvo);
   }
   
   private ProdutoDTO produtoToDto(Produto produto) {
	   return new ProdutoDTO(produto.getCodigo(), produto.getNome(), produto.getValor());
   }*/
    
     public List<ProdutoDTO> getAll() {
        Iterable<Produto> produtosDatabase = produtoRepository.findByStatus(ProdutoStatus.ATIVO);
        Iterator<Produto> iterator = produtosDatabase.iterator();
        
        List<ProdutoDTO> produtos = new ArrayList<>();
        
        while(iterator.hasNext()) {
            Produto next = iterator.next();
            ProdutoDTO produtoDTO = new ProdutoDTO(next.getCodigo(), next.getNome(), next.getValor());
            produtos.add(produtoDTO);	
        }
        
        return produtos;
    }
    
    
}
