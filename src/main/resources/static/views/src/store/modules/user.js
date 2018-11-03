import { login, getById, logout } from '@/api/users'
import { getToken, setToken, removeToken } from '@/utils/auth'

const user = {
  state: {
    token: getToken(),
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_USER: (state, user) => {
      Object.assign(state, user)
    }
  },

  actions: {
    // 登录
    login({ commit }, userInfo) {
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        login(username, userInfo.password).then(response => {
          const data = response.data
          setToken(data.id)
          commit('SET_TOKEN', data.id)
          commit('SET_USER', data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 获取用户信息
    getLoginUser({ commit }) {
      return new Promise((resolve, reject) => {
        getById({uid:getToken()}).then(response => {
          const data = response.data
          commit('SET_USER', data)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // // 登出
    // logout({ commit, state }) {
    //   return new Promise((resolve, reject) => {
    //     logout(state.token).then(() => {
    //       commit('SET_TOKEN', '')
    //       removeToken()
    //       resolve()
    //     }).catch(error => {
    //       reject(error)
    //     })
    //   })
    // },

    // 前端 登出
    logout({ commit }) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        removeToken()
        resolve()
      })
    }
  }
}

export default user
