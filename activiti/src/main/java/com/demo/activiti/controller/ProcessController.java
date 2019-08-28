package com.demo.activiti.controller;

import com.demo.activiti.util.ActivitiUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

/**
 * @ClassName: ProcessController
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/27 15:17
 * @Version: 1.0
 */
@Controller
@Slf4j
public class ProcessController {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @RequestMapping("getImg")
    public ResponseEntity getImg(String processInstId) throws Exception{
        HistoricProcessInstance processInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(processInstId).singleResult();
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        HistoricActivityInstanceQuery historyInstanceQuery = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstId);
        List<HistoricActivityInstance> historicActivityInstanceList = historyInstanceQuery.orderByHistoricActivityInstanceStartTime().asc().list();
        List<String> executedActivityIdList = historicActivityInstanceList.stream().map(item -> item.getActivityId()).collect(Collectors.toList());
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService).getDeployedProcessDefinition(processInstance.getProcessDefinitionId());
        List<String> flowIds = ActivitiUtils.getHighLightedFlows(bpmnModel, processDefinition, historicActivityInstanceList);
        ProcessDiagramGenerator diagramGenerator = new DefaultProcessDiagramGenerator();
        InputStream inputStream = diagramGenerator.generateDiagram(bpmnModel, "png", executedActivityIdList, flowIds, "宋体", "微软雅黑", "黑体",null,1.0);
        String fileName = new String("流程图片".getBytes("utf-8"),"iso-8859-1" );
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(IOUtils.toByteArray(inputStream),httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping("cancelProcess")
    @ResponseBody
    public String cancelProcess(){
        try {
            runtimeService.deleteProcessInstance("2501", "撤销流程");
            return "撤销成功";
        }catch (Exception e){
            return "撤销失败";
        }

    }

    @RequestMapping("deleteDeployment")
    @ResponseBody
    public String deleteDeployment(String deploymentId){
        try {
            repositoryService.deleteDeployment(deploymentId,true);
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }
    }

    @RequestMapping("completeTask")
    @ResponseBody
    public String completeTask(String taskId,boolean auditResult){
        try {
            HashMap<String,Object> map = new HashMap<>();
            map.put("result", auditResult);
            taskService.complete(taskId,map);
            return "完成成功";
        }catch (Exception e){
            return "完成失败";
        }
    }

    @RequestMapping("startProcessInst")
    @ResponseBody
    public String startProcessInst(String processDefinitionId){
        try {
            runtimeService.startProcessInstanceById(processDefinitionId);
            log.info("启动成功");
            return "启动成功";
        }catch (Exception e){
            log.error("启动失败", e);
            return "启动失败";
        }
    }

    @RequestMapping("deployment")
    @ResponseBody
    public String deployment(MultipartFile file){
        try {
            repositoryService.createDeployment()
                    .name("请假流程")
                    .addZipInputStream(new ZipInputStream(file.getInputStream()))
                    .deploy();
            return "部署成功";
        }catch (Exception e){
            return "部署失败";
        }
    }
}
