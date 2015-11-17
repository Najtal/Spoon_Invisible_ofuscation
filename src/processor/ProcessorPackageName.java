package processor;

import controller.Initialisation;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtPackage;

public class ProcessorPackageName extends AbstractProcessor<CtPackage> {
	
	@Override
	public void process(CtPackage pack) {

		String newName = Initialisation.getModel().getMeADamnPackageName(null);
		//InvocationFilter filterInvoc = new InvocationFilter(pack.getReferences(new Filter));
		//NameFilter filterName = new NameFilter(pack.getSimpleName());
		pack.setSimpleName(newName);
	}

}

