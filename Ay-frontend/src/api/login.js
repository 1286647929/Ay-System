import {request} from "@/utils/http/request";

export async function login(data) {
    return await request.post('http://localhost:8080/api/auth/login',data);
}