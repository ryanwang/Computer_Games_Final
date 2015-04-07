
import java.awt.*;
import java.util.*;
import game.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.image.BufferedImage;


public class CannonFrame extends Platform
{
   	Random R = new Random();
	double leftLimit, topLimit, bunnyWidth, bunnyHeight, fenceTopLimit , rightLimit, fenceWidth, fenceHeight, diff, cannonX, cannonY;
	int noOfFences, cannonWidth, cannonHeight, potWidth, potHeight; 
	
	boolean bunnyLocked, cannonFired, firing, startFire;
	ImageThing bunny,cannon, carrot, pot;
//	RectThing cannon;
	ImageThing fences[];
//	int testCount = 0, angle=180;;
	double requiredAngle;
	int angle = 180;
	int potAngle = 0;
	int bunnyRotate;

	Point2D bunnyPoint, potPoint, cannonPoint;
	Line2D line1, line2, line3;
	//line1 between bunny and cannon
	//line2 between cannon and iron pot
	//line3 between iron pot and bunny

	double projectileX, projectileY;
	boolean transition, transitionStart;
	Font font;
	String msg1, msg2, msg3, msg4;
	String input;
	boolean checkAnswer;
	boolean wrongAns;
	
	/*
	//---------------------------------------------------------------------------b
	
	Button Increase;
	Button Decrease;
	Button Launch;
	static int BunnyNum = 0;
	static int CarrotNum = 0;
	//static Integer CarrotAngle = 50;
	boolean LaunchResult;
	boolean LvOneOver;
	BufferedImage CurrentBunny;
	
	//---------------------------------------------------------------------------e
	*/

	public void init()
	{
	//		Label label1 = new Label("Label 1");
	//	add(label1);
	//	this.input = new TextField(40);
	//	this.add(input);


	}
	public void setup() 
   	{
		font = new Font("Helvetica",Font.BOLD, 12);



		projectileX=0.0;
		projectileY = 0.0;
		
		bunnyLocked = false;
		cannonFired=false;
		firing = false;
		diff=5;
		leftLimit = 100;
		topLimit = 50;
		bunnyWidth = 50;
		bunnyHeight = 75;
		fenceWidth = 50;
		fenceHeight = 200;
		fenceTopLimit = bunnyHeight + topLimit;
		noOfFences = 8;
		bunnyRotate = 0;
		rightLimit = noOfFences*fenceWidth+(noOfFences-1)*diff+leftLimit;
		checkAnswer= false;
		input = "";
		wrongAns = false;
			
		fences = new ImageThing[noOfFences];
		//fence1 = new  ImageThing("/Users/Voltaire/Desktop/Game/examples2/images/fence.gif", leftLimit+75.0, fenceTopLimit ,50.0, 200.0);
		//addThing(fence1)
		for(int count = 0; count < noOfFences; count++)
		{
			fences[count] =  new  ImageThing(staticValue.CannonImagepath + "fence_rs.png", leftLimit+ count*fenceWidth+(count-1)*diff, fenceTopLimit ,fenceWidth, fenceHeight);
			addThing(fences[count]);

		}
		
		bunny = new ImageThing(staticValue.CannonImagepath + "normal1.gif", leftLimit+50,topLimit ,bunnyWidth, bunnyHeight);
		addThing(bunny);

		cannonX = leftLimit + (rightLimit - leftLimit)/2-50;
		//System.out.println("Width : "+cannonX);
		double cannonY = fenceTopLimit+fenceHeight + 50;
		cannonWidth = 100;
		cannonHeight = 50;
		cannon  =  new  ImageThing(staticValue.CannonImagepath + "cannon.png",cannonX, cannonY, cannonWidth, cannonHeight) ;
			cannon.setRotate(true,angle );
		addThing(cannon);

		//let us initialize the points
		bunnyPoint =  new Point2D.Double(leftLimit+50.0+bunnyWidth/2, topLimit+bunnyHeight/4);
		cannonPoint = new Point2D.Double(cannonX+cannonWidth/2, cannonY+cannonHeight);
		potPoint = new Point2D.Double(rightLimit, cannonY+cannonHeight); 
		  
		//let us initialize the lines
		line1 = new Line2D.Double(bunnyPoint, cannonPoint);
		line2 = new Line2D.Double(cannonPoint, potPoint);
		line3 = new Line2D.Double(potPoint, bunnyPoint);
		
		
		requiredAngle = 180 + (180 / Math.PI) * Math.atan2(((bunnyPoint.getX() - cannonPoint.getX()) * (cannonPoint.getY() - potPoint.getY()) - ((bunnyPoint.getY() - cannonPoint.getY())*(cannonPoint.getX()-potPoint.getX()))),((bunnyPoint.getX()-cannonPoint.getX())*(cannonPoint.getX()-potPoint.getX())+(bunnyPoint.getY()-cannonPoint.getY())*(cannonPoint.getY()-potPoint.getY())));	
		
		System.out.println("Required Angle : "+requiredAngle);	
		carrot  =  new  ImageThing(staticValue.CannonImagepath + "carrots/carrot30.gif",projectileX, projectileY, 24.0, 42.0) ;
		carrot.setRotate(true, (int)(270-requiredAngle));
		carrot.setVisibility(false);
		addThing(carrot);

		potWidth = 100;
		potHeight = 100;
		pot =  new  ImageThing(staticValue.CannonImagepath + "pot.png",potPoint.getX()-potWidth/2,potPoint.getY()-potHeight/2, potWidth, potHeight) ;
		addThing(pot);
	
		potAngle =(int)( 180 -  (180 / Math.PI) * Math.atan2(((potPoint.getX() - bunnyPoint.getX()) * (cannonPoint.getY() - potPoint.getY()) - ((potPoint.getY() - bunnyPoint.getY())*(cannonPoint.getX()-potPoint.getX()))),((potPoint.getX()-bunnyPoint.getX())*(cannonPoint.getX()-potPoint.getX())+(potPoint.getY()-bunnyPoint.getY())*(cannonPoint.getY()-potPoint.getY()))));	
	
		System.out.println("Pot Angle : "+potAngle);
		
		Label label1 = new Label("Label 1");
		add(label1);

		/*-------------------------------------------------------------------b
		Increase = new Button("BIGGER");
		Increase.addActionListener(new IncreaseActionListener());
		add(Increase);
		Decrease = new Button("SMALLER");
		Decrease.addActionListener(new DecreaseActionListener());
		add(Decrease);
		Launch = new Button("LAUNCH");
		Launch.addActionListener(this);
		add(Launch);
		staticValue.init();
		
		CurrentBunny = staticValue.BunnyImage.get(BunnyNum);
		
		LvOneOver = false;
		*/
		//-------------------------------------------------------------------e

	
	}

