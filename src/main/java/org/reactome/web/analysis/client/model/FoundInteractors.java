package org.reactome.web.analysis.client.model;

import java.util.List;
import java.util.Set;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface FoundInteractors {

    List<FoundInteractor> getIdentifiers();

    Set<String> getResources();

    List<String> getExpNames();

    Integer getFound();

}
