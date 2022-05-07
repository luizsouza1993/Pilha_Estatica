import java.util.ArrayList;

public class PilhaEstatica {

    ArrayList<Contato> contato = new ArrayList<>();
	
    Contato getTopo(){
    	int indice = contato.size();
    	return contato.get(indice -1 );
    	
    }
    
    void addEstado(Contato c) {
    	contato.add(c);
    }
    
}
