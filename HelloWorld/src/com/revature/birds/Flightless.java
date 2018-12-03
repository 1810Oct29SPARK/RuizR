package com.revature.birds;

public abstract class Flightless implements Bird {

	public Flightless() {
		Eat();
		Feathers();
		Eggs();
		Move();
	}

	@Override
	public void Eat() {
		System.out.println("Fiss");

	}

	@Override
	public void Feathers() {
		System.out.println("Basic feathers");

	}

	@Override
	public void Eggs() {
		System.out.println("Your Eggs are lame and you should feel lame");
	}
	
	abstract void Move();

}
