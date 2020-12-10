grammar IsiLang;

@header{
	import src.datastructures.IsiSymbol;
	import src.datastructures.IsiVariable;
	import src.datastructures.IsiSymbolTable;
	import src.exceptions.IsiSemanticException;
	import src.ast.IsiProgram;
	import src.ast.AbstractCommand;
	import src.ast.CommandLeitura;
	import src.ast.CommandEscrita;
	import src.ast.CommandAtribuicao;
	import src.ast.CommandDecisao;
	import src.ast.CommandRepeticao;
	import src.ast.CommandIncrementa;
	import src.ast.CommandDecrementa;
	import java.util.ArrayList;
	import java.util.Stack;
}


@members{
	private int _tipo;
	private String _varName;
	private String _varValue;
	private IsiSymbolTable symbolTable = new IsiSymbolTable();
	private IsiSymbol symbol;
	private IsiProgram program = new IsiProgram();
	private ArrayList<AbstractCommand> curThread;
	private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
	private String _readID;
	private String _writeID;
	private String _exprID;
	private String _exprContent;
	private String _exprDecision;
	private String a;
	private ArrayList<AbstractCommand> listaTrue;
	private ArrayList<AbstractCommand> listaFalse;
	
	public void verificaID(String id){
		if (!symbolTable.exists(id)){
			throw new IsiSemanticException("Variável "+id+" nao foi declarada.");
		}
	}

	public void varUsed(String id) {
        if(symbolTable.exists(id)){
            IsiVariable var = (IsiVariable)symbolTable.get(id);
            var.setUsed(true);
        }
    }

    public boolean isVarUsed(String id) {
        if(symbolTable.exists(id)){
			IsiVariable var = (IsiVariable)symbolTable.get(id);
            return var.isUsed();
        }
        return false;
    }
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: 'programa' decl bloco 'fimprog;'
           {  program.setVarTable(symbolTable);
           	  program.setComandos(stack.pop());           	 
           } 
		;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  ((tipo ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	            		symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Variavel "+_varName+" ja foi declarada.");
	                  }
                    } )
				|

				('vetor' { _tipo = IsiVariable.ARRAY; }
					ACOL size=NUMBER FCOL vectorName=ID
					{ _varName = $vectorName.text;
	                  _varValue = $size.text;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	            		symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Variavel "+_varName+" ja foi declarada.");
	                  } })
				)

              (  VIR 
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new IsiVariable(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);	
	                  }
	                  else{
	                  	 throw new IsiSemanticException("Variavel "+_varName+" ja foi declarada.");
	                  }
                    }
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = IsiVariable.NUMBER;  }
           | 'texto'  { _tipo = IsiVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdif
		|  cmdrepeticao
		|  cmdincrementa
		|  cmddecrementa  
		;
		
cmdleitura	: 'leia' AP
                    (ID { verificaID(_input.LT(-1).getText());
                     	_readID = _input.LT(-1).getText();
						IsiVariable var = (IsiVariable)symbolTable.get(_readID);
						varUsed(_readID);
              			CommandLeitura cmd = new CommandLeitura(_readID, var);
              			stack.peek().add(cmd);
                    }
					| (varName=ID ACOL position=NUMBER FCOL {
						verificaID($varName.text);
        				_readID = $varName.text+"["+$position.text+"]"; 
						IsiVariable var = new IsiVariable($varName.text, 2, null);
						varUsed(_readID);
						CommandLeitura cmd = new CommandLeitura(_readID, var);
              			stack.peek().add(cmd); }))
                    FP 
                    SC
              {
              	
              }   
			;
			
cmdescrita	: 'escreva' 
                	AP 
                	(ID {  verificaID(_input.LT(-1).getText());
	                	_writeID = _input.LT(-1).getText();
						CommandEscrita cmd = new CommandEscrita(_writeID, 0);
            			stack.peek().add(cmd); }
					| ASP a=STRING ASP { 
						CommandEscrita cmd = new CommandEscrita($a.getText(), 1);
            			stack.peek().add(cmd);  }
					| vetor {						
						CommandEscrita cmd = new CommandEscrita(_exprID, 0);
						stack.peek().add(cmd);
					}
					)
                	FP 
                	SC
               	;

vetor: (varName=ID ACOL position=NUMBER FCOL {
		verificaID($varName.text);
        _exprID = $varName.text+"["+$position.text+"]";
		if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");
		})
	;
			
cmdattrib	:  ((ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   })
				| vetor)
               ATTR { _exprContent = ""; } 
               expr  
               SC
               {				   	
				   	varUsed(_exprID);
               		CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
               		stack.peek().add(cmd);
               }
			;

