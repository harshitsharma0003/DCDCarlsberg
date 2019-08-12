package com.fusionhawk.service;

import java.util.List;

import com.fusionhawk.model.req.DemandTableReq;
import com.fusionhawk.model.req.FilterSkuReq;
import com.fusionhawk.model.res.DemandTableDbRes;

public interface FusionhawkService {
	
	public List<String> getBrands();
	
	public List<String> getLeadSkuNames(FilterSkuReq filterSkuReq);
	
	public List<DemandTableDbRes> getDemandTable(DemandTableReq demandTableReq, String startWeek, String endWeek);

}
