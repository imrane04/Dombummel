package com.dombummel;

public class Vector2 {
	public float x;
	public float y;

	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2() {
		this(0, 0);
	}

	public Vector2 add(Vector2 other) {
		return new Vector2(this.x + other.x, this.y + other.y);
	}

	public Vector2 sub(Vector2 other) {
		return new Vector2(this.x - other.x, this.y - other.y);
	}

	public Vector2 mul(float scalar) {
		return new Vector2(this.x * scalar, this.y * scalar);
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public Vector2 normalized() {
		float len = length();
		return len == 0 ? new Vector2(0, 0) : new Vector2(x / len, y / len);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
