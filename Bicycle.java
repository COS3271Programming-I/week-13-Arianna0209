package week131;

class Bicycle {        
    
	// the Bicycle class has five fields
    public int cadence, gear, speed;
    String owner, type;
    
    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear, String startType, String startOwner) {
        this.gear = startGear;
        this.cadence = startCadence;
        this.speed = startSpeed;
        this.type = startType;
        this.owner = startOwner;
    }
   
    // Added setters:
    public void setCadence(int cadence) {
    	this.cadence = cadence;
    }
	public void setSpeed(int speed) {
    	this.speed = speed;
    }
	public void setGear(int gear) {
    	this.gear = gear;
	}
	
	// Added getters:
	public String getOwner() {
		return owner;
	}
	public String getType() {
		return type;
	}
	public int getSpeed() {
		return speed;
	}
	public int getGear() {
		return gear;
	}
    
	// the Bicycle class has a method to print information
    public String getInfo (){
    	String message;
    	message = this.owner + " owns this " + this.type + " bicycle.";
    	message += "\nCurrently we are in gear "+ this.gear + " and going " + this.speed + " MPH.";
    	message += "\nThe cadence is " + this.cadence + " RPM.";
    	return message;
    }
}

