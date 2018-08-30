package me.dariocrosa.resistantbricks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplosionListener implements Listener {
    @EventHandler
    public void onBlockExplode(BlockExplodeEvent e) {
        BlockHandler.handleExplosion(e.blockList());
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e) {
        BlockHandler.handleExplosion(e.blockList());
    }
}
