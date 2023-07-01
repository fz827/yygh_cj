package com.chenjiang.controller;

import com.chenjiang.model.illness.Illness;
import com.chenjiang.result.Result;
import com.chenjiang.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class IllnessController {
    @Autowired
    private IllnessService illnessService;

    /**
     * 查询所有病症
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll(){
        return Result.ok( illnessService.list());
    }

    /**
     * id查询
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable int id){
        return Result.ok(illnessService.getById(id));
    }


    /**
     * 添加病症
     * @param illness
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Illness illness){
        return Result.ok(illnessService.save(illness));    }


    /**
     * 删除病情
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        return Result.ok(illnessService.removeById(id));
    }


    /**
     * 修改病情
     * @param illness
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Illness illness){
        return  Result.ok(illnessService.updateById(illness));
    }
}
