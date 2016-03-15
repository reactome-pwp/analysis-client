package org.reactome.web.analysis.client.model;

import java.util.Set;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface PathwayInteractor {

    String getIdentifier();

    String getResource();

    Set<InteractorEvidence> getInteractors();
}
