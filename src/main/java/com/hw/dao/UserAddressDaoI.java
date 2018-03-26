package com.hw.dao;

import com.hw.entity.Address;
import com.hw.entity.PageModel;

public interface UserAddressDaoI {
	
	public int addAddress(Integer user_id, Address address);
	public int deleteAddressByUserId(Integer user_id, Integer id);
	public int updateUserAddressByUserId(Integer user_id, Address address);
	public PageModel<Address> findUserAddress(Integer user_id, Integer pageNo, Integer pageSize);
	public Address findOneAddress(Integer id);
	public PageModel<Address> findAllUserAddress(Integer pageNo, Integer pageSize);
	
}
