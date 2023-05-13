import request from "../utils/http/request";
import {ElMessage} from "element-plus";
import qs from 'qs' //序列化模块与json格式化差不多

export async function login(data) {
    try {
        return await request.post('/api/auth/login', qs.stringify(data))
    }catch (err) {
        ElMessage.error("服务器发生错误！！")
    }
}