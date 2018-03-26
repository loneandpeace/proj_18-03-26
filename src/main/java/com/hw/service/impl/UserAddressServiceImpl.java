package com.hw.service.impl;

import com.hw.dao.UserAddressDaoI;
import com.hw.dao.impl.UserAddressDaoImpl;
import com.hw.entity.Address;
import com.hw.entity.PageModel;
import com.hw.service.UserAddressServiceI;

public class UserAddressServiceImpl implements UserAddressServiceI{
	UserAddressDaoI userAddressDao=new UserAddressDaoImpl();
	@Override
	public int addAddressService(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		return userAddressDao.addAddress(user_id, address);
	}

	@Override
	public int deleteAddressByUserIdService(Integer user_id, Integer id) {
		// TODO Auto-generated method stub
		return userAddressDao.deleteAddressByUserId(user_id, id);
	}

	@Override
	public int updateUserAddressByUserIdService(Integer user_id, Address address) {
		// TODO Auto-generated method stub
		return userAddressDao.updateUserAddressByUserId(user_id, address);
	}

	@Override
	public PageModel<Address> findUserAddressService(Integer user_id, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return userAddressDao.findUserAddress(user_id, pageNo, pageSize);
	}

	@Override
	public Address findOneAddressService(Integer id) {
		// TODO Auto-generated method stub
		return userAddressDao.findOneAddress(id);
	}

	@Override
	public PageModel<Address> findAllUserAddressService(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return userAddressDao.findAllUserAddress(pageNo, pageSize);
	}

}
