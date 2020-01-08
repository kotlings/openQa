const  Message = new Vue().$message
const service = axios.create({
    baseURL:'http://localhost:8889', // api 的 base_url
    timeout: 25000 ,// 请求超时时间
    headers: {
        'Content-type': 'application/json;charset=UTF-8'
    },
  })

  // request拦截器
  service.interceptors.request.use(
    config => {
    	config.headers['X-Token'] = sessionStorage.token
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

//获取url中的字段
function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
}


