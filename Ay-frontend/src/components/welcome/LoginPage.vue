<script setup>
import {ref} from "vue";
import {useRouter} from 'vue-router'//导入路由
import {Edit} from "@element-plus/icons-vue";
import {getCurrentInstance} from "vue";
import {encrypt, decrypt} from "@/utils/jsencrypt";
import Cookies from 'js-cookie'
import useUserStore from '@/stores/modules/user'

const userStore = useUserStore()
const router = useRouter()  //使用路由
const {proxy} = getCurrentInstance()

const loginForm = ref({
    username: "admin",
    password: "123456",
    rememberMe: false,
    code: "",
    uuid: ""
});

const loading = ref(false);

const loginRules = {
    username: [{required: true, trigger: "blur", message: "请输入您的账号"}],
    password: [{required: true, trigger: "blur", message: "请输入您的密码"}],
    code: [{required: true, trigger: "change", message: "请输入验证码"}]
};

function handleLogin() {
    proxy.$refs.loginRef.validate(async (valid) => {
        if (valid) {
            loading.value = true;
            // 勾选了需要记住密码设置在 cookie 中设置记住用户名和密码
            // if (loginForm.value.rememberMe) {
            //     Cookies.set("username", loginForm.value.username, {expires: 30});
            //     Cookies.set("password", encrypt(loginForm.value.password), {expires: 30});
            //     Cookies.set("rememberMe", loginForm.value.rememberMe, {expires: 30});
            // } else {
            //     // 否则移除
            //     Cookies.remove("username");
            //     Cookies.remove("password");
            //     Cookies.remove("rememberMe");
            // }
            // 调用action的登录方法
            let rs = await userStore.login(loginForm.value)
            console.log(rs)
            if (rs.success){
                loading.value = false;
                router.push({path:'/index'})
            }
        }
    });
}

function Register() {
    router.push({name: 'register'})
}

</script>

<template>
    <div style="text-align: center;margin-top: 150px;">
        <div style="font-size: 25px;font-weight: bold">登录</div>
        <div style="font-size: 13px;margin-top:15px;color: coral">请在以下区域填写您的账号和密码</div>
    </div>
    <el-divider border-style="double"/>
    <el-form ref="loginRef" style="width: 90%;margin: 50px 20px" :model="loginForm" :rules="loginRules"
             label-width="30px" label-position="right">
        <el-form-item prop="username">
            <el-input prefix-icon="User" size="large" placeholder="账号" v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item prop="password" style="text-align: center">
            <el-input prefix-icon="Lock" size="large" placeholder="密码" type="password"
                      v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item prop="code">
            <div style="flex: 1">
                <el-input prefix-icon="Message" style="width: 80%;margin-right: 20px" size="large" placeholder="验证码"
                          v-model="loginForm.code"></el-input>
            </div>
            <div style="width: 35%">
                <el-image style="height: 80px"
                          src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"></el-image>
            </div>
        </el-form-item>
        <el-form-item>
            <div style="flex: 1">
                <el-switch v-model="loginForm.rememberMe"/>
                <el-text style="margin-left: 5px">记住密码</el-text>
            </div>
            <div>
                <el-link :icon="Edit">忘记密码？</el-link>
            </div>
        </el-form-item>
        <el-form-item>
            <div style="width: 100%;text-align: center">
                <el-button :loading="loading" style="width: 100%" type="primary" @click.prevent="handleLogin">
                    <span v-if="!loading">登 录</span>
                    <span v-else>登 录 中...</span>
                </el-button>
            </div>
        </el-form-item>
        <el-form-item>
            <div style="width: 100%;text-align: center">
                <el-button style="width: 100%" type="default" @click="Register">现在去注册</el-button>
            </div>
        </el-form-item>
    </el-form>
    <el-divider border-style="double"/>
</template>

<style scoped>

</style>