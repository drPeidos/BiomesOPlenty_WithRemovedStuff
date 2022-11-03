package biomesoplenty.common.configuration;

import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

public class BOPConfigurationIDs
{
	public static Configuration config;

	public static int promisedLandDimID;

	public static int wonderousWoodsID;
	public static int majesticMeadowID;
	public static int promisedLandShrubID;
	public static int blessedBogID;

	public static boolean potionAutoAssign;
	
	public static int paralysisPotionID;
	public static int possessionPotionID;
	
	public static void init(File configFile)
	{
		config = new Configuration(configFile);

		try
		{
			config.load();

			promisedLandDimID = config.get("Dimension Settings", "Promised Land Dimension ID", 20, null).getInt();

			promisedLandShrubID = config.get("Biome IDs", "Sublime Shrubland (Promised Land) ID", 53).getInt();

			wonderousWoodsID = config.get("Biome IDs", "Wonderous Woods (Promised Land) ID", 77).getInt();
			majesticMeadowID = config.get("Biome IDs", "Majestic Meadow (Promised Land) ID", 78).getInt();
			blessedBogID = config.get("Biome IDs", "Blessed Bog (Promised Land) ID", 79).getInt();

			//Potions IDs
			potionAutoAssign = config.get("Potion Auto Assign", "Potion Auto Assign", true, "Automatically assign potion ids if false set potion ids manually.").getBoolean();
			paralysisPotionID = config.get("Potions IDs", "Paralysis Potion ID", 20, null).getInt();
			possessionPotionID = config.get("Potions IDs", "Possession Potion ID", 21, null).getInt();
		}
		catch (Exception e)
		{
			FMLLog.log(Level.ERROR, e, "Biomes O Plenty has had a problem loading its configuration");
		}
		finally
		{
			if (config.hasChanged()) 
			{
				config.save();
			}
		}
	}
}
