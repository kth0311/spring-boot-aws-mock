package com.github.jojoldu.sample.controller;

import com.github.jojoldu.sample.dto.PointDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jojoldu@gmail.com on 2018. 3. 15.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class Sample2Controller {
    private final QueueMessagingTemplate messagingTemplate;

    @PostMapping("/sample2")
    public String save(@RequestBody PointDto requestDto){
        messagingTemplate.convertAndSend("sample2", requestDto);
        return "success";
    }


}
