package com.metanet.meriteshopbatch.tasklet;

import com.metanet.meriteshopbatch.entity.Item;
import com.metanet.meriteshopbatch.entity.User;
import com.metanet.meriteshopbatch.service.ItemService;
import com.metanet.meriteshopbatch.service.MailService;
import com.metanet.meriteshopbatch.service.UserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class Top5EmailSendTasklet implements Tasklet {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserSerivce userSerivce;

    @Autowired
    private MailService mailService;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("### This is Step1");
        //service => DB에서 top5 불러오기, 메일 text 구성
        //메일 구성 serivce가 실패할 경우(try catch) 실패로 return

        //repository로 DB에서 유저 리스트 다 불러오기
        //유저 리스트 불러오기가 실패할 경우(try catch) 실패로 return

        //for문으로 유저 돌리고 메일 SMTP로 보내기
        //try catch{ continue }
        //끝나면 finished

        List<Item> itemList = itemService.findTop5OrderByRateDesc();
        String text = "내용입니당";
        for (Item item : itemList) {
            System.out.println(item);
            //todo make text
        }

        List<User> userList = userSerivce.getUserList();
        for (User user : userList) {
            try {
                mailService.send(user.getEmail(), "subject", text);
            } catch (Exception e) {
                log.error("send error. user : " + user);
            }
        }

        return RepeatStatus.FINISHED;
    }
}
