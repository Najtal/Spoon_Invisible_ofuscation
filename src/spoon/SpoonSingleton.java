package spoon;

public class SpoonSingleton {

	private static Launcher spoonLauncher;

	{
		 this.spoonLauncher = new spoon.Launcher();
	}
	
	public static Launcher getSpoonLauncher() {
		return spoonLauncher;
	}
}
