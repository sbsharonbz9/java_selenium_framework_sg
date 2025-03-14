package galen.constants;

import java.time.Duration;

public class FrameworkConstants {

	private static final Duration EXPLICIT_WAIT = Duration.ofSeconds(2);
	private static final Duration EXPLICIT_SHORT_WAIT = Duration.ofMillis(500);

	public static Duration getExplicitWait() {
		return EXPLICIT_WAIT;
	}
	public static Duration getExplicitShortWait() {
		return EXPLICIT_SHORT_WAIT;
	}
}
