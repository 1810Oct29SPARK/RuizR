package com.revature.birds;

public abstract class BirdsofPrey implements Bird {

	public BirdsofPrey() {
		
	}

	@Override
	public void Eat() {
		System.out.println("Meats");
	}

	@Override
	public void Feathers() {
		System.out.println("Basic feathers");
	}

	@Override
	public void Eggs() {
		System.out.println("Your Eggs are lame and you should feel lame");
	}
	
	abstract void Fly();

}
