package hash;

public class ClasseHashing {
	private int N;
	
	
	
	public int getN() {
		return N;
	}



	public void setN(int n) {
		N = n;
	}

	public int dh(int chave) {
		return (chave % N) + 1;	
	}
	
	public int adh(String chave) {
		int i, soma;
		soma = 0;
		for (i = 1; i < chave.length(); i++){
			//soma = soma + ord(chave[i]);
		}
		
		return 0;	
	}
	
}

/*
	fun��o adh (chv:string):inteiro;
var i,soma : inteiro
in�cio
soma := 0;
para i de 1 at� length(chv) fa�a
soma := soma + ord(chv[i]);
retorne (soma mod N) + 1;
fim; 
*/