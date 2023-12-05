package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {
	private TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		
		} else {
			 assertThatThrownBy(() -> testDemo.addPositive(a,b));
		}
	}
	public static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				Arguments.of(3, 5, 8, false),
				Arguments.of(0, 5, 5, true),
				Arguments.of(7, 0, 7, true)
				);
		}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForMultiplyPositive")
	void assertThatTwoPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
				
			assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected);
			
		} else {
			assertThatThrownBy(() -> testDemo.multiplyPositive(a,b));
		}
	}
	public static Stream<Arguments> argumentsForMultiplyPositive() {
		return Stream.of(
				Arguments.of(3, 5, 15, false),
				Arguments.of(0, 5, 0, true),
				Arguments.of(7, 0, 0, true)
				);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreMultipliedCorrectly() {
		assertThat(testDemo.multiplyPositive(4, 5)).isEqualTo(20);
		assertThat(testDemo.multiplyPositive(40, 50)).isEqualTo(2000);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo testDemo = new TestDemo();
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}
