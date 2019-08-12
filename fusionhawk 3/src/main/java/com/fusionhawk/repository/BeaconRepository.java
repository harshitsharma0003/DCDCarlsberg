package com.fusionhawk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fusionhawk.model.res.DemandTableDbRes;

@Repository
public interface BeaconRepository extends JpaRepository<DemandTableDbRes, String> {

	String fetchDemandTableQuery = "SELECT CALENDARYEAR, SUM(res.APO) AS APO, SUM(res.PREDICTIONS) AS PREDICTIONS, SUM(res.TOTALSALESVOLUME) AS TOTALSALESVOLUME, SUM(res.TEMPERTURE) AS TEMPERTURE FROM\n"
			+ "(SELECT LEADSKUNAME, CALENDARYEAR, SUM(APO) AS APO, SUM(PREDICTIONS) AS PREDICTIONS, SUM(TOTALSALESVOLUME) AS TOTALSALESVOLUME, SUM(TEMPERTURE) AS TEMPERTURE FROM beacon WHERE LEADSKUNAME IN :leadSkuList and CALENDARYEAR > :startWeek and CALENDARYEAR < :endWeek group by LEADSKUNAME, CALENDARYEAR) AS res GROUP BY CALENDARYEAR";

	@Query(value = "SELECT DISTINCT(BRANDNAME) FROM beacon WHERE BRANDNAME!=''", nativeQuery = true)
	List<String> fetchBrands();

	@Query(value = "SELECT DISTINCT(LEADSKUNAME) FROM beacon WHERE LEADSKUNAME!=''", nativeQuery = true)
	List<String> fetchLeadSkuNames();

	@Query(value = "SELECT DISTINCT(LEADSKUNAME) FROM beacon WHERE LEADSKUNAME!='' AND LEADSKUNAME REGEXP :regexp", nativeQuery = true)
	List<String> fetchLeadSkuNamesByBrands(@Param("regexp") String regexp);

	@Query(value = fetchDemandTableQuery, nativeQuery = true)
	List<DemandTableDbRes> fetchDemandTable(@Param("leadSkuList") List<String> leadSkuList, @Param("startWeek") String startWeek, @Param("endWeek") String endWeek);

}
