package org.reactome.web.analysis.client.model;

import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface FoundEntities {

    List<String> getExpNames();

    List<FoundEntity> getIdentifiers();

    List<String> getResources();

    Integer getFound();

}
