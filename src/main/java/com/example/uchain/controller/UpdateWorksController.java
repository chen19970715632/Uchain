package com.example.uchain.controller;

import cn.hutool.core.io.FileUtil;
import com.example.uchain.demo.Result;
import com.example.uchain.demo.UpdateWorks;
import com.example.uchain.service.UpdateWorksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@Slf4j//日志用的注解
public class UpdateWorksController {
    @Autowired
    private UpdateWorksService updateWorksService;

    @GetMapping("/update")
    public Result findAll() {
        log.info("查看作品信息");
        List<UpdateWorks> updateWorksList = updateWorksService.findAll();
        return Result.success(updateWorksList);
    }

    @PostMapping("/update")
    public Result AddGood(@RequestBody UpdateWorks updateWorks){

        log.info("新增作品信息: {}",updateWorks);
        updateWorksService.AddUpdate(updateWorks);
        return Result.success();
    }

    @DeleteMapping("update/{workIds}")
    public Result deleteGoodById(@PathVariable("workIds") List<Integer> workIds){
        log.info("根据id批量删除作品信息: {}",workIds);
        updateWorksService.deleteUpdateById(workIds);
        return Result.success();
    }

    @PutMapping( "/update")
    public Result updateById(@RequestBody UpdateWorks updateWorks){
        log.info("修改作品信息: {}", updateWorks);
        updateWorksService.updateById(updateWorks);
        return Result.success();
    }

    //接收前端上传的文件
    //默认单个文件最大为1MB 可在配置文件里面修改
    @Value("${ip}")
    String ip;

    @Value("${server.port}")
    String port;


//private static final String ROOT_PATH = "uchain/src/main/resources/static/images/";
//
//    @PostMapping("/upload")
//    public Result upload(MultipartFile file) {
//        try {
//            String originalFilename = file.getOriginalFilename();  // 文件的原始名称
//
//            // 构造唯一的文件名 --> uuid(通用唯一识别码)
//            assert originalFilename != null;
//            String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
//            String newFileName = UUID.randomUUID().toString() + extname;
//            log.info("新的文件名: {}", newFileName);
//
//            String absolutePath = new File(ROOT_PATH).getAbsolutePath(); // 获取文件夹绝对路径
//            File saveFile = new File(absolutePath + File.separator + newFileName);
//            file.transferTo(saveFile);  // 存储文件到本地的磁盘里面去
//
//            String url = "http://" + ip + ":" + port + "/images/" + newFileName;
//            System.out.println("url:  " + url);
//            return Result.success(url);  // 返回文件的链接，这个链接就是文件的下载地址
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return Result.error("上传失败");
//        }
//    }


    private static final String ROOT_PATH = System.getProperty("user.dir") +File.separator + "images";
    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();  // 文件的原始名称

            // 构造唯一的文件名 --> uuid(通用唯一识别码)
            assert originalFilename != null;
            String extname = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString() + extname;
            log.info("新的文件名: {}", newFileName);

            String absolutePath = new File(ROOT_PATH).getAbsolutePath(); // 获取文件夹绝对路径
            File saveFile = new File(absolutePath + File.separator + newFileName);
            file.transferTo(saveFile);  // 存储文件到本地的磁盘里面去

            String url = "http://" + ip + ":" + port + "/images/" + newFileName;
            System.out.println("url:  " + url);
            return Result.success(url);  // 返回文件的链接，这个链接就是文件的下载地址

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Result.error("上传失败");
        }
    }

//    @GetMapping("/testResource")
//    @ResponseBody
//    public String testResource() {
//        String path = Paths.get("").toAbsolutePath().toString();
//        File file = new File(path + "/images/73f506f1-6c3e-4c14-b39d-3d88c3f7d760.png");
//
//        System.out.println(path);
//        if(file.exists()) {
//            return "Resource exists";
//        } else {
//            return "Resource does not exist";
//        }
//    }
}
