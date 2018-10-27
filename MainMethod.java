/*Name: Haitong Wang  
NetID: 28246763
Assignment No.: Project 1 
Lab section: MW 2:00pm
"I did not collaborate with anyone on this
assignment."*/
// Main method file: Run this file to start the game 

import java.util.Scanner; 
import java.util.Random;
public class MainMethod {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		double speed; // meter/second
		double angle; // degree 
		int sum = 0; // score sum of each round 
		int height;// meter 
		int distance;// meter
		Integer[] store = new Integer[2]; // integer stores the height of the wall from previous round 
		boolean gamecontrol2 = true; // control the round while loop 
		boolean gamecontrol1; // control the game while loop 
		boolean currentstatus; // give the status of whether the launch make over the wall or not 
		Integer[] score_sum = new Integer[1000]; // store the score for each round 
		int basecost = -1; // cost of each launch 
		
        //////////////////////////////////////////////////
		// Introduce the rule of this game 
		System.out.println("Welcome to the Launch Projectiles Game!In this game, you have a catapult and you are trying to launch it in"
		        + "\nprojectile motion over an imaginary wall!In each round of the game, you will be asked to set the launch angle"
				+ "\nand the speed of catapult. In terms of the result, you will be informed whether the projectile makes it over the wall or not. There is a base score"
				+ "\nof 50 points.Each launch costs 1 point. A close clear gets 5 points and a far clear gets 3 points. A near miss loses 2 points and a far miss loses 4 points."
				+ "\nAt the end of each round, you may chose to continue to play for quit the game. The current score will be updated and reflected at the beginning of each round."
				+ "\nThe final score will be reported after requested to quit.Now, Are you ready to play? Enter 'Start' to begin to play");
		
		////////////////////////////////////////////////////
		 
		// check if user enter start to play the game 
		while(true){
		String input1 = scan.next();
		if(input1.equals("Start")){
			gamecontrol1 = true;
			break;
			// first game control, controlling the outside while loop 
			// for continue to play
		}
		else{ 
			gamecontrol1 = false;
			System.out.println("Error, Please enter again!");
			continue;
		}
		}
		/////////////////////////////////////////////////////
		// each round begin here!
		int i = 1;// loop iteration counts
		int roundnumber = 1; // count round number 
		
		while (gamecontrol1){ // game while loop controls the game 
	    // begin of each round 
		System.out.println("\nROUND "+roundnumber);
		// inform player their scores 
			if(roundnumber == 1){
				System.out.println("Now! Let play the projectile game!");
				System.out.print("You have a base score of 0.");
	            }
	            else{
	            	System.out.println("You have a base score of "+sum+".");
	            }
		
		// generate random height of the wall and distance from the wall and report them
        height = random.nextInt((100-10)+1)+10; // unit: meter
        distance = random.nextInt((300-20)+1)+20;// unit: meter 
        WallProperties wall = new WallProperties(height, distance, store, roundnumber);
		wall.calculateheight(height,i); // report height of the wall 
        wall.calculatedistance(distance, i); // report distance of the wall 
        
        // begin each iteration within the round
		while(gamecontrol2){// round while loop controls each round 
			// give player their basic score 
			if(i ==1){
			}
			else{
				System.out.print("Your current score is "+sum+".");
			}
		
            // prompt user to enter the speed and angle of the game 
			System.out.println(" Please enter the speed in m/s2 for your catapult:");
			speed = scan.nextDouble();
			System.out.print("Please enter the launch angle in degree for your catapult:");
			angle = scan.nextDouble();
			
			// calculate the projectile and assign comment for the outcome
			CalculateProjectile game = new CalculateProjectile(speed, angle, distance,height);
			game.projectile(speed,angle,distance,height);// get projectile height 
			game.comment();//get the performance comment of the launch 
			currentstatus = game.getStatus(); //get the status of the launch whether get over the wall or not 
			
			// update score for each round 	
			sum = sum +basecost+ game.getScore();
			
			// update the iteration count
	        i++; 
	        
	        // Check whether the user want to continue to play this round 
	        System.out.println("\nEnter 'Continue' to continue playing this round."
	        		+ " Enter 'Quit' to quit the game. Enter 'Skip' to skip this round.");// user has the option to quit the game after each launch 
	        while(true){ // prevent player to enter something else
	        	if(currentstatus == true){ // if user get over the wall in current launch, the round is over 
	        		gamecontrol2 = false;
	        		break;
	        	}
	        	else{
	        String input3 = scan.next();
	        if(input3.equals("Continue")){
	        	gamecontrol2 = true; // continue the round while loop
	        	break;
	        }
	        else if(input3.equalsIgnoreCase("Quit")){
	        	gamecontrol2 = false; // quit current round while loop
	        	gamecontrol1 = false; // quit the game while loop
	        	break;
	        }
	        else if(input3.equalsIgnoreCase("Skip")){
	        	gamecontrol2 = false;// quit current round while loop 
	        	gamecontrol1 = true;// continue the game while loop
	        	break;
	        }
	        else{
	        	System.out.println("Error, please enter again!");//print error if user enter something else 
	        	continue; 
	        }
	        	}
	        }
	            
		}
		// each round end here
		/////////////////////////////////////////////////////////////
		System.out.print("Your final score of this round is "+sum+". Good job! ");
		score_sum[roundnumber-1] = sum;// record the final score of each round
		System.out.println("\nEnter 'Quit' to quit the game or 'Continue' to continue the game");// user has the option to quit the game after each round 
		while(true){
			String input2 = scan.next();
		if(input2.equalsIgnoreCase("Quit")){
			gamecontrol1 = false;// quit the game while loop 
			gamecontrol2 = false;// quit the round while loop
			break;
		}
		else if(input2.equalsIgnoreCase("Continue")){
			gamecontrol1 = true;
			gamecontrol2 = true;
			roundnumber++; // update each round number 
			break; 
			}
		else{
			System.out.println("Error, please enter again");
			continue; 
		}
		}
	}
	// end of game 
		System.out.println("Thank you for playing! Following is all your recorded score from each round:");
		for(int j=0;j<score_sum.length;j++){
			if (score_sum[j] != null){
				System.out.print(score_sum[j]+" ");// print out all the score within the array that are not nulll 
			}
		}
}
}
