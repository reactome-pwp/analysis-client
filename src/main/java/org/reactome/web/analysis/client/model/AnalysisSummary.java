package org.reactome.web.analysis.client.model;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface AnalysisSummary {

    String getToken();

    Boolean getProjection();

    Boolean getInteractors();

    String getType();

    Long getSpecies();

    String getFileName();

    boolean isText();

    String getSampleName();

    //IMPORTANT: next methods are not in the Analysis RESTFul service data model
    //definition, but we need them to set the name after retrieval so the UI
    //can use it later one for the summary
    void setSpeciesName(String name);
    String getSpeciesName();

    boolean isIncludeDisease();
}
