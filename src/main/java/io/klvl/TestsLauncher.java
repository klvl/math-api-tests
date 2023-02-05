package io.klvl;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TagFilter;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class TestsLauncher {

    public static void main(String[] args) {
        LauncherDiscoveryRequestBuilder requestBuilder = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectPackage("io.klvl.tests"));

        if (args.length > 0) requestBuilder = requestBuilder.filters(TagFilter.includeTags(args));

        LauncherDiscoveryRequest request = requestBuilder.build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();

        System.out.print("Amount of started tests: " + summary.getTestsStartedCount() + "\n");
        System.out.print("Amount of succeeded tests: " + summary.getTestsSucceededCount() + "\n");
        System.out.print("Amount of failed tests: " + summary.getTestsFailedCount());
    }
}
