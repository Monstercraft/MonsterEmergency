package org.monstercraft.info.plugin.utils;

import org.monstercraft.info.plugin.api.Carrier;

public class CarrierUtils {

    public static Carrier findCarrier(final String name) {
        if (name == null) {
            return null;
        }
        for (Carrier c : Carrier.values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

}
