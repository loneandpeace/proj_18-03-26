package com.hw.service;

import com.hw.entity.Address;
import com.hw.entity.PageModel;

public interface UserAddressServiceI {
	public int addAddressService(Integer user_id, Address address);
	public int deleteAddressByUserIdService(Integer user_id, Integer id);
	public int updateUserAddressByUserIdService(Integer user_id, Address address);
	public PageModel<Address> findUserAddressService(Integer user_id, Integer pageNo, Integer pageSize);
	public Address findOneAddressService(Integer id);
	
	public PageModel<Address> findAllUserAddressService(Integer pageNo, Integer pageSize);
}
