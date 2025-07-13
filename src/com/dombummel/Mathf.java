package com.dombummel;

public class Mathf {

	public static double sin(double radians) {
		return Math.sin(radians);
	}

	public static double cos(double radians) {
		return Math.cos(radians);
	}

	public static double tan(double radians) {
		return Math.tan(radians);
	}

	public static double toRadians(double degrees) {
		return Math.toRadians(degrees);
	}

	public static double toDegrees(double radians) {
		return Math.toDegrees(radians);
	}

	public static double sqrt(double value) {
		return Math.sqrt(value);
	}

	public static double pow(double base, double exp) {
		return Math.pow(base, exp);
	}

	public static double clamp(double val, double min, double max) {
		return Math.max(min, Math.min(max, val));
	}

	public static double lerp(double a, double b, double t) {
		return a + (b - a) * t;
	}

	public static double distance(double x1, double y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		return Math.sqrt(dx * dx + dy * dy);
	}
}
