package org.lifeline.service;

import org.lifeline.model.Services;

import java.util.List;

public interface ServicesService {
    public Services saveService(Services services);
    public List<Services> getAllServices();
}
