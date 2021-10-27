package org.reactome.web.analysis.client.model;

import java.util.List;
import java.util.Map;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface FoundEntities {

    List<String> getExpNames();

    List<FoundEntity> getIdentifiers();

    List<String> getResources();

    Integer getFound();

    Integer getTotalEntitiesCount();

    Map<String, Integer> getResourceToMappedEntitiesCount();

}
