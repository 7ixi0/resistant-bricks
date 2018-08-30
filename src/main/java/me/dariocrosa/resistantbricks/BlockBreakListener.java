package me.dariocrosa.resistantbricks;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

class BlockBreakListener implements Listener {
    private final boolean disableIfCreative;

    BlockBreakListener(boolean disableIfCreative) {
        this.disableIfCreative = disableIfCreative;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (this.disableIfCreative &&
                e.getPlayer().getGameMode() == GameMode.CREATIVE) return;

        boolean cancel = BlockHandler.handleBlockBreak(e.getBlock());
        e.setCancelled(cancel);
    }
}
