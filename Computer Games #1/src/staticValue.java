import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;


public class staticValue {
	
	public static List<BufferedImage> CarrotImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> BunnyImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> ScaredBunnyImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> AngryBunnyImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> VaultImage = new ArrayList<BufferedImage>();
	public static List<BufferedImage> StoryImage = new ArrayList<BufferedImage>();


	public static String CarrotImagepath = System.getProperty("user.dir") + "/game/carrot/";
	public static String VaultImagepath = System.getProperty("user.dir") + "/game/vault/";
	public static String BunnyImagepath = System.getProperty("user.dir") + "/game/bunny/";
	public static String ScaredBunnyImagepath = System.getProperty("user.dir") + "/game/scaredbunny/";
	public static String AngryBunnyImagepath = System.getProperty("user.dir") + "/game/angrybunny/";
	public static String SoundImagepath = System.getProperty("user.dir") + "/game/sound/";
	public static String CannonImagepath = System.getProperty("user.dir") + "/game/cannon/";
	public static String StoryImagepath = System.getProperty("user.dir") + "/game/story/";

	public static void init(){
		// ADD ALL CARROT
		for(int i = 0; i <= 9; i++){
			try{
				CarrotImage.add(ImageIO.read(new File(CarrotImagepath + i + ".gif")));
			}catch(Exception ee){ee.printStackTrace();}
		}
		
		//ADD ALL BUNNY
		for(int i = 0; i <= 9; i++){
			try{
				BunnyImage.add(ImageIO.read(new File(BunnyImagepath + i + ".gif")));
			}catch(Exception ee){ee.printStackTrace();}
		}
		
		for(int i = 0; i <= 9; i++){
			try{
				ScaredBunnyImage.add(ImageIO.read(new File(ScaredBunnyImagepath + i + ".gif")));
			}catch(Exception ee){ee.printStackTrace();}
		}
		
		for(int i = 0; i <= 1; i++){
			try{
				VaultImage.add(ImageIO.read(new File(VaultImagepath + i + ".jpg")));
			}catch(Exception ee){ee.printStackTrace();}
		}
		
			try{
				StoryImage.add(ImageIO.read(new File(StoryImagepath  + "0.gif")));
			}catch(Exception ee){ee.printStackTrace();}
	}
}
