/**
 * 
 */
package org.remast.baralga.gui.actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.remast.baralga.Messages;
import org.remast.baralga.gui.model.PresentationModel;
import org.remast.baralga.gui.model.ProjectStateException;

/**
 * Stops the currently running project activity.
 * @author remast
 */
@SuppressWarnings("serial") //$NON-NLS-1$
public class StopAction extends AbstractBaralgaAction {
    
    /** The logger. */
    private static final Log log = LogFactory.getLog(StopAction.class);
    
    public StopAction(final PresentationModel model) {
        super(model);
        
        putValue(NAME, Messages.getString("StopAction.Name")); //$NON-NLS-1$
        putValue(SHORT_DESCRIPTION, Messages.getString("StopAction.ShortDescription")); //$NON-NLS-1$
        putValue(SMALL_ICON, new ImageIcon(getClass().getResource("/icons/gtk-stop.png"))); //$NON-NLS-1$
    }

    /**
     * {@inheritDoc}
     */
    public void actionPerformed(ActionEvent event) {
        try {
            getModel().stop();
        } catch (ProjectStateException e) {
            log.error(e, e);
        }
    }

}
