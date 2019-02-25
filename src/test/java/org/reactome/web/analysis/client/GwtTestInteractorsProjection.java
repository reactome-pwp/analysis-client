package org.reactome.web.analysis.client;

import com.google.gwt.junit.client.GWTTestCase;
import org.reactome.web.analysis.client.model.AnalysisError;
import org.reactome.web.analysis.client.model.AnalysisResult;
import org.reactome.web.analysis.client.model.FoundInteractors;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class GwtTestInteractorsProjection extends GWTTestCase {

    private static String token;
    /**
     * Must refer to a valid module that sources this class.
     */
    @Override
    public String getModuleName() {
        return "org.reactome.web.analysis.analysisJUnit";
    }


    @Override
    protected void gwtSetUp() throws Exception {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 10 seconds before timing out.
        delayTestFinish(10000);

        AnalysisClient.SERVER = "http://dev.reactome.org";
        AnalysisClient.analyseData("#Interactors\nFUND1\nQ9Z254\nQ9GZQ8\nQ8WXH5", true, true, null, 1, 1, new AnalysisHandler.Result() {
            @Override
            public void onAnalysisServerException(String message) {
                fail(message);
            }

            @Override
            public void onAnalysisResult(AnalysisResult result, long time) {
                token = result.getSummary().getToken();
                assertTrue("There has to be more than one result", result.getPathwaysFound() > 0);
                finishTest();
            }

            @Override
            public void onAnalysisError(AnalysisError error) {
                fail(error.getReason());
            }
        });
    }

    /**
     * Tests the data analysis projecting to human.
     */
    public void testAnalysisProjectionData() {
        // Since RPC calls are asynchronous, we will need to wait for a response
        // after this test method returns. This line tells the test runner to wait
        // up to 10 seconds before timing out.
        delayTestFinish(10000);

        AnalysisClient.SERVER = "http://dev.reactome.org";
        AnalysisClient.getPathwayFoundInteractors(token, "TOTAL", 5205647L, new AnalysisHandler.Interactors() {
            @Override
            public void onPathwayInteractorsLoaded(FoundInteractors interactors, long time) {
                System.out.println(interactors.getFound());
                finishTest();
            }

            @Override
            public void onPathwayInteractorsNotFound(long time) {
                fail("No pathways interactors found for " + token);
            }

            @Override
            public void onPathwayInteractorsError(AnalysisError error) {
                fail(error.getReason());
            }

            @Override
            public void onAnalysisServerException(String message) {
                fail(message);
            }
        });
    }

//    /**
//     * This test will send a request to the server using the greetServer method in
//     * GreetingService and verify the response.
//     */
//    public void testPathwaysSummaries() {
//        // Since RPC calls are asynchronous, we will need to wait for a response
//        // after this test method returns. This line tells the test runner to wait
//        // up to 10 seconds before timing out.
//        delayTestFinish(10000);
//
//        AnalysisClient.SERVER = "http://reactomedev.oicr.on.ca";
//        List<String> pathways = Arrays.asList("194306","399955","447041", "420029", "000000");
//        AnalysisClient.getPathwaySummaries(token, "TOTAL", pathways, new AnalysisHandler.Summaries() {
//            @Override
//            public void onPathwaySummariesLoaded(List<PathwaySummary> pathwaySummaries, long time) {
//                assertTrue("Only four of them should be there", pathwaySummaries.size() == 4);
//                finishTest();
//            }
//
//            @Override
//            public void onPathwaySummariesNotFound(long time) {
//                fail("No pathways summaries found for " + token);
//            }
//
//            @Override
//            public void onPathwaySummariesError(AnalysisError error) {
//                fail(error.getReason());
//            }
//
//            @Override
//            public void onAnalysisServerException(String message) {
//                fail(message);
//            }
//        });
//    }
}
