package org.reactome.web.analysis.client;


import org.reactome.web.analysis.client.model.*;

import java.util.List;
import java.util.Set;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public interface AnalysisHandler {

    void onAnalysisServerException(String message);


    interface Entities extends AnalysisHandler {

        void onPathwayEntitiesLoaded(FoundEntities entities, long time);

        void onPathwayEntitiesNotFound(long time);

        void onPathwayEntitiesError(AnalysisError error);

    }

    interface Interactors extends AnalysisHandler {

        void onPathwayInteractorsLoaded(FoundInteractors interactors, long time);

        void onPathwayInteractorsNotFound(long time);

        void onPathwayInteractorsError(AnalysisError error);
    }


    interface Elements extends AnalysisHandler {

        void onPathwayElementsLoaded(FoundElements elements, long time);

        void onPathwayElementsNotFound(long time);

        void onPathwayElementsError(AnalysisError error);

    }


    interface NotFoundIdentifiers extends AnalysisHandler {

        void onNotFoundIdentifiersLoaded(List<IdentifierSummary> notFoundIdentifiers);
        
        void onNotFoundIdentifiersError(AnalysisError error);
    }


    interface Page extends AnalysisHandler {

        void onPageFound(Integer page);

        void onPageError(AnalysisError error);

    }


    interface Pathways extends AnalysisHandler {

        void onPathwaysSpeciesFiltered(SpeciesFilteredResult result);

        void onPathwaysSpeciesError(AnalysisError error);

    }

    interface Reactions extends AnalysisHandler {

        void onReactionsAnalysisDataRetrieved(Set<Long> reactions);

        void onReactionsAnalysisError(AnalysisError error);

    }


    interface Result extends AnalysisHandler {

        void onAnalysisResult(AnalysisResult result, long time);

        void onAnalysisError(AnalysisError error);

    }


    interface Summary extends AnalysisHandler {

        void onResultSummaryLoaded(AnalysisSummary summary, ExpressionSummary expressionSummary, long time);

        void onResultSummaryNotFound(long time);

        void onResultSummaryError(AnalysisError error);

    }


    interface Summaries extends AnalysisHandler {

        void onPathwaySummariesLoaded(List<PathwaySummary> pathwaySummaries, long time);

        void onPathwaySummariesNotFound(long time);

        void onPathwaySummariesError(AnalysisError error);

    }


    interface Token extends AnalysisHandler {

        void onTokenAvailabilityChecked(boolean available, String message);

    }

}
