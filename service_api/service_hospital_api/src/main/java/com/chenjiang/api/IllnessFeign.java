package com.chenjiang.api;

import com.chenjiang.model.illness.Illness;
import com.chenjiang.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-hospital-cj")
@Repository
public interface IllnessFeign {

    /**
     * 查询所有病症
     * @return
     */
    @GetMapping("/getAll")
    public Result getAll();



    /**
     * id查询
     * @param id
     * @return
     */
    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable int id);


    /**
     * 添加病症
     * @param illness
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody Illness illness);



    /**
     * 删除病情
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id);




    /**
     * 修改病情
     * @param illness
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Illness illness);
}
