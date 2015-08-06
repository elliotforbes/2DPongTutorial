package gameEngine;

import utils.Vector3f;
import graphicsEngine.VertexArrayObject;
import input.KeyboardInput;
import static org.lwjgl.glfw.GLFW.*;

public class Paddle extends GameObject{

	private VertexArrayObject vao; 
	
	float[] vertices = {
			0.0f, 0.25f, 0f,
			0.0f, 0.0f, 0f,
			0.05f, -0.0f, 0f,
			0.05f, 0.25f, 0f,
	};
	
	public byte[] indices = new byte[] {
		0, 1, 2,
		2, 3, 0
	};
	
	public Paddle() {
		this.count = indices.length;
		vao = new VertexArrayObject(this.vertices, this.indices);
		this.vaoID = vao.getVaoID();
		this.position = new Vector3f();
	}
	
	public void update(){
		if(KeyboardInput.isKeyDown(GLFW_KEY_W))
			position.y += 0.01f;
		if(KeyboardInput.isKeyDown(GLFW_KEY_S))
			position.y -= 0.01f;
	}
	
	public void AIUpdate(){
		if(KeyboardInput.isKeyDown(GLFW_KEY_UP))
			position.y += 0.01f;
		if(KeyboardInput.isKeyDown(GLFW_KEY_DOWN))
			position.y -= 0.01f;
	}
	
}
