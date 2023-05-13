import axios from 'axios'
import {ElMessage} from "element-plus";

// // 创建axios的对象
const instance = axios.create({
    baseURL: "http://localhost:8080",  //配置固定域名
    timeout: 5000
})

// 请求拦截
// 所有的网络请求都会走这个方法,可以在请求添加自定义内容
instance.interceptors.request.use(
    function (config) {
        config.headers.token = '666' // 请求头添加token值
        config.headers.info = 'ay'  //请求头添加info值
        return config
    },
    function (err) {
        return Promise.request(err)
    }
)// 响应拦截
// 此处可以根据服务器返回的状态码做相应的数据
instance.interceptors.response.use(
    function (response) {
        const res = response
        if (res.status === 401) {
            ElMessage.info('系统未登录，请重新登录')
            return Promise.reject('error')
        }
        return res;
    },
    function (err) {
        return Promise.request(err)
    }
)

const request = {
    /**
     * @param get请求
     * @param url
     * @param params
     * @returns {Promise<unknown>}
     */
    get:function (url,params) {
        return new Promise((resolve, reject) => {
            instance.get(url,{params:params}).then((res) => {
                resolve(res)
            }).catch((err)  => {
                reject(err)
            })
        })
    },

    /**
     * @param post请求
     * @param url
     * @param data
     * @returns {Promise<unknown>}
     */
    post:function (url,data) {
        return new Promise((resolve, reject) => {
            instance.post(url,data).then((res) => {
                resolve(res)
            }).catch((err)  => {
                reject(err)
            })
        })
    }
}
export default instance