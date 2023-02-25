public class Notation {

	public Notation() {
		
	}
	
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
	    MyQueue<String> q = new MyQueue<String>(infix.length());
	    MyStack<String> s = new MyStack<String>(infix.length());

	    char[] rep = infix.toCharArray();
	    try {
	        for(int count=0;count<rep.length;count++) {
	       char charact=rep[count];
	          switch (charact) {
	               case ' ':
	                    continue;
	               case '(':
	                    s.push(Character.toString(charact));
	                    break;
	               case ')':
	                    while (!s.isEmpty()&&!s.top().equals("(")) {
	                        q.enqueue(s.pop());
	                    }
	                if (!s.isEmpty()&&s.top().equals("(")) {
	                        s.pop();
	                    }
	                    else
	                        throw new Exception();
	                    break;
	             case '+':
	              case '-':
	             case '*':
	             case '/':
	   while (!s.isEmpty() && (s.top().equals("*") || s.top().equals("/") ||
	              (s.top().equals("+")||s.top().equals("-"))&&
	                            !orderOfp(s.top(),Character.toString(charact)))) {
	                        q.enqueue(s.pop());
	                    }
	                    s.push(Character.toString(charact));
	                    break;
	                default:
	                    if (Character.isDigit(charact)) {
	                        q.enqueue(Character.toString(charact));
	                        break;
	                    }
	                    throw new InvalidNotationFormatException();
	            }
	        }
	        while (!s.isEmpty()&&!s.top().equals("(")) {
	            q.enqueue(s.pop());
	        }
	        if (!s.isEmpty()) {
	            throw new InvalidNotationFormatException();
	        }
	    } catch (Exception e) {
	        throw new InvalidNotationFormatException();
	    }
	    return q.toString();
	}
	
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
	    String n1;
	    String n2;
	    char[] rep = postfix.toCharArray();
	    MyStack<String> s = new MyStack<String>(postfix.length());
	    try {
	        for (int count=0;count<rep.length;count++) {
	            char charact = rep[count];
	            switch (charact) {
	          case '+':
	           case '-':
	           case '*':
	           case '/':{
	              n1 = s.pop();
	          n2 = s.pop();
	      s.push("(" + n2 + charact + n1 + ")");
	              break;
	                }
	                default:
	                    if (Character.isDigit(charact)) {
	                        s.push(Character.toString(charact));
	                    } else {
	                        throw new InvalidNotationFormatException();
	                    }
	            }
	        }
	        if (s.size()!=1) {
	            throw new Exception();
	        }
	    } catch (Exception e) {
	        throw new InvalidNotationFormatException();
	    }
	    return s.toString();
	}
	
	public static double evaluatePostfixExpression(String postfixExpr) 
	throws InvalidNotationFormatException {
	   String n1;
  String n2;
	    char[] rep = postfixExpr.toCharArray();

	    MyStack<String> s = new MyStack<String>(postfixExpr.length());

	 try {
	        for (int count=0; count<rep.length;count++) {
	          char charact = rep[count];
	         switch (charact) {
	         case ' ':
	           continue;
	           case '+':
	             n1 = s.pop();
	            n2 = s.pop();
	           s.push(Integer.toString(Integer.parseInt(n2)+Integer.parseInt(n1)));
	            break;
	            case '-':
	            n1 = s.pop();
	           n2 = s.pop();
	         s.push(Integer.toString(Integer.parseInt(n2)-Integer.parseInt(n1)));
	          break;
	          case '*':
	            n1 = s.pop();
	          n2 = s.pop();
	         s.push(Integer.toString(Integer.parseInt(n2)*Integer.parseInt(n1)));
	          break;
	        case '/':
	         n1 = s.pop();
	        n2 = s.pop();
	       s.push(Integer.toString(Integer.parseInt(n2)/Integer.parseInt(n1)));
	        break;
	        default:
	          if (Character.isDigit(charact)) {
	          s.push(Character.toString(charact));
	               break;
	                    }
	           throw new InvalidNotationFormatException();
	            }
	        }
    if (s.size()>1) {
	      throw new InvalidNotationFormatException();
	        }
	    } 
	    catch (InvalidNotationFormatException e) {
	        throw e;
	 
	    } catch (Exception e) {
	        throw new InvalidNotationFormatException();
	    }
	    return Integer.parseInt(s.toString());
	}
	
	
	
	
	public static boolean orderOfp(String re1, String re2) {
		int re3=1;
		int re4=1;
		boolean flag;
		
		if (!(re1.equals("/"))) {
			;
		}
		else if  (!(re1.equals("*"))){
			;
		}
		else {
			re3++;
		}
		
		if ((!re2.equals("/"))) {
			;
		}
		else if (!(re2.equals("*"))) {
			;
		}
		else {
			re4++;
		}
		
		if (re4<re3) {
			flag=false;
		}
		else {
			flag=true;
		}
		
		return flag;
	}
	

}