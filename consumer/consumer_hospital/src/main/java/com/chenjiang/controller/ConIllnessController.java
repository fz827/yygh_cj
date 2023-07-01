package com.chenjiang.controller;

import com.chenjiang.api.IllnessFeign;
import com.chenjiang.model.illness.Illness;
import com.chenjiang.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/illness")
@CrossOrigin
public class ConIllnessController {


    @Autowired
    private IllnessFeign illnessFeign;
    /**
     * 查询所有病症
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll(){
       return illnessFeign.getAll();
    }



    /**
     * id查询
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable int id){
        return illnessFeign.getById(id);
    }


    /**
     * 添加病症
     * @param illness
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Illness illness){
        return illnessFeign.save(illness);
    }



    /**
     * 删除病情
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
        return illnessFeign.delete(id);
    }




    /**
     * 修改病情
     * @param illness
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Illness illness){
        return illnessFeign.update(illness);
    }
}
