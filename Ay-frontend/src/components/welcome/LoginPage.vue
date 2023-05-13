<script setup>
import {login} from "@/api/login";

// import request  from "./utils/http/request";
async function Login(){
    let form = {
        username:"admin",
        password:123456
    }
    let data = await login(form)
    // let data = await request.post('http://localhost:8080/api/auth/login',form)
    console.log(data)
}
</script>

<template>
    <div style="text-align: center;margin-top: 150px;">
        <div style="font-size: 25px;">登录</div>
        <el-button type="primary" @click="Login">登录</el-button>
    </div>
</template>

<style scoped>

</style>