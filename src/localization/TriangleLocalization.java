package localization;

public class TriangleLocalization {



	public static Coordinate F1L_det= new Coordinate (-9,6);
	public static Coordinate F1R_det= new Coordinate (9,6);
	public static double F1L_distance;
	public static Coordinate F2L_det= new Coordinate (-9,-6);
	public static double F2L_distance;
	public static double F1R_distance;
	public static Coordinate F2R_det= new Coordinate (9,-6);
	public static double F2R_distance;
	public static Coordinate G1L_det= new Coordinate (-9,1);
	public static double G1L_distance;
	public static Coordinate G2L_det= new Coordinate (-9,-1);
	public static double G2L_distance;
	public static Coordinate G1R_det= new Coordinate (9,1);
	public static double G1R_distance;
	public static Coordinate G2R_det= new Coordinate (9,-1);
	public static double G2R_distance;

	public static Coordinate Localize (String mark1,String mark2,double mark1_distance, double mark2_distance){

		Coordinate Agent_Det=new Coordinate(200,200);
		if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("f2l"))||(mark1.equalsIgnoreCase("f2l") && mark2.equalsIgnoreCase("f1l"))){
			Agent_Det=trilateration(F1L_det.getX(), F1L_det.getY(), F2L_det.getX(),F2L_det.getY(), F1L_distance, F2L_distance);
		}else if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("f1r"))||(mark1.equalsIgnoreCase("f1r") && mark2.equalsIgnoreCase("f1l"))){
			Agent_Det=trilateration(F1L_det.getX(), F1L_det.getY(), F1R_det.getX(),F1R_det.getY(), mark1_distance, mark2_distance);
			
			
			
		}else if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("f2r"))||(mark1.equalsIgnoreCase("f2r") && mark2.equalsIgnoreCase("f1l"))){
			Agent_Det=trilateration(F1L_det.getX(), F1L_det.getY(), F2R_det.getX(),F2R_det.getY(), F1L_distance, F2R_distance);
		}else if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("g1l"))||(mark1.equalsIgnoreCase("g1l") && mark2.equalsIgnoreCase("f1l"))){
			Agent_Det=trilateration(F1L_det.getX(), F1L_det.getY(), G1L_det.getX(),G1L_det.getY(), F1L_distance, G1L_distance);
		}else if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("g2l"))||(mark1.equalsIgnoreCase("g2l") && mark2.equalsIgnoreCase("f1l"))){
			Agent_Det=trilateration(F1L_det.getX(), F1L_det.getY(), G2L_det.getX(),G2L_det.getY(), F1L_distance, G2L_distance);
		}else if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("g1r"))||(mark1.equalsIgnoreCase("g1r") && mark2.equalsIgnoreCase("f1l"))){
			Agent_Det=trilateration(F1L_det.getX(), F1L_det.getY(), G1R_det.getX(),G1R_det.getY(), F1L_distance, G1R_distance);
		}else if ((mark1.equalsIgnoreCase("f1l") && mark2.equalsIgnoreCase("g2r"))||(mark1.equalsIgnoreCase("g2r") && mark2.equalsIgnoreCase("f1l"))){
			Agent_Det=trilateration(F1L_det.getX(), F1L_det.getY(), G2R_det.getX(),G2R_det.getY(), F1L_distance, G2R_distance);
		}


		else if ((mark1.equalsIgnoreCase("f2l") && mark2.equalsIgnoreCase("f1r"))||(mark1.equalsIgnoreCase("f1r") && mark2.equalsIgnoreCase("f2l"))){
			Agent_Det=trilateration(F1R_det.getX(), F1R_det.getY(), F2L_det.getX(),F2L_det.getY(), F1R_distance, F2L_distance);
		}else if ((mark1.equalsIgnoreCase("f2l") && mark2.equalsIgnoreCase("f2r"))||(mark1.equalsIgnoreCase("f2r") && mark2.equalsIgnoreCase("f2l"))){
			Agent_Det=trilateration(F2R_det.getX(), F2R_det.getY(), F2L_det.getX(),F2L_det.getY(), F2R_distance, F2L_distance);
		}else if ((mark1.equalsIgnoreCase("f2l") && mark2.equalsIgnoreCase("g1l"))||(mark1.equalsIgnoreCase("g1l") && mark2.equalsIgnoreCase("f2l"))){
			Agent_Det=trilateration(G1L_det.getX(), G1L_det.getY(), F2L_det.getX(),F2L_det.getY(), G1L_distance, F2L_distance);
		}else if ((mark1.equalsIgnoreCase("f2l") && mark2.equalsIgnoreCase("g2l"))||(mark1.equalsIgnoreCase("g2l") && mark2.equalsIgnoreCase("f2l"))){
			Agent_Det=trilateration(G2L_det.getX(), G2L_det.getY(), F2L_det.getX(),F2L_det.getY(), G2L_distance, F2L_distance);
		}else if ((mark1.equalsIgnoreCase("f2l") && mark2.equalsIgnoreCase("g1r"))||(mark1.equalsIgnoreCase("g1r") && mark2.equalsIgnoreCase("f2l"))){
			Agent_Det=trilateration(G1R_det.getX(), G1R_det.getY(), F2L_det.getX(),F2L_det.getY(), G1R_distance, F2L_distance);
		}else if ((mark1.equalsIgnoreCase("f2l") && mark2.equalsIgnoreCase("g2r"))||(mark1.equalsIgnoreCase("g2r") && mark2.equalsIgnoreCase("f2l"))){
			Agent_Det=trilateration(G2R_det.getX(), G2R_det.getY(), F2L_det.getX(),F2L_det.getY(), G2R_distance, F2L_distance);
		}


		else if ((mark1.equalsIgnoreCase("f1r") && mark2.equalsIgnoreCase("f2r"))||(mark1.equalsIgnoreCase("f2r") && mark2.equalsIgnoreCase("f1r"))){
			Agent_Det=trilateration(F1R_det.getX(), F1R_det.getY(), F2R_det.getX(),F2R_det.getY(), F1R_distance, F2R_distance);
		}else if ((mark1.equalsIgnoreCase("f1r") && mark2.equalsIgnoreCase("g1l"))||(mark1.equalsIgnoreCase("g1l") && mark2.equalsIgnoreCase("f1r"))){
			Agent_Det=trilateration(F1R_det.getX(), F1R_det.getY(), G1L_det.getX(),G1L_det.getY(), F1R_distance, G1L_distance);
		}else if ((mark1.equalsIgnoreCase("f1r") && mark2.equalsIgnoreCase("g2l"))||(mark1.equalsIgnoreCase("g2l") && mark2.equalsIgnoreCase("f1r"))){
			Agent_Det=trilateration(F1R_det.getX(), F1R_det.getY(), G2L_det.getX(),G2L_det.getY(), F1R_distance, G2L_distance);
		}else if ((mark1.equalsIgnoreCase("f1r") && mark2.equalsIgnoreCase("g1r"))||(mark1.equalsIgnoreCase("g1r") && mark2.equalsIgnoreCase("f1r"))){
			Agent_Det=trilateration(F1R_det.getX(), F1R_det.getY(), G1R_det.getX(),G1R_det.getY(), F1R_distance, G1R_distance);
		}else if ((mark1.equalsIgnoreCase("f1r") && mark2.equalsIgnoreCase("g2r"))||(mark1.equalsIgnoreCase("g2r") && mark2.equalsIgnoreCase("f1r"))){
			Agent_Det=trilateration(F1R_det.getX(), F1R_det.getY(), G2R_det.getX(),G2R_det.getY(), F1R_distance, G2R_distance);
		}




		else if ((mark1.equalsIgnoreCase("f2r") && mark2.equalsIgnoreCase("g1l"))||(mark1.equalsIgnoreCase("g1l") && mark2.equalsIgnoreCase("f2r"))){
			Agent_Det=trilateration(G1L_det.getX(), G1L_det.getY(), F2R_det.getX(),F2R_det.getY(), G1L_distance, F2R_distance);
		}else if ((mark1.equalsIgnoreCase("f2r") && mark2.equalsIgnoreCase("g2l"))||(mark1.equalsIgnoreCase("g2l") && mark2.equalsIgnoreCase("f2r"))){
			Agent_Det=trilateration(G2L_det.getX(), G2L_det.getY(), F2R_det.getX(),F2R_det.getY(), G2L_distance, F2R_distance);
		}else if ((mark1.equalsIgnoreCase("f2r") && mark2.equalsIgnoreCase("g1r"))||(mark1.equalsIgnoreCase("g1r") && mark2.equalsIgnoreCase("f2r"))){
			Agent_Det=trilateration(G1R_det.getX(), G1R_det.getY(), F2R_det.getX(),F2R_det.getY(), G1R_distance, F2R_distance);
		}else if ((mark1.equalsIgnoreCase("f2r") && mark2.equalsIgnoreCase("g2r"))||(mark1.equalsIgnoreCase("g2r") && mark2.equalsIgnoreCase("f2r"))){
			Agent_Det=trilateration(G2R_det.getX(), G2R_det.getY(), F2R_det.getX(),F2R_det.getY(), G2R_distance, F2R_distance);
		}
		
		
		
		
		else if ((mark1.equalsIgnoreCase("g1l") && mark2.equalsIgnoreCase("g2l"))||(mark1.equalsIgnoreCase("g2l") && mark2.equalsIgnoreCase("g1l"))){
			Agent_Det=trilateration(G1L_det.getX(), G1L_det.getY(), G2L_det.getX(),G2L_det.getY(), G1L_distance, G2L_distance);
		}else if ((mark1.equalsIgnoreCase("g1l") && mark2.equalsIgnoreCase("g1r"))||(mark1.equalsIgnoreCase("g1r") && mark2.equalsIgnoreCase("g1l"))){
			Agent_Det=trilateration(G1L_det.getX(), G1L_det.getY(), G1R_det.getX(),G1R_det.getY(), G1L_distance, G1R_distance);
		}else if ((mark1.equalsIgnoreCase("g1l") && mark2.equalsIgnoreCase("g2r"))||(mark1.equalsIgnoreCase("g2r") && mark2.equalsIgnoreCase("g1l"))){
			Agent_Det=trilateration(G1L_det.getX(), G1L_det.getY(), G2R_det.getX(),G2R_det.getY(), G1L_distance, G2R_distance);
		}
		
		
		else if ((mark1.equalsIgnoreCase("g1r") && mark2.equalsIgnoreCase("g2l"))||(mark1.equalsIgnoreCase("g2l") && mark2.equalsIgnoreCase("g1r"))){
			Agent_Det=trilateration(G1R_det.getX(), G1R_det.getY(), G2L_det.getX(),G2L_det.getY(), G1R_distance, G2L_distance);
		}else if ((mark1.equalsIgnoreCase("g1r") && mark2.equalsIgnoreCase("g2r"))||(mark1.equalsIgnoreCase("g2r") && mark2.equalsIgnoreCase("g1r"))){
			Agent_Det=trilateration(G1R_det.getX(), G1R_det.getY(), G2R_det.getX(),G2R_det.getY(), G1R_distance, G2R_distance);
		}
	

			return Agent_Det;
		}	









		public static Coordinate trilateration (double ax, double ay, double bx, double by, double d1, double d2)
		{
			//vriskei tis suntetagmenes an kserei tis apostaseis apo 2 marks
			//mark1 (ax,ay)
			//mark2 (bx,by)
			//distance from mark1=d1
			//distance from mark2=d2

			double D= Math.sqrt((Math.pow((ax-bx),2))+Math.pow((ay-by),2));
			double S= (Math.pow(D, 2)+Math.pow(d1, 2)-Math.pow(d2, 2))/(2*D);
			double cx=ax+(bx-ax)*S/D;
			double cy=ay+(by-ay)*S/D;
			double u=Math.sqrt((Math.pow(d1, 2)-Math.pow(S, 2)));
			double x= cx - (by-ay)*u/D;
			double y= cy + (bx-ax)*u/D;
			if(x>9||x<-9||y>6||x<-6){
				x= cx + (by-ay)*u/D;
				y= cy - (bx-ax)*u/D;
			}
			//System.out.println("poition at  ( "+x+" , "+y+" )");
			Coordinate Det =new Coordinate(x, y);
			return Det; 
		}

		public static double universal__head_angle (double ax, double ay, double x, double y, double f, double d){
			//briskei tin gonia tou kefaliou se sxesi me ton aksona X tou gipedou
			//mark (ax,ay)
			//agent (x,y)
			//head angle from mark f
			//distance from mark d
			double univer_angle=400;
			double angle_y =Math.sin((Math.abs(ax-x))/d); /////prepei na dw poio einai to x k poio to y sto gipedo
			if(f>0){ ////an to kefali koitaei aristera apo tin simaia
				univer_angle=angle_y+f;
			}
			else if(f<0){ //// an to kefali koitaei deksia apo tin simaia
				univer_angle=angle_y-f;
			}
			else{
				univer_angle=angle_y-f;}
			return univer_angle;

		}

		public static Coordinate get_det_with_distance_angle (double ax, double ay, double f, double d){
			//briskei tis suntetagmenes enos antikeimenou pou vriskete se apostasi D upo gonia f (APO TON AKSONA X TOU GIPEDOU, oxi gonia kefaliou)
			//det agent (x,y)
			//D-> apostasi
			//F-> gonia
			double x=ax+d*Math.cos(f);
			double y=ay+d*Math.sin(f);
			Coordinate Det =new Coordinate(x, y);
			return Det; 
		}

	}