package src.ast;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand {

	private String id;
    private String condition;
    private ArrayList<AbstractCommand> lt;
	
	public CommandRepeticao(String id, String condition, ArrayList<AbstractCommand> lt) {
		this.id = id;
        this.condition = condition;
        this.lt = lt;
    }

    public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while ("+ id +""+condition+") {\n");
		for (AbstractCommand cmd: lt) {
            str.append(cmd.generateJavaCode());
            str.append("\n");
		}
        str.append("}");
        return str.toString();
    }

    @Override
	public String toString() {
		return "CommandRepeticao [condition= "+id+""+condition+", listaTrue=" + lt + "]";
	}
}