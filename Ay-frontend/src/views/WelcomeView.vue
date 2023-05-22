<script setup>

</script>

<template>
    <div style="width: 100vw;height: 100vh;overflow: hidden;display: flex">
        <div style="flex: 1">
            <el-image style="width: 100%;height: 100%" src="https://img1.baidu.com/it/u=2463514011,1142503686&fm=253&fmt=auto&app=138&f=JPEG?w=888&h=500"></el-image>
        </div>

        <div style="width: 36%;background-color: white">
            <router-view/>
        </div>
    </div>
</template>

<style scoped>

</style>