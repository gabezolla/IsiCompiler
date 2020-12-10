package src.datastructures;

public class IsiVariable extends IsiSymbol {
	
	public static final int NUMBER = 0;
	public static final int TEXT = 1;
	public static final int ARRAY = 2;

	private boolean varUsed = false;	
	private int type;
	private String value;
	
	public IsiVariable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}

	public boolean isUsed() {
        return varUsed;
    }

    public void setUsed(boolean used) {
        this.varUsed = used;
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "IsiVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
	}
	
	public String generateJavaCode() {
       String str;
       if (type == NUMBER) {
		   str = "double ";
	   }
	   else if(type == ARRAY) {
		   str = "double[] "+name+"= new double["+value+"];";
		   return str;
	   }
       else {
    	   str = "String ";
	   }
       return str + " "+super.name+";";
	}
}
