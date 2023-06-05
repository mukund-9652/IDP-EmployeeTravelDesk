package com.cognizant.employeetraveldesk.humanresources.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeetraveldesk.humanresources.entity.Users;
import com.cognizant.employeetraveldesk.humanresources.exception.DuplicateResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.InvalidResourceException;
import com.cognizant.employeetraveldesk.humanresources.exception.ResourceNotFoundException;
import com.cognizant.employeetraveldesk.humanresources.mapper.ModelMapper;
import com.cognizant.employeetraveldesk.humanresources.mapper.ModelMapperList;
import com.cognizant.employeetraveldesk.humanresources.model.UsersDTO;
import com.cognizant.employeetraveldesk.humanresources.repository.UsersRepository;

@Service
public class UsersServiceImplementation
		implements com.cognizant.employeetraveldesk.humanresources.service.UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	GradesHistoryServiceImplementation gradesServiceImpl;

	ModelMapperList modelMapperList = new ModelMapperList();
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<UsersDTO> getEmployees() throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		List<UsersDTO> usersDTO = modelMapperList.mapUserToUserDto(usersRepository.findAll());
		if (usersDTO.size() == 0) {
			throw new ResourceNotFoundException("There is no employee data. Kindly check your database");
		}
		return usersDTO;
	}

	@Override
	public boolean addEmployee(UsersDTO usersDTO) throws DuplicateResourceException, InvalidResourceException {
		// TODO Auto-generated method stub
		Optional<Users> employeeCheck = usersRepository.findById(usersDTO.getEmployeeid());
		if (employeeCheck.isPresent()) {
			throw new DuplicateResourceException("Resource already exists");
		}

		if (usersDTO.getEmployeeid() < 100000) {
			throw new InvalidResourceException("The entered employee id must have 6 digits for sure.");
		}

		if (!this.checkEmail(usersDTO.getEmailAddress())) {
			throw new InvalidResourceException("Your email id must have @cognizant.com for sure.");
		}

		if (usersDTO.getRole().equalsIgnoreCase("TravelDeskExec") && usersDTO.getGrades().getId() > 1) {
			throw new InvalidResourceException("TravelDeslExec will always start from Grade-1");
		}

		usersRepository.save(modelMapper.mapUserDtoToUser(usersDTO));

		employeeCheck = usersRepository.findById(usersDTO.getEmployeeid());
		if (employeeCheck.isPresent()) {
			gradesServiceImpl.createGradesHistoryByEmployeeid(employeeCheck.get().getEmployeeid());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeById(int userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> employeeCheck = usersRepository.findById(userId);
		if (employeeCheck.isPresent()) {
			usersRepository.delete(employeeCheck.get());
			employeeCheck = usersRepository.findById(userId);
			if (!employeeCheck.isPresent()) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new ResourceNotFoundException("The Data for Employee id: " + userId + " is not found");
		}
	}

	@Override
	public boolean updateEmployee(int userId, UsersDTO usersDTO) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> employeeCheck = usersRepository.findById(userId);
		if (employeeCheck.isPresent()) {
			if (usersDTO.getEmployeeid() < 100000) {
				throw new InvalidResourceException("The entered employee id must have 6 digits for sure.");
			}

			if (!this.checkEmail(usersDTO.getEmailAddress())) {
				throw new InvalidResourceException("Your email id must have @cognizant.com for sure.");
			}
			
			if(gradesServiceImpl.updateGradesHistoryByEmployeeId(userId, usersDTO)) {
				
				usersRepository.save(modelMapper.mapUserDtoToUser(usersDTO));
				return true;
			}
			else {
				return false;
			}
		} else {
			throw new ResourceNotFoundException(
					"The sent data is not there is database. Kindly check the deta passed.");
		}
	}

	@Override
	public UsersDTO getEmployeeById(int userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> employeeCheck = usersRepository.findById(userId);
		if (employeeCheck.isPresent()) {
			return modelMapper.mapUserToUserDto(employeeCheck.get());
		} else {
			throw new ResourceNotFoundException("The Data for Employee id: " + userId + " is not found");
		}
	}

	private boolean checkEmail(String emailAddress) {
		if (!emailAddress.contains("@cognizant.com")) {
			return false;
		}
		return true;
	}

}
