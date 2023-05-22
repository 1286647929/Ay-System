import {defineStore} from "pinia";
import {getToken, setToken, removeToken} from "@/utils/auth";
import {login} from "@/api/login";

const useUserStore = defineStore(
    'user',
    {
        state: () => ({
            token: getToken(),
            name: '',
            avatar: '',
            introduction: '',
            roles: [],
        }),
        getters: {},
        actions: {
            //登录
            login(userInfo) {
                const username = userInfo.username.trim()
                const password = userInfo.password
                const code = userInfo.code
                const uuid = userInfo.uuid
            },
        }
    }
)


export default useUserStore