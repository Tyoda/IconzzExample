package org.tyoda.wurm.IconzzExample;

import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.ItemTemplatesCreatedListener;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.tyoda.wurm.Iconzz.Iconzz;

public class IconzzExample implements WurmServerMod, ItemTemplatesCreatedListener, Initable, PreInitable {
    @Override
    public void init() {
        Iconzz.getInstance().addIcon("/");
    }

    @Override
    public void preInit() {

    }

    @Override
    public void onItemTemplatesCreated() {

    }
}
