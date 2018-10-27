/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 1 
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// CalculateProjectile class: this class will calculate 
// the projectile high based on user input for each round. It will also give 
// a comment about the user's launch and its corresponding score. 

public class CalculateProjectile {
	
	double speed; // meter/second 
	double angle; // degree
	int distance; // actual distance from the wall
	int height; // actual height of the wall
	double gravity= 9.8; // unit: m/s2
	double projectile; // calculate height of projectile 
	double diff; // difference between the height or distance 
	int score; // score of each round 
	boolean status; // status of each launch whether it make over the wall or not 
	
	
	public CalculateProjectile(double s, double a, int d, int h){
		speed = s;
		angle = a;
		distance = d;
		height = h;
	}
	
	public double projectile(double s, double a, int d, int h){
		// calculate projection high 
		a = a * (Math.PI/180);
		projectile=(d*Math.tan(a)) - (gravity*Math.pow(d, 2))/(2*Math.pow((s*Math.cos(a)), 2)); //projectile motion formula
		System.out.print("Your projectile height is "+ projectile+". ");
		diff = projectile - h;// give the difference between the actual and user input height 
		return diff;
	}
  
	
	public void comment(){ //comment the projectile 
		if(diff>0 && diff <= 3){ 
			System.out.print("And, you made it over the wall! "); //close clear 
			score = 4; 
			status = true; 
		}
		else if(diff>3){
			System.out.print("Nice try, but there is plenty of room over the wall! "); //far clear 
			score = 2;
			status = true; 
		}
		else if(diff<0 && diff>=-3){
			System.out.print("Not quite over! Try again! "); //near miss
			score = -2;
			status = false; 
		}
		else{
			System.out.print("You are not even close! Give another try! "); //far miss
			score = -4;
			status = false; 
		}
	}
	
	public int getScore(){ 
		// pass out score
		return score;
	}
	
	public boolean getStatus(){
		// pass out the status of launch whether it is over the wall or not 
		return status;	
	}
		
}


