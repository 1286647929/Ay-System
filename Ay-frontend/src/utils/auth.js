import Cookie from 'js-cookie'

const TokenKey = 'Admin-Token'

/**
 *获取cookie
 */
export function getToken() {
  return Cookie.get(TokenKey)
}

/**
 *设置cookie
 */
export function setToken(token) {
    return Cookie.set(TokenKey, token)
}

/**
 *删除cookie
 */
export function removeToken() {
    return Cookie.remove(TokenKey)
}