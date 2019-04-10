package br.com.db1.pedidos.pedidosapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.pedidos.pedidosapi.domain.dto.ClienteDTO;
import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.domain.entity.Produto;
import br.com.db1.pedidos.pedidosapi.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/produtos") //Definir nome da URL
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value= "/codigo")
	public List<ProdutoDTO> getByCodigo() {
		return ProdutoService.getByCodigo();
	}
	
	
/*	@GetMapping(value= "/codigo")
	public List<ProdutoDTO> getByCodigo(@RequestParam("codigo") Produto codigo ) {
		return produtoService.getByCodigo(codigo);
	}*/
	
	@PostMapping
	public ProdutoDTO post(ProdutoDTO body) {
		return produtoService.salvar(body);
	}
	
	@PutMapping(value="/{id}")
	public ProdutoDTO put(@PathVariable("id") Long id,@RequestBody ProdutoDTO body) {
		return produtoService.alterar(id, body);
	}
	
	@DeleteMapping(value="/{id}")
	public ProdutoDTO put(@PathVariable("id") Long id) {
		return produtoService.deletar(id);
	}
	
}
