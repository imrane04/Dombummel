package com.dombummel;

public class Vector4 {
	public float x, y, z, w;

	public Vector4(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public Vector4() {
		this(0, 0, 0, 0);
	}

	public Vector4 add(Vector4 other) {
		return new Vector4(x + other.x, y + other.y, z + other.z, w + other.w);
	}

	public Vector4 sub(Vector4 other) {
		return new Vector4(x - other.x, y - other.y, z - other.z, w - other.w);
	}

	public Vector4 mul(float scalar) {
		return new Vector4(x * scalar, y * scalar, z * scalar, w * scalar);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ", " + w + ")";
	}
}
