package action;
import connection.Connection;


public class MotionHandler {

	private String Str;
	Connection con;

	private int endMotionPose;
	private int speedControl;
	private int speed; 
	private int poseOffset;

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
			poseOffset=1;

		}else if (Motion.equalsIgnoreCase("Forwards")){

			endMotionPose=66;
			speed=3;
			speedControl=10;
			poseOffset=1;
		}else if (Motion.equalsIgnoreCase("KickForwardRight")){

			endMotionPose=61;
			speed=2;
			speedControl=10;
			poseOffset=1;

		}else{

			return "";
		}


		//there is no any motion in progress
		if(CurrentMotion.getCurrentMotionPlaying().equalsIgnoreCase("")){
			System.out.println("there is no any motion in progress");
			CurrentMotion.setCurrentMotionPlaying(Motion);
			return "";

		}else if(CurrentMotion.getCurrentMotionPlaying().equalsIgnoreCase(Motion)){
			System.out.println("play the same");
			if((Current-CurrentMotion.getStartMotionCyrcles())%speed==0){
				int previousPose=CurrentMotion.getMotionPose();
				pose=previousPose+poseOffset;
				System.out.println("current pose playing:"+pose);
				CurrentMotion.setMotionPose(pose);

				if (pose >= endMotionPose){
					CurrentMotion.setPoseEnding(true);		
					CurrentMotion.setStartMotionCyrcles(0);			
					CurrentMotion.setEndMotionCyrcles(0);
					CurrentMotion.setCurrentMotionCyrcles(0);
					CurrentMotion.setMotionPose(0);
					MotionTrigger.setMotion("");
					return dnc.StopBehavior();

				}else{
					CurrentMotion.setMotionPose(pose);
					return dnc.Motion(Motion,pose,speedControl);
				}


			}




		}else{
			System.out.println("move change");
			if(CurrentMotion.getInitCyrcles()<10){

				int nextInit=CurrentMotion.getInitCyrcles()+1;
				CurrentMotion.setInitCyrcles(nextInit);
				System.out.println("init playing pose:"+CurrentMotion.getInitCyrcles());
				return "";


			}else{

				CurrentMotion.setInitCyrcles(0);
				CurrentMotion.setCurrentMotionPlaying(Motion);
				CurrentMotion.setStartMotionCyrcles(Current);

				return "";
			}




		}
		return Str;


	}


}