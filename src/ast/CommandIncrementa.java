package src.ast;

public class CommandIncrementa extends AbstractCommand {    
	private String id;
	private int pp;
	
	public static final int posIncrementa = 1;
	public static final int preIncrementa = 0;
	
	public CommandIncrementa(String id, int pp) { // pp = pós ou pré incrementação, pós = 1, pré = 0.
		this.id = id;
		this.pp = pp;
    }
    
	@Override
	public String generateJavaCode() {
		if(pp == 1) return id+"++;";
		if(pp == 0) return "++"+id+";";
		return "";
	}

	@Override
	public String toString() {
		return "CommandIncrementacao[id="+id+"]";
	}    
}
