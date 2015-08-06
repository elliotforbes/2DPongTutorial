package main;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import gameEngine.GameObject;
import gameEngine.Level;
import input.KeyboardInput;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GLContext;



public class Driver {

	public int width = 800, height = 800;
	public boolean running = false;
	public long window;
	
	public GLFWKeyCallback keyboardInput;
	
	Level level1;
	
	
	public void init(){
		this.running = true;     
		
		if(glfwInit() != GL_TRUE){
			System.err.println("Error initializing glfw window handler library");
		}
		
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(width, height, "2D Pong", NULL, NULL);
		if(window == NULL){
			System.err.println("Could not create our Window!");
		}
		
		glfwSetKeyCallback(window, keyboardInput = new KeyboardInput());
		
		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, 100, 100);
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		
		GLContext.createFromCurrent();
		System.out.println("OpenGL: " + glGetString(GL_VERSION));
		
		level1 = new Level();
		
	}
	
	public void render(){
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glClearColor(0.39f, 0.58f, 0.92f, 1.0f);
		
		level1.draw();
		
		glfwSwapBuffers(window);
	}
	
	public void update(){
		glfwPollEvents();
		
		level1.update();
	}
	
	public void run(){
		init();
		long lastTime = System.nanoTime();
		double delta = 0.0;
		double ns = 1000000000.0 / 60.0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1.0) {
				update();
				updates++;
				delta--;
			}
			render();		
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
			if(glfwWindowShouldClose(window) == GL_TRUE){
				running = false;
			}
		}
		
		level1.cleanUp();
	}
	
	public static void main(String args[]){
		Driver driver = new Driver();
		driver.run();
	}
	
}