   	public void update() {
		/*testCount++;
		if(testCount == 20)
		{
			testCount = 0;
			angle=angle+5;
		//	System.out.println("Angle :"+angle);
			if(angle>360)
				angle = 180;
		}*/
		cannon.setRotate(true,angle );
		if(Math.abs((int)requiredAngle - (360-angle))<5)
		{
			bunnyLocked = true;
		//	System.out.println("Bunny Locked");
		}
	//	Graphics2D g2 = (Graphics2D) g.create();
	//	g2.draw(line1);
	//	g2.draw(line2);
	//	g2.draw(line3);
	
		
		msg1 = "";
		msg2 = "";
		msg3 = "";
		msg4 = "";


		if(!cannonFired)
		{
			msg1 = "Press left or right arrow key to adjust cannon";
		}
	//	input="";
			if(bunnyLocked&&!cannonFired)
		{
			msg2 = "Bunny locked!!! Solve the puzzle. ";
			msg3 = "Angle made by cannon with ground on right : "+ (int)requiredAngle;
			msg4 = "The angle made by cannnon with ground on left is : "+input;
		}
	//this fires the carrot
			if(firing)
			{	
				if(projectileX ==0)
				{
					projectileX = cannonPoint.getX()+cannonWidth*Math.cos(Math.toRadians(requiredAngle));;
					projectileY = cannonPoint.getY()-cannonWidth*Math.sin(Math.toRadians(requiredAngle));;
				}
				else if(projectileY > bunnyPoint.getY())
				{			
					carrot.setVisibility(true);
					projectileX = projectileX + diff*Math.cos(Math.toRadians(requiredAngle));
					projectileY = projectileY - diff*Math.sin(Math.toRadians(requiredAngle));
					carrot.setX(projectileX);
					carrot.setY(projectileY);
					System.out.println(projectileX+","+projectileY);
				}
				else 
				{
					firing = false;
					try
					{
						Thread.sleep(200);
					}
					catch(InterruptedException ie)	
					{
						//safely ignore
					}
					carrot.setVisibility(false);
					transition = true;	
					transitionStart = true;
					

				}
				
			}
	//this part of code checks the answer

	if(checkAnswer)
	{
		if(Integer.parseInt(input) == 180 - (int) requiredAngle)
		{
			msg2 = "Very Good !! Correct answer, cannon will fire!!!";
			cannonFired = true;
			firing = true;
			bunnyLocked = false;
			
		}
		else
		{
			input ="";
			msg2="hint : ";
			wrongAns= false;
		}
		checkAnswer=false;
	}
	

	//this sends the bunny to pot
	if(transition)
	{
		if(bunny.getX() > potPoint.getX())
		{
			transition=false;
			bunny.setVisibility(false);
		}
		else
		{
			bunnyRotate +=20;
			bunny.setRotate(true, bunnyRotate);
			bunny.setX(bunny.getX()+diff*Math.cos(Math.toRadians(potAngle)));
			bunny.setY(bunny.getY()+diff*Math.sin(Math.toRadians(potAngle)));
		}
	}
		
       }
	public void overlay(Graphics g)
	{
		 g.setColor(Color.black);
	 	 g.setFont(font);

		g.drawString(msg1, 200, 450);
		g.drawString(msg2, 200, 470);
			g.drawString(msg3, 200, 490);
			g.drawString(msg4, 200, 510);
			
		/*/------------------------------------------------------------------b
			if(LvOneOver == false){
				g.drawImage(staticValue.VaultImage.get(0), 0, 0, this);
				g.drawImage(staticValue.CarrotImage.get(CarrotNum), 0, 300, this);
				g.drawImage(CurrentBunny, 400, 60, this);
			}else{
				g.drawImage(staticValue.VaultImage.get(1), 0, 0, this);
				g.setColor(Color.BLUE);
				g.drawString("Please expect the lockpick level.. under construction :)", 200, 200);}
				
				*/
		//------------------------------------------------------------------e

	}
		

