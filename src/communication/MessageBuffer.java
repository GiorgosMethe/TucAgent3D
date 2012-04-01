package communication;

import worldState.TeamState;


public class MessageBuffer {

	public static float[] DistancesBuffer =new float[8];


	@SuppressWarnings("static-access")
	public static void UpdateBuffer(HearMessage msg){



		for(int j=0;j<DistancesBuffer.length;j++){
			
			System.out.println("*********"+DistancesBuffer[j]);
			
		}

		if(!msg.getMsg().equalsIgnoreCase("")){
			String[] splittedMsg = msg.getMsg().split("%");
			if(splittedMsg[1].equalsIgnoreCase(TeamState.getTeamSide())){
				
				DistancesBuffer[Integer.parseInt(splittedMsg[2])]=Float.parseFloat(splittedMsg[3]);

			}
		}

	}


	public static float[] getDistancesBuffer() {
		return DistancesBuffer;
	}


	public static void setDistancesBuffer(float[] distancesBuffer) {
		DistancesBuffer = distancesBuffer;
	}




}
