import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main (String[] args){
    	
    	int control = 1;
    	int i = 0;

        Scanner sc = new Scanner(System.in);
        
        ArrayList<PilhaEstatica> agenda = new ArrayList<>();
        
        while (control !=0) {
        	mostrarMenu();
        	control = sc.nextInt();
        	
        	switch(control) {
        		case 1:
        			//Incluir contato
        			PilhaEstatica pilha = new PilhaEstatica();
        			System.out.print("Informe o nome do contato: ");
        			String nome = sc.next();
        			System.out.print("Informe o telefone do contato: ");
        			String telefone = sc.next();
        			System.out.print("Informe o email do contato: ");
        			String email = sc.next();
        			Contato contato = new Contato(i,nome,telefone, email);
        			pilha.addEstado(contato);
        			agenda.add(pilha);
        			i++;
        			System.out.println("Contato incluido na agenda!");
        			System.out.println(" ");
        			break;
        		case 2:
        			// alterar contato
        			System.out.println("Informe o id a ser alterado:");
        			int alt = sc.nextInt();
        			PilhaEstatica contatoAlterado = agenda.get(alt);
        			System.out.print("Informe o novo nome do contato: ");
        			String nome1 = sc.next();
        			System.out.print("Informe o novo telefone do contato: ");
        			String telefone1 = sc.next();
        			System.out.print("Informe o novo email do contato: ");
        			String email1 = sc.next();
        			Contato contato1 = new Contato(alt,nome1,telefone1, email1);
        			contatoAlterado.addEstado(contato1);
        			System.out.println("Contato alterado com sucesso!");
        			System.out.println(" ");
        			break;
        		case 3:
        			// excluir contato
        			System.out.println("Informe o id a ser deletado:");
        			int exc = sc.nextInt();
        			String contatoExcluido = agenda.get(exc).getTopo().getNome();
        			agenda.remove(exc);
        			System.out.println("Contato removido: "+ contatoExcluido);
        			break;
        		case 4:
        			// exibir contato
        			if (agenda.isEmpty()) {
        				System.out.println("Agenda vazia");
        				break;
        			}else {
        			for (PilhaEstatica ctt: agenda) {
        				System.out.println("--------------------------------------");
        				System.out.println("id: "+ ctt.getTopo().getId());
        				System.out.println("Nome: "+ ctt.getTopo().getNome());
        				System.out.println("Telefone: "+ ctt.getTopo().getTelefone());
        				System.out.println("Email: "+ ctt.getTopo().getEmail());
        				System.out.println("--------------------------------------");
        				}
        			break;
        			}
        		case 5:
        			// Exibir historico do contato
        			System.out.println("Informe o id do contato alterado a ser exibido:");
        			int hist = sc.nextInt();
        			PilhaEstatica contatoHist = agenda.get(hist);
        			for(Contato ctt: contatoHist.contato) {
        					System.out.println(ctt);
        			}
        			break;
        		default:
        			if (control !=0) {
        				System.out.println("Voce informou uma opção incorreta, digite uma opção valida");
        				mostrarMenu();
        				control = sc.nextInt();
        			}
        			break;
        			
        	}
        		
        }
    	System.out.println("Execução finalizada!");
    }
    
    static void mostrarMenu() {
    	System.out.println("Informe a operação desejada:\n");
    	System.out.println("1. Incluir contato \n2. Alterar contato \n3. Excluir contato\n4. Exibir contatos\n5. Exibir histórico do contato alterado\n0. Sair"); 
    }

}
