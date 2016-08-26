package net.eulerform.web.module.cms.basic.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.eulerform.web.core.base.service.IBaseService;
import net.eulerform.web.module.cms.basic.entity.Slideshow;

public interface ISlideshowService extends IBaseService {

    public List<Slideshow> loadSlideshow();

    public void saveSlideshow(List<MultipartFile> img, List<String> url);

}