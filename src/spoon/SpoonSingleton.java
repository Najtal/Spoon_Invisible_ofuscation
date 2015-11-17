package spoon;

/**
 * Singleton d'usage des instances Spoon
 * @author jvdur
 */
public class SpoonSingleton {

	private static Launcher spoonEditorLauncher;
	private static Launcher spoonModelReaderLauncher;

	static {
		 SpoonSingleton.spoonEditorLauncher = new spoon.Launcher();
		 SpoonSingleton.spoonModelReaderLauncher = new spoon.Launcher();
	}

	/**
	 * @return L'instance d'�dition du projet source
	 */
	public static Launcher getSpoonEditorLauncher() {
		return spoonEditorLauncher;
	}
	
	/**
	 * @return L'instance de lecture et d'analyse du mod�le
	 */
	public static Launcher getSpoonModelReaderLauncher() {
		return spoonModelReaderLauncher;
	}
}
