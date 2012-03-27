package action;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

//import connection.Connection;
import perceptor.GetNormalJointValue;

public class Motions {

	private int motionOffsetValues;

	public String Motion(String motionName, int i, int SpeedControl) {


		String msg = "";
		Vector<String> MotionVector = new Vector<String>();
		MotionVector = readMotion(motionName);

		GetNormalJointValue gNjV = new GetNormalJointValue();

		String MotionPoseSplit="";
		
		if(MotionVector.elementAt(0).equalsIgnoreCase("#WEBOTS_MOTION,V1.0")){
			MotionPoseSplit=",";
			motionOffsetValues=2;
		}else{
			MotionPoseSplit="%";
			motionOffsetValues=1;
		}
		
		String[] joint = MotionVector.elementAt(1).split(MotionPoseSplit);
		String[] value = MotionVector.elementAt(i+1).split(MotionPoseSplit);
		
		for (int x = 0; x < joint.length; x++) {

			String jointReal="";
			if(joint[x].equalsIgnoreCase("LHipYawPitch")){
				jointReal="lle1";
			}else if(joint[x].equalsIgnoreCase("LHipRoll")){
				jointReal="lle2";
			}else if(joint[x].equalsIgnoreCase("LHipPitch")){
				jointReal="lle3";
			}else if(joint[x].equalsIgnoreCase("LKneePitch")){
				jointReal="lle4";
			}else if(joint[x].equalsIgnoreCase("LAnklePitch")){
				jointReal="lle5";
			}else if(joint[x].equalsIgnoreCase("LAnkleRoll")){
				jointReal="lle6";
			}else if(joint[x].equalsIgnoreCase("RHipYawPitch")){
				jointReal="rle1";
			}else if(joint[x].equalsIgnoreCase("RHipRoll")){
				jointReal="rle2";
			}else if(joint[x].equalsIgnoreCase("RHipPitch")){
				jointReal="rle3";
			}else if(joint[x].equalsIgnoreCase("RKneePitch")){
				jointReal="rle4";
			}else if(joint[x].equalsIgnoreCase("RAnklePitch")){
				jointReal="rle5";
			}else if(joint[x].equalsIgnoreCase("RAnkleRoll")){
				jointReal="rle6";
			}else if(joint[x].equalsIgnoreCase("HeadYaw")){
				jointReal="he1";
			}else if(joint[x].equalsIgnoreCase("HeadPitch")){
				jointReal="he2";
			}else if(joint[x].equalsIgnoreCase("LShoulderPitch")){
				jointReal="lae1";
			}else if(joint[x].equalsIgnoreCase("LShoulderRoll")){
				jointReal="lae2";
			}else if(joint[x].equalsIgnoreCase("LElbowYaw")){
				jointReal="lae3";
			}else if(joint[x].equalsIgnoreCase("LElbowRoll")){
				jointReal="lae4";
			}else if(joint[x].equalsIgnoreCase("RShoulderPitch")){
				jointReal="rae1";
			}else if(joint[x].equalsIgnoreCase("RShoulderRoll")){
				jointReal="rae2";
			}else if(joint[x].equalsIgnoreCase("RElbowYaw")){
				jointReal="rae3";
			}else if(joint[x].equalsIgnoreCase("RElbowRoll")){
				jointReal="rae4";
			}
			
			
			
			float a=(float) (Float.valueOf(value[x+motionOffsetValues].trim()));
			float a1=gNjV.Get(jointReal, a);

			float a2 = (float) (a1/SpeedControl);

			String str = Float.toString(a2);

			msg += "(" + jointReal + " "+str+ ")";
			

		}

		return msg;
	}

	public Vector<String> readMotion(String motionName) {

		String MotionFilepath;
		Vector<String> MotionVector = new Vector<String>();


		if (motionName.equalsIgnoreCase("Forwards50")){

			MotionFilepath="motions/Forwards50.motion";

		}else if (motionName.equalsIgnoreCase("Forwards")){

			MotionFilepath="motions/Forwards.motion";

		}else if (motionName.equalsIgnoreCase("Backwards")){

			MotionFilepath="motions/Backwards.motion";

		}else if (motionName.equalsIgnoreCase("HandWave")){

			MotionFilepath="motions/HandWave.motion";

		}else if (motionName.equalsIgnoreCase("Shoot")){

			MotionFilepath="motions/Shoot.motion";

		}else if (motionName.equalsIgnoreCase("SideStepLeft")){

			MotionFilepath="motions/SideStepLeft.motion";

		}else if (motionName.equalsIgnoreCase("SideStepRight")){

			MotionFilepath="motions/SideStepRight.motion";

		}else if (motionName.equalsIgnoreCase("StandUpFromFront")){

			MotionFilepath="motions/StandUpFromFront.motion";

		}else if (motionName.equalsIgnoreCase("TurnLeft40")){

			MotionFilepath="motions/TurnLeft40.motion";

		}else if (motionName.equalsIgnoreCase("TurnLeft60")){

			MotionFilepath="motions/TurnLeft60.motion";

		}else if (motionName.equalsIgnoreCase("TurnLeft180")){

			MotionFilepath="motions/TurnLeft180.motion";

		}else if (motionName.equalsIgnoreCase("TurnRight40")){

			MotionFilepath="motions/TurnRight40.motion";

		}else if (motionName.equalsIgnoreCase("TurnRight60")){

			MotionFilepath="motions/TurnRight60.motion";

		}else if (motionName.equalsIgnoreCase("Init")){

			MotionFilepath="motions/Init.motion";
			
		}else if (motionName.equalsIgnoreCase("KickForwardRight")){

			MotionFilepath="motions/KickForwardRight.motion";
		
		}else if (motionName.equalsIgnoreCase("leftFall")){

			MotionFilepath="motions/leftFall.motion";
			
		}else if (motionName.equalsIgnoreCase("Aerobic")){

			MotionFilepath="motions/Aerobic.motion";
			
		}else if (motionName.equalsIgnoreCase("AldebaranFront")){

			MotionFilepath="motions/AldebaranFront.motion";
			
		}else if (motionName.equalsIgnoreCase("Forwards100")){

			MotionFilepath="motions/Forwards100.motion";
			
		}else if (motionName.equalsIgnoreCase("KickSideRight")){

			MotionFilepath="motions/KickSideRight.motion";
			
		}else{

			MotionFilepath="";
		}


		
		try{
			
			// Open the file that is the first 
			// command line parameter
			FileInputStream fstream = new FileInputStream(MotionFilepath);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				//System.out.println (strLine);
				MotionVector.add(strLine);
			}
			//Close the input stream
			in.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

		return MotionVector;

	}
	
	public String StopBehavior(){
		
		
		String str="(he1 0)(he2 0)(lae4 0)(rae4 0)(lae3 0)(rae3 0)(lae2 0)(rae2 0)(lae1 0)(rae1 0)(rle1 0)(rle2 0)(rle3 0)(rle4 0)(rle5 0)(rle6 0)(lle1 0)(lle2 0)(lle3 0)(lle4 0)(lle5 0)(lle6 0)";
		return str;
		
	}

}