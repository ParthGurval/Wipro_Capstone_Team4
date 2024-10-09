package com.wipro.cpastone.farmpartner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.cpastone.farmpartner.dto.FarmPartnerDTO;
import com.wipro.cpastone.farmpartner.entity.FarmPartner;
import com.wipro.cpastone.farmpartner.repository.FarmPartnerRepository;

@Service
public class FarmPartnerService implements IFarmPartnerService {
	
	@Autowired
    private FarmPartnerRepository farmPartnerRepository;

	@Override
	public FarmPartner createFarmPartner(FarmPartnerDTO farmPartnerDTO) {
		// TODO Auto-generated method stub
		
		FarmPartner farmPartner = new FarmPartner();
		
        farmPartner.setName(farmPartnerDTO.getName());
        farmPartner.setLocation(farmPartnerDTO.getLocation());
        farmPartner.setContactInfo(farmPartnerDTO.getContactInfo());

//        FarmPartner savedFarmPartner = farmPartnerRepository.save(farmPartner);
//        
//        farmPartnerDTO.setPartnerId(savedFarmPartner.getPartnerId());

        return farmPartnerRepository.save(farmPartner);
	}

	@Override
	public FarmPartnerDTO getFarmPartnerById(Long partnerId) {
		// TODO Auto-generated method stub
		
		FarmPartner farmPartner = farmPartnerRepository.findById(partnerId).orElse(null);
		
		FarmPartnerDTO farmPartnerDto = new FarmPartnerDTO();
		
		farmPartnerDto.setPartnerId(farmPartner.getPartnerId());
		farmPartnerDto.setName(farmPartner.getName());
		farmPartnerDto.setLocation(farmPartner.getLocation());
		farmPartnerDto.setContactInfo(farmPartner.getContactInfo());
		
		return farmPartnerDto;
	}

	@Override
	public List<FarmPartner> getAllFarmPartners() {
		// TODO Auto-generated method stub
		return farmPartnerRepository.findAll();
	}

	@Override
	public FarmPartner updateFarmPartner(FarmPartnerDTO farmPartnerDTO) {
		// TODO Auto-generated method stub
		
		FarmPartner farmPartner = new FarmPartner();
		
		farmPartner.setPartnerId(farmPartnerDTO.getPartnerId());
		farmPartner.setName(farmPartnerDTO.getName());
		farmPartner.setLocation(farmPartnerDTO.getLocation());
		farmPartner.setContactInfo(farmPartnerDTO.getContactInfo());
		
		return farmPartnerRepository.save(farmPartner);
	}

	@Override
	public String deleteFarmPartner(Long partnerId) {
		// TODO Auto-generated method stub
		
		farmPartnerRepository.deleteById(partnerId);
		
		return "Record Deleted For FarmPartner ID: " + partnerId;
	}

}
