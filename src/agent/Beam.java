package agent;

public class Beam {

	public String Init(int number){

		String beam;
		String beamX = null;
		String beamY = null;
		String beamTheta = null;
		if(number==1){
			beamX="-11.0"; beamY="0.0"; beamTheta="0.0";
		}else if(number==2){
			beamX="-7.0"; beamY="-3.0"; beamTheta="0.0";
		}else if(number==3){
			 beamX="-7.0"; beamY="0.0"; beamTheta="0.0";
		}else if(number==4){
			beamX="-7.0"; beamY="3.0"; beamTheta="0.0";
		}else if(number==5){
			beamX="-3.0"; beamY="-3.0"; beamTheta="0.0";
		}else if(number==6){
			beamX="-3.0"; beamY="3.0"; beamTheta="0.0";
		}else if(number==7){
			beamX="-3.0"; beamY="0.0"; beamTheta="0.0";
		}else{
			
		}
		
		beam=beamX+" "+beamY+" "+beamTheta;

		return beam;
	}

}
