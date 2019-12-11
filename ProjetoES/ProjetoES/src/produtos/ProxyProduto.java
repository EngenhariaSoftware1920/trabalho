package produtos;


import java.util.*;

public class ProxyProduto implements IProduto {

	public ProxyProduto() {
	}

	private ArrayList<IProduto> produtos;

	private ProdutoFactory factory;


}