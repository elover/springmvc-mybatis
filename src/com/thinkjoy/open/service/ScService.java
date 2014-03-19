package com.thinkjoy.open.service;

import com.thinkjoy.open.domain.Sc;

import java.util.List;

public interface ScService {

	List<Sc> findAll(String studentId);

}
