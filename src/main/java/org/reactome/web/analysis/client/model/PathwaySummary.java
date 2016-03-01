package org.reactome.web.analysis.client.model;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface PathwaySummary {
    String getStId();

    Long getDbId();

    String getName();

    boolean getLlp(); //get whether this pathway is lower level pathway

    SpeciesSummary getSpecies();

    EntityStatistics getEntities();

    ReactionStatistics getReactions();
}
