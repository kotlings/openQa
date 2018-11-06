import router from './router'
import store from './store'
import {
  getToken
} from '@/utils/auth' // 验权

const needLoginList = ['/question/add'] // 需要登录的页面
router.beforeEach((to, from, next) => {

  if(getToken() && store.getters.user.loginState == null){  //登录了，但还没有获取用户信息
    store.dispatch('getLoginUser').catch(error=>{
      store.dispatch('logout')  //获取失败，则删除token
    })
  }

  if (needLoginList.indexOf(to.path) == -1) {  //不需要登录的页面，直接跳过
    if(store.getters.user.loginState != null && to.path === '/login'){  //已经登录再进登录页面，会直接跳转到主页
      next({path:'/'})
    }else{
      next()
    }
  } else {
    next('/login')
  }
})