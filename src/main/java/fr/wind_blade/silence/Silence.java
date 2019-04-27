package fr.wind_blade.silence;

import fr.wind_blade.silence.common.Common;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod.EventBusSubscriber
@Mod(modid = Silence.MODID, name = Silence.NAME, version = Silence.VERSION)
public class Silence {
	
    public static final String MODID = "silence";
    public static final String NAME = "Silence";
    public static final String VERSION = "0.1";
    
	@Instance(Silence.MODID)
	public static Silence instance;
	
	@SidedProxy(clientSide = "fr.wind_blade.silence.client.Client", serverSide = "fr.wind_blade.silence.common.Common")
	public static Common proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
