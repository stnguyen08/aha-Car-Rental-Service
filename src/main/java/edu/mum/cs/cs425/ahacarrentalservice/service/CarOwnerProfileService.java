package edu.mum.cs.cs425.ahacarrentalservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.ahacarrentalservice.model.CarOwnerProfile;
import edu.mum.cs.cs425.ahacarrentalservice.model.InformationType;
import edu.mum.cs.cs425.ahacarrentalservice.model.ProfileStatus;
import edu.mum.cs.cs425.ahacarrentalservice.repository.ICarOwnerProfileRepository;
import edu.mum.cs.cs425.ahacarrentalservice.validation.ValidationException;

@Service("carOwnerProfileService")
public class CarOwnerProfileService implements ICarOwnerProfileService {
	
	@Autowired
	ICarOwnerProfileRepository carOwnerProfileRepository;

	@Override
	public List<CarOwnerProfile> findPendingApproveProfiles() {
		// TODO Auto-generated method stub
		return carOwnerProfileRepository.findAll(); //.findPendingApplications();
	}
	
	@Override
	public List<CarOwnerProfile> findAll() {
		// TODO Auto-generated method stub
		return carOwnerProfileRepository.findAll();
	}

	@Override
	public CarOwnerProfile create(CarOwnerProfile profile) throws ValidationException {
//		if(findByUserId(profile.getUserId())) {
//			throw new ValidationException("The user id '" + profile.getUserId() + "' is already used by other. Please choose another.");
//		}
//		if(findByUserId(profile.getUser().getUsername())) {
//			throw new ValidationException("The user id '" + profile.getUser().getUsername() + "' is already used by other. Please choose another.");
//		}
		profile.setStatus(ProfileStatus.PENDING);
		return carOwnerProfileRepository.save(profile);
	}

	@Override
	public CarOwnerProfile findById(long id) {
		// TODO Auto-generated method stub
		Optional<CarOwnerProfile> result = carOwnerProfileRepository.findById(id);
		return result.orElse(null);
	}

	@Override
	public CarOwnerProfile approveProfile(CarOwnerProfile profile)  {
		// TODO Auto-generated method stub
		profile.setStatus(ProfileStatus.APPROVED);
		return carOwnerProfileRepository.save(profile);
	}

//	@Override
//	public Boolean findByUserId(String userId) {
//		// TODO Auto-generated method stub
//		return carOwnerProfileRepository.existsByUserId(userId);
//	}

	public CarOwnerProfile save(CarOwnerProfile carOwnerProfile){
		return carOwnerProfileRepository.save(carOwnerProfile);
	}
	
	
	
}
