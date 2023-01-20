package com.deguzman.repository;

import java.util.List;

import com.deguzman.domain.Revenue;

public interface RevenueRepository {

	public List<Revenue> getAllRevenueByYear();
}
