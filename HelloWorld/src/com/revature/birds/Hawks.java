package com.revature.birds;

public class Hawks extends BirdsofPrey {

	public Hawks() {
		super();
		String className = this.getClass().getSimpleName();
		System.out.println(className);
	}

	@Override
	void Fly() {
		System.out.println("Not Floating Flying");

	}

	public static void main(String[] args) {
		new Hawks();
	}

	@Override
	public void Eat() {
		super.Eat();
	}

	@Override
	public void Feathers() {
		System.out.println("Grey");
	}

	@Override
	public void Eggs() {
		super.Eggs();
	}

}
