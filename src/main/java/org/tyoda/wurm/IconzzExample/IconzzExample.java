package org.tyoda.wurm.IconzzExample;

import com.wurmonline.server.items.ItemTemplate;
import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.tyoda.wurm.Iconzz.Iconzz;

import java.io.IOException;

public class IconzzExample implements WurmServerMod, ItemTemplatesCreatedListener, Initable, PreInitable {
    private static final String iconsDir = "mods/IconzzExample/icons/";
    private short exampleIcon1Id = -1;

    @Override
    public void preInit() {
        // You can register a new icon in preInit and store it in a variable for later
        exampleIcon1Id = Iconzz.getInstance().addIcon("ExampleMod_icon1", iconsDir+"ExampleIcon1.png");
    }

    @Override
    public void init() {
        // You can register a new icon in init and call getIdFromName() later to retrieve the Id
        Iconzz.getInstance().addIcon("ExampleMod_icon2", iconsDir+"ExampleIcon2.png");
    }

    @Override
    public void onItemTemplatesCreated() {
        // You can register a new icon in onItemTemplatesCreated
        short exampleIcon3Id = Iconzz.getInstance().addIcon("ExampleMod_icon3", iconsDir + "ExampleIcon3.png");
        /*
            Note that all names in addIcon are prefixed by the name of this mod.
            This is good practice to avoid different mods conflicting by trying
            to use the same name for two different icons.
         */

        try {
            ItemTemplate ExampleItemTemplate1 = new ItemTemplateBuilder("example1")
                    .name("example1", "example1s", "An example showing you can register icons in preInit().")
                    .imageNumber(exampleIcon1Id)
                    .modelName("model.creature.quadraped.pig.")
                    .itemTypes(new short[0])
                    .behaviourType((short)1)
                    .build();
            ItemTemplate ExampleItemTemplate2 = new ItemTemplateBuilder("example2")
                    .name("example2", "example2s", "An example showing you can retrieve an icon's id using getIdFromName().")
                    .imageNumber(Iconzz.getInstance().getIdFromName("ExampleMod_icon2"))
                    .modelName("model.creature.quadraped.pig.")
                    .itemTypes(new short[0])
                    .behaviourType((short)1)
                    .build();
            ItemTemplate ExampleItemTemplate3 = new ItemTemplateBuilder("example3")
                    .name("example3", "example3s", "An example showing you can register icons in onItemTemplatesCreated.")
                    .imageNumber(exampleIcon3Id)
                    .modelName("model.creature.quadraped.pig.")
                    .itemTypes(new short[0])
                    .behaviourType((short)1)
                    .build();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        /*
            You can now create these items as a GM and they'll have the set icons.
         */
    }
}
