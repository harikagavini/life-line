package org.lifeline.service;

import org.lifeline.model.Storage;
import org.lifeline.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService{

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public List<Storage> getAllStorages(){
        return storageRepository.findAll();
    }

}