cmdincrementa : ((ID { verificaID(_input.LT(-1).getText());
					if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");
                    _exprID = _input.LT(-1).getText();
                   } | vetor)
				'++'
				SC {
					CommandIncrementa cmd = new CommandIncrementa(_exprID, CommandIncrementa.posIncrementa);
					stack.peek().add(cmd);					
				})
				|
				(
				'++'
				(ID { verificaID(_input.LT(-1).getText());
                _exprID = _input.LT(-1).getText();
                }

				SC {
					CommandIncrementa cmd = new CommandIncrementa(_exprID, CommandIncrementa.preIncrementa);
					stack.peek().add(cmd);					
				}))

			; 

cmddecrementa : ((ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
					if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");

                   } | vetor)
				'--'
				SC {
					CommandDecrementa cmd = new CommandDecrementa(_exprID, CommandDecrementa.posDecrementa);
					stack.peek().add(cmd);					
				})
				|
				('--'				
				ID { verificaID(_input.LT(-1).getText());
                    _exprID = _input.LT(-1).getText();
                   }
				
				SC {
					CommandDecrementa cmd = new CommandDecrementa(_exprID, CommandDecrementa.preDecrementa);
					stack.peek().add(cmd);					
				})
			; 
			
			
cmdif  :  'se' AP
                    (ID { 
						verificaID(_input.LT(-1).getText());
						_exprDecision = _input.LT(-1).getText(); 
						if(isVarUsed(_exprDecision)==false) throw new IsiSemanticException("Variavel nao utilizada"); } 
					| (varName=ID ACOL position=NUMBER FCOL {
						if(isVarUsed(_exprDecision)==false) throw new IsiSemanticException("Variavel nao utilizada");
						verificaID($varName.text);
       					_exprDecision = $varName.text+"["+$position.text+"]";}))

                    OPREL { _exprDecision += _input.LT(-1).getText(); }

                    ((varName=ID | NUMBER  {
						verificaID($varName.text);
						_exprDecision += _input.LT(-1).getText(); 
						if(isVarUsed($varName.text)==false) throw new IsiSemanticException("Variavel nao utilizada");})
					| 
					(varName=ID ACOL position=NUMBER FCOL { 
						verificaID($varName.text);
       					_exprDecision += $varName.text+"["+$position.text+"]";
						if(isVarUsed($varName.text)==false) throw new IsiSemanticException("Variavel nao utilizada");
						})						   
					)
                    FP 
					'entao'
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
                      stack.push(curThread);
                    }
                    (cmd)+ 
                    
                    FCH 
                    {
                       listaTrue = stack.pop();	
                    } 
                   ('senao' 
                   	 ACH
                   	 {
                   	 	curThread = new ArrayList<AbstractCommand>();
                   	 	stack.push(curThread);
                   	 } 
                   	(cmd+) 
                   	FCH
                   	{
                   		listaFalse = stack.pop();
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;

cmdrepeticao : 'enquanto'	AP
							((ID  {
							verificaID(_input.LT(-1).getText());
							if(isVarUsed(_exprID)==false) throw new IsiSemanticException("Variavel nao utilizada");
							_exprID = _input.LT(-1).getText();}) 
							| 
							(varName=ID ACOL position=NUMBER FCOL {
								verificaID($varName.text);
								if(isVarUsed($varName.text)==false) throw new IsiSemanticException("Variavel nao utilizada");
								_exprID = $varName.text+"["+$position.text+"]";
							}))
							OPREL { 
								_exprDecision = "";
								_exprDecision += _input.LT(-1).getText(); }
							((varName=ID | NUMBER {
								verificaID($varName.text);
								if(isVarUsed($varName.text)==false) throw new IsiSemanticException("Variavel nao utilizada");
								_exprDecision += _input.LT(-1).getText(); 
								}) 
							|
							(varName=ID ACOL position=NUMBER FCOL { 
								verificaID($varName.text);
								if(isVarUsed($varName.text)==false) throw new IsiSemanticException("Variavel nao utilizada");
       							_exprDecision += $varName.text+"["+$position.text+"]";}
							))
							FP
							ACH 
                    		{ 	curThread = new ArrayList<AbstractCommand>(); 
                      			stack.push(curThread);
                    		}
							(cmd)+							
							FCH
							{
								listaTrue = stack.pop();
								CommandRepeticao cmd = new CommandRepeticao(_exprID, _exprDecision, listaTrue);
								stack.peek().add(cmd);
							}
			;
			
expr		:  termo ( 
	             OP  { _exprContent += _input.LT(-1).getText();}
	            termo
	            )*
			;

			
termo		: ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
			;
			
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : ':='
	 ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;

ASP : '"';	 

ACOL : '[';
FCOL : ']';
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;

STRING : ([a-z] | [A-Z] | [0-9])+;

BOOL : 'verdadeiro' | 'falso';