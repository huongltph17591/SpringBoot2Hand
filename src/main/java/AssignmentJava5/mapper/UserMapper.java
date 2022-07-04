package AssignmentJava5.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import AssignmentJava5.entities.*;
import AssignmentJava5.model.*;

@Service
public class UserMapper {
	@Autowired
	private ModelMapper mapper;

	public Account convertToEntity(AccountModel AccountModel)
	{
		Account entity = mapper.map(AccountModel, Account.class);
		
		return entity;
	}

	public AccountModel convertToDTO(Account entity)
	{
		AccountModel AccountModel = mapper.map(entity, AccountModel.class);
		
		return AccountModel;
	}
}
