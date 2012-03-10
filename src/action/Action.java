/*package action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

//import connection.Connection;
import perceptor.GetNormalJointValue;

public class Action {

	public String Motion(String motionName, int i) {

		// String java.lang.Integer.toHexstring( int )

		String msg = "";
		Vector<String> MotionVector = new Vector<String>();
		MotionVector = readMotion(motionName);

		GetNormalJointValue gNjV = new GetNormalJointValue();

		String[] joint = MotionVector.elementAt(0).split(",");
		String[] value = MotionVector.elementAt(i).split(",");


		for (int x = 0; x < joint.length; x++) {

			float a=Float.valueOf(value[x+2].trim());
			float a1=gNjV.Get(joint[x], a);

			float a2 = (float) (a1/10);

			String str = Float.toString(a2);

			msg += "(" + joint[x] + " "+str+ ")";
			System.out.println(msg);

		}

		return msg;
	}

	public Vector<String> readMotion(String motionName) {

		String MotionFilepath;
		Vector<String> MotionVector = new Vector<String>();


		if (motionName.equalsIgnoreCase("walk")){

			MotionFilepath="motions/Forwards50.motion";


		}else{

			MotionFilepath="";

		}


		File file = new File(MotionFilepath);
		StringBuffer contents = new StringBuffer();
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;

			// repeat until all lines is read
			while ((text = reader.readLine()) != null) {
				MotionVector.add(reader.readLine());
				// System.out.println(reader.readLine());
				contents.append(text).append(
						System.getProperty("line.separator"));

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// show file contents here
		return MotionVector;

		

		}
	
}
*/