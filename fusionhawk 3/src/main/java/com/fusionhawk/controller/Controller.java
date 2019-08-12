package com.fusionhawk.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fusionhawk.model.req.DemandTableReq;
import com.fusionhawk.model.req.FilterSkuReq;
import com.fusionhawk.model.res.DemandTableDbRes;
import com.fusionhawk.service.FusionhawkService;

@RestController
@RequestMapping("/v1")
public class Controller {

	@Autowired
	private FusionhawkService service;

	@GetMapping(value = "/ping")
	public String getCurrentTimeStamp() {
		return "Application recieved ping on " + new Date().toString();
	}

	@GetMapping(value = "/brands")
	public ResponseEntity<List<String>> getBrands() {
		return new ResponseEntity<>(service.getBrands(), HttpStatus.OK);
	}

	@GetMapping(value = "/sku")
	public ResponseEntity<List<String>> getLeadSkuNames(@RequestBody FilterSkuReq filterSkuReq) {
		return new ResponseEntity<>(service.getLeadSkuNames(filterSkuReq), HttpStatus.OK);
	}

	@GetMapping(value = "/demandTable")
	public ResponseEntity<List<DemandTableDbRes>> getDemandTable(@RequestBody DemandTableReq demandTableReq,
			@RequestParam(value = "startWeek", required = false) String startWeek,
			@RequestParam(value = "endWeek", required = false) String endWeek) {
		return new ResponseEntity<>(service.getDemandTable(demandTableReq, startWeek, endWeek), HttpStatus.OK);
	}

}
