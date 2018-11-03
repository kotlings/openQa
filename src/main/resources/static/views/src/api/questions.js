import request from '@/utils/request'

export function queryList(data) {
  return request({
    url: '/questions/queryList',
    method: 'post',
    data
  })
}

export function getHot() {
  return request({
    url: '/questions/gethot',
    method: 'get'
  })
}

export function getone(params) {
  return request({
    url: '/questions/getone',
    method: 'get',
    params
  })
}

export function add(data) {
  return request({
    url: '/questions/add',
    method: 'post',
    data
  })
}

export function update(data) {
  return request({
    url: '/questions/edit',
    method: 'post',
    data
  })
}

export function del(data) {
  return request({
    url: '/questions/delete',
    method: 'post',
    data
  })
}

//添加回答
export function addAnswer(data) {
  return request({
    url: '/questions/addAnswer',
    method: 'post',
    data
  })
}

