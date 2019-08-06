package com.test.reflect;

public class HeroPlus {

	private String name;
	
	public float hp;
	
	public float damage;
	
	public int id;
	
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HeroPlus(){
         
    }
    public HeroPlus(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
    	return "Hero [name=" + name + "]";
    }
    
    public boolean isDead() {
    	return false;
    }
    
    public void attackHero(HeroPlus h2) {
    	System.out.println(this.name + " is attacking " + h2.getName());
    }
    
    public static void main(String[] args) {
		System.out.println("Ö´ÐÐmain·½·¨");
	}
}
