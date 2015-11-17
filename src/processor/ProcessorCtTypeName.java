package processor;

import controller.Initialisation;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtType;

/**
 * Spoon processor : permet de renommer les classes, les interfaces et les Enum
 * @author jvdur
 */
public class ProcessorCtTypeName  extends AbstractProcessor<CtType> {
	
	@Override
	public void process(CtType element) {
		System.out.println("elem a renom : " + element.getSimpleName());
		
		String newName = Initialisation.getModel().getMeADamnTypeName(null);
		System.out.println("elem a remplacer : " + newName);
		
		element.setSimpleName(newName);		
	}}