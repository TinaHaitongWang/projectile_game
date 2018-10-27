/*Name: Haitong Wang 
NetID: 28246763
Assignment No.: Project 1 
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// CalculateProjectile class: this class will calculate 
// the projectile height based on user input for each round. 

public class WallProperties {
	int height; // meter 
	int distance; // meter 
	Integer[] store = new Integer[2];// store the previous round's wall height 
	int heightdiff; // difference of the wall height between round 
	int distancediff; // difference of the wall distance between round 
	int i; // each iteration of the round 

	public WallProperties(int h, int d, Integer[] s, int i){
		height = h;
		distance = d;
		store = s;	
	}
	
	public int calculateheight(int height, int i){ 
		// calculate the high difference of the wall from the previous round 
        if(i ==1){
        System.out.print(" The height of this wall is "+height+". ");// for the first round just print out the height 
        store[0] = height; // store the first round's height 
        }
        else{
        	int heightdiff = store[0]-height; // find the difference between previous round height the current round height 
        	store[0] = height;
        	if(heightdiff<0){
        		System.out.print("The wall becomes taller by "+ Math.abs(heightdiff)+"! ");// wall taller
        	}
        	else{
        		System.out.print("The wall becomes shorter by "+ Math.abs(heightdiff)+"! ");// wall shorter 
        	}
        }
        return heightdiff; 
	}
	public int calculatedistance(int distance, int i){
		    // calculate the distance difference of the wall from the previous round 
	        if(i ==1){
	        System.out.print(" Your distance from the wall is "+distance+". ");// for the first round just record the distance 
	        store[1] = distance; // record distance of first round for comparison 
	        }
	        else{
	        	int distancediff = store[1]-distance;// find the difference between previous round distance the current round distance
		        store[1] = distance; 
	        	if(distancediff<0){
	        		System.out.print("The wall moves farther away by "+ Math.abs(distancediff)+"! ");// distance farther 
	        	}
	        	else{
	        		System.out.print("The wall moves closer by "+ Math.abs(distancediff)+"! ");// distance closer 
	        	}
	        }
	        return distancediff;
	}

}
