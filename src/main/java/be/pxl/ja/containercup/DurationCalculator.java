package be.pxl.ja.containercup;

import java.time.Duration;
import java.util.function.Function;

public class DurationCalculator {

	private Duration value = Duration.ZERO;

	// TODO implement generic method
	public <T> void minus(T i, Function<T,Duration> duration){

	}

	public void minus(Duration duration) {
		value = value.minus(duration);
	}

	public void plus(Duration duration) {
		value = value.plus(duration);
	}

	public Duration getResult() {
		return value;
	}
}
