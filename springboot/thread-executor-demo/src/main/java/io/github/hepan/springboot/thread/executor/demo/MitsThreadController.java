package io.github.hepan.springboot.thread.executor.demo;

import io.github.hepan.springboot.thread.executor.demo.master.MitsThreadService;
import io.github.hepan.springboot.thread.executor.demo.my.MyThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hp
 * @describe
 * @createTime 2019/9/8 09:43
 **/
@RestController()
public class MitsThreadController {
    @Autowired
    MitsThreadService mitsThreadService;
    @Autowired
    MyThreadService myThreadService;

    @GetMapping("/call")
    public String call() {
        mitsThreadService.call();

        return "success";
    }


    @GetMapping("/call2")
    public String call2() throws InterruptedException {
        myThreadService.call();

        return "success";
    }
}
