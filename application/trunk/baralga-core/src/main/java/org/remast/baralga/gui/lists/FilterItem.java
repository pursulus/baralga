package org.remast.baralga.gui.lists;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Represents an item to filter by in the GUI. A {@link FilterItem} consists 
 * of an item object and a label for that object.
 * @author remast
 * @param <E> the type to be filtered by
 */
public class FilterItem<E extends Comparable<E>> implements Comparable<FilterItem<E>>{
    
    /** The item. */
    private final E item;
    
    /** The label. */
    private String label;
    

    public FilterItem(final E filterObject) {
        this.item = filterObject;
    }

    public FilterItem(final E filterObject, final String label) {
        this.item = filterObject;
        this.label = label;
    }

    /**
     * @return the filterObject
     */
    public E getItem() {
        return item;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }
    
    @Override
    public String toString() {
        if (label != null) {
            return label;
        }
        return String.valueOf(this.item);
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj != null
                && (obj instanceof FilterItem)) {
            final FilterItem<E> that = (FilterItem<E>) obj;
            
            // Compare the item objects of both FilterItems
            final EqualsBuilder eqBuilder = new EqualsBuilder();
            eqBuilder.append(this.getItem(), that.getItem());
            
            return eqBuilder.isEquals();
        }
        return false;
    }

	@Override
	public int compareTo(final FilterItem<E> o) {
		return this.getItem().compareTo(o.getItem());
	}


}
