package com.harreke.easyappframework.helpers;

import android.content.Context;

import com.harreke.easyappframework.configs.RequestExecutorConfig;
import com.harreke.easyappframework.requests.IRequestCallback;
import com.harreke.easyappframework.requests.IRequestExecutor;
import com.harreke.easyappframework.requests.RequestBuilder;

public class RequestHelper {
    private IRequestExecutor mExecutor = null;

    /**
     * 取消正在执行的Http请求
     */
    public final void cancel() {
        if (mExecutor != null) {
            mExecutor.cancel();
        }
    }

    /**
     * 执行Http请求 如果有正在执行的Http请求，则该请求会被取消
     *
     * @param context
     *         执行Http请求的Context
     * @param builder
     *         Http请求
     * @param callback
     *         回调
     */
    public final void execute(Context context, RequestBuilder builder, IRequestCallback<String> callback) {
        if (context != null) {
            cancel();
            mExecutor = RequestExecutorConfig.create(context, builder, callback);
        }
    }

    /**
     * 判断是否有Http请求正在执行
     *
     * @return 是否有Http请求正在执行
     */
    public final boolean isExecuting() {
        return mExecutor != null && mExecutor.isExecuting();
    }
}