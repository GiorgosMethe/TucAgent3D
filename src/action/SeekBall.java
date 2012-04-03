/*******************************************************************************
 * Copyright 2012, Technical University of Crete
 * Autonomous Agents, winter semester 2011-12
 * Semester Assignment
 * 
 * @author Methenitis Giorgos
 * @author Mpountouris Konstantinos
 * @author Papadimitriou Maouro Vassilis
 * @author Skipetaris Dimosthenis 
 *******************************************************************************/

package action;

import connection.ServerCyrcles;
import perceptor.Ball;
import perceptor.GetNormalJointValue;
import perceptor.HingeJointPerceptor;
import perceptor.Vision;


public class SeekBall {

	GetNormalJointValue gNjV = new GetNormalJointValue();

	public String MoveHead(){

		
		int cycles=ServerCyrcles.getCyrclesNow();
		float moveX=(float) (2.09*Math.sin(cycles/15));
		float moveY= (float) (0.59*Math.sin(cycles/8)-0.078);
		String str="";

		if(Vision.isiSee()==true){

			if(Ball.isSeeTheBall()==true){
				str="("+"he1"+" "+centerTheBallX()+")"+"("+"he2"+" "+centerTheBallY()+")";			
			}else{
				float realMoveX=gNjV.Get("he1", moveX)/5;
				float realMoveY=gNjV.Get("he2", moveY)/5;
				str="("+"he1"+" "+realMoveX+")"+"("+"he2"+" "+realMoveY+")";
			}

		}
		return str;
	}

	public float centerTheBallX(){
		float x = 0;
		if(Math.abs(HingeJointPerceptor.getHj1())<125){

			if(Ball.getAngleX()>5){
				x = 1;
			}
			if(Ball.getAngleX()<-5){
				x = -1;
			}
		}else{					
						
		}
		return x;
	}
	
	public float centerTheBallY(){
		float x = 0;
		if(Math.abs(HingeJointPerceptor.getHj2())<45){

			if(Ball.getAngleY()>5){
				x = 1;
			}
			if(Ball.getAngleY()<-5){
				x = -1;
			}
		}else{					
						
		}
		return x;
	}
	
		
	
	
	
}