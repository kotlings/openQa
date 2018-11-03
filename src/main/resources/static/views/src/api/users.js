import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/user/login',
    method: 'post',
    data: {
      account: username,
      pwd: password
    }
  })
}

export function getById(params) {
  return request({
    url: '/user/getbyid',
    method: 'get',
    params
  })
}

export function getNew() {
  return request({
    url: '/user/getnew',
    method: 'get'
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'get'
  })
}
