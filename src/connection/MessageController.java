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
package connection;

import java.util.Vector;
import javax.vecmath.Vector3d;

import perceptor.Accelerometer;
import perceptor.Ball;
import perceptor.ForceResistancePerceptor;
import perceptor.GyroScope;
import perceptor.HingeJointPerceptor;
import perceptor.Vision;

import communication.HearMessage;
import communication.MessageBuffer;

import agent.Agent;
import agent.AgentType;
import localization.*;
import worldState.ServerTime;
import worldState.GameState;
import worldState.TeamState;

public class MessageController {
	Coordinate curloc=new Coordinate(0, 0);
	public MessageController() {

	}
	int k=0;
	@SuppressWarnings("static-access")
	public void GetPerceptors(Connection con) {

		Vector<String> message = con.GetVector();
		Vector<Landmark> landmarks = new Vector<Landmark>();
		Vector<Landmark> coplayers = new Vector<Landmark>();
		Vector<Landmark> rivals = new Vector<Landmark>();
		TriangleLocalization localizer = new TriangleLocalization();
		// print message from server

		boolean iSeeTheBall = false;
		boolean see = false;
		int i = 0;
		int j=0;

		do {

			// System.out.println("--"+message.elementAt(i));
			if (!message.elementAt(i).equalsIgnoreCase(null)) {

				if (message.elementAt(i).equalsIgnoreCase("time")) {

					ServerTime.setName(message.elementAt(i + 1).toString());
					float time = Float.parseFloat(message.elementAt(i + 2)
							.toString());
					ServerTime.setTime(time);
					// System.out.println("time @ "+i);
					i = i + 3;

				} else if (message.elementAt(i).equalsIgnoreCase("GS")) {

					if(message.elementAt(i+1).equalsIgnoreCase("t")){
						float time = Float.parseFloat(message.elementAt(i + 2).toString());
						GameState.setGameTime(time);
						GameState.setGameState(message.elementAt(i + 4).toString());
						// System.out.println("game state @ "+i);
						i = i + 5;
					}else if(message.elementAt(i+1).equalsIgnoreCase("unum")){
						int num=Integer.parseInt(message.elementAt(i+2));
						AgentType.setPlayerNum(num);
						TeamState.setTeamSide(message.elementAt(i+4));
						float time = Float.parseFloat(message.elementAt(i + 6).toString());
						GameState.setGameTime(time);
						GameState.setGameState(message.elementAt(i + 8).toString());
						i=i+9;
					}


				} else if (message.elementAt(i).equalsIgnoreCase("GYR")) {

					float anglex = Float.parseFloat(message.elementAt(i + 4)
							.toString());
					GyroScope.setAngleX(anglex);
					float angley = Float.parseFloat(message.elementAt(i + 5)
							.toString());
					GyroScope.setAngleY(angley);
					float anglez = Float.parseFloat(message.elementAt(i + 6)
							.toString());
					GyroScope.setAngleZ(anglez);
					// System.out.println("gyroscope @ "+i);
					i = i + 7;

				} else if (message.elementAt(i).equalsIgnoreCase("ACC")) {

					float accX = Float.parseFloat(message.elementAt(i + 4)
							.toString());
					Accelerometer.setAccX(accX);
					float accY = Float.parseFloat(message.elementAt(i + 5)
							.toString());
					Accelerometer.setAccX(accY);
					float accZ = Float.parseFloat(message.elementAt(i + 6)
							.toString());
					Accelerometer.setAccX(accZ);
					// System.out.println("accelerometer @ "+i);
					i = i + 7;

				} else if (message.elementAt(i).equalsIgnoreCase("UJ")) {

					// System.out.println("univ joint @ "+i);
					i = i + 1;

				} else if (message.elementAt(i).equalsIgnoreCase("TCH")) {

					// System.out.println("touch perceptor @ "+i);
					i = i + 1;

				} else if (message.elementAt(i).equalsIgnoreCase("HJ")) {
					float axis = 0;
					if (message.elementAt(i + 2).equalsIgnoreCase("hj1")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setHj1(axis);
					} else if (message.elementAt(i + 2).equalsIgnoreCase("hj2")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setHj2(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("laj1")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLaj1(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("laj2")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLaj2(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("laj3")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLaj3(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("laj4")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLaj4(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("llj1")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLlj1(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("llj2")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLlj2(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("llj3")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLlj3(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("llj4")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLlj4(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("llj5")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLlj5(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("llj6")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setLlj6(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("rlj1")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRlj1(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("rlj2")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRlj2(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("rlj3")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRlj3(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("rlj4")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRlj4(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("rlj5")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRlj5(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("rlj6")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRlj6(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("raj1")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRaj1(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("raj2")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRaj2(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("raj3")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRaj3(axis);
					} else if (message.elementAt(i + 2)
							.equalsIgnoreCase("raj4")) {
						axis = Float.parseFloat(message.elementAt(i + 4)
								.toString());
						HingeJointPerceptor.setRaj4(axis);
					}

					//System.out.println("hint joint @ " + axis);
					i = i + 5;

				} else if (message.elementAt(i).equalsIgnoreCase("hear")) {

					if(message.elementAt(i+2).equalsIgnoreCase("self")){
						i = i + 4;
					}else{
	
						System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
						HearMessage.setSelf(false);
						float direction = Float.parseFloat(message.elementAt(i+2));
						HearMessage.setDirection(direction);
						float time = Float.parseFloat(message.elementAt(i+1));
						HearMessage.setTime(time);
						String msg = message.elementAt(i+3);
						HearMessage.setMsg(msg);
						HearMessage Htemp = new HearMessage(time, direction, msg, false);
						MessageBuffer.UpdateBuffer(Htemp);
						i = i + 4;
					}

				} else if (message.elementAt(i).equalsIgnoreCase("See")) {
					j=i;
					j++;
					do{
						if(message.elementAt(j).equalsIgnoreCase("f1l")){
							Landmark lm=new Landmark("f1l", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;
						}else if(message.elementAt(j).equalsIgnoreCase("f2l")){
							Landmark lm=new Landmark("f2l", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;
						}else if(message.elementAt(j).equalsIgnoreCase("f1r")){
							Landmark lm=new Landmark("f1r", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;
						}else if(message.elementAt(j).equalsIgnoreCase("f2r")){
							Landmark lm=new Landmark("f2r", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;
						}else if(message.elementAt(j).equalsIgnoreCase("g1l")){
							Landmark lm=new Landmark("g1l", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;
						}else if(message.elementAt(j).equalsIgnoreCase("g2l")){
							Landmark lm=new Landmark("g2l", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;
						}else if(message.elementAt(j).equalsIgnoreCase("g1r")){
							Landmark lm=new Landmark("g1r", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;
						}
						else if(message.elementAt(j).equalsIgnoreCase("g2r")){
							Landmark lm=new Landmark("g2r", Float.parseFloat(message.elementAt(j+2).toString()),Float.parseFloat(message.elementAt(j+4).toString()), Float.parseFloat(message.elementAt(j+3).toString()));
							landmarks.add(lm);
							j=j+4;

						}
						else if(message.elementAt(j).equalsIgnoreCase("b")){

							iSeeTheBall = true;
							float distance = Float.parseFloat(message.elementAt(j + 2)
									.toString());
							Ball.setDistance(distance);
							float angleX = Float.parseFloat(message.elementAt(j + 3)
									.toString());
							Ball.setAngleX(angleX);
							float angleY = Float.parseFloat(message.elementAt(j + 4)
									.toString());
							Ball.setAngleY(angleY);
							// System.out.println("ball @ "+i);

							j=j+4;
						}else if(message.elementAt(j).equalsIgnoreCase("p")){
							j++;
							String team_name=null;
							String player_id=null;
							double player_distance=0;
							double player_horizontal_angle=0;
							double player_vertical_angle=0;
							j++;
							team_name=message.elementAt(j);
							j++; //message=id
							j++;
							player_id=message.elementAt(j);
							j++;
							int k=0;
							while(message.elementAt(j).equalsIgnoreCase("head")||message.elementAt(j).equalsIgnoreCase("rlowerarm")
									||message.elementAt(j).equalsIgnoreCase("llowerarm")||message.elementAt(j).equalsIgnoreCase("rfoot")
									||message.elementAt(j).equalsIgnoreCase("lfoot")){
								k++;
								j++; //message=pol
								j++;
								player_distance=player_distance+Float.parseFloat(message.elementAt(j));
								j++;
								player_horizontal_angle=player_horizontal_angle+Float.parseFloat(message.elementAt(j));
								j++;
								player_vertical_angle=player_horizontal_angle+Float.parseFloat(message.elementAt(j));
								j++;
							}
							j--;
							if(k!=0){
								player_distance=player_distance/k;
								player_horizontal_angle=player_horizontal_angle/k;
								player_vertical_angle=player_horizontal_angle;	
							}
							Landmark player=new Landmark(player_id, player_distance, player_vertical_angle, player_horizontal_angle);
							if(team_name.equalsIgnoreCase(Agent.Teamname)){
								if(!player.getName().equalsIgnoreCase(Agent.num+"")){
									coplayers.add(player);
								}
							}else{
								rivals.add(player);
							}





						}else{
							//System.out.println("WHAT THE FUCK!!!");
						}
						j++;

					}while (message.elementAt(j).equalsIgnoreCase("f1l")||message.elementAt(j).equalsIgnoreCase("f2l")||
							message.elementAt(j).equalsIgnoreCase("f2r")||message.elementAt(j).equalsIgnoreCase("f1r")||
							message.elementAt(j).equalsIgnoreCase("g1l")||message.elementAt(j).equalsIgnoreCase("g2l")||
							message.elementAt(j).equalsIgnoreCase("g1r")||message.elementAt(j).equalsIgnoreCase("g2r")||
							message.elementAt(j).equalsIgnoreCase("b")||message.elementAt(j).equalsIgnoreCase("p")
					);
					Coordinate loc_buffer=new Coordinate(0, 0);

					int k=0;
					double x=0;
					double y=0;
					for(int ii=0;ii<landmarks.size();ii++){
						for(int jj=ii+1;jj<landmarks.size();jj++){
							loc_buffer=localizer.Localize(landmarks.elementAt(ii),landmarks.elementAt(jj));
							x=x+loc_buffer.X;
							y=y+loc_buffer.Y;
							k++;
						}
					}
					if(x!=0 && y!=0){
						if(k!=0){
							curloc=new Coordinate(x/k, y/k);
						}
						else{
							curloc=new Coordinate(x, y);
						}
					}
					//System.out.println("I am  = ( "+curloc.getX()+" , "+ curloc.getY() +" )");

					///////////////////////////////////////////////////
					AgentPosition.setX((float) curloc.getX());
					AgentPosition.setY((float) curloc.getY());
					LocalizationResults.setCurrent_location(curloc);
					//////////////////////////////////////////////////

					int l=0;
					double angle_buffer=0;
					double angle=0;
					for (int ii=0;ii<landmarks.size();ii++){
						angle_buffer=localizer.universal_angle(landmarks.elementAt(ii), curloc);
						angle=angle+angle_buffer;
						l++;
						//System.out.println(" angle====="+angle);//+"\n landmark=="+landmarks.elementAt(ii).getName()+"\n distance=="+landmarks.elementAt(ii).getDistance()+"\n hor_angle=="+landmarks.elementAt(ii).getHorizontal_Angle());
					}
					double head_angle=0;
					if(angle!=0){
						if(l!=0){
							head_angle=angle/l;
						}else{
							head_angle=angle;
						}
					}

					////////////////////////////////////////////////////
					AgentPosition.setTheta((float) (head_angle+HingeJointPerceptor.getHj1()));
					////////////////////////////////////////////////////
					LocalizationResults.setHead_angle(head_angle);
					LocalizationResults.setBody_angle((head_angle-HingeJointPerceptor.getHj1()));

					//System.out.println("I look at "+head_angle+" degrees");
					//System.out.println("My body looks at " + (head_angle+HingeJointPerceptor.getHj1()));
					Coordinate Ball_det=localizer.get_det_with_distance_angle(curloc.getX(), curloc.getY(), (head_angle+Ball.getAngleX()), Ball.getDistance());
					LocalizationResults.setBall_location(Ball_det);
					LocalizationResults.setLandmarks(landmarks);
					LocalizationResults.setCoplayers(coplayers);
					LocalizationResults.setRivals(rivals);
					for(int jj=0;jj<coplayers.size();jj++){
						@SuppressWarnings("unused")
						Coordinate found_player=localizer.get_det_with_distance_angle(curloc.getX(),curloc.getY() , (head_angle+coplayers.elementAt(jj).getHorizontal_Angle()), coplayers.elementAt(jj).getDistance());
						//System.out.println("i see teammate with id ( "+ coplayers.elementAt(jj).getName()+" ) at distance ( "+coplayers.elementAt(jj).getDistance()+" ) at angle "+coplayers.elementAt(jj).getHorizontal_Angle());
						//System.out.println("and see him at ( "+found_player.getX()+" , "+found_player.getY()+" )");
					}
					if(coplayers.size()==0){
						//System.out.println("I see no teammates");
					}
					for(int jj=0;jj<rivals.size();jj++){
						@SuppressWarnings("unused")
						Coordinate found_player=localizer.get_det_with_distance_angle(curloc.getX(),curloc.getY() , (head_angle+rivals.elementAt(jj).getHorizontal_Angle()), rivals.elementAt(jj).getDistance());
						//System.out.println("i see rival with id ( "+ rivals.elementAt(jj).getName()+" ) at distance ( "+rivals.elementAt(jj).getDistance()+" ) at angle "+rivals.elementAt(jj).getHorizontal_Angle());
						//System.out.println("and see him at ( "+found_player.getX()+" , "+found_player.getY()+" )");
					}
					if(rivals.size()==0){
						//System.out.println("I see no rivals");
					}
					//System.out.println("I see ball at ( "+Ball_det.getX()+" , "+Ball_det.getY()+" ) at angle "+ Ball.getDistance());
					//System.out.println("-------------------------------------------------------------------------------------------");
					//coplayers.removeAllElements();
					//rivals.removeAllElements();
					//landmarks.removeAllElements();
					i=j;
					j=0;
					see=true;
					Vision.setiSee(see);
					// System.out.println("see perceptor @ "+i);
					//i = i + 1;

				} else if (message.elementAt(i).equalsIgnoreCase("FRP")) {

					ForceResistancePerceptor.setName(message.elementAt(i+2).toString());
					Vector3d forceOr= new Vector3d();
					Vector3d force= new Vector3d();
					forceOr.x=Float.parseFloat(message.elementAt(i+4).toString());
					forceOr.y=Float.parseFloat(message.elementAt(i+5).toString());
					forceOr.z=Float.parseFloat(message.elementAt(i+6).toString());
					force.x=Float.parseFloat(message.elementAt(i+8).toString());
					force.y=Float.parseFloat(message.elementAt(i+9).toString());
					force.z=Float.parseFloat(message.elementAt(i+10).toString());
					ForceResistancePerceptor.setForceOrigin(forceOr);
					ForceResistancePerceptor.setForce(force);
					//System.out.println("force res perce @ "+i);
					i = i + 11;

				} else {
					i++;
				}
			}

			if(i==message.size()){
				Vision.setiSee(see);
				Ball.setSeeTheBall(iSeeTheBall);
				message.removeAllElements();
				break;
			}

			//System.out.println("next is      "+message.elementAt(i));
		} while (i < message.size()+1);



	}

}