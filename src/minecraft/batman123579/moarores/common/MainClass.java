package batman123579.moarores.common; //The package your mod is in

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import batman123579.moarores.common.CommonProxy;
import batman123579.moarores.common.handlers.ClientPacketHandler;
import batman123579.moarores.common.handlers.ServerPacketHandler;

@NetworkMod(clientSideRequired=true,serverSideRequired=false, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"MoarOres"}, packetHandler = ClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"MoarOres"}, packetHandler = ServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="MoarOres",name="Even Moar Ores",version="Beta 0.1")

public class MainClass {

@Instance("TutorialMod") //The instance, this is very important later on
public static MainClass instance = new MainClass();

@SidedProxy(clientSide = "batman123579.moarores.client.ClientProxy", serverSide = "batman123579.moarores.common.CommonProxy") //Tells Forge the location of your proxies
public static CommonProxy proxy;

@PreInit
public void PreInit(FMLPreInitializationEvent e){

}

@Init
public void InitTutorialMod(FMLInitializationEvent event){ //Your main initialization method

//MULTIPLAYER ABILITY
NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

}
}