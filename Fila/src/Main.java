import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Integer[] fila = new Integer [5];
		int inicio = 0;
		int fim = 0;
		int dado = 0;
		
		//Menu
		String menu = "Estrutura de Dados: Fila \nComandos: \n 1 - Adicionar dado \n 2 - Retirar dado \n 3 - Quantidade de dados \n 4 - Visualizar Fila \n 0 - Sair";
		int comando = Integer.parseInt(JOptionPane.showInputDialog(menu));
		while (comando != 0) {
			if (comando == 1) {				
				fim = main.enfileirar(fila, inicio, fim, Integer.parseInt(JOptionPane.showInputDialog("Digite o dado: ")));
				JOptionPane.showMessageDialog(null,"Fim da fila: "+fim);		
			}
			if (comando == 2) {
				inicio = main.desenfileirar(fila, inicio, fim);
				JOptionPane.showMessageDialog(null, "Início da fila: "+inicio);
			}	
			if (comando == 3) {		
				JOptionPane.showMessageDialog(null, "Quantidade de dados: "+main.qtdeDados(fila));
			}
			if (comando == 4) {
				JOptionPane.showMessageDialog(null, main.visualizarFila(fila));
			}
			comando = Integer.parseInt(JOptionPane.showInputDialog(menu));	
		}
}
	//Algoritmos da fila
	public int enfileirar (Integer[] fila, int inicio, int fim, int dado) {	
		if((fim == inicio) && (fila[inicio] != null)) {
			JOptionPane.showMessageDialog(null, "Fila cheia, impossível adicionar dado!");
			return fim;
		}else {					
			fila[fim] = dado;
			if(fim+1 == fila.length) {	
				fim=0;
				return fim;
			}else {
				fim++;
				return fim;
			}
		}
	}
	public int desenfileirar(Integer[] fila, int inicio, int fim) {
		Main main = new Main();
		if (main.qtdeDados(fila) == 0) {
			JOptionPane.showMessageDialog(null, "Fila vazia, impossível remover dado!");
			return inicio;
		}else {
			fila[inicio] = null;
			inicio = inicio + 1;
			if(inicio == fila.length) {
				inicio=0;
			}
			return inicio;
		}
	}
	public String visualizarFila(Integer[] fila) {
		return "Fila: ["+fila[0]+"]["+fila[1]+"]["+fila[2]+"]["
				+fila[3]+"]["+fila[4]+"]";
	}
	public int qtdeDados(Integer[] fila) {
		int qtde = 0;
		for (int i = 0; i < fila.length; i++){
			if (fila[i] != null){
				qtde++;
			}
		}
		return qtde;
	}
}
