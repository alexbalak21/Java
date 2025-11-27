package app;

import app.adept.DepartmentTest;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class RunTests {
    public static void main(String[] args) {
        // Create a test launcher
        Launcher launcher = LauncherFactory.create();
        
        // Create a summary listener to collect test results
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        
        // Create a test discovery request for our test class
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectClass(DepartmentTest.class))
                .build();
        
        // Register the listener and execute the tests
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        
        // Get the test execution summary
        TestExecutionSummary summary = listener.getSummary();
        
        // Print the test results
        System.out.println("\n=== Test Execution Summary ===");
        System.out.println("Tests found: " + summary.getTestsFoundCount());
        System.out.println("Tests started: " + summary.getTestsStartedCount());
        System.out.println("Tests succeeded: " + summary.getTestsSucceededCount());
        System.out.println("Tests failed: " + summary.getTestsFailedCount());
        
        // Print failure details if any
        if (summary.getTestsFailedCount() > 0) {
            System.out.println("\nFailed tests:");
            summary.getFailures().forEach(failure -> 
                System.out.println(" - " + failure.getTestIdentifier().getDisplayName() + 
                                 ": " + failure.getException().getMessage())
            );
        }
        
        // Exit with appropriate status code
        System.exit(summary.getTestsFailedCount() > 0 ? 1 : 0);
    }
}
