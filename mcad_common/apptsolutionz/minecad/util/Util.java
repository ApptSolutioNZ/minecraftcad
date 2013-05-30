package apptsolutionz.minecad.util;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class Util {
    
    private static Util instance;
    
    public static Util getInstance(){
        if(instance==null){
            instance=new Util();
        }
        return instance;
    }
    
    private Util(){};
    /**
     * bindPlayersInventory
     * 
     * @param container the container to add it to
     * @param player    the playerEntity
     * @param incHotBar add the hotbar too?
     * @param invVector2d  the location of the inventory slot positions
     * @param hotVector2d the location of the hotbar slot positions
     */
    public void bindPlayersInventory(Container container,
            InventoryPlayer player, Boolean incHotBar, Vector2d invVector2d,
            Vector2d hotVector2d) {
        bindPlayersInventoryOnly(container, 9, player, invVector2d);
        if (incHotBar) {
            bindPlayersHotbarOnly(container, 0, player, hotVector2d);
        }
    }

    protected void bindPlayersHotbarOnly(Container container, int slotStart,
            InventoryPlayer player, Vector2d vector2d) {
        int slotCount = 0;
        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(player, (slotStart + (slotCount++)),
                    vector2d.getX(i), vector2d.getY(i)),
                    container);

        }
    }

    protected void bindPlayersInventoryOnly(Container container, int slotStart,
            InventoryPlayer player, Vector2d vector2d) {
        int slotCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(player, (slotStart + (slotCount++)),
                        vector2d.getX(j), vector2d.getY(i)),
                        container);
            }
        }
    }

    @SuppressWarnings("unchecked")
    protected Slot addSlotToContainer(Slot slot, Container container) {
        slot.slotNumber = container.inventorySlots.size();
        container.inventorySlots.add(slot);
        container.inventoryItemStacks.add((Object) null);
        return slot;

    }
}
