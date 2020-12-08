package src.ast;

public class CommandIncrementa extends AbstractCommand {    
	private String id;
	
	public CommandIncrementa(String id) {
		this.id = id;
    }
    
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return id+"++;";
	}
	@Override
	public String toString() {
		return "CommandIncrementacao [id="+id+"++]";
	}    
}
