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
package perceptor;

public class GetNormalJointValue {

	float alrValue;
	float chnValue = 0;
	float ValueToDeg = 0;

	public float Get(String name, float value) {

		if (name.equalsIgnoreCase("he1")) {

			alrValue = HingeJointPerceptor.getHj1();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("he2")) {

			alrValue = HingeJointPerceptor.getHj2();
			ValueToDeg =(float) (Math.toDegrees(value));  //done
			

		} else if (name.equalsIgnoreCase("lae1")) {

			alrValue = HingeJointPerceptor.getLaj1();
			ValueToDeg = (float) -Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("lae2")) {

			alrValue = HingeJointPerceptor.getLaj2();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("lae3")) {

			alrValue = HingeJointPerceptor.getLaj3();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("lae4")) {

			alrValue = HingeJointPerceptor.getLaj4();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("lle1")) {

			alrValue = HingeJointPerceptor.getLlj1();
			if(value>0){
				ValueToDeg = (float) (Math.toDegrees(value)/42);
			}else if(value<0){
				ValueToDeg = (float) (Math.toDegrees(value)*1.36);
			}else{
				ValueToDeg = (float) (Math.toDegrees(value));
			}
			

		} else if (name.equalsIgnoreCase("lle2")) {

			alrValue = HingeJointPerceptor.getLlj2();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("lle3")) {

			alrValue = HingeJointPerceptor.getLlj3();
			ValueToDeg = (float) (-Math.toDegrees(value)); //done 2

		} else if (name.equalsIgnoreCase("lle4")) {

			alrValue = HingeJointPerceptor.getLlj4();
			ValueToDeg = (float) (-Math.toDegrees(value)); //done 2

		} else if (name.equalsIgnoreCase("lle5")) {

			alrValue = HingeJointPerceptor.getLlj5();
			ValueToDeg = (float) (-Math.toDegrees(value)); //done 2

		} else if (name.equalsIgnoreCase("lle6")) {

			alrValue = HingeJointPerceptor.getLlj6();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("rle1")) {

			alrValue = HingeJointPerceptor.getRlj1(); //done 2
			if(value>0){
				ValueToDeg = (float) (Math.toDegrees(value)/42);
			}else if(value<0){
				ValueToDeg = (float) (Math.toDegrees(value)*1.36);
			}else{
				ValueToDeg = (float) (Math.toDegrees(value));
			}

		} else if (name.equalsIgnoreCase("rle2")) {

			alrValue = HingeJointPerceptor.getRlj2();
			ValueToDeg = (float) Math.toDegrees(value); //done 

		} else if (name.equalsIgnoreCase("rle3")) {

			alrValue = HingeJointPerceptor.getRlj3();
			ValueToDeg = (float) (-Math.toDegrees(value)); //done 2

		} else if (name.equalsIgnoreCase("rle4")) {

			alrValue = HingeJointPerceptor.getRlj4();
			ValueToDeg = (float) (-Math.toDegrees(value)); //done 2

		} else if (name.equalsIgnoreCase("rle5")) {

			alrValue = HingeJointPerceptor.getRlj5();
			ValueToDeg = (float) (-Math.toDegrees(value)); //done 2

		} else if (name.equalsIgnoreCase("rle6")) {

			alrValue = HingeJointPerceptor.getRlj6();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("rae1")) {

			alrValue = HingeJointPerceptor.getRaj1();
			ValueToDeg = (float) -Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("rae2")) {

			alrValue = HingeJointPerceptor.getRaj2();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("rae3")) {

			alrValue = HingeJointPerceptor.getRaj3();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		} else if (name.equalsIgnoreCase("rae4")) {

			alrValue = HingeJointPerceptor.getRaj4();
			ValueToDeg = (float) Math.toDegrees(value);  //done

		}


		chnValue = ValueToDeg-alrValue;
		if (Math.abs(chnValue)<0.01){
			return (float) 0.0;
		}else{
			return (float) chnValue;
		}
		
	}

}
