package com.metanet.meriteshopbatch.config;

import com.metanet.meriteshopbatch.tasklet.Top5EmailSendTasklet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@AllArgsConstructor  // 생성자 DI를 위한 lombok Annotation
@Configuration
public class Top5EmailSendConfig {
//    private MemberRepository memberRepository;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Top5EmailSendTasklet top5EmailSendTasklet;

    @Bean
    public Job top5EmailSendJob() {
        return jobBuilderFactory.get("top5EmailSendJob")  // 1_1
                .start(top5EmailSendStep())  // 1_3
                .build();  // 1_4
    }

    @Bean
    public Step top5EmailSendStep() {
        log.info("********** This is top5EmailSendStep");
        return stepBuilderFactory.get("top5EmailSendStep")
                .tasklet(top5EmailSendTasklet)
                .build();
    }


}
