package processor;

import controller.Initialisation;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtType;

public class ProcessorCtTypeName  extends AbstractProcessor<CtType> {
	
	@Override
	public void process(CtType element) {
		System.out.println("elem a renom : " + element.getSimpleName());
		
		String newName = Initialisation.getModel().getMeADamnTypeName(null);
		System.out.println("elem a remplacer : " + newName);
		
		element.setSimpleName(newName);		
	}}