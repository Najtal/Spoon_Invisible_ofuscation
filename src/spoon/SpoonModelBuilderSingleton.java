package spoon;

public class SpoonModelBuilderSingleton {

	private SpoonModelBuilder spoonModelBuilder;

	{
		 this.spoonModelBuilder = new spoon.Launcher().getModelBuilder();
	}
	
	public SpoonModelBuilder getSpoonModelBuilder() {
		return spoonModelBuilder;
	}
}
