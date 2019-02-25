package org.reactome.web.analysis.client.model;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface SpeciesSummary {

    Long getDbId();

    Long getTaxId();

    String getName();

    Integer getPathways();

}
