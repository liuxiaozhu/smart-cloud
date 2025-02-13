/*
 * Copyright © 2019 collin (1634753825@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.smartframework.cloud.starter.core.business.util;

import org.smartframework.cloud.common.pojo.Response;
import org.smartframework.cloud.common.pojo.ResponseHead;
import org.smartframework.cloud.constants.CommonReturnCodes;
import org.smartframework.cloud.utility.ObjectUtil;
import org.smartframework.cloud.utility.spring.I18nUtil;

/**
 * {@link Response}工具类
 *
 * @author collin
 * @date 2019-04-06
 */
public class RespUtil {

    private RespUtil() {
    }

    /**
     * 构造响应成功对象
     *
     * @return
     */
    public static <R> Response<R> success() {
        return new Response<>(new ResponseHead(CommonReturnCodes.SUCCESS));
    }

    /**
     * 构造响应成功对象
     *
     * @param r
     * @return
     */
    public static <R> Response<R> success(R r) {
        return new Response<>(r);
    }

    /**
     * 构造响应错误对象
     *
     * @param code
     * @return
     */
    public static <R> Response<R> error(String code) {
        return new Response<>(new ResponseHead(code));
    }

    /**
     * 是否成功
     *
     * @param resp
     * @return
     */
    public static <R> boolean isSuccess(Response<R> resp) {
        return ObjectUtil.isNotNull(resp) && ObjectUtil.isNotNull(resp.getHead())
                && ObjectUtil.equals(CommonReturnCodes.SUCCESS, resp.getHead().getCode());
    }

    /**
     * 获取失败的提示信息
     *
     * @param resp
     * @return
     */
    public static <R> String getFailMsg(Response<R> resp) {
        if (ObjectUtil.isNull(resp)) {
            return I18nUtil.getMessage(CommonReturnCodes.RPC_REQUEST_FAIL);
        }

        if (ObjectUtil.isNull(resp.getHead())) {
            return I18nUtil.getMessage(CommonReturnCodes.RPC_RESULT_EXCEPTION);
        }

        return resp.getHead().getMessage();
    }

}