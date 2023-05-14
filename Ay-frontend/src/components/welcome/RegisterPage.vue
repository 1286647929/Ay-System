<script setup>
import {ref} from "vue";
import { useRouter } from 'vue-router'  //导入路由
const router = useRouter()  //使用路由
const registerForm = ref({
    username:"",
    password:"",
    repassword:""
});
</script>

<template>
    <div style="text-align: center;margin-top: 150px;">
        <div style="font-size: 25px;font-weight: bold">注册</div>
        <div style="font-size: 13px;margin-top:15px;color: coral">请在以下区域填写您的账号和密码</div>
    </div>
    <el-divider border-style="double" />
    <el-form :model="registerForm" label-width="120px">
        <el-form-item label="账号">
            <el-input v-model="registerForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="registerForm.password"></el-input>
        </el-form-item>
        <el-form-item label="再次密码">
            <el-input v-model="registerForm.repassword"></el-input>
        </el-form-item>
        <el-form-item>
            <div>
                <router-link class="link-type" :to="'/'">去登录</router-link>
            </div>
        </el-form-item>

    </el-form>
</template>

<style scoped>

</style>