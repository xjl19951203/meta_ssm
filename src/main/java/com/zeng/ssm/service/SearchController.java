package com.zeng.ssm.service;

import com.zeng.ssm.dao.*;
import com.zeng.ssm.model.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/search")
public class SearchController {
    @Resource
    SceneDataDao sceneDataDao;

    @RequestMapping(value="")

}
