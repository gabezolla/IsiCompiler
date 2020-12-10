package src.ast;

public class CommandDecrementa extends AbstractCommand {    
	private String id;
	private int pp;

	public static final int posDecrementa = 1;
	public static final int preDecrementa = 0;

	public CommandDecrementa(String id, int pp) {
		this.id = id;
		this.pp = pp;
    }
    
	@Override
	public String generateJavaCode() {
		if(pp == 1) return id+"--;";
		else return "--"+id+";";
	}
	
	@Override
	public String toString() {
		return "CommandDecrementacao [id="+id+"]";
	}    
}
