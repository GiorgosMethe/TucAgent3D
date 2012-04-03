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
package localization;

import java.util.Vector;

public class LocalizationResults {
	public LocalizationResults() {
		// TODO Auto-generated constructor stub
	}
	public static Coordinate current_location,ball_location;
	public static Coordinate getBall_location() {
		return ball_location;
	}
	public static void setBall_location(Coordinate ball_location) {
		LocalizationResults.ball_location = ball_location;
	}
	public static double head_angle,body_angle;
	public static Vector<Landmark> landmarks = new Vector<Landmark>();
	public static Vector<Landmark> coplayers = new Vector<Landmark>();
	public static Vector<Landmark> rivals = new Vector<Landmark>();
	public static Coordinate getCurrent_location() {
		return current_location;
	}
	public static void setCurrent_location(Coordinate current_location) {
		LocalizationResults.current_location = current_location;
	}
	public static double getHead_angle() {
		return head_angle;
	}
	public static void setHead_angle(double head_angle) {
		LocalizationResults.head_angle = head_angle;
	}
	public static double getBody_angle() {
		return body_angle;
	}
	public static void setBody_angle(double body_angle) {
		LocalizationResults.body_angle = body_angle;
	}
	public static Vector<Landmark> getLandmarks() {
		return landmarks;
	}
	public static void setLandmarks(Vector<Landmark> landmarks) {
		LocalizationResults.landmarks = landmarks;
	}
	public static Vector<Landmark> getCoplayers() {
		return coplayers;
	}
	public static void setCoplayers(Vector<Landmark> coplayers) {
		LocalizationResults.coplayers = coplayers;
	}
	public static Vector<Landmark> getRivals() {
		return rivals;
	}
	public static void setRivals(Vector<Landmark> rivals) {
		LocalizationResults.rivals = rivals;
	}
}