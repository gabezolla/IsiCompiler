package src.ast;

import src.datastructures.IsiVariable;

public class CommandLeitura extends AbstractCommand {

	private String id;
	private IsiVariable var;
	
	public CommandLeitura (String id, IsiVariable var) {
		this.id = id;
		this.var = var;
	}

	@Override
	public String generateJavaCode() {

		if(var.getType() == IsiVariable.NUMBER) {
			return id+"= _key."+"nextDouble();";
		}

		if(var.getType() == IsiVariable.TEXT) {
			return id+"= _key."+"nextLine();";
		}

		if(var.getType() == IsiVariable.ARRAY) {
			return id+"= _key."+"nextDouble();";
		}

		return "";
	}

	@Override
	public String toString() {
		return "CommandLeitura [id=" + id + "]";
	}

}
