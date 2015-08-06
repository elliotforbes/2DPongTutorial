package gameEngine;

import graphicsEngine.VertexArrayObject;
import utils.Vector3f;

public class Ball extends GameObject{

	private VertexArrayObject vao; 
	
	float[] vertices = {
			0.0f, 0.05f, 0f,
			0.0f, 0.0f, 0f,
			0.05f, 0.0f, 0f,
			0.05f, 0.05f, 0f,
	};
	
	public byte[] indices = new byte[] {
		0, 1, 2,
		2, 3, 0
	};
	
	public Ball(){
		this.count = indices.length;
		vao = new VertexArrayObject(this.vertices, this.indices);
		this.vaoID = vao.getVaoID();
		this.position = new Vector3f();
	}
	
	public void update(){
//		position.x += 0.01f;
	}
	
}
