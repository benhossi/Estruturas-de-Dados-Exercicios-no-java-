package Listas;
import javax.swing.*;
public class Principal {	
	public static void main(String[] args) {
		Principal principal = new Principal();
		Integer [] lista = new Integer [5];
		principal.menu(lista);
	}
	//Interface gráfica
	public void menu (Integer [] lista){
		int i = 10;
		while (i != 0){
			i = Integer.parseInt(JOptionPane.showInputDialog("Comandos: \n1 - Adicionar dado ao fim da lista \n2 - Remover dados"
			+ " \n3 - Visualizar lista \n4 - Visualizar qtde de dados na lista \n5 - Verificar dado \n6 - Pegar dado de uma posição \n0 - Sair"));
			switch (i) {
				case 1: 
					Integer dado = Integer.parseInt(JOptionPane.showInputDialog("Digite um dado: ")); 
					add_fim(lista, dado);
				break;
				case 2:
					dado = Integer.parseInt(JOptionPane.showInputDialog("Digite o dado a ser removido: ")); 
					if (remover_organizar(lista, dado)){
						JOptionPane.showMessageDialog(null, "Dado removido e lista reorganizada!");
						menu(lista);
					}
					else 
						JOptionPane.showMessageDialog(null, "Não foi possível remover o dado!");
						menu(lista);						
				break;
				case 3:
					JOptionPane.showMessageDialog(null, visualizarLista(lista));
					menu(lista);
				break;
				case 4: 
					JOptionPane.showMessageDialog(null, qtdeDados(lista));
					menu(lista);
				break;
				case 5: 
					if(verificarDado(lista, Integer.parseInt(JOptionPane.showInputDialog("Digite o dado que deseja verifcar na lista: ")))){
						JOptionPane.showMessageDialog(null, "O dado existe na lista!");
					}else{
						JOptionPane.showMessageDialog(null, "O dado não existe na lista!");
					}
					menu(lista);
				break;
				case 6:
					int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do dado que deseja pegar: "));
					Integer date = pegarDadoPosicao(lista, posicao);
					if (date != null){
						JOptionPane.showMessageDialog(null, "O dado armazenado na posição "+posicao+" é: "+date);
					}
				break;
				case 0:
					System.exit(0);
				break;
				default: JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		}
	}
	//Funções da lista (métodos)
	public Integer pegarDadoPosicao(Integer[] lista, int posicao){
		while (posicao < lista.length){
			if (lista[posicao] != null){
				return lista[posicao];
			}
			posicao++;
		}
		JOptionPane.showMessageDialog(null, "A posição digitada é inválida!");		
		return null;
	}
	public void add_fim(Integer[] lista, Integer dado){
		int i = 0;
		while ((i<lista.length) && (lista[i] != null))
				i++;
		if (i<lista.length)
			lista[i] = dado;
		else
		JOptionPane.showMessageDialog(null, "Impossível adicionar dado!");
		menu(lista);
	}
	public boolean remover_organizar (Integer [] lista, Integer dado){
		int i = 0;
		while ((i < lista.length) && (lista[i] != dado))
			i++;
		if (i < lista.length){
			lista[i] = null;
			while (i < lista.length-1){
				Integer aux = lista[i + 1];
				lista[i + 1] = lista[i];
				lista[i] = aux;
				i++;
			}
			return true;	
		}
		else
			return false;			
	}
	public String qtdeDados(Integer[] lista){
		int qtde = 0;
			for (int i = 0; i < lista.length; i++){
				if (lista[i] != null){
					qtde++;
				}
			}
		return "Quantidade de dados na lista: "+qtde;
	}
	public boolean verificarDado(Integer [] lista, Integer dado){
		for (int i=0; i<lista.length; i++){
			if (lista[i] == dado){
				return true;
			}	
		}
		return false;
	}
	public String visualizarLista(Integer [] lista){
		return "["+lista[0]+"]"+"["+lista[1]+"]"+"["+lista[2]+"]"+"["+lista[3]+"]"+"["+lista[4]+"]";
	}
}