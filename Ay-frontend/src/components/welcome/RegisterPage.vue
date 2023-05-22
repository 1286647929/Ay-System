<script setup>
import {ref} from "vue";
import {login} from "@/api/login";
import { useRouter } from 'vue-router'//导入路由
import {Edit} from "@element-plus/icons-vue";
const router = useRouter()  //使用路由
const loginForm = ref({
    username:"admin",
    password:123456,
    remember:false
});

async function Login(loginForm){
    let data = await login(loginForm)
    // let data = await request.post('http://localhost:8080/api/auth/login',form)
    console.log(data)
    if(data.status === 200){
        router.push({name:'index'})
    }
}

function Register(){
    router.push({name:'register'})
}

</script>

<template>
    <div style="text-align: center;margin-top: 150px;">
        <div style="font-size: 25px;font-weight: bold">注册</div>
        <div style="font-size: 13px;margin-top:15px;color: coral">请在以下区域填写您的账号和密码</div>
    </div>
    <el-divider border-style="double" />
    <el-form style="width: 90%;margin: 50px 20px" :model="loginForm" label-width="120px" label-position="right">
        <el-form-item label="账号">
            <el-input v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" style="text-align: center">
            <el-input type="password" v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item label="二次密码" style="text-align: center">
            <el-input type="password" v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item>
            <div style="width: 100%;text-align: center">
                <el-button style="width: 100%" type="primary" @click="Login(loginForm)">立即注册</el-button>
            </div>
        </el-form-item>
        <el-form-item>
            <div style="width: 100%;text-align: center">
                <el-button style="width: 100%" type="default" @click="Register">返回登录</el-button>
            </div>
        </el-form-item>
    </el-form>
    <el-divider border-style="double" />
</template>

<style scoped>

</style>