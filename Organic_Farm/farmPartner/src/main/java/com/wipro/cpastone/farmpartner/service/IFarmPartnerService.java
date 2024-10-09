package com.wipro.cpastone.farmpartner.service;

import java.util.List;

import com.wipro.cpastone.farmpartner.dto.FarmPartnerDTO;
import com.wipro.cpastone.farmpartner.entity.FarmPartner;

public interface IFarmPartnerService {

	public FarmPartner createFarmPartner(FarmPartnerDTO farmPartnerDTO);
	
    public FarmPartnerDTO getFarmPartnerById(Long partnerId);
    
    public List<FarmPartner> getAllFarmPartners();
    
    public FarmPartner updateFarmPartner(FarmPartnerDTO farmPartnerDTO);
    
    public String deleteFarmPartner(Long partnerId);
}
