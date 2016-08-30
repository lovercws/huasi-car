package org.huasi.car.system.service;

import java.util.List;

import org.huasi.car.system.entity.SysImageCarousel;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT, readOnly = true)
public interface SysImageCarouselService {

	public List<SysImageCarousel> getAllImageCarousel();

}
