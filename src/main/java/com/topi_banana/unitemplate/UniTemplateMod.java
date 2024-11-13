package com.topi_banana.unitemplate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//#if FORGE
//$$ import net.minecraftforge.fml.common.Mod;
//#elseif NEOFORGE
//$$ import net.neoforged.fml.common.Mod;
//#endif

//#if FORGE || NEOFORGE
//$$ @Mod("fastipping")
//#endif
public class UniTemplateMod
        //#if FABRIC
        implements net.fabricmc.api.ModInitializer
        //#endif
{
    public static final Logger LOGGER = LogManager.getLogger();

    //#if FABRIC
    @Override public void onInitialize()
    //#elseif FORGE || NEOFORGE
    //$$ public UniTemplateMod()
    //#endif
    {
        LOGGER.info("Hello, World!");
    }
}
