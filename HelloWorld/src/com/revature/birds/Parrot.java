package com.revature.birds;

public class Parrot extends Domestic {

	public Parrot() {
		super();
		String className = this.getClass().getSimpleName();
		System.out.println(className);
	}

	@Override
	void Fly() {
		System.out.println("I believe it can fly");
	}

	public static void main(String[] args) {
		new Parrot();
	}

	@Override
	public void Eat() {
		super.Eat();
	}

	@Override
	public void Feathers() {
		System.out.println("Rainbow feathers");
	}

	@Override
	public void Eggs() {
		super.Eggs();
	}

}
