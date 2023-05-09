import request from "../utils/http/request";
import {ElMessage} from "element-plus";

export async function login(data) {
    try {
        return await request.post('http://localhost:8080/api/auth/login', data)
    }catch (err) {
        ElMessage.error(err)
    }
}