package org.remast.baralga.gui.panels.report;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;
import org.jdesktop.swingx.renderer.FormatStringValue;
import org.remast.baralga.FormatUtils;
import org.remast.baralga.gui.model.report.ObservingAccumulatedActivitiesReport;
import org.remast.baralga.gui.panels.table.AccumulatedActivitiesTableFormat;
import org.remast.baralga.model.report.AccumulatedActivitiesReport;
import org.remast.baralga.model.report.AccumulatedProjectActivity;
import org.remast.swing.util.GuiConstants;

import ca.odell.glazedlists.swing.EventTableModel;

import com.jidesoft.swing.JideScrollPane;

/**
 * Panel containing the accumulated hours spent on each project on one day.
 * @author remast
 */
@SuppressWarnings("serial") //$NON-NLS-1$
public class AccummulatedActitvitiesPanel extends JPanel implements Observer {

    private AccumulatedActivitiesReport report;
    
    private EventTableModel<AccumulatedProjectActivity> tableModel;

    public AccummulatedActitvitiesPanel(final AccumulatedActivitiesReport report) {
        this.report = report;
        this.setLayout(new BorderLayout());

        this.report.addObserver(this);
        
        initialize();
    }

    /**
     * Set up GUI components.
     */
    private void initialize() {
        tableModel = new EventTableModel<AccumulatedProjectActivity>(this.report.getAccumulatedActivitiesByDay(), new AccumulatedActivitiesTableFormat());
        final JXTable table = new JXTable(tableModel);
        table.setHighlighters(GuiConstants.HIGHLIGHTERS);

        table.getColumn(0).setCellRenderer(new DefaultTableRenderer(new FormatStringValue(DateFormat.getDateInstance())));
        table.getColumn(2).setCellRenderer(new DefaultTableRenderer(new FormatStringValue(FormatUtils.durationFormat)));

        table.setAutoResizeMode(JXTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        JideScrollPane table_scroll_pane = new JideScrollPane(table);

        this.add(table_scroll_pane, BorderLayout.CENTER);
    }

    public void update(final Observable o, final Object arg) {
        if (o != null && o instanceof ObservingAccumulatedActivitiesReport) {
            tableModel.fireTableDataChanged();
        }
        
    }
}