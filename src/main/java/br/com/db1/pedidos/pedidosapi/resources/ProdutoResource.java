package br.com.db1.pedidos.pedidosapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.pedidos.pedidosapi.domain.dto.ProdutoDTO;
import br.com.db1.pedidos.pedidosapi.service.ProdutoService;

@RestController
@RequestMapping(value = "/api/produtos") //Definir nome da URL
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value= "/codigo")
	public List<ProdutoDTO> getAllCodigo() {
		return this.getByCodigo();
	}
	
}
