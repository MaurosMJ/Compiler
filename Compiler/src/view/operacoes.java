package view;

import java.util.ArrayList;
import java.util.HashMap;

public class operacoes {
	
	private String[] lines;
	public ArrayList<String[]> quebraLinha = new ArrayList<String[]>(); //Adicionado vetor cujo indice+1 é a linha do vetor com todos caracteres quebrados
	public int linhas;

	public int gettemChar () {
		int cont = 0;
		int cont2 = 0;
		int contID=0;
		int valor=1;
		
		for (cont2 = 0; cont2 < this.getline(); cont2++){
			for (cont = 0; cont < this.getPalavras(cont2); cont++){
				if (quebraLinha.get(cont2)[cont].equals("char")) {	
					return cont2;
				}
			}
		}
				return 9999;
	}
	
	public int linha (int id) {
		int  cont = 0;
		int cont2 =0;
		int contID=0;
		for (cont2 = 0; cont2 < this.getline(); cont2++){
			for (cont = 0; cont < this.getPalavras(cont2); cont++){
				
				
				for(int i = 0; i < quebraLinha.get(cont2)[cont].length(); i++)
					{
					if (contID >= id) {				
						return cont2;
					}	
					contID++;	
									}
				
				if (contID >= id) {				
					return cont2;
				}
			}
			
			contID++;
			if (contID >= id) {				
				return cont2;
			}
		}
		return 10;
	}
	

	
	public int lineCount (String txt) {   //OBRIGATORIO INVOCACAO DESTE METODO 
		lines = txt.split("\r\n|\r|\n"); //vetor com todas linhas; 
		this.separarLinha(txt);
		return  lines.length;

	}

	public void separarLinha (String txt) {	  //OBRIGATORIO INVOCACAO DESTE METODO
		for (int cont = 0; cont < lines.length; cont++) {

			quebraLinha.add(lines[cont].split(" "));  

		}
				
		linhas = lines.length;
	}


	public int getPalavras (int index) {
		return quebraLinha.get(index).length;
	}

	public int getline () {
		return lines.length;
	}
	
	public void redimencionaArray (int indexLinha, int indexToken) {
		quebraLinha.get(indexLinha)[indexToken] = "";
	}

	public String decodeficar (int id) {

		if (id == 1) {
		return "DOLLAR";
		}

		if (id == 2) {
			return "palavra reservada";
		}
		if (id == 3) {
			return "identificador";
		}

		if (id == 4) {
			return "identificador";
		}

		if (id == 5) {
			return "identificador";
		}

		if (id == 6) {
			return "identificador";
		}

		if (id == 7) {
			return "constante int";
		}

		if (id == 8) {
			return "constante float";
		}

		if (id == 9) {
			return "constante string";
		}

		if (id == 10) {
			return "palavra reservada";
		}

		if (id == 11) {
			return "palavra reservada";
		}

		if (id == 12) {
			return "palavra reservada";
		}

		if (id == 13) {
			return "palavra reservada";
		}

		if (id == 14) {
			return "palavra reservada";
		}

		if (id == 15) {
			return "palavra reservada";
		}

		if (id == 16) {
			return "palavra reservada";
		}

		if (id == 17) {
			return "palavra reservada";
		}

		if (id == 18) {
			return "palavra reservada";
		}

		if (id == 19) {
			return "palavra reservada";
		}

		if (id == 20) {
			return "palavra reservada";
		}

		if (id == 21) {
			return "palavra reservada";
		}

		if (id == 22) {
			return "palavra reservada";
		}

		if (id == 23) {
			return "palavra reservada";
		}

		if (id == 24) {
			return "palavra reservada";
		}

		if (id == 25) {
			return "palavra reservada";
		}

		if (id == 26) {
			return "palavra reservada";
		}

		if (id == 27) {
			return "palavra reservada";
		}

		if (id == 28) {
			return "símbolo especial";
		}

		if (id == 29) {
			return "símbolo especial";
		}

		if (id == 30) {
			return "símbolo especial";
		}

		if (id == 31) {
			return "símbolo especial";
		}

		if (id == 32) {
			return "símbolo especial";
		}

		if (id == 33) {
			return "símbolo especial";
		}

		if (id == 34) {
			return "símbolo especial";
		}

		if (id == 35) {
			return "símbolo especial";
		}

		if (id == 36) {
			return "símbolo especial";
		}

		if (id == 37) {
			return "símbolo especial";
		}

		if (id == 38) {
			return "símbolo especial";
		}

		if (id == 39) {
			return "símbolo especial";
		}

		if (id == 40) {
			return "símbolo especial";
		}

		if (id == 41) {
			return "símbolo especial";
		}

		if (id == 42) {
			return "símbolo especial";
		}
		
		if (id == 43) {
			return "símbolo especial";
		}
		return null;

		
	}
}
