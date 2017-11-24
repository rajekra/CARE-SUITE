package com.ahp.cas.spark;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.spark.api.java.function.FlatMapFunction;

import com.ahp.cas.domains.claims.ClaimHeader;
import com.fasterxml.jackson.databind.ObjectMapper;

class ParseJson implements FlatMapFunction<Iterator<String>, ClaimHeader> {
	public Iterator<ClaimHeader> call(Iterator<String> lines) throws Exception {
		System.out.println(lines);
		ArrayList<ClaimHeader> people = new ArrayList<ClaimHeader>();
		ObjectMapper mapper = new ObjectMapper();
		while (lines.hasNext()) {
			String line = lines.next();
			try {
				people.add(mapper.readValue(line, ClaimHeader.class));
			} catch (Exception e) {
				// skip records on failure
			}
		}
		return (Iterator<ClaimHeader>) people;
	}
}