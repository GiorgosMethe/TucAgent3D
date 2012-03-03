package perceptor;

import java.util.Vector;

import javax.vecmath.Vector3d;

import localization.Landmark;

//import org.apache.commons.math.geometry.Vector3D;

//import org.apache.commons.math.geometry.Vector3D;
import connection.Connection;
import worldState.ServerTime;
import worldState.GameState;

public class Perceptors {

	public Perceptors() {

	}
	int k=0;
	public void GetPerceptors(Connection con) {

		Vector<String> message = con.GetVector();
		Vector<Landmark> landmarks = new Vector<Landmark>();
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

					float time = Float.parseFloat(message.elementAt(i + 2)
							.toString());
					GameState.setGameTime(time);
					GameState.setGameState(message.elementAt(i + 4).toString());
					// System.out.println("game state @ "+i);
					i = i + 5;

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

					// System.out.println("hear perceptor @ "+i);
					i = i + 1;

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
						}else{
							System.out.println("WHAT THE FUCK!!!");
						}
						j++;
						//System.out.println("aaaaaaaaaaaa    "+message.elementAt(j));
					}while (message.elementAt(j).equalsIgnoreCase("f1l")||message.elementAt(j).equalsIgnoreCase("f2l")||
							message.elementAt(j).equalsIgnoreCase("f2r")||message.elementAt(j).equalsIgnoreCase("f1r")||
							message.elementAt(j).equalsIgnoreCase("g1l")||message.elementAt(j).equalsIgnoreCase("g2l")||
							message.elementAt(j).equalsIgnoreCase("g1r")||message.elementAt(j).equalsIgnoreCase("g2r")
							||message.elementAt(j).equalsIgnoreCase("b")
							//||message.elementAt(j).equalsIgnoreCase("p")
							);
					System.out.println(landmarks.size());
					for(int jj=0;jj<landmarks.size();jj++){
						System.out.println("Saw landmark "+landmarks.elementAt(jj).getName());
					}
					k++;
					System.out.println(k);
					if(k>=50){
						if(k==50){
							System.out.println(k);
							System.out.println(k);
							System.out.println(k);
						}
					}

					//Coordinate curloc=localizer.Localize(landmarks.elementAt(0).getName(),landmarks.elementAt(1).getName(),landmarks.elementAt(0).getDistance(),landmarks.elementAt(1).getDistance());
					//System.out.println("I am  = ( "+curloc.getX()+" , "+ curloc.getY() +" )");
					landmarks.removeAllElements();
					System.out.println("j einai "+j);
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
