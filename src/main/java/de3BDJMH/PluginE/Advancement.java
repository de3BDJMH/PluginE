package de3BDJMH.PluginE;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Advancement {
    public static void read() {
        File f = new File(PluginE.instance.getDataFolder(), "advancement.json");
        String advancementJSON;
        StringBuilder s = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String temp;
            while ((temp = reader.readLine()) != null) {
                s.append(temp);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        advancementJSON = s.toString();
        Bukkit.getUnsafe().loadAdvancement(
                new NamespacedKey(PluginE.instance,"craft_transmutation_table"),
                advancementJSON
        );
    }
}
