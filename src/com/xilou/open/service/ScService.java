package com.xilou.open.service;

import com.xilou.open.domain.Sc;

import java.util.List;

public interface ScService {

	List<Sc> findAll(String studentId);

}
