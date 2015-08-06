package graphicsEngine;

public class ShaderManager {

	public static Shader shader1;
	public static Shader shader2;
	public static Shader shader3;
	
	public ShaderManager(){
		System.out.println("Shader Manager Started");
	}
	
	public static void loadShader(String vertFile, String fragFile){
		new Shader(vertFile, fragFile);
	}
	
	public static void loadAll(){
		shader1 = new Shader("src/shaders/vertexShader", "src/shaders/fragShader");
		shader2 = new Shader("src/shaders/vertexShader1", "src/shaders/fragShader1");
		shader3 = new Shader("src/shaders/vertexShader2", "src/shaders/fragShader2");
	}
	
	
	
}
