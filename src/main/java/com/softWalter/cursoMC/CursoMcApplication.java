package com.softWalter.cursoMC;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softWalter.cursoMC.domain.Categoria;
import com.softWalter.cursoMC.domain.Cidade;
import com.softWalter.cursoMC.domain.Cliente;
import com.softWalter.cursoMC.domain.Endereco;
import com.softWalter.cursoMC.domain.Estado;
import com.softWalter.cursoMC.domain.ItemPedido;
import com.softWalter.cursoMC.domain.Pagamento;
import com.softWalter.cursoMC.domain.PagamentoComBoleto;
import com.softWalter.cursoMC.domain.PagamentoComCartao;
import com.softWalter.cursoMC.domain.Pedido;
import com.softWalter.cursoMC.domain.Produto;
import com.softWalter.cursoMC.domain.enums.EstadoPagamento;
import com.softWalter.cursoMC.domain.enums.TipoCliente;
import com.softWalter.cursoMC.repositories.CategoriaRepository;
import com.softWalter.cursoMC.repositories.CidadeRepository;
import com.softWalter.cursoMC.repositories.ClienteRepository;
import com.softWalter.cursoMC.repositories.EnderecoRepository;
import com.softWalter.cursoMC.repositories.EstadoRepository;
import com.softWalter.cursoMC.repositories.ItemPedidoRepository;
import com.softWalter.cursoMC.repositories.PagamentoRepository;
import com.softWalter.cursoMC.repositories.PedidoRepository;
import com.softWalter.cursoMC.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner{

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
						
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com",
				"36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("34311770", "9383893"));
		Endereco e1 = new Endereco(null, "rua flores", "cidade  jardim", 
				"sujismundo pereira", "755523"
				, cli1, c1);
		Endereco e2 = new Endereco(null, "ruan angelo", "domingos", 
				"marolina", "75525", cli1, c1);
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy"
				+ "HH:mm");
		Pedido pedi1 = new Pedido(null, sdf.parse("30/09/2018"
				+ "10:32"), cli1, e1);
		Pedido pedi2 = new Pedido(null, sdf.parse("10/10/2019"
				+ "19:35"), cli1, e2);
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,
				pedi1, 6);
		pedi1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,
				pedi2, sdf.parse("20/10/2020 00:00"), null);
		pedi2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(pedi1, pedi2));
		
		pedidoRepository.saveAll(Arrays.asList(pedi1, pedi2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(pedi1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(pedi1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(pedi2, p2, 100.00, 1, 800.00);
		pedi1.getItens().addAll(Arrays.asList(ip1,ip2));
		pedi2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
