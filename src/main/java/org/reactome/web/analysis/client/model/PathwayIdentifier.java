package org.reactome.web.analysis.client.model;

import java.util.List;
import java.util.Set;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface PathwayIdentifier {

    String getIdentifier();

    List<Double> getExp();

    Set<IdentifierMap> getMapsTo();
}
