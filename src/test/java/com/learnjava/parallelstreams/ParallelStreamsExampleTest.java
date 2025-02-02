package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;
import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamsExampleTest
{
	ParallelStreamsExample parallelStreamsExample = new ParallelStreamsExample();

	@Test
	void stringTransform()
	{
		// given
		List<String> inputList = DataSet.namesList();

		// when
		startTimer();
		List<String> resultList = parallelStreamsExample.stringTransform(inputList);
		timeTaken();

		// then
		assertEquals(4, resultList.size());
		resultList.forEach(name ->
		{
			assertTrue(name.contains("-"));
		});
	}

	@ParameterizedTest
	@ValueSource(booleans = {false, true})
	void stringTransform_1(boolean isParallel)
	{
		// given
		List<String> inputList = DataSet.namesList();

		// when
		startTimer();
		List<String> resultList = parallelStreamsExample.stringTransform(inputList, isParallel);
		timeTaken();

		// then
		assertEquals(4, resultList.size());
		resultList.forEach(name ->
		{
			assertTrue(name.contains("-"));
		});
	}

	@Test
	void string_toLowerCase()
	{
		// given
		List<String> inputList = DataSet.namesList();

		// when
		List<String> resultList = parallelStreamsExample.string_toLowerCase(inputList);

		// then
		for (int i = 0; i <= inputList.size() - 1; i++)
		{
			assertEquals(inputList.get(i).toLowerCase(), resultList.get(i));
		}
	}
}
