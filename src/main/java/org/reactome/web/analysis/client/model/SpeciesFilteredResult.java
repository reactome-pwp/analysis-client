package org.reactome.web.analysis.client.model;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface SpeciesFilteredResult {

    String getType();

    ExpressionSummary getExpressionSummary();

    List<PathwayBase> getPathways();

    AnalysisType getAnalysisType();

    void setAnalysisType(AnalysisType analysisType);

}
