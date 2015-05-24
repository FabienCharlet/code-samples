package org.example.samples.nocomments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.example.samples.nocomments.raw.CrypticClass;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class TestParses {

	private static final String TEST_URL = 
			"http://nocomments.samples.example.org:8080/rep1/rep2?var1=val1&var2=val2&var3=v3";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRawMethod() {
		
		List res = CrypticClass.process(TEST_URL);
		
		Iterator resIterator = res.iterator();
		
		Assertions.assertThat(resIterator.next()).isEqualTo("http");
		
		List<String> domainElements = (List<String>) resIterator.next();
		Iterator domainIterator = domainElements.iterator();
		
		Assertions.assertThat(domainIterator.next()).isEqualTo("nocomments");
		Assertions.assertThat(domainIterator.next()).isEqualTo("samples");
		Assertions.assertThat(domainIterator.next()).isEqualTo("example");

		Assertions.assertThat(resIterator.next()).isEqualTo("org");
		Assertions.assertThat(resIterator.next()).isEqualTo("8080");
		
		Assertions.assertThat(resIterator.next()).isEqualTo("rep1");
		Assertions.assertThat(resIterator.next()).isEqualTo("rep2");
		
		Map<String, String> vars = (Map<String, String>) resIterator.next();
		
		Assertions.assertThat(vars.get("var1")).isEqualTo("val1");
		Assertions.assertThat(vars.get("var2")).isEqualTo("val2");
		Assertions.assertThat(vars.get("var3")).isEqualTo("v3");
		
	}
}
