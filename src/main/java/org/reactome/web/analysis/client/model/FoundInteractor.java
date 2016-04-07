package org.reactome.web.analysis.client.model;

import java.util.Set;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface FoundInteractor extends IdentifierSummary {

    Set<String> getMapsTo();

    IdentifierMap getInteractsWith();

}
