package com.qixiu.schoolfix.constant;

import com.qixiu.schoolfix.BuildConfig;

/**
 * Created by my on 2018/11/22.
 */

public class ConstantUrl {
    //获取token
    public final static String tokenUrl = BuildConfig.BASE_URL + "api/services/app/TokenAuthService/Authenticate\n";


    //首页
    public final static String homeUrl = BuildConfig.BASE_URL + "api/services/app/MyUser/GetRepairIndexInfo";
    //登录
    public final static String loginUrl = BuildConfig.BASE_URL + "api/services/app/MyUser/UserLogin";


    //扫码设备详情
    public final static String mechineDetailsUrl = BuildConfig.BASE_URL + "/api/services/app/SHQrCode/GetViewDto";
    //根据设备码查询设备详情
    public final static String mechineDetails = BuildConfig.BASE_URL + "/api/services/app/SHProduct/GetViewPage";

    //工单列表
    public final static String workListUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/ComAppMyWorkOderList";

    //工单详情

    public final static String workDetailsUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/GetViewDto?id=";

    //修改密码
    public final static String changePswUrl = BuildConfig.BASE_URL + "/api/services/app/MyUser/UpdateByDto";

    //上传文件
    public final static String uploadFile = BuildConfig.BASE_URL + "/api/services/app/File/UploadFile?type='SHWorkOrder'";


    //问题列表
    public final static String problemListUrl = BuildConfig.BASE_URL + "/api/services/app/SHProductProblem/GetViewPage";


    //设备列表
    public final static String mechineCodeList = BuildConfig.BASE_URL + "/api/services/app/SHDevice/GetViewPage";


    //创建设备
    public final static String createEqupmentList = BuildConfig.BASE_URL + "/api/services/app/SHDevice/CreateByDto";

    //修改设备
    public final static String modifyEqupmentList = BuildConfig.BASE_URL + "/api/services/app/SHDevice/UpdateByDto";


    //问题解决方案
    public final static String getProductProblemSolutionList = BuildConfig.BASE_URL + "/api/services/app/SHProductProblemSolution/GetProductProblemSolution";

    //维护商列表
    public final static String getRepairCompanyList = BuildConfig.BASE_URL + "/api/services/app/SHRepairBusiness/GetViewPageBySschool";

    //二维码绑定设备
    public final static String bindingUrl = BuildConfig.BASE_URL + "/api/services/app/SHDevice/UpdateByDto";


    //接单
    public final static String receiveUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/UpdateByDto";

    //签到
    public final static String signUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/UpdateByDto";

    //保存设施报告
    public final static String saveReportUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/UpdateByDto";


    //维修人员列表
    public final static String repairPersonUrl = BuildConfig.BASE_URL + "/api/services/app/myUser/GetViewPage";


    //产品列表
    public final static String productListUrl = BuildConfig.BASE_URL +  "/api/services/app/SHProduct/GetViewPage";

    //创建工单的产品列表
    public final static String productListUrl02 = BuildConfig.BASE_URL +   "/api/services/app/SHProduct/GetViewPageBySchool";

    //学校列表
    public final static String schoolListUrl = BuildConfig.BASE_URL + "/api/services/app/SHRepairBusiness/GetViewPageBySschool";

    //创建工单
    public final static String createWorkUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/CreateByDto";
    //指派工单
    public final static String giveOrderUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/UpdateByDto";

    //转交工单

    public final static String transferOrderUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/TransferWorkOrder";

    //服务完成
    public final static String completeWorkUrl = BuildConfig.BASE_URL + "/api/services/app/SHWorkOrder/UpdateByDto";

    // 获取文章类型
    public final static String shareTypeUrl = BuildConfig.BASE_URL + "/api/services/app/ZSKArticleType/GetView";
}
