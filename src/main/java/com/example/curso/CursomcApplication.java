package com.example.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.curso.domain.Categoria;
import com.example.curso.domain.Cidade;
import com.example.curso.domain.Cliente;
import com.example.curso.domain.Endereco;
import com.example.curso.domain.Estado;
import com.example.curso.domain.Produto;
import com.example.curso.domain.enums.TipoCliente;
import com.example.curso.repositories.CategoriaRepository;
import com.example.curso.repositories.CidadeRepository;
import com.example.curso.repositories.EnderecoRepository;
import com.example.curso.repositories.EstadoRepository;
import com.example.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	public void run(String... args) throws Exception{
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est1);
		
		Cliente cl1 = new Cliente(null, "Maria", "maria@hotmail.com", "135325556", TipoCliente.PESSOAFISICA);
		
		Endereco e1 = new Endereco(null, "Rua Flores", "323", "", "Centro", "8783903", cl1, c1);
		Endereco e2 = new Endereco(null, "Rua dos Cajus", "378", "", "Velho", "73849490", cl1, c2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		cl1.getTelefones().addAll(Arrays.asList("23242445","36743832"));
		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
}

/*spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true*/
