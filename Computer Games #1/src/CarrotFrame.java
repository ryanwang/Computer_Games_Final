import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import game.*;

public class CarrotFrame extends Platform implements ActionListener{
	
	Button Increase;
	Button Decrease;
	Button Launch;
	static int BunnyNum = 0;
	static int CarrotNum = 0;
	//static Integer CarrotAngle = 50;
	boolean LaunchResult;
	boolean LvOneOver;
	BufferedImage CurrentBunny;
	ImageThing bunny;
	boolean StoryEnd;
	BufferedImage Story;
	Font font1 = new Font("Arial", Font.BOLD, 30);
	
	public void setup(){
		
		Increase = new Button("BIGGER");
		Increase.addActionListener(new IncreaseActionListener());
		add(Increase);
		Decrease = new Button("SMALLER");
		Decrease.addActionListener(new DecreaseActionListener());
		add(Decrease);
		Launch = new Button("Go!");
		Launch.addActionListener(this);
		add(Launch);
		staticValue.init();
		
		CurrentBunny = staticValue.BunnyImage.get(BunnyNum);
		
		LaunchResult = true;
		LvOneOver = false;
		//System.out.println(staticValue.imagepath);
		StoryEnd = false;
		Story = staticValue.StoryImage.get(0);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		//super.update();	
	}

	@Override
	public void overlay(Graphics g) {
		// TODO Auto-generated method stub
		if(StoryEnd == false){g.drawImage(Story, 0, 0, this);}else{
			if(LvOneOver == false){
				g.drawImage(staticValue.VaultImage.get(0), 0, 0, this);
				g.drawImage(staticValue.CarrotImage.get(CarrotNum), 0, 300, this);
				if(LaunchResult == false){g.drawImage(CurrentBunny, 50, -180, this);}else {g.drawImage(CurrentBunny, 400, 60, this);}
				
			}else{
				g.setFont(font1);
				g.drawImage(staticValue.VaultImage.get(1), 0, 0, this);
				g.setColor(Color.BLUE);
				g.drawString("Please wait the lockpick level.. under construction :)", 200, 200);}
		}
		

		//g.drawString(CarrotAngle.toString(), 80, 80);
		//if(LaunchResult){}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(StoryEnd == false) {StoryEnd = true; return;}
		if(BunnyNum == CarrotNum){
				LaunchResult = true;
				if(CarrotNum  < 9) {
					BunnyNum ++;
					CurrentBunny = staticValue.BunnyImage.get(BunnyNum);
					playClip(staticValue.SoundImagepath + "BunnyFallCrash.wav");

				}
				if(CarrotNum == 9) {
					LvOneOver = true;
				}
			}else {
				LaunchResult = false;
				CurrentBunny = staticValue.ScaredBunnyImage.get(BunnyNum);
				playClip(staticValue.SoundImagepath + "EvilBunnyAnnoyed.wav");
			}
	}	
	
}
