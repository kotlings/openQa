const  Message = new Vue().$message
const service = axios.create({
    baseURL:'http://119.84.146.233:8889', // api 的 base_url
    timeout: 25000 ,// 请求超时时间
    headers: {
        'Content-type': 'application/json;charset=UTF-8'
    },
  })
  
  // request拦截器
  service.interceptors.request.use(
    config => {
        return config
    },
    error => {
      // Do something with request error
      console.log(error) // for debug
      Promise.reject(error)
    }
  )
  
  // response 拦截器
  service.interceptors.response.use(
    response => {
      /**
       * code为非20000是抛错 可结合自己业务进行修改
       */
      const res = response.data
      return response.data
    },
    error => {
      console.log('err' + error) // for debug
      Message({
        message: error.message,
        type: 'error',
        duration: 5 * 1000
      })
      return Promise.reject(error)
    }
  )
  