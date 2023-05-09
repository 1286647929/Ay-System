<script setup>
import {login} from "@/api/login";

function Login(){
    const {body} = login({
        username:"admin",
        password:123456
    })
    console.log(body)
}

</script>

<template>
  <div style="width: 100vw;height: 100vh;overflow: hidden;display: flex">
      <div style="flex: 1">
          <el-image style="width: 100%;height: 100%" src="https://img1.baidu.com/it/u=2463514011,1142503686&fm=253&fmt=auto&app=138&f=JPEG?w=888&h=500"></el-image>
      </div>

      <div style="width: 30%;background-color: white">
          <div style="text-align: center;margin-top: 150px;">
              <div style="font-size: 25px;">登录</div>
              <el-button type="primary" @click="Login">登录</el-button>
          </div>
      </div>
  </div>
</template>

<style scoped>

</style>
