package EstudoListaEnc;

import EstudoListaEnc.Arquivo;
import java.io.*;
import java.util.Scanner;

import javax.swing.Popup;

public class EstudoListaEnc {
	Contato primeiro;
	Contato ultimo;
	
	public EstudoListaEnc(){
		primeiro = null;
		ultimo = primeiro;
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
				
		}else {
			if (validaLista(nome)== false){
				Contato  novo = new Contato();
				novo.setNome(nome);
				novo.setTelefone(fone);
				novo.setProx(null);
				ultimo.setProx(novo);
				ultimo = novo;
			}else{
				System.out.println("Este contato já esta na lista...");
			}			
		}
	}
		
	public void CarregarLista(){
		try
		{
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
			
			while(andar != null){
				System.out.println(andar.getNome());
				System.out.println(andar.getTelefone());				
				andar = andar.getProx();
			}
		}		
	}
	
	public void CarregarArquivo() throws IOException{
		Contato carregar  = primeiro.getProx();
		if(ListaVazia()==true){
			System.out.println("Lista vazia.....");
		}else{
			File aux = new File("d:\\Teste.txt");
			if(aux.exists()){
				FileWriter grava = new FileWriter ("d:\\Teste.txt", true);
				BufferedWriter buffer = new BufferedWriter( grava);
				while(carregar != null){
					buffer.write(carregar.getNome());
					buffer.write("-->" + carregar.getTelefone());
					buffer.newLine( );
					carregar = carregar.getProx();    		
				}
				buffer.close( );
				grava.close( );
			}else{
				System.out.println("Arquivo não encontrado.");				
			}			
     	}		
	}
	
	public void Retirar(String valor){
		boolean achou =  false;
		Contato remove = primeiro.getProx();
		Contato aux = primeiro;
	
		if(ListaVazia()==true){
			System.out.println("Lista vazia.....");
		}else{
			
			if (primeiro != null){
				while(remove != null){
					if(remove.getNome().equals(valor)){
						if (remove.getProx()== null){
							ultimo = aux;
							ultimo.setProx(null);
							remove = null;
							achou = true;
							break;
						}else{
							aux.setProx(remove.getProx());
							remove.setProx(null);
			 				remove = null;
							achou= true;
							break;
						}
					}
					remove =remove.getProx();
					aux = aux.getProx();
				}
			}
			if (achou == false ){
				System.out.println("Contato não encontrado....");
			}
		}		
	}
	
	public void OrdernarLista(Contato contato){
		if(ListaVazia()==false){
			/*
			 * 
			 * 
			 * 
			 */
			 
			Contato aux, temp, temp1;
		    temp= primeiro.getProx();
		    String nomeAux= temp.getNome();
	        		
			while(primeiro != null) {
				int resultado;
				temp1 =  temp.getProx();
				resultado = temp.getNome().compareTo(temp1.getNome());
				
				if(resultado ==0){
					//Iguais
					
		        }else if(resultado>0){
		        	//Carlos > beto
		        	primeiro.setNome(temp1.getNome());
		        	primeiro = primeiro.getProx() ;
		        }else if(resultado <0){
		        	
		        }			
		     	temp1 = temp1.getProx();
			}
		}		
	}
		
	public static void main(String args[] ) throws IOException {   
		EstudoListaEnc popular = new EstudoListaEnc();
		Scanner entrada = new  Scanner(System.in);
		String nome , arquivo, fone="";
		
		int op;
				
		do{
			 System.out.print("Digite uma das opções abaixo\n");
	         System.out.println();
	         System.out.println("1 - Popular lista");
	         System.out.println("2 - Retirar da lista");
	         System.out.println("3 - Mostrar a lista");
	         System.out.println("4 - Jogar lista para arquivo");
	         System.out.println("5 - Jogar do arquivo para a lista");
	         System.out.println("6 - Ordernar a lista");
	         System.out.println("7 -Busca binária");
	         System.out.println("8 - Sair");
	         op = entrada.nextInt();
	         
	         switch (op) {
		         case 1:
		        	 System.out.print("Informe o nome do contato: ");
		        	 nome=entrada.next();
		        	 System.out.print("Informe o telefone do contato: ");
		        	 fone = entrada.next();
		        	 popular.Adiciona(nome, fone);
		        	 break;
		         case 2:
		        	 if (popular.ListaVazia()== false){
		        		 System.out.print("Informe o nome do contato para retirar da lista: ");
		        		 popular.Retirar(entrada.next());
		        	 }else{
		        		 System.out.println("Lista vazia.....");
		        	 }
		        	 break;
		         case 3:
					 popular.mostraLista();
					 break;
		          case 4:
		        	 if (popular.ListaVazia()== false){
		        	 	popular.CarregarArquivo();
		        	 }else{
		        		 System.out.println("Lista vazia.....");
		        	 }
		        	 break;
		         case 5:
		        	 	popular.CarregarLista();
		        	 break;
		         case 6:
		        	 Contato contato = new Contato();
		        	 popular.OrdernarLista(contato);
		        	 break;
		         case 7:
		        	 System.out.println("O Programa foi encerrado....");
		     	     break;
			}
		} while (op!=8);
	}



}

