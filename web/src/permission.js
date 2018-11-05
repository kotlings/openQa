import router from './router'
import store from './store'
import {
  getToken
} from '@/utils/auth' // 验权

const needLoginList = ['/question/add'] // 需要登录的页面
router.beforeEach((to, from, next) => {
  if (getToken()) {  //登录后，随便跑
    if(store.getters.user.id == undefined){  //登录了，但没有用户信息？页面被刷新了
      store.dispatch('getLoginUser').then(() => { 
        next({ ...to, replace: true }) // hack方法 确保addRoutes已完成 ,set the replace: true so the navigation will not leave a history record
      }).catch(error=>{   //有token，但没能在服务器上取到用户信息
        store.dispatch('logout')
        next('/login')
      })
    }
    if (to.path === '/login') {
      next({
        path: '/'
      })
    } else {
      next()
    }
  } else {  //没有登录时
    if (needLoginList.indexOf(to.path) == -1) {
      next()
    } else {
      next('/login')
    }
  }
})