package util;

import java.util.HashMap;
import java.util.UUID;

import spoon.reflect.code.CtExpression;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.ModifierKind;

public class FactoryReference {

	public HashMap<String,String> names ;
	public HashMap<String,String> strings ;
	private CtClass<?> ConstanteClass;
	
	
	public FactoryReference() {
		names = new HashMap<String,String>();
		strings = new HashMap<String,String>();
		ConstanteClass = null;
	}
	
	public String getName(String old) {
		String newName = "v" + UUID.randomUUID().toString().replace("-", "_");
		if(!names.containsKey(old)) {
			
			names.put(old, newName);
		}
		return names.get(old);
	}
	
	
	public String SaveString(String old) throws Exception {
		if(ConstanteClass == null) throw new Exception ("Constante Class TOTO");
		String newName = "v" + UUID.randomUUID().toString().replace("-", "_");
		if(!strings.containsKey(old)) {
			CtField field ;
		    CtExpression ce;
			field = ConstanteClass.getFactory().Core().createField();
	    	field.setSimpleName(newName);
		    field.setType( ConstanteClass.getFactory().Code().createCtTypeReference(String.class));
		    field.addModifier(ModifierKind.PUBLIC);
		    field.addModifier(ModifierKind.STATIC);
		    ce = ConstanteClass.getFactory().Code().createCodeSnippetExpression(old);
		    field.setAssignment(ce);
		    ConstanteClass.addField(field);
			strings.put(old, newName);
		}
		return ConstanteClass.getQualifiedName() + "." + strings.get(old);
	}
	
	public CtClass<?> getContanteClass() throws Exception {
		if(ConstanteClass == null) throw new Exception ("Constante Class TOTO");
		 return ConstanteClass;
	}
	
	public void setContanteClass(CtClass<?> c) {
		ConstanteClass = c;
	}
}