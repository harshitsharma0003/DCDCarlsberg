package com.fusionhawk.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fusionhawk.model.req.DemandTableReq;
import com.fusionhawk.model.req.FilterSkuReq;
import com.fusionhawk.model.res.DemandTableDbRes;
import com.fusionhawk.repository.BeaconRepository;
import com.fusionhawk.service.FusionhawkService;

@Service
public class FusionhawkServiceImpl implements FusionhawkService {

	@Autowired
	private BeaconRepository repository;

	@Override
	public List<String> getBrands() {
		return repository.fetchBrands();
	}

	@Override
	public List<String> getLeadSkuNames(FilterSkuReq filterSkuReq) {
		List<String> brandList = filterSkuReq.getFilterBrands();
		if (brandList.size() == 0)
			return repository.fetchLeadSkuNames();
		else {
			String regexp = "^".concat(brandList.get(0));
			if (brandList.size() > 1) {
				for (int i = 1; i < brandList.size(); i++) {
					regexp = regexp.concat("|^").concat(brandList.get(i));
				}
			}
			return repository.fetchLeadSkuNamesByBrands(regexp);
		}
	}

	@Override
	public List<DemandTableDbRes> getDemandTable(DemandTableReq demandTableReq, String startWeek, String endWeek) {
		return repository.fetchDemandTable(demandTableReq.getLead_sku_name(), startWeek, endWeek);
	}
}