	public boolean keyDown(Event e, int key) 
	{
		System.out.println("Some key was pressed "+key);
		if (key == 114)
		{
		//	reset = true;
		}
		if (key==32)
		{
		//	startgame = true;
		}
		if(key == 1006&&!cannonFired)
		{
			System.out.println("Left Key was pressed");
			if(angle>=185)
				angle = angle-5;
	//		dx = -8;
		}
		else
		if(key==1007&&!cannonFired)
		{
			System.out.println("Right key was pressed");
			if(angle<=355)
				angle=angle+5;
	//		dx = 8;
		//	System.out.println("dx : "+dx);
		}
		if(key==102&&!cannonFired&&bunnyLocked)
		{
			cannonFired = true;
			firing = true;
			System.out.println("Cannon Fired!!!");
		}
		if(bunnyLocked)
		{
			if(key == 48)
			{
				input = input+"0";
			}
			if(key == 49)
			{
				input = input+"1";
			}
			if(key == 50)
			{
				input = input+"2";
			}
			if(key == 51)
			{
				input = input+"3";
			}
			if(key == 52)
			{
				input = input+"4";
			}
			if(key == 53)
			{
				input = input+"5";
			}
			if(key == 54)
			{
				input = input+"6";
			}
			if(key == 55)
			{
				input = input+"7";
			}
			if(key == 56)
			{
				input = input+"8";
			}
			if(key == 57)
			{
				input = input+"9";
			}
			if(key==10)
			{
				checkAnswer=true;
				
			}
			if(key==8)
			{
				if(input.length()>0)
				{
					input=input.substring(0, input.length()-1);
				}
			}

		}
	
      		return false;
   	}
	
	/*@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(BunnyNum == CarrotNum){
			LaunchResult = true;
			if(CarrotNum  < 9) {
				BunnyNum ++;
				CurrentBunny = staticValue.BunnyImage.get(BunnyNum);
			}
			if(CarrotNum == 9) {
				LvOneOver = true;
			}
		}else {
			LaunchResult = false;
			CurrentBunny = staticValue.ScaredBunnyImage.get(BunnyNum);
			playClip(staticValue.SoundImagepath + "EvilBunny1.wav");
		}
	}
	*/

  }

