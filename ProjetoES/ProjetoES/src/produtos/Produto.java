package produtos;

import java.util.*;

import vendas.ProdutoVenda;

public abstract class Produto implements IProduto {

	public Produto() {
	}

	private String nome;

	private String empresa;

	private double preco;

	private int stock;

	private ArrayList<ProdutoVenda> vendas;






}