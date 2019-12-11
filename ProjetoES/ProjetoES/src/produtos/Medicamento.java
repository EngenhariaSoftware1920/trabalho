package produtos;

import java.util.*;

import animais.Genero;

public class Medicamento extends Produto {

	private Medicamento() {
	}

	private ArrayList<String> dosagem;

	private ArrayList<Embalagem> embalagens;

	private Genero genero;

	@Override
	public boolean updateStock(int quant) {
		// TODO Auto-generated method stub
		return false;
	}



}