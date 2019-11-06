package com.gmail.mosoft521.cp.jxc.service.impl;

import com.gmail.mosoft521.cp.jxc.dao.ProviderMapper;
import com.gmail.mosoft521.cp.jxc.entity.Provider;
import com.gmail.mosoft521.cp.jxc.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public List<Provider> list() {
        return providerMapper.selectByExample(null);
    }

    @Override
    public boolean saveOrUpdate(Provider provider) {
        int r = 0;
        if (null == provider.getProviderId()) {
            r = providerMapper.insertSelective(provider);
        } else {
            r = providerMapper.updateByPrimaryKey(provider);
        }
        return r > 0 ? true : false;
    }

    @Override
    public boolean delete(Integer providerId) {
        return providerMapper.deleteByPrimaryKey(providerId) > 0 ? true : false;
    }

    @Override
    public String getNameById(Integer providerId) {
        return providerMapper.selectByPrimaryKey(providerId).getName();
    }
}
