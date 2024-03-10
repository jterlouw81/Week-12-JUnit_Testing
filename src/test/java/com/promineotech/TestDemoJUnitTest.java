package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumdersAreAddedCorrectly(int a, int b, int expected, boolean expectedException) {

		
		if(!expectedException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive(){
		
		return Stream.of(
				arguments(6, 3, 9, false),
				arguments(-1, 5, 4, true),
				arguments(1, 0, 1, true),
				arguments(6, -3, 3, true),
				arguments(1, 5, 6, false),
				arguments(0, 0, 0, true),
				arguments(2, 4, 6, false)
				);
			}
	@Test
	
		void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		
			assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
			assertThat(testDemo.addPositive(5, 7)).isEqualTo(12);
			assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
			assertThat(testDemo.addPositive(25, 27)).isEqualTo(52);
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForModuloEven")
		
		void assertThatModulusResultIsEven(int a, int b, int expected, boolean expectedException) {
		
		if(!expectedException) {
			assertThat(testDemo.moduloEven(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.moduloEven(a,b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	static Stream<Arguments> argumentsForModuloEven(){
		
		return Stream.of(
				arguments(6,3,0,false),
				arguments(4,2,0,false),
				arguments(9,2,1,true)
				);
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
}
}