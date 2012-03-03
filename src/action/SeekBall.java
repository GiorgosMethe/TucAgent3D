package action;

import perceptor.Ball;
import perceptor.GetNormalJointValue;
import perceptor.Vision;


public class SeekBall {
	
	GetNormalJointValue gNjV = new GetNormalJointValue();
	
	public String MoveHead(int cycle){
		
		float moveX=(float) (2.09*Math.sin(cycle/25));
		float moveY= (float) (0.59*Math.sin(cycle/8)-0.078);
		String str="";
		
		if(Vision.isiSee()==true){
			
			if(Ball.isSeeTheBall()==true){
			
				str="("+"he1"+" "+0.0f+")"+"("+"he2"+" "+0.0f+")";	
			
			}else{
				float realMoveX=gNjV.Get("he1", moveX)/2;
				float realMoveY=gNjV.Get("he2", moveY)/2;
				str="("+"he1"+" "+realMoveX+")"+"("+"he2"+" "+realMoveY+")";
			}
			
		}
		
		return str;
		
		
	}
	
}
