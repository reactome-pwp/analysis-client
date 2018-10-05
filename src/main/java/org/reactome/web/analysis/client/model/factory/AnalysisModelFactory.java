package org.reactome.web.analysis.client.model.factory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import org.reactome.web.analysis.client.exceptions.AnalysisModelException;
import org.reactome.web.analysis.client.model.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public abstract class AnalysisModelFactory {

    @SuppressWarnings("UnusedDeclaration")
    interface AnalysisAutoBeanFactory extends AutoBeanFactory {
        AutoBean<AnalysisError> analysisError();
        AutoBean<AnalysisResult> analysisResult();
        AutoBean<AnalysisSummary> analysisSummary();
        AutoBean<DBInfo> dBInfo();
        AutoBean<ResourceSummary> resourceSummary();
        AutoBean<PathwayBase> pathwayBase();
        AutoBean<InteractorEvidence> interactorEvidence();
        AutoBean<PathwaySummary> pathwaySummary();
        AutoBean<SpeciesSummary> getSpeciesSummary();
        AutoBean<EntityStatistics> entityStatistics();
        AutoBean<ReactionStatistics> reactionStatistics();
        AutoBean<FoundEntities> foundEntities();
        AutoBean<FoundEntity> foundEntity();
        AutoBean<FoundInteractor> foundInteractor();
        AutoBean<FoundInteractors> foundInteractors();
        AutoBean<FoundElements> foundElements();
        AutoBean<IdentifierMap> identifierMap();
        AutoBean<IdentifierSummary> identifierSummary();
        AutoBean<ExpressionSummary> expressionBoundaries();
        AutoBean<SpeciesFilteredResult> speciesFilteredResult();
    }

    public static <T> T getModelObject(Class<T> cls, String json) throws AnalysisModelException {
        try{
            AutoBeanFactory factory = GWT.create(AnalysisAutoBeanFactory.class);
            AutoBean<T> bean = AutoBeanCodex.decode(factory, cls, json);
            return bean.as();
        }catch (Throwable e){
            throw new AnalysisModelException("Error mapping json string for [" + cls + "]: " + json, e);
        }
    }

    public static List<PathwaySummary> getPathwaySummaryList(String json)
            throws AnalysisModelException, NullPointerException, IllegalArgumentException, JSONException {
        List<PathwaySummary> rtn = new LinkedList<>();
        JSONArray array = JSONParser.parseStrict(json).isArray();
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.get(i).isObject();
            rtn.add(getModelObject(PathwaySummary.class, jsonObject.toString()));
        }
        return rtn;
    }
}
