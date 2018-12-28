package bid.adonis.lau.service;

import chinatelecom.feilong.scheduler.entity.exception.SchedulerException;
import chinatelecom.feilong.scheduler.entity.response.GeneralResponse;
import chinatelecom.feilong.scheduler.service.SchedulerService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author: Adonis Lau
 * @date: 2018/11/14 11:21
 */
@Service
public class ProcessService {

    /**
     * 开启调度
     *
     * @param jobName
     * @param projectId
     * @return
     */
    public GeneralResponse openScheduler(String jobName, String projectId) {
        GeneralResponse generalResponse = null;
        try {
            // 开启调度
            generalResponse = SchedulerService.jobScheduleOpen(jobName, projectId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 关闭调度
     *
     * @param jobName
     * @param projectId
     * @return
     */
    public GeneralResponse closeScheduler(String jobName, String projectId) {
        GeneralResponse generalResponse = null;
        try {
            // 关闭调度
            generalResponse = SchedulerService.jobScheduleClose(jobName, projectId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 运行一次
     *
     * @param jobName
     * @param projectId
     * @return
     */
    public GeneralResponse runOnce(String jobName, String projectId) {
        GeneralResponse generalResponse = null;
        try {
            // 运行一次
            generalResponse = SchedulerService.jobExecute(jobName, projectId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 作业暂停
     *
     * @param jobName
     * @param projectId
     * @return
     */
    public GeneralResponse jobSuspend(String jobName, String projectId, String executionId) {
        GeneralResponse generalResponse = null;
        try {
            // 暂停
            generalResponse = SchedulerService.jobSuspend(jobName, projectId, executionId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 继续运行
     *
     * @param jobName
     * @param projectId
     * @param executionId
     * @return
     */
    public GeneralResponse jobContinue(String jobName, String projectId, String executionId) {
        GeneralResponse generalResponse = null;
        try {
            // 继续运行
            generalResponse = SchedulerService.jobContinue(jobName, projectId, executionId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 事件触发
     *
     * @param jobName
     * @param projectId
     * @param date
     * @return
     */
    public GeneralResponse setRuntime(String jobName, String projectId, Date date) {
        GeneralResponse generalResponse = null;
        try {
            // 事件触发
            generalResponse = SchedulerService.setRuntime(jobName, projectId, date);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 作业强杀
     *
     * @param jobName
     * @param projectId
     * @param executionId
     * @return
     */
    public GeneralResponse jobKill(String jobName, String projectId, String executionId) {
        GeneralResponse generalResponse = null;
        try {
            // 强杀
            generalResponse = SchedulerService.jobKill(jobName, projectId, executionId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 作业重跑
     *
     * @param jobName
     * @param projectId
     * @param executionId
     * @return
     */
    public GeneralResponse jobReExecute(String jobName, String projectId, String executionId, String pluginName) {
        GeneralResponse generalResponse = null;
        try {
            // 重跑
            generalResponse = SchedulerService.jobReExecute(jobName, projectId, executionId, pluginName);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 查看执行结果
     *
     * @param jobName
     * @param projectId
     * @param executionId
     * @return
     */
    public GeneralResponse jobCheck(String jobName, String projectId, String executionId) {
        GeneralResponse generalResponse = null;
        try {
            // 查看运行状态
            generalResponse = SchedulerService.jobCheck(jobName, projectId, executionId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return generalResponse;
    }

    /**
     * 获取运行日志
     *
     * @param jobName
     * @param projectId
     * @param executionId
     * @return
     */
    public InputStream downloadLog(String jobName, String projectId, String executionId) {
        InputStream inputStream = null;
        try {
            inputStream = SchedulerService.downloadLog(jobName, projectId, executionId);
        } catch (IOException | SchedulerException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
