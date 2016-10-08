package main.java.com.boot.service.impl;

import main.java.com.boot.repository.jpa.SubMenuRepository;
import main.java.com.boot.service.SubMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by hao huang on 13/07/2016.
 */
@Service
@Transactional
public class SubMenuServiceImpl implements SubMenuService{

    @Resource
    private SubMenuRepository subMenuRepository;
}
