package graphicsEngine;

import static utils.Utilities.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import utils.Vector3f;

public class Shader {

	
	private int programID;
	private int vertexShaderID;
	private int fragmentShaderID;
	
	public Shader(String vertexFile, String fragmentFile){
		vertexShaderID = loadShader(vertexFile, GL_VERTEX_SHADER);
		fragmentShaderID = loadShader(fragmentFile, GL_FRAGMENT_SHADER);
		programID = glCreateProgram();
		glAttachShader(programID, vertexShaderID);
		glAttachShader(programID, fragmentShaderID);
		glLinkProgram(programID);
		glValidateProgram(programID);
	}
	
	public void start(){
		glUseProgram(programID);
	}
	
	public void stop(){
		glUseProgram(0);
	}
	
	public int getID(){
		return this.programID;
	}
	
	public int getUniform(String name){
		int result = glGetUniformLocation(programID, name);
		if(result == -1)
			System.err.println("Could not find uniform variable'" + name + "'!");
		return glGetUniformLocation(programID, name);
	}
	
	public void setUniform3f(String name, Vector3f vector) {
		glUniform3f(getUniform(name), vector.x, vector.y, vector.z);
	}
	
	public void cleanUp(){
		stop();
		glDetachShader(programID, vertexShaderID);
		glDetachShader(programID, fragmentShaderID);
		glDeleteShader(vertexShaderID);
		glDeleteShader(fragmentShaderID);
		glDeleteProgram(programID);
	}
	
	protected void bindAttribute(int attribute, String variableName){
		glBindAttribLocation(programID, attribute, variableName);
	}
	
}
