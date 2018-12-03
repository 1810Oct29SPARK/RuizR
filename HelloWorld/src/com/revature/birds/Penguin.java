package com.revature.birds;

public class Penguin extends Flightless {

	public Penguin() {
		super();
		String className = this.getClass().getSimpleName();
		System.out.println(className);
	}

	@Override
	void Move() {
		System.out.println("Swim");
	}

	public static void main(String[] args) {
		new Penguin();
	}

	@Override
	public void Eat() {
		super.Eat();
	}

	@Override
	public void Feathers() {
		System.out.println("Black and white tuxedo");
	}

	@Override
	public void Eggs() {
		System.out.println("Small eggs");
	}

}
