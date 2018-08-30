package me.dariocrosa.resistantbricks;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

class BlockHandler {
    static boolean handleBlockBreak(Block block) {
        if (block.getType() == Material.STONE_BRICKS) {
            block.setType(Material.CRACKED_STONE_BRICKS);
            return true;
        }
        return false;
    }

    static void handleExplosion(List<Block> blocks) {

        for (Block block : new ArrayList<>(blocks)) {
            boolean cancel = handleBlockBreak(block);
            if (cancel) blocks.remove(block);
        }
    }
}
