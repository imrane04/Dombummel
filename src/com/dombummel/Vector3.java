package com.dombummel;

public class Vector3 {
	public float x, y, z;

	public Vector3(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3() {
		this(0, 0, 0);
	}

	public Vector3 add(Vector3 other) {
		return new Vector3(x + other.x, y + other.y, z + other.z);
	}

	public Vector3 sub(Vector3 other) {
		return new Vector3(x - other.x, y - other.y, z - other.z);
	}

	public Vector3 mul(float scalar) {
		return new Vector3(x * scalar, y * scalar, z * scalar);
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public Vector3 normalized() {
		float len = length();
		return len == 0 ? new Vector3(0, 0, 0) : new Vector3(x / len, y / len, z / len);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
}
