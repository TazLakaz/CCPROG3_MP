import java.util.ArrayList;

/**
 * Represents a slot in the vending machine that can hold multiple items.
 */

public class Slots {
    private ArrayList<Item> slotItems;

    /**
     * Constructor for the Slots class.
     * Initializes an empty list of slot items.
     */

    public Slots() {
        slotItems = new ArrayList<>();
    }

    public void insertItem(Item item) {
        slotItems.add(item);
    }

    /**
     * Retrieves the list of items in the slot.
     *
     * @return The list of items in the slot.
     */

    public ArrayList<Item> getSlotItems() {
        return slotItems;
    }

    /**
     * Removes an item from the slot at the specified index.
     *
     * @param index The index of the item to be removed.
     */

    public void removeItem(int index) {
        if (index >= 0 && index < slotItems.size()) {
            slotItems.remove(index);
        }
    }

    /**
     * Retrieves the name of the item in the slot, or "Empty Slot" if the slot is empty.
     *
     * @return The name of the item in the slot or "Empty Slot" if the slot is empty.
     */

    public String getItemName() {
        if (!slotItems.isEmpty()) {
            return slotItems.get(0).getName();
        } else {
            return "Empty Slot";
        }
    }
}