package gameEngine;

import utils.Vector3f;
import graphicsEngine.ShaderManager;

public class Level {

	public Paddle player1;
	public Paddle player2;
	
	public Ball ball;
	
	public ShaderManager shaderManager;
	
//	public Ball ball;
	
	public Level(){
		shaderManager = new ShaderManager();
		shaderManager.loadAll();
		
		player1 = new Paddle();
		player2 = new Paddle();
		ball = new Ball();
		
		player1.position.x -= 1.0f;
		player2.position.x += 0.95f;
		
	}
	
	public void update(){
		player1.update();
		player2.AIUpdate();
		ball.update();
	}
	
	public void draw(){
		ShaderManager.shader1.start();
		ShaderManager.shader1.setUniform3f("pos", player1.position);
		player1.draw();
		ShaderManager.shader1.stop();
		
		ShaderManager.shader1.start();
		ShaderManager.shader1.setUniform3f("pos", player2.position);
		player2.draw();
		ShaderManager.shader1.stop();
		
		ShaderManager.shader3.start();
		ShaderManager.shader3.setUniform3f("pos", ball.position);
		ball.draw();
		ShaderManager.shader3.stop();
	}
	
	public void cleanUp(){
		ShaderManager.shader1.cleanUp();
		ShaderManager.shader2.cleanUp();
		ShaderManager.shader3.cleanUp();
	}
	
}
