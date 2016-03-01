package org.reactome.web.analysis.client.model;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface ExpressionSummary {
    List<String> getColumnNames();
    Double getMin();
    Double getMax();
}
