package action;

import localization.Landmark;
import localization.LocalizationResults;
import perceptor.HingeJointPerceptor;

public class WalkTo {
	
	public void Act(float X,float Y,float Theta){
		
		boolean iseegoal=false;
		float Distance1;
		float Distance2;
		float Angle1=0;
		float Angle2 = 0;
		float prefferedAngleKick=0;
		float prefferedAngleKickFromBody=0;
		
		for(int k=0;k<LocalizationResults.getLandmarks().size();k++){
			Landmark a=LocalizationResults.getLandmarks().elementAt(k);
			if(a.getName().equalsIgnoreCase("g1r")){
				iseegoal=true;
				Distance1=(float) a.getDistance();
				Angle1=(float) a.getHorizontal_Angle();
			}
			if(a.getName().equalsIgnoreCase("g2r")){
				iseegoal=true;
				Distance2=(float) a.getDistance();
				Angle2=(float) a.getHorizontal_Angle();
			}
		
		}
		
		if(iseegoal==true){
			prefferedAngleKick=(Angle1+Angle2)/2;
			System.out.println("----------prankick--------------------");
			System.out.println(prefferedAngleKick);
			System.out.println("-----------prformbody-------------------");
			prefferedAngleKickFromBody=prefferedAngleKick+HingeJointPerceptor.getHj1();
			System.out.println(prefferedAngleKickFromBody);
			System.out.println("-----------body-------------------");
			System.out.println(LocalizationResults.body_angle);
				
		}
		
	}

}
