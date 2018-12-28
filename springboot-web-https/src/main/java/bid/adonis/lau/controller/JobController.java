package bid.adonis.lau.controller;

import bid.adonis.lau.entity.Constant;
import bid.adonis.lau.service.JobService;
import bid.adonis.lau.service.ProcessService;
import chinatelecom.feilong.scheduler.entity.Job;
import chinatelecom.feilong.scheduler.entity.JobConfig;
import chinatelecom.feilong.scheduler.entity.response.GeneralResponse;
import chinatelecom.feilong.scheduler.service.SchedulerService;
import chinatelecom.feilong.scheduler.utils.DateUtils;
import chinatelecom.feilong.scheduler.utils.JSONObject;
import chinatelecom.feilong.scheduler.utils.JobUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.web.server.Ssl;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * 作业接口
 *
 * @author: Adonis Lau
 * @date: 2018/12/25 14:34
 */
@RestController
@RequestMapping("/job/")
@Slf4j
public class JobController {

    private final JobService jobService;
    private final ProcessService processService;

    @Autowired
    public JobController(JobService jobService, ProcessService processService) {
        this.jobService = jobService;
        this.processService = processService;
    }

    @ModelAttribute
    public void init() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        // 初始化作业发布服务
        SchedulerService.init(Constant.IP, Constant.PORT, Constant.CONTEXT);

//        System.setProperty("javax.net.ssl.trustStore", "classpath:config/tomcat.keystore");
//        System.setProperty("javax.net.ssl.trustStorePassword", "111111");
        log.info("初始化作业发布服务成功");
    }

    @GetMapping("publishJob")
    public GeneralResponse publishJob() {
        Job job = jobService.createJob();
        log.info("job = {}", job.toString());
        GeneralResponse generalResponse = jobService.publishJob(job);
        log.info("generalResponse = {}", JSONObject.toJSONString(generalResponse));
        return generalResponse;
    }

    @GetMapping("setSchedulerConfig")
    public void setSchedulerConfig() {
        JobConfig jobConfig = JobUtils.getJobConfig("0 1,11,21,31,41,51 * * * ? ");
        GeneralResponse response = jobService.setSchedulerConfig(Constant.JOBNAME, Constant.PROJECT_ID, jobConfig);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("openScheduler")
    public void openScheduler() {
        GeneralResponse response = processService.openScheduler(Constant.JOBNAME, Constant.PROJECT_ID);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("closeScheduler")
    public void closeScheduler() {
        GeneralResponse response = processService.closeScheduler(Constant.JOBNAME, Constant.PROJECT_ID);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("runOnce")
    public void runOnce() {
        GeneralResponse response = processService.runOnce(Constant.JOBNAME, Constant.PROJECT_ID);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("jobSuspend/{executionId}")
    public void jobSuspend(@PathVariable("executionId") String executionId) {
        GeneralResponse response = processService.jobSuspend(Constant.JOBNAME, Constant.PROJECT_ID, executionId);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("jobContinue/{executionId}")
    public void jobContinue(@PathVariable("executionId") String executionId) {
        GeneralResponse response = processService.jobContinue(Constant.JOBNAME, Constant.PROJECT_ID, executionId);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("setRuntime")
    public void setRuntime() {
        Date runTime = DateUtils.addMinutes(new Date(), 2);
        GeneralResponse response = processService.setRuntime(Constant.JOBNAME, Constant.PROJECT_ID, runTime);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("jobKill/{executionId}")
    public void jobKill(@PathVariable("executionId") String executionId) {
        GeneralResponse response = processService.jobKill(Constant.JOBNAME, Constant.PROJECT_ID, executionId);
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("jobReExecute/{executionId}")
    public void jobReExecute(@PathVariable("executionId") String executionId) {
        GeneralResponse response = processService.jobReExecute(Constant.JOBNAME, Constant.PROJECT_ID, executionId, "python_test");
        System.out.println(JSONObject.toJSONString(response));
    }

    @GetMapping("jobCheck/{executionId}")
    public void jobCheck(@PathVariable("executionId") String executionId) {
        for (int i = 0; i < 200; i++) {
            GeneralResponse response = processService.jobCheck(Constant.JOBNAME, Constant.PROJECT_ID, executionId);
            System.out.println(JSONObject.toJSONString(response));
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("downloadLog/{executionId}")
    public void downloadLog(@PathVariable("executionId") String executionId) {
        InputStream inputStream = processService.downloadLog(Constant.JOBNAME, Constant.PROJECT_ID, executionId);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
        String s;
        try {
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("jobDelete")
    public void jobDelete() {
        GeneralResponse response = jobService.deleteJob(Constant.JOBNAME, Constant.PROJECT_ID);
        System.out.println(JSONObject.toJSONString(response));
    }
}
