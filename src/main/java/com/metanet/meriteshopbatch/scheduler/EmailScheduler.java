package com.metanet.meriteshopbatch.scheduler;

import com.metanet.meriteshopbatch.config.Top5EmailSendConfig;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@EnableScheduling
public class EmailScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Top5EmailSendConfig top5EmailSendConfig;

    @Scheduled(cron = "0 0 10 * * 0")
    public void top5EmailSend(){
        try{
            Map<String, JobParameter> confMap = new HashMap<>();
            confMap.put("time", new JobParameter(System.currentTimeMillis()));
            JobParameters jobParameters = new JobParameters(confMap);
            jobLauncher.run(top5EmailSendConfig.top5EmailSendJob(), jobParameters);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
