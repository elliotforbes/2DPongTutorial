package graphicsEngine;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

import static utils.Utilities.*;

public class VertexArrayObject {

	public static final int VERTEX_ATTRIB = 0;
	public static final int TCOORD_ATTRIB = 1;
	
	private int vao;
	
	public VertexArrayObject(float[] vertices, byte[] indices){
		createArrayObject(vertices, indices);
	}
	
	public void createArrayObject(float[] vertices, byte[] indices){
		vao = glGenVertexArrays();
		glBindVertexArray(vao);
		
		createVerticesBuffer(vertices);
		createIndicesBuffer(indices);
		
		glBindVertexArray(0);
	}
	
	public int getVaoID(){
		return vao;
	}
	
	private void createVerticesBuffer(float[] vertices){
		int vboID = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboID);
		glBufferData(GL_ARRAY_BUFFER, createFloatBuffer(vertices), GL_STATIC_DRAW);
		glVertexAttribPointer(VERTEX_ATTRIB, 3, GL_FLOAT, false, 0, 0);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	private void createIndicesBuffer(byte[] indices){
		int ibo = glGenBuffers();
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, createByteBuffer(indices), GL_STATIC_DRAW);
	}

	
	

}
