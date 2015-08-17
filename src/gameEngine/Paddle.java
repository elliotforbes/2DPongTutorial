package gameEngine;

import utils.Vector3f;
import graphicsEngine.VertexArrayObject;
import input.KeyboardInput;
import static org.lwjgl.glfw.GLFW.*;

public class Paddle extends GameObject{

	private VertexArrayObject vao; 
	
	private float HEIGHT = 0.25f;
	private float WIDTH = 0.05f;
	
	float[] vertices = {
			0.0f, HEIGHT, 0f,
			0.0f, 0.0f, 0f,
			WIDTH, 0.0f, 0f,
			WIDTH, HEIGHT, 0f,
	};
	
	public byte[] indices = new byte[] {
		0, 1, 2,
		2, 3, 0
	};
	
	private Vector3f movement = new Vector3f();
	
	public Paddle() {
		this.count = indices.length;
		vao = new VertexArrayObject(this.vertices, this.indices);
		this.vaoID = vao.getVaoID();
		this.position = new Vector3f();
	}
	
	public boolean checkBounds(){
		if(position.y <= -1.0f) {
			System.out.println("Below the Window");
			position.y = -0.99f;
			return true;
		}
		if(position.y + HEIGHT >= 1.0f){
			System.out.println("Above the Window");
			position.y = 0.99f - HEIGHT;
			return true;
		}
		return false;
	}
	
	public void update(){
		if(KeyboardInput.isKeyDown(GLFW_KEY_W))
			movement.y = 0.01f;
		else if(KeyboardInput.isKeyDown(GLFW_KEY_S))
			movement.y = -0.01f;
		else
			movement.y = 0;
		
		if(!checkBounds())
			position.y += movement.y;
	}
	
	public void AIUpdate(){
		if(KeyboardInput.isKeyDown(GLFW_KEY_UP))
			position.y += 0.01f;
		if(KeyboardInput.isKeyDown(GLFW_KEY_DOWN))
			position.y -= 0.01f;
	}
	
}
