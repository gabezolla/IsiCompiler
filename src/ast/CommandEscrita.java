package src.ast;

public class CommandEscrita extends AbstractCommand {

	private String id;
	private int type; // type 0 para variáveis, type 1 para strings 
	
	public CommandEscrita(String id, int type) {
		this.id = id;
		this.type = type;
	}

	@Override
	public String generateJavaCode() {
		if(type == 0) return "System.out.println("+id+");";
		else return "System.out.println(\""+id+"\");";
	}
	
	@Override
	public String toString() {
		return "CommandEscrita [id=" + id + "]";
	}
	

}
