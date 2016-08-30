package org.huasi.car.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.huasi.car.system.dao.SysImageCarouselDao;
import org.huasi.car.system.entity.SysImageCarousel;
import org.huasi.car.system.enums.ImageCarouselEnum;
import org.huasi.car.system.service.SysImageCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysImageCarouselServiceImpl implements SysImageCarouselService {

	@Autowired
	private SysImageCarouselDao carouseDao;
	
	@Override
	public List<SysImageCarousel> getAllImageCarousel() {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("carouselStatus", ImageCarouselEnum.NORMAL.value());
		return carouseDao.listByColumn(paramMap);
	}

}
