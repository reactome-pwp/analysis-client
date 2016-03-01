package org.reactome.web.analysis.client.model;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface PathwayIdentifiers {

    List<String> getExpNames();

    List<PathwayIdentifier> getIdentifiers();

    List<String> getResources();

    Integer getFound();

}
