package vendas;

import java.time.LocalDateTime;
import java.util.*;

import clientes.Cliente;

public class Venda {

	public Venda() {
	}

	private int codVenda;

	private LocalDateTime dataHora;

	private Cliente cliente;

	private IState pagamento;

	private ArrayList<ProdutoVenda> produtos;






}