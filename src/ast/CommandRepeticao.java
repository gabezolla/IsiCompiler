package src.ast;

import java.util.ArrayList;

public class CommandRepeticao extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> lt;
	
	public CommandRepeticao(String condition, ArrayList<AbstractCommand> lt) {
        this.condition = condition;
        this.lt = lt;
    }

    public String generateJavaCode() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append("while ("+condition+") {\n");
		for (AbstractCommand cmd: lt) {
            str.append(cmd.generateJavaCode());
            str.append("\n");
		}
        str.append("}");
        return str.toString();
    }

    @Override
	public String toString() {
		return "CommandRepeticao [condition= "+condition+", listaTrue=" + lt + "]";
	}
}