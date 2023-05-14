<script setup>
import {login} from "@/api/login";
import {ref} from "vue";
import { useRouter } from 'vue-router'  //导入路由
const router = useRouter()  //使用路由
const loginForm = ref({
    username:"admin",
    password:123456
});

async function Login(loginForm){
    let data = await login(loginForm)
    // let data = await request.post('http://localhost:8080/api/auth/login',form)
    console.log(data)
    if(data.code === 200){
        router.push({name:'home'})
    }
}
</script>

<template>
    <div style="text-align: center;margin-top: 150px;">
        <div style="font-size: 25px;font-weight: bold">登录</div>
        <div style="font-size: 13px;margin-top:15px;color: coral">请在以下区域填写您的账号和密码</div>
    </div>
    <el-divider border-style="double" />
    <el-form :model="loginForm" label-width="120px">
        <el-form-item label="账号">
            <el-input v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="Login(loginForm)">登录</el-button>
            <div style="margin-left: 100px">
                <router-link class="link-type" :to="'/register'">立即注册</router-link>
            </div>
        </el-form-item>

    </el-form>
</template>

<style scoped>

</style>