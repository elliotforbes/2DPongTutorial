package gameEngine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import utils.Vector3f;
import graphicsEngine.ShaderManager;
import graphicsEngine.VertexArrayObject;

public class GameObject {
	
	public int vaoID;
	public int count;
	public float SIZE = 1.0f;
	
	public Vector3f position;
	public int shaderID;
	
	public VertexArrayObject vao; 

	public GameObject(){	
	}
	
	public void setShaderID(int id){
		this.shaderID = id;
	}
		
	public void draw(){		
		glBindVertexArray(vaoID);
		glEnableVertexAttribArray(0);
		glDrawElements(GL_TRIANGLES, count, GL_UNSIGNED_BYTE, 0);
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
	}
}
