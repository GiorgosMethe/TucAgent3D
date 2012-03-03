package action;

//import perceptor.Perceptors;
//import worldState.ServerTime;
import connection.Connection;
import connection.ServerCyrcles;

public class MotionHandler {

	private String Str;
	Connection con;

	private int endMotionPose;
	private int speedControl;
	private int speed; 
	private int poseOffset;
	//private float time;

	public MotionHandler(){


	}

	public String MotionFactory(String Motion, int Current){

		int pose=0;
		Str="";
		Motions dnc=new Motions();


		if (Motion.equalsIgnoreCase("Forwards50")){

			endMotionPose=170;
			speed=3;
			speedControl=10;
			poseOffset=2;

		}else if (Motion.equalsIgnoreCase("Forwards")){

			endMotionPose=66;
			speed=3;
			speedControl=10;
			poseOffset=2;

		}else if(Motion.equalsIgnoreCase("StopBehavior")){


			if(!MotionTimer.getCurrentMotionPlaying().equalsIgnoreCase("StopBehavior")){
				MotionTimer.setPoseEnding(true);
				Str=dnc.StopBehavior();	

			}else{
				Str="";
			}

			MotionTimer.setCurrentMotionPlaying("StopBehavior");


		}else{

			Str="";
		}


		if(Motion.equalsIgnoreCase("StopBehavior")){

		}else if(Motion.equalsIgnoreCase("")){
		
		}else{

			if(MotionTimer.getStartMotionCyrcles()==0){

				MotionTimer.setCurrentMotionPlaying(Motion);			
				MotionTimer.setStartMotionCyrcles(Current);			
				MotionTimer.setEndMotionCyrcles((endMotionPose*speed)+ServerCyrcles.getCyrclesNow());
				MotionTimer.setCurrentMotionCyrcles(Current);
				MotionTimer.setMotionPose(0);

			}else{

				MotionTimer.setCurrentMotionCyrcles(ServerCyrcles.getCyrclesNow());
			}
			
			if(Current<MotionTimer.getEndMotionCyrcles()) {

				if((Current-MotionTimer.getStartMotionCyrcles())%speed==0){

					int previousPose=MotionTimer.getMotionPose();
					pose=previousPose+poseOffset;


					if (pose > endMotionPose){
						MotionTimer.setPoseEnding(true);
						MotionTimer.setCurrentMotionPlaying("StopBehavior");			
						MotionTimer.setStartMotionCyrcles(0);			
						MotionTimer.setEndMotionCyrcles(0);
						MotionTimer.setCurrentMotionCyrcles(0);
						MotionTimer.setMotionPose(0);
						Str= "";
					}else{
						Str=dnc.Motion(Motion,pose,speedControl);
						MotionTimer.setMotionPose(pose);
					}

				}else{
					Str="";
				}

			}else{
				
				return "";
				
			}
		}
		
		return Str;
	}


}
