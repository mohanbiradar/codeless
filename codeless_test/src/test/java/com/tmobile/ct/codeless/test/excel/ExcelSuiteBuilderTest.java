package com.tmobile.ct.codeless.test.excel;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.tmobile.ct.codeless.core.Executor;
import com.tmobile.ct.codeless.core.Suite;


public class ExcelSuiteBuilderTest {

	@Test
	public void itShouldBuildSuite(){
		Suite suite = new ExcelSuiteBuilder().build("/suites/test_google.xlsx");
		System.out.println(suite);
		assertThat(suite.getTests()).describedAs("tests").isNotEmpty();
		System.out.println(suite.getConfig());
		suite.getTests().forEach(test ->{
			System.out.println("\n"+test.getName());
			test.getSteps().forEach(step ->{
			System.out.println(step.getName());
			});
		});
	}
	
	@Test
	public void itShouldRunSuite(){
		Suite suites = new ExcelSuiteBuilder().build("/suites/test_google.xlsx");
		Executor exec = new Executor();
			suites.getTests().forEach(test -> 
				test.getSteps().forEach( step ->
					exec.run(step)));
	}
}
