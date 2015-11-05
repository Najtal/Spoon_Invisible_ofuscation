package spoon;

public class SpoonSingleton {

	private static Launcher spoonEditorLauncher;
	private static Launcher spoonModelReaderLauncher;

	{
		 SpoonSingleton.spoonEditorLauncher = new spoon.Launcher();
		 SpoonSingleton.spoonModelReaderLauncher = new spoon.Launcher();
	}
	
	public static Launcher getSpoonEditorLauncher() {
		return spoonEditorLauncher;
	}
	
	public static Launcher getSpoonModelReaderLauncher() {
		return spoonModelReaderLauncher;
	}
}
