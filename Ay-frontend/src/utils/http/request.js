import axios from 'axios'
import {ElMessage} from "element-plus";
import qs from 'qs'

// const qs = require('qs')


// // 创建axios的对象
// const instance = axios.create({
//     baseURL: "https://api.cat-shop.penkuoer.com",  //配置固定域名
//     timeout: 5000
// })
//
// // 请求拦截
// // 所有的网络请求都会走这个方法,可以在请求添加自定义内容
// instance.interceptors.request.use(
//     function (config) {
//         config.headers.token = '123456' // 请求头添加token值
//         config.headers.info = 'lxy'  //请求头添加info值
//         return config
//     },
//     function (err) {
//         return Promise.request(err)
//     }
// )
//
// // 响应拦截
// // 此处可以根据服务器返回的状态码做相应的数据
// instance.interceptors.response.use(
//     function (response) {
//         const res = response
//         if (res.status === 500) {
//             MessageBox.alert('系统未登录，请重新登录', '错误', {
//                 confirmButtonText: '确定',
//                 type: 'error'
//             }).then(() => {
//                 store.dispatch('FedLogOut').then(() => {
//                     location.reload()
//                 })
//             })
//             return Promise.reject('error')
//         } else if (res.errno === 502) {
//             MessageBox.alert('系统内部错误，请联系管理员维护', '错误', {
//                 confirmButtonText: '确定',
//                 type: 'error'
//             })
//             return Promise.reject('error')
//         }
//     },
//     function (err) {
//         return Promise.request(err)
//     }
// )

const request = {
    async get(url, data) {
        try {
            let res = await axios.get(url, {params: data})
            res = res.datareturn
            new Promise((resolve) => {
                if (res.code === 0) {
                    resolve(res)
                } else {
                    resolve(res)
                }
            })
        } catch (err) {
            ElMessage('服务器出错！')
            console.log(err)
        }
    }, async post(url, data) {
        try {
            let res = await axios.post(url, qs.stringify(data))
            res = res.datareturn
            new Promise((resolve, reject) => {
                if (res.code === 0) {
                    resolve(res)
                } else {
                    reject(res)
                }
            })
        } catch (err) {// return (e.message)alert('服务器出错')console.log(err)}},
            ElMessage('服务器出错！')
            console.log(err)
        }
    }
}
export {request}