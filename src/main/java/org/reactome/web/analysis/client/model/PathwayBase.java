package org.reactome.web.analysis.client.model;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface PathwayBase {
    String getStId();

    Long getDbId();

    EntityStatistics getEntities();

}
