package EstudoListaEnc;
import EstudoListaEnc.Arquivo;
import EstudoListaEnc.Contato;
import EstudoListaEnc.EstudoListaEnc;

import java.io.*;
import java.util.Scanner;


public class BuscaBinaria {
	Contato primeiro;
	Contato ultimo;
	int tamanho;
	String Vetor[];
	
	public BuscaBinaria(){
		primeiro = null;
		ultimo = primeiro;
		tamanho=0;
	}
	
	public boolean ListaVazia(){
		boolean vazia = false;
		if (primeiro== null){
			vazia = true;
		}
		return vazia;
	}
	
	public void Adiciona(String nome, String fone){
		if (primeiro == null){
			primeiro = new Contato();
			ultimo = primeiro;
			Contato  novo = new Contato();
			novo.setNome(nome);
			novo.setTelefone(fone);
			novo.setProx(null);
			ultimo.setProx(novo);
			ultimo = novo;
			tamanho++;	
		}else {
			if (validaLista(nome)== false){
				Contato  novo = new Contato();
				novo.setNome(nome);
				novo.setTelefone(fone);
				novo.setProx(null);
				ultimo.setProx(novo);
				ultimo = novo;
				tamanho++;
			}else{
				System.out.println("Este contato já esta na lista...");
			}			
		}
	}
		
	public void CarregarLista(){
		try
		{
			if(tamanho > 0 ) {
				System.out.println("A lista já foi carregada.");
			}else{
				String AuxNome="";
				String AuxFone="";			
				FileReader arquivo = new FileReader("d:\\Teste.txt");
				BufferedReader lerArquivo = new BufferedReader(arquivo);
				String linha = lerArquivo.readLine(); 
				while (linha != null) {
					AuxNome = linha.split("-->")[0];
					AuxFone= linha.split("-->")[1];
					Adiciona(AuxNome,AuxFone);
					linha = lerArquivo.readLine();
				}
				arquivo.close();
			}
		} catch (IOException e) 
		{
			System.err.printf(e.getMessage());
		}
	}
	
	
	public boolean validaLista(String nomePesquisa){
		boolean existe=  false;
		Contato ctt = primeiro.getProx();
				
		if(ctt!= null){
			while (ctt!= null){
				if (ctt.getNome().equals(nomePesquisa)){
					existe = true;	
					break;
				}else{
					ctt= ctt.getProx();				
				}
			}				
		}
		return existe;		
	}
	
	public void mostraLista() throws IOException{
		
		if(ListaVazia()==true){
			System.out.println("Lista vazia.....");
		}else{
			Contato andar = primeiro.getProx();
			int count=0;
			while(andar != null){
				System.out.println(andar.getNome());
				System.out.println(andar.getTelefone());
				andar = andar.getProx();
				count ++;
			}
		}		

	}
	
	 //Busca Binária de String
    public int binaria(String sVet[], String sPalavra){
    	boolean achou = false;
        int inicio=0;
        int meio, fim=sVet.length-1;

        do{
            meio = (inicio + fim)/2;
            if (sVet[meio].equalsIgnoreCase(sPalavra)){
                return meio;
            }
            else if (sVet[meio].compareToIgnoreCase(sPalavra)<0){
                inicio = meio + 1;
            }
            else{
                fim  = meio - 1;
            }

        }while (inicio <= fim);
         
        return -1;
    }
	
	public void buscaBinaria(String paramentroDeBusca){
		if(paramentroDeBusca.toString()!=""){
			int passos = 0;
			
		
			
			EstudoListaEnc busca = new EstudoListaEnc();
			//busca.primeiro.getProx();
			System.out.println("Número de elementos: " + tamanho);
			//dividir a lista por 2
			System.out.println(tamanho/2);
			/*if(busca!= null){
				z
				while (busca!= null){
					if (busca.equals(paramentroDeBusca)){
						
						break;
					}else{
						busca = busca.				
					}
				}				
			}
			*/
		}
		else{
			System.out.println("Não foi informado o valor para a busca.");
		}
			
	}
		
	public static void main(String args[] ) throws IOException {   
		BuscaBinaria lista = new BuscaBinaria();
		Scanner entrada = new  Scanner(System.in);
		String nome , arquivo, fone="";
		
		int op;
				
		do{
			 System.out.print("Digite uma das opções abaixo\n");
	         System.out.println();
	         System.out.println("1 - Mostrar a lista");
	         System.out.println("2 - Jogar do arquivo para a lista");
	         System.out.println("3 - Busca binária");
	         System.out.println("4 - Sair");
	         op = entrada.nextInt();
	         
	         switch (op) {
		          case 1:
		        	  if (lista.ListaVazia()== false){
			        	 	lista.mostraLista();
			        	 }else{
			        		 System.out.println("Lista vazia.....");
			        	 }
		        	  break;
		          case 2:
		        	  	lista.CarregarLista();
		        	  	break;
		          case 3:
		        	  if(lista.ListaVazia()== false){
		        		  System.out.print("Informe o nome para pesquisa: ");
		        		  //lista.buscaBinaria(entrada.next());
		        		  String vetor[]=  {"ana", "beto", "carlos" , "matheus" , "vanessa"};
		        		  lista.binaria( vetor , entrada.next());
		        	  } else{
		        		  System.out.println("Lista vazia.....");
		        	  }
		        	 break;
		           case 4:
		        	 System.out.println("O Programa foi encerrado....");
		     	     break;
			}
		} while (op!=8);
	}

}

