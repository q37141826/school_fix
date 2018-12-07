package com.qixiu.schoolfix.utils.reuestutil;

import com.qixiu.qixiu.request.OKHttpRequestModel;
import com.qixiu.qixiu.request.OKHttpUIUpdataListener;
import com.qixiu.qixiu.request.bean.C_CodeBean;
import com.qixiu.qixiu.utils.ToastUtil;
import com.qixiu.schoolfix.BuildConfig;
import com.qixiu.schoolfix.R;
import com.qixiu.schoolfix.constant.ConstantUrl;
import com.qixiu.schoolfix.model.IdIntef;
import com.qixiu.schoolfix.model.UploadFileBean;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by my on 2018/11/29.
 */

public class UploadFileRequest {

    public interface UploadFileCallBack<T> {
        void call(T t);
        void onError();
        void onFailue();
    }

    public static void uploadFile(String path,UploadFileCallBack callBack) {
        if(path.startsWith(BuildConfig.BASE_URL)){
            UploadFileBean uploadFileBean=new UploadFileBean();
            uploadFileBean.setO(path.replace(BuildConfig.BASE_URL,""));
            callBack.call(uploadFileBean);
            return;
        }
        OKHttpRequestModel okHttpRequestModel = new OKHttpRequestModel(new OKHttpUIUpdataListener() {
            @Override
            public void onSuccess(Object data, int i) {
                callBack.call(data);
            }

            @Override
            public void onError(Call call, Exception e, int i) {
                ToastUtil.toast(R.string.link_error);
                callBack.onError();
            }

            @Override
            public void onFailure(C_CodeBean c_codeBean) {
                ToastUtil.toast(c_codeBean.getM());
                callBack.onFailue();
            }
        });
        Map<String, File> mapFiles = new HashMap<>();
        try {
            mapFiles.put("File", new File(path));
        } catch (Exception e) {

        }
        okHttpRequestModel.okhHttpPost(ConstantUrl.uploadFile, null, new UploadFileBean(), mapFiles);
    }

    public static String getUrlsStringSpell(List<String> datas,String symbol){
        StringBuffer stringBuffer=new StringBuffer("");
        for (int i = 0; i < datas.size(); i++) {
            if(i==datas.size()-1){
                stringBuffer.append(datas.get(i)+"");
            }else {
                stringBuffer.append(datas.get(i)+symbol);
            }
        }
        return stringBuffer.toString();
    }

    public static String getIdsStringSpell(List<? extends IdIntef> datas, String symbol){
        StringBuffer stringBuffer=new StringBuffer("");
        for (int i = 0; i < datas.size(); i++) {
            if(i==datas.size()-1){
                stringBuffer.append(datas.get(i).getId()+"");
            }else {
                stringBuffer.append(datas.get(i).getId()+symbol);
            }
        }
        return stringBuffer.toString();
    }


    public static String[]  splitStrs(String str,String symbol){
        String[] split = str.split(symbol);
        return split;
    }

}
